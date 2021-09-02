package mg.meddoc.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mg.meddoc.models.Adresse;
import mg.meddoc.models.Contact;
import mg.meddoc.models.Pharmacie;
import mg.meddoc.models.TypeUtilisateur;
import mg.meddoc.models.Utilisateur;
import mg.meddoc.services.AdresseSer;
import mg.meddoc.services.ContactService;
import mg.meddoc.services.PharmacieService;
import mg.meddoc.services.SpecialiteService;
import mg.meddoc.services.UtilisateurService;

@RestController
@RequestMapping(value = "/pharmacie")
@CrossOrigin(origins = { "*" })
@Component
public class PharmacieController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(PharmacieController.class);

	@Autowired
	PharmacieService servicePharmacie;

	@Autowired
	UtilisateurService serviceUtilisateur;

	@Autowired
	SpecialiteService serviceSpecialite;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	ContactService serviceContact;

	@Autowired
	AdresseSer serviceAdresse;

	// GetAll_Pharmacie
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllPharmacie() {
		List<Pharmacie> pharmacie = new ArrayList<Pharmacie>();
		try {
			pharmacie = servicePharmacie.getAll();
			System.out.println(om.writeValueAsString(pharmacie));
			return new ResponseEntity<>(pharmacie, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}

	// GetById_Pharmacie
	@GetMapping(value = "/p/{id}")
	public @ResponseBody ResponseEntity<?> getPharmacieById(@PathVariable(name = "id") Long id) {
		Pharmacie pharmacie = null;
		System.out.println("get pharmacie by id");
		try {

			pharmacie = servicePharmacie.getPharmacieById(id);
//			log.info(om.writeValueAsString(pharmacie));
			return new ResponseEntity<>(pharmacie, HttpStatus.OK);

		} catch (Exception e) {
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Get Pharmacie by raison sociale
	@GetMapping(value = "/{raisonSocial}")
	public @ResponseBody ResponseEntity<?> getPharmacieByRaisonSocial(
			@PathVariable(name = "raisonSocial") String raisonSocial) {
		Pharmacie pharmacie = null;

		try {
			pharmacie = servicePharmacie.getByRaisonSocial(raisonSocial);

			return new ResponseEntity<>(pharmacie, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Register
	@Transactional(rollbackFor = Exception.class)
	@PostMapping(value = "/register")
	public @ResponseBody ResponseEntity<?> registerPharmacie(@RequestBody HashMap<String, Object> data) {
		List<String> error = new ArrayList<String>();
		// Save user and pharmacie
		try {
			Utilisateur user = om.readValue(om.writeValueAsString(data.get("user")), new TypeReference<Utilisateur>() {
			});
			Pharmacie pharmacie = om.readValue(om.writeValueAsString(data.get("pharmacie")),
					new TypeReference<Pharmacie>() {
					});
			// Save user
			Utilisateur newUser = new Utilisateur();

			if (serviceUtilisateur.existsByEmail(user.getEmail())) {
				error.add("Adresse email déjà prise");
			}

			if (user.getNom() == null) {
				error.add("Veuillez insérer votre nom");
			} else {
				newUser.setNom(user.getNom());
			}

			if (user.getPrenoms() == null) {
				error.add("Veuillez insérer votre prénom");
			} else {
				newUser.setPrenoms(user.getPrenoms());
			}

			if (user.getPassword() == null) {
				error.add("Veuillez insérer votre mot de passe");
			} else {
				newUser.setPassword(encoder.encode(user.getPassword()));
			}

			if (user.getEmail() == null) {
				error.add("Veuillez insérer votre email");
			} else {
				newUser.setEmail(user.getEmail());
			}

			newUser.setStatut(0);
			newUser.setTypeUtilisateur(new TypeUtilisateur(2));

			// Save pharmacie
			Pharmacie newPharmacie = new Pharmacie();
//			newPharmacie.setAdresse(pharmacie.getAdresse());
			newPharmacie.setNif(pharmacie.getNif());
			newPharmacie.setStat(pharmacie.getStat());
			newPharmacie.setPresentation(pharmacie.getPresentation());
			newPharmacie.setRaisonSocial(pharmacie.getRaisonSocial());
			newPharmacie.setSpecialite(pharmacie.getSpecialite());

			Pharmacie savedPharmacie = null;
			Set<Utilisateur> pharmacieUtilisateur = new HashSet<Utilisateur>();

			if (error.isEmpty()) {
				user = serviceUtilisateur.save(newUser);
				System.out.println(om.writeValueAsString(user));
				pharmacieUtilisateur.add(user);
				newPharmacie.setUtilisateurs(pharmacieUtilisateur);
				savedPharmacie = servicePharmacie.save(newPharmacie);
			} else {
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}

			// Save contact
			List<Contact> contacts = new ArrayList<Contact>();
			for (Contact cont : pharmacie.getContact()) {
				cont.setIdEntite(savedPharmacie.getIdPharmacie());
				cont.setPharmacie(savedPharmacie);
				contacts.add(cont);
				serviceContact.save(cont);
			}
			// save adresse
//			Set<Adresse> newAdr = new HashSet<Adresse>();
			Adresse adresse = null;
			for (Adresse adr : pharmacie.getAdresse()) {
				adresse = new Adresse();
				adresse.setDateDebut(new Timestamp(System.currentTimeMillis()));
				adresse.setDistrict(adr.getDistrict());
				adresse.setIdUser(savedPharmacie.getIdPharmacie());
				adresse.setInformationAcces(adr.getInformationAcces());
				adresse.setInformationAdresse(adr.getInformationAdresse());
				adresse.setInformationUtile(adr.getInformationUtile());
				adresse.setLatitude(adr.getLatitude());
				adresse.setLongitude(adr.getLongitude());
				serviceAdresse.save(adresse);
			}
			return new ResponseEntity<>(savedPharmacie, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			error.add(e.getMessage());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Save_Pharmacie
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> savePharmacie(@RequestBody Pharmacie pharmacie) {

		try {
			if (pharmacie.getRaisonSocial() == null)
				throw new Exception("Raison sociale ne peut pas être vide");
			if (pharmacie.getRaisonSocial() == "")
				throw new Exception("Raison sociale tena vide");
			if (pharmacie.getLatitude() != null && (pharmacie.getLatitude() > 100 || pharmacie.getLatitude() < 0))
				throw new Exception("Latitude incorrect");
			if (pharmacie.getLongitude() != null && (pharmacie.getLongitude() > 100 || pharmacie.getLongitude() < 0))
				throw new Exception("Longitude incorrect");

			servicePharmacie.save(pharmacie);
			log.info(om.writeValueAsString(pharmacie));

			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", pharmacie);

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Delete_Pharmacie
	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody ResponseEntity<?> deletePharmacieById(@PathVariable Long id) {

		try {

			servicePharmacie.deleteById(id);

			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", "Pharmacie id: " + id + " supprimée avec success");

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", "Pharmacie id " + id + " not found");

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// GetByRaisonSociale_Pharmacie
	@GetMapping(value = "/byRaisonSociale/{raisonSociale}")
	public @ResponseBody ResponseEntity<?> getPharmacieByRaisonSociale(@PathVariable String raisonSociale) {
		try {
			Page<Pharmacie> produitResult = servicePharmacie.findByRaisonSocialContainingIgnoreCase(raisonSociale, 1,
					10, "raisonSocial", "ASC");
//			System.out.println(om.writeValueAsString(produitResult));
			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", produitResult);

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Raison sociale introuvable", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/my-store")
	public @ResponseBody ResponseEntity<?> getStore() {
		try {
			Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			List<Pharmacie> pharma = servicePharmacie.findByUtilisateursIdUtilisateur(user.getIdUtilisateur());
			return new ResponseEntity<>(pharma, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Pas d'utilisateur", HttpStatus.BAD_REQUEST);
		}

	}

	// Get Pharmacie by Raison Social & district
	@GetMapping(value = "/{raisonSocial}/{district}")
	public @ResponseBody ResponseEntity<?> getPharmacyByRaisonSocialAndDistrict(
			@PathVariable(name = "raisonSocial") String raisonSocial,
			@PathVariable(name = "district") String district) {
		Pharmacie pharmacie = servicePharmacie.findByRaisonSocialAndAdresseDistrictNomDistrict(raisonSocial, district);

		return new ResponseEntity<>(pharmacie, HttpStatus.OK);
	}

}

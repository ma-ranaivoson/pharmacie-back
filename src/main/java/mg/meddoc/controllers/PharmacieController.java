package mg.meddoc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.meddoc.models.Pharmacie;
import mg.meddoc.services.PharmacieService;

@RestController
@RequestMapping(value = "/pharmacie")
@CrossOrigin(origins = { "*" })
@Component
public class PharmacieController {
	
	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(PharmacieController.class);

	@Autowired
	PharmacieService servicePharmacie;

	//GetAll_Pharmacie
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
	
	//GetById_Pharmacie
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getPharmacieById(@PathVariable Long id) {
		Pharmacie pharmacie = null;
		
		try {
			
			pharmacie = servicePharmacie.getById(id);
			log.info(om.writeValueAsString(pharmacie));
			return new ResponseEntity<>(pharmacie, HttpStatus.OK);
			
		} catch (Exception e) {
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}
	
	//Save_Pharmacie
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> savePharmacie(@RequestBody Pharmacie pharmacie) {
		
		try {
			if(pharmacie.getRaisonSocial()==null)
				throw new Exception("Raison sociale ne peut pas être vide");
			if(pharmacie.getRaisonSocial()=="")
				throw new Exception("Raison sociale ne peut pas être vide");
			if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
				throw new Exception("Latitude incorrect");
			if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
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

	//Delete_Pharmacie	
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

	//GetByRaisonSociale_Pharmacie
	@GetMapping(value = "/byRaisonSociale/{raisonSociale}")
	public @ResponseBody ResponseEntity<?> getPharmacieByRaisonSociale(@PathVariable String raisonSociale) {
		//Pharmacie pharmacie = null;
		
		try {
			
			//List <Pharmacie> pharmacies = (List<Pharmacie>) servicePharmacie.recherchePharmacie(raisonSociale);
			@SuppressWarnings("unchecked")
			Page<Pharmacie> pharmacieResult = servicePharmacie.findByRaisonSocialContainingIgnoreCase(raisonSociale, 1, 10, "raisonSocial", "ASC");
			System.out.println(om.writeValueAsString(pharmacieResult));
			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", pharmacieResult);
			
			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Raison sociale introuvable", HttpStatus.BAD_REQUEST);
		}
	}
	
}

package mg.meddoc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@CrossOrigin(origins = {"*"})
@Component
public class PharmacieController {
	
	ObjectMapper om=new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(PharmacieController.class);
	
	@Autowired
	PharmacieService servicePharmacie;
	
//GetAll_Pharmacie
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllPharmacie() {
		List<Pharmacie> pharmacie = new ArrayList<Pharmacie>();
		try {
			
			pharmacie = servicePharmacie.getAll();
			log.info(om.writeValueAsString(pharmacie));
			return new ResponseEntity<>(pharmacie,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux",HttpStatus.BAD_REQUEST);
		}
	}
//GetById_Pharmacie
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getPharmacieById(@PathVariable Long id) {
			Pharmacie pharmacie = null;
			try {
				
				pharmacie = servicePharmacie.getById(id);
				log.info(om.writeValueAsString(pharmacie));
				return new ResponseEntity<>(pharmacie,HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur ou n'est pas dans la BDD",HttpStatus.BAD_REQUEST);
			}
		}
//Save_Pharmacie
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> savePharmacie(@RequestBody Pharmacie pharmacie) {
		try {
//			Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
			servicePharmacie.save(pharmacie);
			log.info(om.writeValueAsString(pharmacie));
			return new ResponseEntity<>("Pharmacie inscrite avec succès",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Une erreur s'est produite",HttpStatus.BAD_REQUEST);
		}
	}
//Delete_Pharmacie	
	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody ResponseEntity<?> deletePharmacieById(@PathVariable Long id) {
		try {
//			Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
			servicePharmacie.deleteById(id);
//			servicePharmacie.save(pharmacie);
//			log.info(om.writeValueAsString(pharmacie));
			return new ResponseEntity<>("Pharmacie supprimée avec succès",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Une erreur s'est produite",HttpStatus.BAD_REQUEST);
		}
	}
//GetByRaisonSociale_Pharmacie
			@GetMapping(value = "/byRaisonSociale/{raisonSociale}")
			public @ResponseBody ResponseEntity<?> getPharmacieByRaisonSociale(@PathVariable String raisonSociale) {
				Pharmacie pharmacie = null;
				try {
					
					pharmacie = servicePharmacie.recherchePharmacie(raisonSociale);
					log.info(om.writeValueAsString(pharmacie));
					return new ResponseEntity<>(pharmacie,HttpStatus.OK);
					//return new ResponseEntity<>("Pharmacie trouvée avec succès",HttpStatus.OK);
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<>("Raison sociale introuvable",HttpStatus.BAD_REQUEST);
				}
			}
			
}

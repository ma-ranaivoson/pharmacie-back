package mg.meddoc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
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
import mg.meddoc.models.Paiement;
import mg.meddoc.services.PaiementService;

@RestController
@RequestMapping(value = "/paiement")
@CrossOrigin(origins = { "*" })
@Component
public class PaiementController {
	
	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(PaiementController.class);

	@Autowired
	PaiementService servicePaiement;
	
	//GetAll_Paiement
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllPaiement() {
			List<Paiement> paiement = new ArrayList<Paiement>();
			try {
				paiement = servicePaiement.getAll();
				System.out.println(om.writeValueAsString(paiement));
				return new ResponseEntity<>(paiement, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetById_Paiement
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getPaiementById(@PathVariable Long id) {
			Paiement paiement = null;
			
			try {
				
				paiement = servicePaiement.getById(id);
				log.info(om.writeValueAsString(paiement));
				return new ResponseEntity<>(paiement, HttpStatus.OK);
				
			} catch (Exception e) {
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		//Save_Paiement
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> savePaiement(@RequestBody Paiement paiement) {
			
			try {
//				if(pharmacie.getRaisonSocial()==null)
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getRaisonSocial()=="")
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
//					throw new Exception("Latitude incorrect");
//				if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
//					throw new Exception("Longitude incorrect");
				
				servicePaiement.save(paiement);
				log.info(om.writeValueAsString(paiement));
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", paiement);
				
				return new ResponseEntity<>(success, HttpStatus.OK);			
			} catch (Exception e) {
				e.printStackTrace();
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

		//Delete_Paiement	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deletePaiementById(@PathVariable Long id) {
			
			try {		
				
				servicePaiement.deleteById(id);
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", "Paiement id: " + id + " supprimée avec success");
				
				return new ResponseEntity<>(success, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", "Paiement id " + id + " not found");
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
	
}

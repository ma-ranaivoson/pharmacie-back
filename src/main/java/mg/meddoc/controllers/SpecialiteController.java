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

import mg.meddoc.models.Pharmacie;
import mg.meddoc.models.Specialite;
import mg.meddoc.services.PharmacieService;
import mg.meddoc.services.SpecialiteService;

@RestController
@RequestMapping(value = "/specialite")
@CrossOrigin(origins = { "*" })
@Component
public class SpecialiteController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(SpecialiteController.class);

	@Autowired
	SpecialiteService serviceSpecialite;
	
	//GetAll_Specialite
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllSpecialite() {
			List<Specialite> specialite = new ArrayList<Specialite>();
			try {
				specialite = serviceSpecialite.getAll();
				System.out.println(om.writeValueAsString(specialite));
				return new ResponseEntity<>(specialite, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetById_Specialite
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getSpecialiteById(@PathVariable Long id) {
			Specialite specialite = null;
			
			try {
				
				specialite = serviceSpecialite.getById(id);
				log.info(om.writeValueAsString(specialite));
				return new ResponseEntity<>(specialite, HttpStatus.OK);
				
			} catch (Exception e) {
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		//Save_Service
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> saveSpecialite(@RequestBody Specialite specialite) {
			
			try {
//				if(pharmacie.getRaisonSocial()== null)
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getRaisonSocial()=="")
//					throw new Exception("Raison sociale tena vide");
//				if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
//					throw new Exception("Latitude incorrect");
//				if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
//					throw new Exception("Longitude incorrect");
				
				serviceSpecialite.save(specialite);
				log.info(om.writeValueAsString(specialite));
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", specialite);
				
				return new ResponseEntity<>(success, HttpStatus.OK);			
			} catch (Exception e) {
				e.printStackTrace();
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

		//Delete_Specialite	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deleteSpecialiteById(@PathVariable Long id) {
			
			try {		
				
				serviceSpecialite.deleteById(id);
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", "Specialite id: " + id + " supprimée avec success");
				
				return new ResponseEntity<>(success, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", "Specialite id " + id + " not found");
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
	
}

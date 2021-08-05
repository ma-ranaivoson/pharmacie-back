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

import mg.meddoc.models.SousCategorie;
import mg.meddoc.services.SousCategorieService;

@RestController
@RequestMapping(value = "/sous_categorie")
@CrossOrigin(origins = { "*" })
@Component
public class SousCategorieController {
	
	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(SousCategorieController.class);

	@Autowired
	SousCategorieService serviceSousCategorie;
	
	//GetAll_SousCategorie
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllSousCategorie() {
			List<SousCategorie> souscategorie = new ArrayList<SousCategorie>();
			try {
				souscategorie = serviceSousCategorie.getAll();
				System.out.println(om.writeValueAsString(souscategorie));
				return new ResponseEntity<>(souscategorie, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetById_SousCategorie
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getSouCategorieById(@PathVariable Long id) {
			SousCategorie souscategorie = null;
			
			try {
				
				souscategorie = serviceSousCategorie.getById(id);
				log.info(om.writeValueAsString(souscategorie));
				return new ResponseEntity<>(souscategorie, HttpStatus.OK);
				
			} catch (Exception e) {
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		//Save_SousCategorie
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> saveSousCatgorie(@RequestBody SousCategorie souscategorie) {
			
			try {
//				if(pharmacie.getRaisonSocial()== null)
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getRaisonSocial()=="")
//					throw new Exception("Raison sociale tena vide");
//				if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
//					throw new Exception("Latitude incorrect");
//				if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
//					throw new Exception("Longitude incorrect");
				
				serviceSousCategorie.save(souscategorie);
				log.info(om.writeValueAsString(souscategorie));
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", souscategorie);
				
				return new ResponseEntity<>(success, HttpStatus.OK);			
			} catch (Exception e) {
				e.printStackTrace();
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

		//Delete_SousCategorie	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deleteSousCategorieById(@PathVariable Long id) {
			
			try {		
				
				serviceSousCategorie.deleteById(id);
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", "SousCategorie id: " + id + " supprimée avec success");
				
				return new ResponseEntity<>(success, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", "SousCategorie id " + id + " not found");
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
	
	
}

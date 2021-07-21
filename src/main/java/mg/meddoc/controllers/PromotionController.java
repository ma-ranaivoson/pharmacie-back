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
import mg.meddoc.models.*;
import mg.meddoc.services.PromotionService;

@RestController
@RequestMapping(value = "/promotion")
@CrossOrigin(origins = { "*" })
@Component
public class PromotionController {
	
	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(PromotionController.class);

	@Autowired
	PromotionService servicePromotion;
	
	//GetAll_Promotion
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllPromotion() {
			List<Promotion> promotion = new ArrayList<Promotion>();
			try {
				promotion = servicePromotion.getAll();
				System.out.println(om.writeValueAsString(promotion));
				return new ResponseEntity<>(promotion, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetById_Promotion
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getPromotionById(@PathVariable Long id) {
			Promotion promotion = null;
			
			try {
				
				promotion = servicePromotion.getById(id);
				log.info(om.writeValueAsString(promotion));
				return new ResponseEntity<>(promotion, HttpStatus.OK);
				
			} catch (Exception e) {
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		//Save_Promotion
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> savePpromotion(@RequestBody Promotion promotion) {
			
			try {
//				if(pharmacie.getRaisonSocial()==null)
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getRaisonSocial()=="")
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
//					throw new Exception("Latitude incorrect");
//				if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
//					throw new Exception("Longitude incorrect");
				
				servicePromotion.save(promotion);
				log.info(om.writeValueAsString(promotion));
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", promotion);
				
				return new ResponseEntity<>(success, HttpStatus.OK);			
			} catch (Exception e) {
				e.printStackTrace();
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

		//Delete_Promotion	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deletePharmacieById(@PathVariable Long id) {
			
			try {		
				
				servicePromotion.deleteById(id);
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", "Promotion id: " + id + " supprimée avec success");
				
				return new ResponseEntity<>(success, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", "Promotion id " + id + " not found");
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
}

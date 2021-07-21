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
import mg.meddoc.models.Garde;
import mg.meddoc.services.GardeService;

@RestController
@RequestMapping(value = "/garde")
@CrossOrigin(origins = { "*" })
@Component
public class GardeController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(GardeController.class);

	@Autowired
	GardeService serviceGarde;
	
	//GetAll_Garde
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllGarde() {
			List<Garde> garde = new ArrayList<Garde>();
			try {
				garde = serviceGarde.getAll();
				System.out.println(om.writeValueAsString(garde));
				return new ResponseEntity<>(garde, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetById_Garde
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getGardeById(@PathVariable Long id) {
			Garde garde = null;
			
			try {
				
				garde = serviceGarde.getById(id);
				log.info(om.writeValueAsString(garde));
				return new ResponseEntity<>(garde, HttpStatus.OK);
				
			} catch (Exception e) {
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		//Save_Garde
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> saveGarde(@RequestBody Garde garde) {
			
			try {
//				if(pharmacie.getRaisonSocial()==null)
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getRaisonSocial()=="")
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
//					throw new Exception("Latitude incorrect");
//				if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
//					throw new Exception("Longitude incorrect");
				
				serviceGarde.save(garde);
				log.info(om.writeValueAsString(garde));
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", garde);
				
				return new ResponseEntity<>(success, HttpStatus.OK);			
			} catch (Exception e) {
				e.printStackTrace();
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

		//Delete_Garde	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deleteGardeById(@PathVariable Long id) {
			
			try {		
				
				serviceGarde.deleteById(id);
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", "Garde id: " + id + " supprimée avec success");
				
				return new ResponseEntity<>(success, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", "Garde id " + id + " not found");
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

}

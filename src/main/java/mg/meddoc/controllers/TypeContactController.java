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
//import mg.meddoc.services.PharmacieService;
import mg.meddoc.services.Type_ContactService;

@RestController
@RequestMapping(value = "/type_ontact")
@CrossOrigin(origins = { "*" })
@Component
public class TypeContactController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(TypeContactController.class);

	@Autowired
	Type_ContactService serviceTypeContact;
	
	//GetAll_TypeContact
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllTypeContact() {
			List<Type_Contact> typecontact = new ArrayList<Type_Contact>();
			try {
				typecontact = serviceTypeContact.getAll();
				System.out.println(om.writeValueAsString(typecontact));
				return new ResponseEntity<>(typecontact, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetById_TypeContact
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getTypeContactById(@PathVariable Long id) {
			Type_Contact typecontact = null;
			
			try {
				
				typecontact = serviceTypeContact.getById(id);
				log.info(om.writeValueAsString(typecontact));
				return new ResponseEntity<>(typecontact, HttpStatus.OK);
				
			} catch (Exception e) {
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		//Save_TypeContact
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> saveTypeContact(@RequestBody Type_Contact typecontact) {
			
			try {
//				if(pharmacie.getRaisonSocial()==null)
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getRaisonSocial()=="")
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
//					throw new Exception("Latitude incorrect");
//				if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
//					throw new Exception("Longitude incorrect");
				
				serviceTypeContact.save(typecontact);
				log.info(om.writeValueAsString(typecontact));
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", typecontact);
				
				return new ResponseEntity<>(success, HttpStatus.OK);			
			} catch (Exception e) {
				e.printStackTrace();
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

		//Delete_TypeContact	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deleteTypeContactById(@PathVariable Long id) {
			
			try {		
				
				serviceTypeContact.deleteById(id);
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", "TypeContact id: " + id + " supprimée avec success");
				
				return new ResponseEntity<>(success, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", "TypeContact id " + id + " not found");
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
	
}

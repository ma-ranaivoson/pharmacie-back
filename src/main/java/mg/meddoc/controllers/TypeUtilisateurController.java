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
import mg.meddoc.services.Type_UtilisateurService;
import mg.meddoc.models.*;

@RestController
@RequestMapping(value = "/type_utilisateur")
@CrossOrigin(origins = { "*" })
@Component
public class TypeUtilisateurController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(TypeUtilisateurController.class);

	@Autowired
	Type_UtilisateurService serviceTypeUtilisateur;
	
	//GetAll_TypeUtilisateur
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllTypeUtilisateur() {
			List<TypeUtilisateur> typeUtilisateur = new ArrayList<TypeUtilisateur>();
			try {
				typeUtilisateur = serviceTypeUtilisateur.getAll();
				System.out.println(om.writeValueAsString(typeUtilisateur));
				return new ResponseEntity<>(typeUtilisateur, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetById_TypeUtilisateur
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getTypeUtilisateurById(@PathVariable Long id) {
			TypeUtilisateur typeUtilisateur = null;
			
			try {
				
				typeUtilisateur = serviceTypeUtilisateur.getById(id);
				log.info(om.writeValueAsString(typeUtilisateur));
				return new ResponseEntity<>(typeUtilisateur, HttpStatus.OK);
				
			} catch (Exception e) {
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		//Save_TypeUtilisateur
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> saveTypeUtilisateur(@RequestBody TypeUtilisateur typeUtilisateur) {
			
			try {
//				if(pharmacie.getRaisonSocial()==null)
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getRaisonSocial()=="")
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
//					throw new Exception("Latitude incorrect");
//				if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
//					throw new Exception("Longitude incorrect");
				
				serviceTypeUtilisateur.save(typeUtilisateur);
				log.info(om.writeValueAsString(typeUtilisateur));
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", typeUtilisateur);
				
				return new ResponseEntity<>(success, HttpStatus.OK);			
			} catch (Exception e) {
				e.printStackTrace();
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

		//Delete_TypeUtilisateur	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deleteTypeUtilisateurById(@PathVariable Long id) {
			
			try {		
				
				serviceTypeUtilisateur.deleteById(id);
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", "TypeUtilisateur id: " + id + " supprimée avec success");
				
				return new ResponseEntity<>(success, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", "TypeUtilisateur id " + id + " not found");
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		
}

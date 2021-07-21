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
import mg.meddoc.models.Panier;
import mg.meddoc.services.PanierService;

@RestController
@RequestMapping(value = "/panier")
@CrossOrigin(origins = { "*" })
@Component
public class PanierController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(PanierController.class);

	@Autowired
	PanierService servicePanier;
	
	//GetAll_Panier
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllPanier() {
			List<Panier> panier = new ArrayList<Panier>();
			try {
				panier = servicePanier.getAll();
				System.out.println(om.writeValueAsString(panier));
				return new ResponseEntity<>(panier, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetById_Panier
		@GetMapping(value = "/{id}")
		public @ResponseBody ResponseEntity<?> getPanierById(@PathVariable Long id) {
			Panier panier = null;
			
			try {
				
				panier = servicePanier.getById(id);
				log.info(om.writeValueAsString(panier));
				return new ResponseEntity<>(panier, HttpStatus.OK);
				
			} catch (Exception e) {
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		//Save_Panier
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> savePanier(@RequestBody Panier panier) {
			
			try {
//				if(pharmacie.getRaisonSocial()==null)
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getRaisonSocial()=="")
//					throw new Exception("Raison sociale ne peut pas être vide");
//				if(pharmacie.getLatitude()!= null&&(pharmacie.getLatitude()>100 || pharmacie.getLatitude()<0))
//					throw new Exception("Latitude incorrect");
//				if(pharmacie.getLongitude()!= null&&(pharmacie.getLongitude()>100 || pharmacie.getLongitude()<0))
//					throw new Exception("Longitude incorrect");
				
				servicePanier.save(panier);
				log.info(om.writeValueAsString(panier));
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", panier);
				
				return new ResponseEntity<>(success, HttpStatus.OK);			
			} catch (Exception e) {
				e.printStackTrace();
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", e.getMessage());
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}

		//Delete_Panier	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deletePanierById(@PathVariable Long id) {
			
			try {		
				
				servicePanier.deleteById(id);
				
				HashMap<String, Object> success = new HashMap<String, Object>();
				success.put("success", true);
				success.put("data", "Panier id: " + id + " supprimée avec success");
				
				return new ResponseEntity<>(success, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				
				HashMap<String, Object> error = new HashMap<String, Object>();
				error.put("success", false);
				error.put("errors", "Panier id " + id + " not found");
				
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}
		}
		
		
}

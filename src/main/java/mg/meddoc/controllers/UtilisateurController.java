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
import mg.meddoc.models.Utilisateur;
import mg.meddoc.services.UtilisateurService;

@RestController
@RequestMapping(value = "/utiliisateur")
@CrossOrigin(origins = {"*"})
@Component
public class UtilisateurController {
	
	ObjectMapper om=new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(UtilisateurController.class);
	
	@Autowired
	UtilisateurService serviceUtilisateur;
	
	//GetAll_Utilisateur
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllPharmacie() {
			List<Utilisateur> utilisateur = new ArrayList<Utilisateur>();
			try {
				
				utilisateur = serviceUtilisateur.getAll();
				log.info(om.writeValueAsString(utilisateur));
				return new ResponseEntity<>(utilisateur,HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux",HttpStatus.BAD_REQUEST);
			}
		}
	//GetById_Utilisateur
			@GetMapping(value = "/{id}")
			public @ResponseBody ResponseEntity<?> getUtilisateurById(@PathVariable Long id) {
				Utilisateur utilisateur = null;
				try {
					
					utilisateur = serviceUtilisateur.getById(id);
					log.info(om.writeValueAsString(utilisateur));
					return new ResponseEntity<>(utilisateur,HttpStatus.OK);
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<>("Erreur ou n'est pas dans la BDD",HttpStatus.BAD_REQUEST);
				}
			}
	//Save_Utilisateur
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> savePharmacie(@RequestBody Utilisateur utilisateur) {
			try {
//				Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
				serviceUtilisateur.save(utilisateur);
				log.info(om.writeValueAsString(utilisateur));
				return new ResponseEntity<>("Utilisateur inscrite avec succès",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Une erreur s'est produite",HttpStatus.BAD_REQUEST);
			}
		}
	//Delete_Utilisateur	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deleteUtilisateurById(@PathVariable Long id) {
			try {
//				Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
				serviceUtilisateur.deleteById(id);
//				servicePharmacie.save(pharmacie);
//				log.info(om.writeValueAsString(pharmacie));
				return new ResponseEntity<>("Utilisateur supprimée avec succès",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Une erreur s'est produite",HttpStatus.BAD_REQUEST);
			}
		}
		
		//GetByRaisonSociale_Utilisateur
		@GetMapping(value = "/byNom/{nom}")
		public @ResponseBody ResponseEntity<?> getPharmacieByRaisonSociale(@PathVariable String nom) {
			Utilisateur utilisateur = null;
			try {
				
				utilisateur = serviceUtilisateur.rechercheUtilisateur(nom);
				log.info(om.writeValueAsString(utilisateur));
				return new ResponseEntity<>(utilisateur,HttpStatus.OK);
				//return new ResponseEntity<>("Pharmacie trouvée avec succès",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Raison sociale introuvable",HttpStatus.BAD_REQUEST);
			}
		}
			
}

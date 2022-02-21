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

import mg.meddoc.models.Categorie;
import mg.meddoc.models.Galerie;
import mg.meddoc.services.GalerieService;

@RestController
@RequestMapping(value = "/galerie")
@CrossOrigin(origins = {"*"})
@Component
public class GallerieController {
	
	ObjectMapper om=new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(GallerieController.class);
	
	@Autowired
	GalerieService serviceGalerie;
	
	//GetAll_Galerie
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllGalerie() {
			List<Galerie> galerie = new ArrayList<Galerie>();
			try {
				
				galerie = serviceGalerie.getAll();
				log.info(om.writeValueAsString(galerie));
				return new ResponseEntity<>(galerie,HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux",HttpStatus.BAD_REQUEST);
			}
		}

		@GetMapping(value = "/all/select/{idPharmacie}")
		public @ResponseBody ResponseEntity<?> getAllGallerySelect() {
			List<Galerie> galerie = new ArrayList<Galerie>();
			try {
				galerie = serviceGalerie.getAll();
				List<HashMap<String,Object>> retour = new ArrayList<HashMap<String, Object>>();
				HashMap<String,Object> maps = null;
				for(Galerie cat:galerie) {
					maps = new HashMap<String, Object>();
					maps.put("value", cat.getAlbum());
					maps.put("label", cat.getAlbum());
					retour.add(maps);
				}
				System.out.println(om.writeValueAsString(retour));
				return new ResponseEntity<>(retour, HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
			}
		}
		
	//GetById_Galerie
			@GetMapping(value = "/{id}")
			public @ResponseBody ResponseEntity<?> getGalerieById(@PathVariable Long id) {
				Galerie galerie = null;
				try {
					
					galerie = serviceGalerie.getById(id);
					log.info(om.writeValueAsString(galerie));
					return new ResponseEntity<>(galerie,HttpStatus.OK);
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<>("Erreur ou n'est pas dans la BDD",HttpStatus.BAD_REQUEST);
				}
			}
	//Save_Galerie
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> saveGalerie(@RequestBody Galerie galerie) {
			try {
//				Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
				serviceGalerie.save(galerie);
				log.info(om.writeValueAsString(galerie));
				return new ResponseEntity<>("Galerie inscrite avec succès",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Une erreur s'est produite "+e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
	
		
	//Delete_Galerie
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deleteGalerieById(@PathVariable Long id) {
			try {
//				Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
				serviceGalerie.deleteById(id);
//				servicePharmacie.save(pharmacie);
//				log.info(om.writeValueAsString(pharmacie));
				return new ResponseEntity<>("Pharmacie supprimée avec succès",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Une erreur s'est produite",HttpStatus.BAD_REQUEST);
			}
		}
	
}

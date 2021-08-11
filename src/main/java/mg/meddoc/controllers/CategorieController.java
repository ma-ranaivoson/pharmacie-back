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
import mg.meddoc.models.SousCategorie;
import mg.meddoc.services.CategorieService;

@RestController
@RequestMapping(value = "/categorie")
@CrossOrigin(origins = {"*"})
@Component
public class CategorieController {
	
	ObjectMapper om=new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(CategorieController.class);
	
	@Autowired
	CategorieService serviceCategorie;
	
	@GetMapping(value = "/all/select")
	public @ResponseBody ResponseEntity<?> getAllCategorieSelect() {
		List<Categorie> categorie = new ArrayList<Categorie>();
		try {
			categorie = serviceCategorie.getAll();
			List<HashMap<String,Object>> retour = new ArrayList<HashMap<String, Object>>();
			HashMap<String,Object> maps = null;
			for(Categorie cat:categorie) {
				maps = new HashMap<String, Object>();
				maps.put("value", cat.getIdCategorie());
				maps.put("label", cat.getLibelle());
				retour.add(maps);
			}
			System.out.println(om.writeValueAsString(retour));
			return new ResponseEntity<>(retour, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}
	
	//GetAll_Categorie
		@GetMapping(value = "/all")
		public @ResponseBody ResponseEntity<?> getAllCategorie() {
			List<Categorie> categorie = new ArrayList<Categorie>();
			try {
				
				categorie = serviceCategorie.getAll();
				log.info(om.writeValueAsString(categorie));
				return new ResponseEntity<>(categorie,HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Erreur",HttpStatus.BAD_REQUEST);
			}
		}
	//GetById_Categorie
			@GetMapping(value = "/{id}")
			public @ResponseBody ResponseEntity<?> getCategorieById(@PathVariable Long id) {
				Categorie categorie = null;
				try {
					
					categorie = serviceCategorie.getById(id);
					log.info(om.writeValueAsString(categorie));
					return new ResponseEntity<>(categorie,HttpStatus.OK);
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<>("Erreur ou n'est pas dans la BDD",HttpStatus.BAD_REQUEST);
				}
			}
	//Save_Categorie
		@PostMapping(value = "/save")
		public @ResponseBody ResponseEntity<?> saveCategorie(@RequestBody Categorie categorie) {
			try {
				serviceCategorie.save(categorie);
				log.info(om.writeValueAsString(categorie));
				return new ResponseEntity<>("Categorie inscrite avec succès",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Une erreur s'est produite",HttpStatus.BAD_REQUEST);
			}
		}
	//Delete_Categorie	
		@DeleteMapping(value = "/delete/{id}")
		public @ResponseBody ResponseEntity<?> deleteCategorieById(@PathVariable Long id) {
			try {
				serviceCategorie.deleteById(id);
				return new ResponseEntity<>("Categorie supprimée avec succès",HttpStatus.OK);
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Une erreur s'est produite",HttpStatus.BAD_REQUEST);
			}
		}
	//GetByLibelle_Categorie
				@GetMapping(value = "/byLibelle/{libelle}")
				public @ResponseBody ResponseEntity<?> getCategorieByLibelle(@PathVariable String libelle) {
					Categorie categorie = null;
					try {
						
						categorie = serviceCategorie.rechercheCategorie(libelle);
						log.info(om.writeValueAsString(categorie));
						return new ResponseEntity<>(categorie,HttpStatus.OK);
					} catch (Exception e) {
						e.printStackTrace();
						return new ResponseEntity<>("Nom Categorie introuvable",HttpStatus.BAD_REQUEST);
					}
				}
	
}

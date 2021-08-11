package mg.meddoc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import mg.meddoc.models.Prix;
import mg.meddoc.models.Produit;
import mg.meddoc.models.ProduitData;
import mg.meddoc.services.PrixService;
import mg.meddoc.services.ProduitService;

@RestController
@RequestMapping(value = "/produit")
@CrossOrigin(origins = { "*" })
@Component
public class ProduitController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(ProduitController.class);

	@Autowired
	ProduitService serviceProduit;
	@Autowired
	PrixService servicePrix;

	// GetAll_Produit
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllProduit() {
		List<Produit> produit = new ArrayList<Produit>();
		try {

			produit = serviceProduit.getAll();
			log.info(om.writeValueAsString(produit));
			return new ResponseEntity<>(produit, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}

	// GetById_Produit
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getProduitById(@PathVariable Long id) {
		Produit produit = null;
		try {

			produit = serviceProduit.getById(id);
			log.info(om.writeValueAsString(produit));
			return new ResponseEntity<>(produit, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			//return new ResponseEntity<>("Erreur ou n'est pas dans la BDD", HttpStatus.BAD_REQUEST);
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Save_Produit
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> saveProduit(@RequestBody ProduitData produit) {
		try {
			log.info(om.writeValueAsString(produit));
			Produit saved = serviceProduit.save(produit.toProduit());
			Prix prix = null;
			if(produit.getPrix()!=null||produit.getPrix().size()>0) {
				prix = produit.getPrix().iterator().next();
				prix.setIdPharmacie(saved.getIdPharmacie());
				prix.setIdProduit(saved.getIdProduit());
				servicePrix.save(prix);
			}
			produit = new ProduitData(saved,prix);
			return new ResponseEntity<>(produit, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());
			return new ResponseEntity<>("Une erreur s'est produite", HttpStatus.BAD_REQUEST);
		}
	}
	
	// Delete_Produit
	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody ResponseEntity<?> deleteProduitById(@PathVariable Long id) {
		try {
//				Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
			serviceProduit.deleteById(id);
			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", "Produit id: " + id + " supprimée avec success");
//				servicePharmacie.save(pharmacie);
//				log.info(om.writeValueAsString(pharmacie));
			//return new ResponseEntity<>("Produit supprimée avec succès", HttpStatus.OK);
			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", "Produit id " + id + " not found");
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}
	
	// GetByDesignation/Produit
	@GetMapping(value = "/byDesignation/{designation}")
	public @ResponseBody ResponseEntity<?> getProduitByDesignation(@PathVariable String designation) {
		//Produit produit = null;
		try {
			
			//produit = serviceProduit.rechercheProduit(designation);
			//Page<Produit> produitResult = serviceProduit.findByRaisonSocialContainingIgnoreCase(designation, 1, 10, "raisonSocial", "ASC");
			//@SuppressWarnings("unchecked")
			Page<Produit> produitResult = serviceProduit.findByDesignationContainingIgnoreCase(designation, 1, 10, "raisonSocial", "ASC");	
			System.out.println(om.writeValueAsString(produitResult));
			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", produitResult);
			
			//log.info(om.writeValueAsString(produitResult));
			return new ResponseEntity<>(success, HttpStatus.OK);
			// return new ResponseEntity<>("Pharmacie trouvée avec succès",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Designation introuvable", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/search/{designation}/{page}/{size}/{direction}/{columnSort}")
	public @ResponseBody ResponseEntity<?> search(@PathVariable String designation,@PathVariable String page,@PathVariable String size,@PathVariable String direction,@PathVariable String columnSort) {
//		Produit produit = null;
		try {
			if(direction==null||direction.compareTo("----")==0)
				direction = null;
			if(columnSort==null||columnSort.compareTo("----")==0)
				columnSort = null;
			Page<Produit> produits = serviceProduit.findByDesignationContainingIgnoreCase(designation, Integer.parseInt(page), Integer.parseInt(size), columnSort, direction);
			log.info(om.writeValueAsString(produits));
			return new ResponseEntity<>(produits, HttpStatus.OK);
			// return new ResponseEntity<>("Pharmacie trouvée avec succès",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Designation introuvable", HttpStatus.BAD_REQUEST);
		}
	}

}

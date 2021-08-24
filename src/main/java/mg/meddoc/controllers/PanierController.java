package mg.meddoc.controllers;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
import mg.meddoc.models.Utilisateur;
import mg.meddoc.services.PanierService;
import mg.meddoc.services.PrixService;
import mg.meddoc.services.ProduitService;

@RestController
@RequestMapping(value = "/panier")
@CrossOrigin(origins = { "*" })
@Component
public class PanierController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(PanierController.class);

	@Autowired
	PanierService servicePanier;
	@Autowired
	ProduitService serviceProduit;
	@Autowired
	PrixService servicePrix;

	// GetAll_Panier
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllPanier() {
		List<Panier> panier = new ArrayList<Panier>();
		try {
			panier = servicePanier.getAll();
			System.out.println(om.writeValueAsString(panier));
			return new ResponseEntity<>(panier, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	// GetById_Panier
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

	// Save_Panier
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> savePanier(@RequestBody Panier panier) {
		Panier cartToSave = new Panier();
		Double prixByPharmacie = null;

		try {
			Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			// Set idUtilisateur
			cartToSave.setIdUtilisateur(user.getIdUtilisateur());

			// Set idProduit
			cartToSave.setIdProduit(panier.getIdProduit());

			// Set pharmacie
			cartToSave.setIdPharmacie(panier.getIdPharmacie());

			// Set utilisateur
			cartToSave.setIdUtilisateur(user.getIdUtilisateur());

			// Get prix by pharmacie
			prixByPharmacie = servicePrix
					.getPrixByIdProduitAndIdPharmacie(panier.getIdProduit(), panier.getIdPharmacie()).getPrix();

			// Set total montant
			Double totalMontant = panier.getQuantite() * prixByPharmacie;
			cartToSave.setMontant(totalMontant);

			// Set id paiement & date d'ajout
			cartToSave.setIdPaiement(null);
			cartToSave.setDate_ajout(new Timestamp(System.currentTimeMillis()));

			// Set unité to null
			cartToSave.setUnite(null);

			// Set statut
			cartToSave.setStatut(0);

			panier = servicePanier.save(cartToSave);

			return new ResponseEntity<>(panier, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("errors", e.getMessage());

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Delete_Panier
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
			error.put("errors", "Panier id " + id + " not found");

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/not-paid")
	public @ResponseBody ResponseEntity<?> getNotPaidProducts() {
		Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(user.getNom());
		List<Panier> panier = servicePanier.getPanierNotPaid(user.getIdUtilisateur());

		return new ResponseEntity<>(panier, HttpStatus.OK);
	}

	// Add count product
	@GetMapping(value = "/produit/{idProduit}/pharmacie/{idPharmacie}/add")
	public @ResponseBody ResponseEntity<?> addProductQuantity(@PathVariable Long idProduit,
			@PathVariable Long idPharmacie) {
		Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Panier userCartProduct = servicePanier.getCartByIdProduct(idProduit, idPharmacie, user.getIdUtilisateur());

		userCartProduct.setQuantite(userCartProduct.getQuantite() + 1);
		userCartProduct.setMontant(userCartProduct.getQuantite() * Double.parseDouble(userCartProduct.getUnite()));
		servicePanier.save(userCartProduct);

		return new ResponseEntity<>(userCartProduct, HttpStatus.OK);
	}

	// Remove count Product
	@GetMapping(value = "/produit/{idProduit}/pharmacie/{idPharmacie}/remove")
	public @ResponseBody ResponseEntity<?> removeProductQuantity(@PathVariable Long idProduit,
			@PathVariable Long idPharmacie) {
		Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Panier userCartProduct = servicePanier.getCartByIdProduct(idProduit, idPharmacie, user.getIdUtilisateur());
		Double quantity = userCartProduct.getQuantite();

		if (quantity <= 1) {
			userCartProduct.setQuantite((double) 1);
			userCartProduct.setMontant(userCartProduct.getQuantite() * Double.parseDouble(userCartProduct.getUnite()));
			servicePanier.save(userCartProduct);
		} else {
			userCartProduct.setQuantite(userCartProduct.getQuantite() - 1);
			userCartProduct.setMontant(userCartProduct.getQuantite() * Double.parseDouble(userCartProduct.getUnite()));
			servicePanier.save(userCartProduct);
		}

		return new ResponseEntity<>(userCartProduct, HttpStatus.OK);
	}
}

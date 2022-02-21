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
import mg.meddoc.models.Marque;
import mg.meddoc.models.SousCategorie;
import mg.meddoc.services.MarqueService;

@RestController
@RequestMapping(value = "/marque")
@CrossOrigin(origins = { "*" })
@Component
public class MarqueController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(MarqueController.class);

	@Autowired
	MarqueService serviceMarque;

	// GetAll_Marque
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllMarque() {
		List<Marque> marque = new ArrayList<Marque>();
		try {
			marque = serviceMarque.getAll();
			System.out.println(om.writeValueAsString(marque));
			return new ResponseEntity<>(marque, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/all/select")
	public @ResponseBody ResponseEntity<?> getAllMarqueSelect() {
		List<Marque> marques = new ArrayList<Marque>();
		try {
			marques = serviceMarque.getAll();
			List<HashMap<String, Object>> retour = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> maps = null;
			for (Marque marque : marques) {
				maps = new HashMap<String, Object>();
				maps.put("value", marque.getIdMarque());
				maps.put("label", marque.getNomination());
				retour.add(maps);
			}
			System.out.println(om.writeValueAsString(retour));
			return new ResponseEntity<>(retour, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}

	// GetById_Marque
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getMarqueById(@PathVariable Long id) {
		Marque marque = null;

		try {

			marque = serviceMarque.getById(id);
			log.info(om.writeValueAsString(marque));
			return new ResponseEntity<>(marque, HttpStatus.OK);

		} catch (Exception e) {
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Save_Marque
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> saveMarque(@RequestBody Marque marque) {

		try {
			serviceMarque.save(marque);
			log.info(om.writeValueAsString(marque));

			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", marque);

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Delete_Marque
	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody ResponseEntity<?> deleteMarqueById(@PathVariable Long id) {

		try {
			serviceMarque.deleteById(id);

			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", "Marque id: " + id + " supprimée avec success");

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", "Marque id " + id + " not found");

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

}

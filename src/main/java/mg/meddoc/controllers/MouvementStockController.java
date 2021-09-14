package mg.meddoc.controllers;

import java.sql.Date;
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
import mg.meddoc.services.MouvementStockService;

@RestController
@RequestMapping(value = "/mouvementstock")
@CrossOrigin(origins = { "*" })
@Component
public class MouvementStockController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(MouvementStockController.class);

	@Autowired
	MouvementStockService serviceMouvementStock;

	// GetAll_MouvementStock
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllMouvementStock() {
		List<MouvementStock> mouv_stock = new ArrayList<MouvementStock>();
		try {
			mouv_stock = serviceMouvementStock.getAll();
			System.out.println(om.writeValueAsString(mouv_stock));
			return new ResponseEntity<>(mouv_stock, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}

	// GetById_MouvementStock
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getMouvementStockById(@PathVariable Long id) {
		MouvementStock mouv_stock = null;

		try {

			mouv_stock = serviceMouvementStock.getById(id);
			log.info(om.writeValueAsString(mouv_stock));
			return new ResponseEntity<>(mouv_stock, HttpStatus.OK);

		} catch (Exception e) {
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Save_MouvementStock
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> saveMmouvementStock(@RequestBody MouvementStock mouv_stock) {

		try {
			mouv_stock.setDate_stock(new Date(System.currentTimeMillis()));
			serviceMouvementStock.save(mouv_stock);
			log.info(om.writeValueAsString(mouv_stock));

			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", mouv_stock);

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Delete_MouvementStock
	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody ResponseEntity<?> deleteMouvementStockById(@PathVariable Long id) {

		try {

			serviceMouvementStock.deleteById(id);

			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", "MouvementStock id: " + id + " supprimée avec success");

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", "MouvementStock id " + id + " not found");

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

}

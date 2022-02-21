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
import mg.meddoc.services.EmploiDuTempsService;
import mg.meddoc.models.EmploiDuTemps;

@RestController
@RequestMapping(value = "/emploidutemps")
@CrossOrigin(origins = { "*" })
@Component
public class EmploiDuTempsController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(EmploiDuTempsController.class);

	@Autowired
	EmploiDuTempsService serviceEPT;

	// GetAll_EPT
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllEmploiDuTemps() {
		List<EmploiDuTemps> ept = new ArrayList<EmploiDuTemps>();
		try {
			ept = serviceEPT.getAll();
			System.out.println(om.writeValueAsString(ept));
			return new ResponseEntity<>(ept, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}

	// GetById_EPT
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getEmploiDuTempsById(@PathVariable Long id) {
		EmploiDuTemps ept = null;

		try {

			ept = serviceEPT.getById(id);
			log.info(om.writeValueAsString(ept));
			return new ResponseEntity<>(ept, HttpStatus.OK);

		} catch (Exception e) {
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Save_EPT
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> saveEmploiDuTemps(@RequestBody EmploiDuTemps ept) {

		try {
			serviceEPT.save(ept);
			log.info(om.writeValueAsString(ept));

			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", ept);

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", e.getMessage());

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	// Delete_EmploiDuTemps
	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody ResponseEntity<?> deleteEmploiDuTempsById(@PathVariable Long id) {

		try {

			serviceEPT.deleteById(id);

			HashMap<String, Object> success = new HashMap<String, Object>();
			success.put("success", true);
			success.put("data", "EmploiDuTemps id: " + id + " supprimée avec success");

			return new ResponseEntity<>(success, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

			HashMap<String, Object> error = new HashMap<String, Object>();
			error.put("success", false);
			error.put("errors", "EmploiDuTemps id " + id + " not found");

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

}

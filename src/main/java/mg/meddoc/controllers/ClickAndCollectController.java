package mg.meddoc.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.meddoc.models.ClickAndCollect;
import mg.meddoc.models.Utilisateur;
import mg.meddoc.services.ClickAndCollectService;

@RestController
@RequestMapping(value = "/click-and-collect")
@CrossOrigin(origins = { "*" })
@Component
public class ClickAndCollectController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(ClickAndCollectController.class);

	@Autowired
	ClickAndCollectService serviceClickAndCollect;

	// GetAll_Contact
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllClickAndCollect() {
		List<ClickAndCollect> clickAndCollect = new ArrayList<ClickAndCollect>();
		try {

			clickAndCollect = serviceClickAndCollect.getAll();
			log.info(om.writeValueAsString(clickAndCollect));
			return new ResponseEntity<>(clickAndCollect, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> saveClickAndCollect(@RequestBody Map<String, Object> data) {
		try { 
			Utilisateur userConnected = (Utilisateur) SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();

			ClickAndCollect newClickAndCollect = new ClickAndCollect((Long) userConnected.getIdUtilisateur(),
					Long.parseLong((String) data.get("idPharmacie")), (String) data.get("fichier"));

			ClickAndCollect saved = serviceClickAndCollect.save(newClickAndCollect);
			return new ResponseEntity<>(saved, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur", HttpStatus.BAD_REQUEST);
		}
	}

}

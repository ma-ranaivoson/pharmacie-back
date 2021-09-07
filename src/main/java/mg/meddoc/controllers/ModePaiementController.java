package mg.meddoc.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.meddoc.models.ModePaiement;
import mg.meddoc.services.ModePaiementService;

@RestController
@RequestMapping(value = "/mode-paiement")
@CrossOrigin(origins = {"*"})
@Component
public class ModePaiementController {
	ObjectMapper om=new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(ModePaiementController.class);
	
	@Autowired
	ModePaiementService serviceModePaiement;
	
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<List<ModePaiement>> getAllModePaiement(){
		return new ResponseEntity<List<ModePaiement>>(serviceModePaiement.getAll(), HttpStatus.OK);
	}
	
}

package mg.meddoc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mg.meddoc.models.Adresse;
import mg.meddoc.models.District;
import mg.meddoc.services.AdresseSer;
import mg.meddoc.services.DistrictSer;

@RestController
@RequestMapping(value = "/adresse")
@CrossOrigin(origins = { "*" })
@Component
public class AdresseController {
	
	@Autowired
	AdresseSer serviceAdresse;
	
	@Autowired
	DistrictSer serviceDistrict;
	
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<List<Adresse>> getAll(){
		return new ResponseEntity<List<Adresse>>(serviceAdresse.getAll(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/districts") 
	public @ResponseBody ResponseEntity<List<District>> getAllDistricts(){
		return new ResponseEntity<List<District>>(serviceDistrict.getAll(), HttpStatus.OK);
	}
}

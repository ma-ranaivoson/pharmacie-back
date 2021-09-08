package mg.meddoc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mg.meddoc.models.UserModePaiement;
import mg.meddoc.models.Utilisateur;
import mg.meddoc.services.UserModePaiementService;

@RestController
@RequestMapping(value = "/user-mode-paiement")
@CrossOrigin(origins = { "*" })
@Component
public class UserModePaiementController {

	@Autowired
	private UserModePaiementService serviceUserModePaiement;

	@GetMapping(value = "/phones")
	public @ResponseBody ResponseEntity<?> getPhoneNumber() {
		Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		try {
			List<UserModePaiement> phoneList = serviceUserModePaiement.findByIdUtilisateur(user.getIdUtilisateur());

			return new ResponseEntity<>(phoneList, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}

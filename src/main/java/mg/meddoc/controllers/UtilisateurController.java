package mg.meddoc.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mg.meddoc.models.Utilisateur;
import mg.meddoc.services.UtilisateurService;

@RestController
@RequestMapping(value = "/user")
public class UtilisateurController {
	@Autowired
	UtilisateurService userService;
	
	HashMap<String, Object> resp = new HashMap<String, Object>();

	// Create user
	// public
	@PostMapping(value = "")
	public @ResponseBody ResponseEntity<?> createUser(@RequestBody Utilisateur user) {

		HashMap<String, Object> res = new HashMap<String, Object>();

		try {
			Utilisateur userSaved = userService.save(user);
			return new ResponseEntity<>(userSaved, HttpStatus.OK);
		} catch (Exception e) {
			res.put("success", false);
			res.put("error", e.getStackTrace());

			return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}

	}

	// Get All user
	@GetMapping(value = "")
	public @ResponseBody ResponseEntity<?> getAllUser() {
		List<Utilisateur> users;
		try {
			users = userService.getAll();
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.BAD_REQUEST);
		}

	}

	// Get user by id
	// TODO : Make an exception handler if there is no user or failed to cast the id
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getUserById(@PathVariable Long id) {
		Utilisateur user = null;
		HashMap<String, Object> res = new HashMap<String, Object>();

		try {
			user = userService.getById(id);
			
			return new ResponseEntity<>(user, HttpStatus.OK);
			
		} catch (NoSuchElementException e) {

			res.put("error", e.getMessage());

			return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
		}
	}
	
	// TODO : Update user by id
//	@PutMapping(value = "/{id}")
//	public @ResponseBody ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody Utilisateur user) {
//		
//		try {
//			user = userService.getById(id);
//			
//			return new ResponseEntity<>(user, HttpStatus.OK);
//			
//		} catch (NoSuchElementException e) {
//
//			resp.put("error", e.getMessage());
//
//			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
//		}		
//	}

	// Delete user by id
	@DeleteMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> deleteUserById (@PathVariable Long id) {
		try {
			userService.deleteById(id);
			resp.put("success", true);
			resp.put("message", "User with id of " + id + " deleted successfully");
			
			return new ResponseEntity<>(resp, HttpStatus.OK);
			
		} catch (Exception e) {
			resp.put("success", false);
			resp.put("error", "There is an error");
			
			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	
	
}

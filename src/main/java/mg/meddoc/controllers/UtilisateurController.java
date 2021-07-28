package mg.meddoc.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.meddoc.message.JwtResponse;
import mg.meddoc.message.LoginForm;
import mg.meddoc.message.ResponseMessage;
import mg.meddoc.models.TypeUtilisateur;
import mg.meddoc.models.Utilisateur;
import mg.meddoc.security.JwtProvider;
import mg.meddoc.services.UtilisateurService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = { "*" })
@Component
public class UtilisateurController {
	@Autowired
	UtilisateurService userService;
	ObjectMapper om = new ObjectMapper();
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	// Create user
	// public
	
	@PostMapping(value = "/register")
	public @ResponseBody ResponseEntity<?> register(@RequestBody Utilisateur user) {

		HashMap<String, Object> res = new HashMap<String, Object>();

		try {
			System.out.println(om.writeValueAsString(user));
			if (userService.existsByEmail(user.getEmail())) {
				return new ResponseEntity<>(new ResponseMessage("Fail -> Adresse email déjà prise"),
						HttpStatus.BAD_REQUEST);
			}
			if (userService.existsByPhone(user.getPhone())) {
				return new ResponseEntity<>(new ResponseMessage("Fail -> Numéro téléphone déjà pris!"),
						HttpStatus.BAD_REQUEST);
			}
			Utilisateur newUser = new Utilisateur();
			newUser.setNom(user.getNom());
			newUser.setPrenoms(user.getPrenoms());
			newUser.setPassword(encoder.encode(user.getPassword()));
			newUser.setEmail(user.getEmail());
			newUser.setPhone(user.getPhone());
			newUser.setTypeUtilisateur(new TypeUtilisateur(1));
			newUser = userService.save(newUser);
			res.put("message", "Inscription réussie");
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			res.put("success", false);
			res.put("error", e.getStackTrace());
			e.printStackTrace();
			return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody HashMap<String,String> user) {
		
		try {
			System.out.println(om.writeValueAsString(user));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.get("email"), user.get("password")));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		Utilisateur userConnected = (Utilisateur) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userConnected.getEmail(), null));
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/me")
	public @ResponseBody ResponseEntity<?> getMe() {
			
		Utilisateur user = (Utilisateur)SecurityContextHolder.getContext().getAuthentication().getPrincipal();


		try {
			System.out.println();
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.getStackTrace(), HttpStatus.BAD_REQUEST);
		}

	}
	
	
	// Get All user
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllUser() {
		List<Utilisateur> users;
		try {
			users = userService.getAll();
			System.out.println(om.writeValueAsString(users));
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
		HashMap<String, Object> resp = new HashMap<String, Object>();
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

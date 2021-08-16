package mg.meddoc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import com.sun.mail.iap.Response;

import mg.meddoc.message.JwtResponse;
import mg.meddoc.message.ResponseMessage;
import mg.meddoc.models.TypeUtilisateur;
import mg.meddoc.models.User;
import mg.meddoc.models.Utilisateur;
import mg.meddoc.repositories.UserRepository;
import mg.meddoc.security.JwtProvider;
import mg.meddoc.services.AmazonSesService;
import mg.meddoc.services.UtilisateurService;
import mg.meddoc.utils.Util;

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

	@Autowired
	AmazonSesService emailservice;

	HashMap<String, Object> res = new HashMap<String, Object>();

	// Create user
	// public

	@PostMapping(value = "/register")
	public @ResponseBody ResponseEntity<?> register(@RequestBody Utilisateur user) {
		List<String> error = new ArrayList<String>();

		try {
			System.out.println(om.writeValueAsString(user));
			if (userService.existsByEmail(user.getEmail())) {
//				return new ResponseEntity<>(new ResponseMessage("Fail -> Adresse email déjà prise"),
//						HttpStatus.BAD_REQUEST);
				error.add("Adresse email déjà prise");
			}
			if (userService.existsByPhone(user.getPhone())) {
//				return new ResponseEntity<>(new ResponseMessage("Fail -> Numéro téléphone déjà pris!"),
//						HttpStatus.BAD_REQUEST);
				error.add("Numéro téléphone déjà pris!");
			}

			Utilisateur newUser = new Utilisateur();

			if (user.getNom() == null) {
				error.add("Veuillez insérer votre nom");
			} else {
				newUser.setNom(user.getNom());
			}

			if (user.getPrenoms() == null) {
				error.add("Veuillez insérer votre prénom");
			} else {
				newUser.setPrenoms(user.getPrenoms());
			}

			if (user.getPassword() == null) {
				error.add("Veuillez insérer votre mot de passe");
			} else {
				newUser.setPassword(encoder.encode(user.getPassword()));
			}

			if (user.getEmail() == null) {
				error.add("Veuillez insérer votre email");
			} else {
				newUser.setEmail(user.getEmail());
			}

			if (user.getPhone() == null) {
				error.add("Veuillez insérer votre numéro de téléphone");
			} else {
				newUser.setPhone(user.getPhone());
			}

			// If there is no error
			if (error.isEmpty()) {
				// Validation Code
				String code = Util.generateCode();
				newUser.setValidationCode(code);
				newUser.setTypeUtilisateur(new TypeUtilisateur(1));

				// send mail
				class MailAndSms implements Runnable {
					String mailSend;
					String phoneSend;
					String codeSend;

					MailAndSms(String mail, String phone, String code) {
						mailSend = mail;
						phoneSend = phone;
						codeSend = code;
					}

					public void run() {
						if (mailSend != null) {
							try {
								emailservice.sendMail(Util.sendEmailValidation(mailSend, String.valueOf(codeSend)));
							} catch (Exception e) {
								e.printStackTrace();
								System.out.println("e-mail tsy envoyée " + e.getMessage());
							}
						}
					}
				}

				Thread t = new Thread(new MailAndSms(newUser.getEmail(), user.getPhone(), code));
				t.start();

				newUser = userService.save(newUser);

				System.out.println(om.writeValueAsString(newUser));

				Authentication authentication = authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(newUser.getEmail(), newUser.getPassword()));

				String jwt = jwtProvider.generateJwtToken(authentication);

				res.put("message", "Inscription réussie");
				return ResponseEntity.ok(new JwtResponse(jwt, newUser.getEmail(), null));
			} else {
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			res.put("error", e.getStackTrace());
			e.printStackTrace();
			return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/confirm/{id}")
	public ResponseEntity<?> confirmAccount(@Valid @RequestBody HashMap<String, String> user, @PathVariable Long id) {
		HashMap<String, String> error = new HashMap<String, String>();
		
		try {
			Utilisateur userConfirm = userService.getById(id);
			System.out.println(userConfirm);
			
			if (userConfirm == null)
				throw new UsernameNotFoundException("User not found");

			if (userConfirm.getValidationCode().equals(user.get("code"))
					) {
				userConfirm.setStatut(1);
				Utilisateur userConnected = userService.save(userConfirm);

				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(user.get("email"), user.get("password")));
				
				String token = jwtProvider.generateJwtToken(authentication);
				
				return ResponseEntity.ok(new JwtResponse(token, userConnected.getEmail(), null));
			} else {
				throw new IllegalAccessError("Code de validation erreur");
			}

		} catch (UsernameNotFoundException ex) {
			ex.printStackTrace();
			error.put("message", "User not found");
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		} catch (IllegalAccessError ex) {
			ex.printStackTrace();
			error.put("message", "Erreur code validation");
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody HashMap<String, String> user) {
		HashMap<String, Object> response = new HashMap<String, Object>();
		Utilisateur loginUser = userService.findByEmail(user.get("email"));
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		try {
			if (loginUser == null || !encoder.matches(user.get("password"), loginUser.getPassword()))
				throw new BadCredentialsException("Bad credentials");

			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(user.get("email"), user.get("password")));

			SecurityContextHolder.getContext().setAuthentication(authentication);

			String jwt = jwtProvider.generateJwtToken(authentication);
			Utilisateur userConnected = (Utilisateur) authentication.getPrincipal();

			return ResponseEntity.ok(new JwtResponse(jwt, userConnected.getEmail(), null));
		} catch (LockedException e) {
			response.put("message", "locked");
			response.put("id", loginUser.getIdUtilisateur());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			response.put("message", "bad credentials");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/me")
	public @ResponseBody ResponseEntity<?> getMe() {
		try {
			Utilisateur user = (Utilisateur) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Pas d'utilisateur", HttpStatus.BAD_REQUEST);
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
	public @ResponseBody ResponseEntity<?> deleteUserById(@PathVariable Long id) {
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

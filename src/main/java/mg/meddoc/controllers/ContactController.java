package mg.meddoc.controllers;

import java.util.ArrayList;
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

import mg.meddoc.models.Contact;
import mg.meddoc.services.ContactService;

@RestController
@RequestMapping(value = "/contact")
@CrossOrigin(origins = { "*" })
@Component
public class ContactController {

	ObjectMapper om = new ObjectMapper();
	public static final Logger log = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	ContactService serviceContact;

	// GetAll_Contact
	@GetMapping(value = "/all")
	public @ResponseBody ResponseEntity<?> getAllContact() {
		List<Contact> contact = new ArrayList<Contact>();
		try {

			contact = serviceContact.getAll();
			log.info(om.writeValueAsString(contact));
			return new ResponseEntity<>(contact, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur de réseaux", HttpStatus.BAD_REQUEST);
		}
	}

	// GetById_Contact
	@GetMapping(value = "/{id}")
	public @ResponseBody ResponseEntity<?> getContactById(@PathVariable Long id) {
		Contact contact = null;
		try {

			contact = serviceContact.getById(id);
			log.info(om.writeValueAsString(contact));
			return new ResponseEntity<>(contact, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur ou n'est pas dans la BDD", HttpStatus.BAD_REQUEST);
		}
	}

	// Save_Contact
	@PostMapping(value = "/save")
	public @ResponseBody ResponseEntity<?> saveContact(@RequestBody Contact contact) {
		try {
//				Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
			serviceContact.save(contact);
			log.info(om.writeValueAsString(contact));
			return new ResponseEntity<>("Contact inscrite avec succès", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<>("Une erreur s'est produite", HttpStatus.BAD_REQUEST);
		}
	}

	// Delete_Contact
	@DeleteMapping(value = "/delete/{id}")
	public @ResponseBody ResponseEntity<?> deleteContactById(@PathVariable Long id) {
		try {
//				Pharmacie pharma = servicePharmacie.getById(pharmacie.get)
			serviceContact.deleteById(id);
//				servicePharmacie.save(pharmacie);
//				log.info(om.writeValueAsString(pharmacie));
			return new ResponseEntity<>("Contact supprimée avec succès", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Une erreur s'est produite", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/by-valeur/{id}/{idTypeContact}")
	public @ResponseBody ResponseEntity<?> getByIdUser(@PathVariable Long id, @PathVariable Integer idTypeContact) {
		List<Contact> contact = null;
		try {

//			contact = serviceContact.findByIdEntite(id);
			contact = serviceContact.findByIdEntiteAndTypeContactIdTypeContact(id, idTypeContact);
			log.info(om.writeValueAsString(contact));
			return new ResponseEntity<>(contact, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Erreur ou n'est pas dans la BDD", HttpStatus.BAD_REQUEST);
		}
	}
}

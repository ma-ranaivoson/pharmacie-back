package mg.meddoc.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable, UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1373533667783304594L;

	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "users-sequence"
			)
			@SequenceGenerator(
			name = "users-sequence",
			sequenceName = "seq_users",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_utilisateur")
	private Long idUtilisateur;
	
	@Column(name = "nom")
	private java.lang.String nom;
	@Column(name = "prenoms")
	private java.lang.String prenoms;
	@Column(name = "validation_code")
	private java.lang.String validationCode;
	@Column(name = "mot_de_passe")
	@JsonIgnoreProperties
	private java.lang.String password;
	@Column(name = "email")
	private java.lang.String email;
	@Column(name = "phone")
	private java.lang.String phone;
	@Column(name = "statut")
	private int statut;
	
	//Relation...
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_type_utilisateur")
	private TypeUtilisateur typeUtilisateur;
	
	public Utilisateur() {
		
	}

	/**
	 * @param idUtilisateur
	 * @param nom
	 * @param prenom
	 * @param mot_de_passe
	 * @param adresse
	 * @param statut
	 */
	public Utilisateur(Long idUtilisateur, String nom, String prenoms, String mot_de_passe, String email, String phone,
			int statut) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenoms = prenoms;
		this.password = mot_de_passe;
		this.email = email;
		this.phone = phone;
		this.statut = statut;
	}
	
	/**
	 * @return the validationCode
	 */
	public java.lang.String getValidationCode() {
		return validationCode;
	}

	/**
	 * @param validationCode the validationCode to set
	 */
	public void setValidationCode(java.lang.String validationCode) {
		this.validationCode = validationCode;
	}
	
	/**
	 * @return the idUtilisateur
	 */
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * @return the nom
	 */
	public java.lang.String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(java.lang.String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public java.lang.String getPrenoms() {
		return prenoms;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenoms(java.lang.String prenoms) {
		this.prenoms = prenoms;
	}

	/**
	 * @return the mot_de_passe
	 */
	public java.lang.String getPassword() {
		return password;
	}

	/**
	 * @param mot_de_passe the mot_de_passe to set
	 */
	public void setPassword(java.lang.String mot_de_passe) {
		this.password = mot_de_passe;
	}

	/**
	 * @return the email
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public java.lang.String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	/**
	 * @return the statut
	 */
	public int getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(int statut) {
		this.statut = statut;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		String pseudo = this.nom;
		pseudo+=this.prenoms!=null?" "+this.prenoms:"";
		return pseudo;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.statut!=0;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.statut!=0;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.statut!=0;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.statut!=0;
	}

	public TypeUtilisateur getTypeUtilisateur() {
		return typeUtilisateur;
	}

	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}


}

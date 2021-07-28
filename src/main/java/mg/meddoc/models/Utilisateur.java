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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "utilisateur", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "nom"
            })
	})
public class Utilisateur implements Serializable, UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private long idUtilisateur;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_type_utilisateur")
	private TypeUtilisateur typeUtilisateur;

	@Column(name = "nom")
	private java.lang.String nom;

	@Column(name = "prenoms")
	private java.lang.String prenoms;

	@Column(name = "mot_de_passe")
	@JsonIgnoreProperties
	private java.lang.String password;

	@Column(name = "adresse")
	private java.lang.String adresse;

	@Column(name = "statut")
	private int statut;
	
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
	public Utilisateur(long idUtilisateur, String nom, String prenoms, String mot_de_passe, String adresse,
			int statut) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenoms = prenoms;
		this.password = mot_de_passe;
		this.adresse = adresse;
		this.statut = statut;
	}

	/**
	 * @return the idUtilisateur
	 */
	public long getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(long idUtilisateur) {
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
	 * @return the adresse
	 */
	public java.lang.String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(java.lang.String adresse) {
		this.adresse = adresse;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
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

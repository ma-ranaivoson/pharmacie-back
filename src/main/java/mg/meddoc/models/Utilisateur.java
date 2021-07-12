package mg.meddoc.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "utilisateur", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "nom"
            })
	})
public class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private long idUtilisateur;
	@Column(name = "nom")
	private java.lang.String nom;
	@Column(name = "prenom")
	private java.lang.String prenom;
	@Column(name = "mot_de_passe")
	private java.lang.String mot_de_passe;
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
	public Utilisateur(long idUtilisateur, String nom, String prenom, String mot_de_passe, String adresse, int statut) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.nom = nom;
		this.prenom = prenom;
		this.mot_de_passe = mot_de_passe;
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
	public java.lang.String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(java.lang.String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the mot_de_passe
	 */
	public java.lang.String getMot_de_passe() {
		return mot_de_passe;
	}

	/**
	 * @param mot_de_passe the mot_de_passe to set
	 */
	public void setMot_de_passe(java.lang.String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
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
	
	
}

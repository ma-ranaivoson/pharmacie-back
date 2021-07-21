package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_utilisateur")
public class TypeUtilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_type_utilisateur")
	private long idTypeUtilisateur;
	@Column(name = "libelle")
	private java.lang.String libelle;
	
	public TypeUtilisateur() {
		
	}
	
	/**
	 * @param idTypeUtilisateur
	 * @param libelle
	 */
	public TypeUtilisateur(long idTypeUtilisateur, String libelle) {
		super();
		this.idTypeUtilisateur = idTypeUtilisateur;
		this.libelle = libelle;
	}

	/**
	 * @return the idTypeUtilisateur
	 */
	public long getIdTypeUtilisateur() {
		return idTypeUtilisateur;
	}

	/**
	 * @param idTypeUtilisateur the idTypeUtilisateur to set
	 */
	public void setIdTypeUtilisateur(long idTypeUtilisateur) {
		this.idTypeUtilisateur = idTypeUtilisateur;
	}

	/**
	 * @return the libelle
	 */
	public java.lang.String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(java.lang.String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TypeUtilisateur(long idTypeUtilisateur) {
		super();
		this.idTypeUtilisateur = idTypeUtilisateur;
	}
	
	
}

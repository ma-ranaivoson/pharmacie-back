package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_categorie")
	private long idCategorie;
	@Column(name = "libelle")
	private java.lang.String libelle;
	
	public Categorie() {
		
	}

	/**
	 * @param idCategorie
	 * @param libelle
	 */
	public Categorie(long idCategorie, String libelle) {
		super();
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}
	
	/**
	 * @return the idCategorie
	 */
	public long getIdCategorie() {
		return idCategorie;
	}
	
	/**
	 * @param idCategorie the idCategorie to set
	 */
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
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
	
}

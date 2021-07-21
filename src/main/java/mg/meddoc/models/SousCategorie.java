package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sous_categorie")
public class SousCategorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_sous_categorie")
	private long idSouCategorie;
	@Column(name = "libelle")
	private java.lang.String libelle;
	
	public SousCategorie() {
		
	}
	
	/**
	 * @param idSouCategorie
	 * @param libelle
	 */
	public SousCategorie(long idSouCategorie, String libelle) {
		super();
		this.idSouCategorie = idSouCategorie;
		this.libelle = libelle;
	}
	
	/**
	 * @return the idSouCategorie
	 */
	public long getIdSouCategorie() {
		return idSouCategorie;
	}

	/**
	 * @param idSouCategorie the idSouCategorie to set
	 */
	public void setIdSouCategorie(long idSouCategorie) {
		this.idSouCategorie = idSouCategorie;
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

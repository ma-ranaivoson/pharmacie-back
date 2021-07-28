package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "specialite")
public class Specialite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_specialite")
	private long idSpecialite;
	@Column(name = "libelle")
	private java.lang.String libelle;
	@Column(name = "information")
	private java.lang.String information;
	
	//Relation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharmacie")
	@JsonBackReference(value="pharmacie-specialite")
	private Pharmacie pharmacie;
	
	
	public Specialite() {
		
	}

	/**
	 * @param idSpecialite
	 * @param libelle
	 * @param information
	 */
	public Specialite(long idSpecialite, String libelle, String information) {
		super();
		this.idSpecialite = idSpecialite;
		this.libelle = libelle;
		this.information = information;
	}

	/**
	 * @return the idSpecialite
	 */
	public long getIdSpecialite() {
		return idSpecialite;
	}

	/**
	 * @param idSpecialite the idSpecialite to set
	 */
	public void setIdSpecialite(long idSpecialite) {
		this.idSpecialite = idSpecialite;
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
	 * @return the information
	 */
	public java.lang.String getInformation() {
		return information;
	}

	/**
	 * @param information the information to set
	 */
	public void setInformation(java.lang.String information) {
		this.information = information;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class Service implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_service")
	private long idService;
	@Column(name = "libelle")
	private java.lang.String libelle;
	@Column(name = "information")
	private java.lang.String information;
	
	public Service() {
		
	}

	/**
	 * @param idService
	 * @param libelle
	 * @param information
	 */
	public Service(long idService, String libelle, String information) {
		super();
		this.idService = idService;
		this.libelle = libelle;
		this.information = information;
	}

	/**
	 * @return the idService
	 */
	public long getIdService() {
		return idService;
	}

	/**
	 * @param idService the idService to set
	 */
	public void setIdService(long idService) {
		this.idService = idService;
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

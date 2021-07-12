package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;


@Entity
@Table(name = "pharmacie")
public class Pharmacie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6100600048093734364L;
	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "pharmacie-sequence"
		)
		@SequenceGenerator(
		name = "pharmacie-sequence",
		sequenceName = "seq_pharmacie",
		allocationSize = 1,
		initialValue = 2
		)
	@Column(name = "id_pharmacie")
	private long idPharmacie;
	@Column(name = "raison_social")
	private java.lang.String raisonSocial;
	@Column(name = "presentation")
	private java.lang.String presentation;
	@Column(name = "adresse")
	private java.lang.String adresse;
	@Column(name = "statut")
	private Integer statut;
	@Column(name = "longitude")
	private Double longitude;
	@Column(name = "latitude")
   private Double latitude;
	
	
	public Pharmacie() {
		
	}
	

	/**
	 * @return the idPharmacie
	 */
	public long getIdPharmacie() {
		return idPharmacie;
	}


	/**
	 * @param idPharmacie the idPharmacie to set
	 */
	public void setIdPharmacie(long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}


	/**
	 * @param idPharmacie
	 * @param raison_social
	 * @param presentation
	 * @param adresse
	 * @param statut
	 * @param longitude
	 * @param latitude
	 */
	public Pharmacie(long idPharmacie, String raison_social, String presentation, String adresse, Integer statut,
			Double longitude, Double latitude) {
		super();
	//	this.idPharmacie = idPharmacie;
		this.raisonSocial = raison_social;
		this.presentation = presentation;
		this.adresse = adresse;
		this.statut = statut;
		this.longitude = longitude;
		this.latitude = latitude;
	}


	/**
	 * @return the raison_social
	 */
	public java.lang.String getRaisonSocial() {
		return raisonSocial;
	}


	/**
	 * @param raison_social the raison_social to set
	 */
	public void setRaisonSocial(java.lang.String raison_social) throws Exception {
//		if(raison_social==null)
//			throw new Exception("Raison sociale ne peut pas être vide");
//		else if(raison_social=="")
//			throw new Exception("Raison sociale ne peut pas être vide");
		
		this.raisonSocial = raison_social;
	}


	/**
	 * @return the presentation
	 */
	public java.lang.String getPresentation() {
		return presentation;
	}


	/**
	 * @param presentation the presentation to set
	 */
	public void setPresentation(java.lang.String presentation) {
		this.presentation = presentation;
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
	public Integer getStatut() {
		return statut;
	}


	/**
	 * @param statut the statut to set
	 */
	public void setStatut(Integer statut) {
		this.statut = statut;
	}


	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}


	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}


	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}


	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
}

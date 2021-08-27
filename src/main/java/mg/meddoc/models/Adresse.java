package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
//import mg.meddoc.models.professionnels.StructureSante;

@Entity
@Table(name="adresse")
@IdClass(AdressePK.class)
public class Adresse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5074128346153899872L;

	@Id
	@Column(name = "id_user")
	private Long idUser;
	@Id
	@Column(name = "date_debut")
	private Timestamp dateDebut;
	@Column(name = "date_fin")
	private Timestamp dateFin;
	@Column(name = "information_adresse")
	private String informationAdresse;
	@Column(name = "information_acces")
	private String informationAcces;
	@Column(name = "information_utile")
	private String informationUtile;
	@Column(name = "longitude")
	private Double longitude;
	@Column(name = "latitude")
	private Double latitude;
//	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
//	@JoinColumn(name = "id_emplacement")
//	private Fokontany fokontany;
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.DETACH)
	@JoinColumn(name = "id_emplacement")
	private District district;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user", insertable = false, updatable = false)
	@JsonBackReference(value="personne-adresse")
	private Utilisateur personneAdresse;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_user", insertable = false, updatable = false)
	@JsonBackReference(value="pharmacie-adresse")
	private Pharmacie pharmacieAdresse;
	
	// public Adresse() {
	// 	super();
	// 	// TODO Auto-generated constructor stub
	// }
	
	public Pharmacie getPharmacieAdresse() {
		return pharmacieAdresse;
	}

	public void setPharmacieAdresse(Pharmacie pharmacieAdresse) {
		this.pharmacieAdresse = pharmacieAdresse;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Timestamp getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Timestamp getDateFin() {
		return dateFin;
	}

	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}

	public String getInformationAdresse() {
		return informationAdresse;
	}

	public void setInformationAdresse(String informationAdresse) {
		this.informationAdresse = informationAdresse;
	}

	public String getInformationAcces() {
		return informationAcces;
	}

	public void setInformationAcces(String informationAcces) {
		this.informationAcces = informationAcces;
	}

	public String getInformationUtile() {
		return informationUtile;
	}

	public void setInformationUtile(String informationUtile) {
		this.informationUtile = informationUtile;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

//	public Fokontany getFokontany() {
//		return fokontany;
//	}
////
//	public void setFokontany(Fokontany fokontany) {
//		this.fokontany = fokontany;
//	}

	public District getDistrict() {
		return district;
	}
//
	public void setDistrict(District district) {
		this.district = district;
	}
//
	public Utilisateur getPersonneAdresse() {
		return personneAdresse;
	}
//
	public void setPersonneAdresse(Utilisateur personneAdresse) {
		this.personneAdresse = personneAdresse;
	}

//	public StructureSante getStructureAdresse() {
//		return structureAdresse;
//	}
////
//	public void setStructureAdresse(StructureSante structureAdresse) {
//		this.structureAdresse = structureAdresse;
//	}

	
}

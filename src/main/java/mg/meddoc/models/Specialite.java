package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "specialite-sequence"
			)
			@SequenceGenerator(
			name = "specialite-sequence",
			sequenceName = "seq_specialite",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_specialite")
	private Long idSpecialite;
	@Column(name = "id_pharmacie")
	private Long idPharmacie;
	
	@Column(name = "libelle")
	private java.lang.String libelle;
	@Column(name = "information")
	private java.lang.String information;
	
	//Relation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharmacie", insertable=false, updatable=false)
	@JsonBackReference(value="pharmacie-specialite")
	private Pharmacie pharmacie;
	
	
	public Specialite() {
		
	}

	/**
	 * @param idSpecialite
	 * @param libelle
	 * @param information
	 */
	public Specialite(Long idSpecialite, String libelle, String information) {
		super();
		//this.idSpecialite = idSpecialite;
		this.libelle = libelle;
		this.information = information;
	}

	/**
	 * @return the idSpecialite
	 */
	public Long getIdSpecialite() {
		return idSpecialite;
	}

	/**
	 * @param idSpecialite the idSpecialite to set
	 */
	public void setIdSpecialite(Long idSpecialite) {
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
	
	/**
	 * @return the pharmacie
	 */
	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	/**
	 * @param pharmacie the pharmacie to set
	 */
	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	/**
	 * @return the idPharmacie
	 */
	public Long getIdPharmacie() {
		return idPharmacie;
	}

	/**
	 * @param idPharmacie the idPharmacie to set
	 */
	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}
	
}

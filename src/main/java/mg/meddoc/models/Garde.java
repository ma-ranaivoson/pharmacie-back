package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "garde")
@IdClass(GardePK.class)
public class Garde implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_pharmacie")
	private Long idPharmacie;
	
	@Id
	@Column(name = "date_debut")
	private java.sql.Date date_debut;
	
	@Column(name = "date_fin")
	private java.sql.Date date_fin;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharmacie",insertable = false, updatable = false)
	@JsonBackReference(value="pharmacie-garde")
	private Pharmacie pharmacie;
	
	public Garde() {
		
	}
	
	/**
	 * @param idGarde
	 * @param date_debut
	 * @param date_fin
	 */
	public Garde(Date date_debut, Date date_fin) {
		super();
	//	this.idGarde = idGarde;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	/**
	 * @return the date_debut
	 */
	public java.sql.Date getDate_debut() {
		return date_debut;
	}

	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(java.sql.Date date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public java.sql.Date getDate_fin() {
		return date_fin;
	}

	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(java.sql.Date date_fin) {
		this.date_fin = date_fin;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

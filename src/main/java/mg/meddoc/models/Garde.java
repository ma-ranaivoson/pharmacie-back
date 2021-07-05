package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "garde")
public class Garde implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_garde")
	private long idGarde;
	@Column(name = "date_debut")
	private java.sql.Date date_debut;
	@Column(name = "date_fin")
	private java.sql.Date date_fin;
	
	public Garde() {
		
	}

	/**
	 * @param idGarde
	 * @param date_debut
	 * @param date_fin
	 */
	public Garde(long idGarde, Date date_debut, Date date_fin) {
		super();
		this.idGarde = idGarde;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	/**
	 * @return the idGarde
	 */
	public long getIdGarde() {
		return idGarde;
	}

	/**
	 * @param idGarde the idGarde to set
	 */
	public void setIdGarde(long idGarde) {
		this.idGarde = idGarde;
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

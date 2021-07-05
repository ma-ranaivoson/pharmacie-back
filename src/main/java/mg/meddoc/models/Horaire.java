package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "horaire_ouverture")
public class Horaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_horaire")
	private long idHoraire;
	@Column(name = "jour")
	private int jour;
	@Column(name = "heure_ouverture")
	private java.sql.Time heure_ouverture;
	@Column(name = "heure_fermeture")
	private java.sql.Time heure_fermeture;
	
	public Horaire() {
		
	}
	
	/**
	 * @param idHoraire
	 * @param jour
	 * @param heure_ouverture
	 * @param heure_fermeture
	 */
	public Horaire(long idHoraire, int jour, Time heure_ouverture, Time heure_fermeture) {
		super();
		this.idHoraire = idHoraire;
		this.jour = jour;
		this.heure_ouverture = heure_ouverture;
		this.heure_fermeture = heure_fermeture;
	}

	/**
	 * @return the idHoraire
	 */
	public long getIdHoraire() {
		return idHoraire;
	}

	/**
	 * @param idHoraire the idHoraire to set
	 */
	public void setIdHoraire(long idHoraire) {
		this.idHoraire = idHoraire;
	}

	/**
	 * @return the jour
	 */
	public int getJour() {
		return jour;
	}

	/**
	 * @param jour the jour to set
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}

	/**
	 * @return the heure_ouverture
	 */
	public java.sql.Time getHeure_ouverture() {
		return heure_ouverture;
	}

	/**
	 * @param heure_ouverture the heure_ouverture to set
	 */
	public void setHeure_ouverture(java.sql.Time heure_ouverture) {
		this.heure_ouverture = heure_ouverture;
	}

	/**
	 * @return the heure_fermeture
	 */
	public java.sql.Time getHeure_fermeture() {
		return heure_fermeture;
	}

	/**
	 * @param heure_fermeture the heure_fermeture to set
	 */
	public void setHeure_fermeture(java.sql.Time heure_fermeture) {
		this.heure_fermeture = heure_fermeture;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

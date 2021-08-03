package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

public class GardePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3759717103328695873L;
	
	Long idPharmacie;
	Date date_debut;
	
	public GardePK() {
		
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

	/**
	 * @return the date_debut
	 */
	public Date getDate_debut() {
		return date_debut;
	}

	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	
	
}

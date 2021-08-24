package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class AdressePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7107141511399158139L;
	
	private Long idUser;
	private Timestamp dateDebut;
	
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

	public AdressePK() {
		// TODO Auto-generated constructor stub
	}

}

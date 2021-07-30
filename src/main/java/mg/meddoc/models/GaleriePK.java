package mg.meddoc.models;

import java.io.Serializable;

public class GaleriePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1521863827139268591L;

	Long idPharmacie;
	String nom;
	public Long getIdPharmacie() {
		return idPharmacie;
	}
	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public GaleriePK() {
		super();
		// TODO Auto-generated constructor stub
	}
}

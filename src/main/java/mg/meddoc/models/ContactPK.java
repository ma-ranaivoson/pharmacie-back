package mg.meddoc.models;

import java.io.Serializable;

public class ContactPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3940490736201704951L;

	Long idEntite;
	String valeur;
	
	public Long getIdEntite() {
		return idEntite;
	}
	public void setIdEntite(Long idEntite) {
		this.idEntite = idEntite;
	}
	public String getValeur() {
		return valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	public ContactPK() {
		super();
		// TODO Auto-generated constructor stub
	}
}

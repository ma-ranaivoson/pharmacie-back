package mg.meddoc.models;

import java.io.Serializable;

public class PrixPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8951852488868081687L;
	Long idProduit;
	Long idPharmacie;
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public Long getIdPharmacie() {
		return idPharmacie;
	}
	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}
	public PrixPK(Long idProduit, Long idPharmacie) {
		super();
		this.idProduit = idProduit;
		this.idPharmacie = idPharmacie;
	}
	public PrixPK() {
		super();
		// TODO Auto-generated constructor stub
	}
}

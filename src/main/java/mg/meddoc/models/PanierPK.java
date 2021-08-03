package mg.meddoc.models;

import java.io.Serializable;

public class PanierPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3369294797715094576L;

	Long idPharmacie;
	Long idProduit;
	Long idUtilisateur;
	public Long getIdPharmacie() {
		return idPharmacie;
	}
	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	public PanierPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PanierPK(Long idPharmacie, Long idProduit, Long idUtilisateur) {
		super();
		this.idPharmacie = idPharmacie;
		this.idProduit = idProduit;
		this.idUtilisateur = idUtilisateur;
	}
	
}

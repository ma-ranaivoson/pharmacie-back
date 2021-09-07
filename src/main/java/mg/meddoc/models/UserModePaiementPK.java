package mg.meddoc.models;

import java.io.Serializable;

public class UserModePaiementPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3940490736201704951L;

	private Long idUtilisateur;
	private Long idModePaiement;
	private String valeur;

	public UserModePaiementPK() {
		super();
	}

	public UserModePaiementPK(Long idUtilisateur, Long idModePaiement, String valeur) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.idModePaiement = idModePaiement;
		this.valeur = valeur;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Long getIdModePaiement() {
		return idModePaiement;
	}

	public void setIdModePaiement(Long idModePaiement) {
		this.idModePaiement = idModePaiement;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

}

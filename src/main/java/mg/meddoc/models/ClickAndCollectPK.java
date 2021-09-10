package mg.meddoc.models;

import java.io.Serializable;

public class ClickAndCollectPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3940490736201704951L;
	private Long idUtilisateur;
	private Long idPharmacie;
	private String fichier;

	public ClickAndCollectPK() {
		super();
	}

	public ClickAndCollectPK(Long idUtilisateur, Long idPharmacie, String fichier) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.idPharmacie = idPharmacie;
		this.fichier = fichier;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Long getIdPharmacie() {
		return idPharmacie;
	}

	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

}

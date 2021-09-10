package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "click_and_collect")
@IdClass(ClickAndCollect.class)
public class ClickAndCollect implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_utilisateur")
	private Long idUtilisateur;
	@Id
	@Column(name = "id_pharmacie")
	private Long idPhamacie;
	@Id
	@Column(name = "fichier")
	private String fichier;

	public ClickAndCollect() {
		super();
	}

	public ClickAndCollect(Long idUtilisateur, Long idPhamacie, String fichier) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.idPhamacie = idPhamacie;
		this.fichier = fichier;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Long getIdPhamacie() {
		return idPhamacie;
	}

	public void setIdPhamacie(Long idPhamacie) {
		this.idPhamacie = idPhamacie;
	}

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

}

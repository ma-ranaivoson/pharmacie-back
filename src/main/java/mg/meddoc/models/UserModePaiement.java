package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rel_paiement_utilisateur")
public class UserModePaiement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4066614379568307722L;
	
	@Id
	@Column(name = "id_utilisateur")
	private Long idUtilisateur;
	@Id
	@Column(name = "id_mode_paiement")
	private Long idModePaiement;
	@Id
	@Column(name = "valeur")
	private String valeur;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Utilisateur utilisateur;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	ModePaiement modePaiement;
	
	public UserModePaiement() {
		super();
	}

	public UserModePaiement(Long idUtilisateur, Long idModePaiement, String valeur) {
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

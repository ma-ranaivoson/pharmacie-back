package mg.meddoc.models;

import java.io.Serializable;

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
@IdClass(UserModePaiementPK.class)
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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_utilisateur",insertable = false, updatable = false)
	Utilisateur utilisateur;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_mode_paiement",insertable = false, updatable = false)
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

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

}

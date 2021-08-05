package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
@IdClass(PanierPK.class)
public class Panier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_produit")
	private Long idProduit;
//	@Id
//	@Column(name = "id_paiement")
//	private Long idPaiement;
	@Id
	@Column(name = "id_pharmacie")
	private Long idPharmacie;
	@Id
	@Column(name = "id_utilisateur")
	private Long idUtilisateur;
	@Column(name = "id_paiement")
	private Long idPaiement;
	@Column(name = "quantite")
	private Double quantite;
	@Column(name = "unite")
	private java.lang.String unite;
	@Column(name = "date_ajout")
	private java.sql.Date date_ajout;
	@Column(name = "montant")
	private Double montant;
	@Column(name = "statut")
	private int statut;
	
//Relation
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_utilisateur",insertable = false, updatable = false)
	private Utilisateur user;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_pharmacie",insertable = false, updatable = false)
	private Pharmacie pharmacie;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_produit",insertable = false, updatable = false)
	private Produit produit;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_paiement",insertable = false, updatable = false)
	private Paiement paiement;
	
//Produit ??	
		
	public Panier() {
		
	}

	/**
	 * @param idPanier
	 * @param quantite
	 * @param unite
	 * @param date_ajout
	 * @param montant
	 * @param statut
	 */
	public Panier(Long idProduit, Long idUtilisateur, Long idPharmacie, Double quantite, String unite, Date date_ajout, Double montant, int statut) {
		super();
		this.idPharmacie = idPharmacie;
		this.idProduit = idProduit;
		this.idUtilisateur = idUtilisateur;
		this.quantite = quantite;
		this.unite = unite;
		this.date_ajout = date_ajout;
		this.montant = montant;
		this.statut = statut;
	}

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

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	public java.lang.String getUnite() {
		return unite;
	}

	public void setUnite(java.lang.String unite) {
		this.unite = unite;
	}

	public java.sql.Date getDate_ajout() {
		return date_ajout;
	}

	public void setDate_ajout(java.sql.Date date_ajout) {
		this.date_ajout = date_ajout;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Paiement getPaiement() {
		return paiement;
	}

	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}

	/**
	 * @return the idPaiement
	 */
	public Long getIdPaiement() {
		return idPaiement;
	}

	/**
	 * @param idPaiement the idPaiement to set
	 */
	public void setIdPaiement(Long idPaiement) {
		this.idPaiement = idPaiement;
	}
}

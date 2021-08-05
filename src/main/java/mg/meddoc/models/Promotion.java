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
@Table(name = "promotion")
@IdClass(PromotionPK.class)
public class Promotion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @return the idPharmacie
	 */
	public Long getIdPharmacie() {
		return idPharmacie;
	}

	/**
	 * @param idPharmacie the idPharmacie to set
	 */
	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	/**
	 * @return the idProduit
	 */
	public Long getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @param produit the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * @return the pharmacie
	 */
	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	/**
	 * @param pharmacie the pharmacie to set
	 */
	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	@Id
	@Column(name = "id_pharmacie")
	private Long idPharmacie;
	@Id
	@Column(name = "id_produit")
	private Long idProduit;
	
	@Id
	@Column(name = "date_debut")
	private java.sql.Date date_debut;
	
	@Column(name = "date_fin")
	private java.sql.Date date_fin;
	@Column(name = "remise_prix")
	private Double remise_prix;
	@Column(name = "remise_pourcentage")
	private Double remise_pourcentage;
	@Column(name = "quantite")
	private int quantite;
	
//Relation
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_produit",insertable=false, updatable=false)
	private Produit produit;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_pharmacie",insertable=false, updatable=false)
	private Pharmacie pharmacie;
	
	public Promotion() {
		
	}

	/**
	 * @param idPromotion
	 * @param date_debut
	 * @param date_fin
	 * @param remise_prix
	 * @param remise_pourcentage
	 * @param quantite
	 */
	public Promotion( Date date_debut, Date date_fin, Double remise_prix, Double remise_pourcentage,
			int quantite) {
		super();
		//this.idPromotion = idPromotion;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.remise_prix = remise_prix;
		this.remise_pourcentage = remise_pourcentage;
		this.quantite = quantite;
	}
	
	/**
	 * @return the date_debut
	 */
	public java.sql.Date getDate_debut() {
		return date_debut;
	}

	/**
	 * @param date_debut the date_debut to set
	 */
	public void setDate_debut(java.sql.Date date_debut) {
		this.date_debut = date_debut;
	}

	/**
	 * @return the date_fin
	 */
	public java.sql.Date getDate_fin() {
		return date_fin;
	}

	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(java.sql.Date date_fin) {
		this.date_fin = date_fin;
	}

	/**
	 * @return the remise_prix
	 */
	public Double getRemise_prix() {
		return remise_prix;
	}

	/**
	 * @param remise_prix the remise_prix to set
	 */
	public void setRemise_prix(Double remise_prix) {
		this.remise_prix = remise_prix;
	}

	/**
	 * @return the remise_pourcentage
	 */
	public Double getRemise_pourcentage() {
		return remise_pourcentage;
	}

	/**
	 * @param remise_pourcentage the remise_pourcentage to set
	 */
	public void setRemise_pourcentage(Double remise_pourcentage) {
		this.remise_pourcentage = remise_pourcentage;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

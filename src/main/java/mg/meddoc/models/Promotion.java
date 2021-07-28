package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "promotion")
public class Promotion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_promotion")
	private long idPromotion;
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
	@JoinColumn(name="id_produit")
	private Produit produit;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_pharmacie")
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
	public Promotion(long idPromotion, Date date_debut, Date date_fin, Double remise_prix, Double remise_pourcentage,
			int quantite) {
		super();
		this.idPromotion = idPromotion;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.remise_prix = remise_prix;
		this.remise_pourcentage = remise_pourcentage;
		this.quantite = quantite;
	}

	/**
	 * @return the idPromotion
	 */
	public long getIdPromotion() {
		return idPromotion;
	}

	/**
	 * @param idPromotion the idPromotion to set
	 */
	public void setIdPromotion(long idPromotion) {
		this.idPromotion = idPromotion;
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

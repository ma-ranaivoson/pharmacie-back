package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "panier")
public class Panier implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_panier")
	private long idPanier;
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
	public Panier(long idPanier, Double quantite, String unite, Date date_ajout, Double montant, int statut) {
		super();
		this.idPanier = idPanier;
		this.quantite = quantite;
		this.unite = unite;
		this.date_ajout = date_ajout;
		this.montant = montant;
		this.statut = statut;
	}

	/**
	 * @return the idPanier
	 */
	public long getIdPanier() {
		return idPanier;
	}

	/**
	 * @param idPanier the idPanier to set
	 */
	public void setIdPanier(long idPanier) {
		this.idPanier = idPanier;
	}

	/**
	 * @return the quantite
	 */
	public Double getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(Double quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the unite
	 */
	public java.lang.String getUnite() {
		return unite;
	}

	/**
	 * @param unite the unite to set
	 */
	public void setUnite(java.lang.String unite) {
		this.unite = unite;
	}

	/**
	 * @return the date_ajout
	 */
	public java.sql.Date getDate_ajout() {
		return date_ajout;
	}

	/**
	 * @param date_ajout the date_ajout to set
	 */
	public void setDate_ajout(java.sql.Date date_ajout) {
		this.date_ajout = date_ajout;
	}

	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * @return the statut
	 */
	public int getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

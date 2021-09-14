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
@Table(name = "mouvement_stock")
@IdClass(MouvementStockPK.class)
public class MouvementStock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2249606482442105503L;

//	Attributs
	@Id
	@Column(name = "id_pharmacie")
	private Long idPharmacie;
	@Id
	@Column(name = "id_produit")
	private Long idProduit;
	@Id
	@Column(name = "date") 
	private java.sql.Date date_stock;
	@Column(name = "quantite")
	private int quantite;
	@Column(name = "mouvement")
	private String mouvement;

	// Relation
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produit", insertable = false, updatable = false)
	private Produit produit;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pharmacie", insertable = false, updatable = false)
	private Pharmacie pharmacie;

	public MouvementStock() {

	}

	/**
	 * @param idPharmacie
	 * @param idProduit
	 * @param date_stock
	 * @param quantite
	 * @param mouvement
	 */
	public MouvementStock(Date date_stock, int quantite, String mouvement) {
		super();
		this.date_stock = date_stock;
		this.quantite = quantite;
		this.mouvement = mouvement;
	}

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
	 * @return the date_stock
	 */
	public java.sql.Date getDate_stock() {
		return date_stock;
	}

	/**
	 * @param date_stock the date_stock to set
	 */
	public void setDate_stock(java.sql.Date date_stock) {
		this.date_stock = date_stock;
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
	 * @return the mouvement
	 */
	public String getMouvement() {
		return mouvement;
	}

	/**
	 * @param mouvement the mouvement to set
	 */
	public void setMouvement(String mouvement) {
		this.mouvement = mouvement;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

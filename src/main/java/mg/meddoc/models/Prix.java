package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "prix")
@IdClass(PrixPK.class)
public class Prix implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_pharmacie")
	private Long idPharmacie;
	@Id
	@Column(name = "id_produit")
	private Long idProduit;
	@Column(name = "prix")
	private int prix;
	@Column(name = "unite")
	private java.lang.String unite;

//	Relation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharmacie",insertable = false, updatable = false)
	@JsonBackReference(value="pharmacie-prix")
	private Pharmacie pharmacie;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produit",insertable = false, updatable = false)
	@JsonBackReference(value="produit-prix")
	private Produit produit;
		
	public Prix() {
		
	}

	/**
	 * @param idPrix
	 * @param prix
	 * @param unite
	 */
	public Prix(Long idPharmacie, Long idProduit, int prix, String unite) {
		super();
		this.idPharmacie = idPharmacie;
		this.idProduit = idProduit;
		this.prix = prix;
		this.unite = unite;
	}

	/**
	 * @return the prix
	 */
	public int getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(int prix) {
		this.prix = prix;
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

	public Long getIdPharmacie() {
		return idPharmacie;
	}

	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
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
}

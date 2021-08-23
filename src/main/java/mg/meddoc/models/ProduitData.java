package mg.meddoc.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;

public class ProduitData implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long idProduit;
	private java.lang.String designation;
	private java.lang.String image;
	private java.lang.String description;
	private java.lang.String format;
	private Marque marque;
	private Set<Pharmacie> pharmacie;
	private Set<SousCategorie> categorie;
	private Set<Prix> prix;
	private Long idMarque;
	private Long idPharmacie;
	
	public ProduitData() {
		
	}

	/**
	 * @param idProduit
	 * @param designation
	 * @param image
	 * @param description
	 * @param format
	 */
	public ProduitData(Long idProduit, String designation, String image, String description, String format) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.image = image;
		this.description = description;
		this.format = format;
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
	 * @return the designation
	 */
	public java.lang.String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(java.lang.String designation) {
		this.designation = designation;
	}

	/**
	 * @return the image
	 */
	public java.lang.String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(java.lang.String image) {
		this.image = image;
	}

	/**
	 * @return the description
	 */
	public java.lang.String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	/**
	 * @return the format
	 */
	public java.lang.String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(java.lang.String format) {
		this.format = format;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Set<Pharmacie> getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Set<Pharmacie> pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Set<SousCategorie> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<SousCategorie> categorie) {
		this.categorie = categorie;
	}

	public Set<Prix> getPrix() {
		return prix;
	}

	public void setPrix(Set<Prix> prix) {
		this.prix = prix;
	}
	
	public Long getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(Long idMarque) {
		this.idMarque = idMarque;
	}

	public Long getIdPharmacie() {
		return idPharmacie;
	}

	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	public Produit toProduit() {
		Produit produit = new Produit();
		produit.setIdProduit(this.getIdProduit());
		produit.setCategorie(this.getCategorie());
		produit.setDescription(this.getDescription());
		produit.setDesignation(this.getDesignation());
		produit.setFormat(this.getFormat());
		produit.setMarque(this.getMarque());
		produit.setPharmacie(this.getPharmacie());
		produit.setIdMarque(this.getIdMarque());
		produit.setIdPharmacie(this.getIdPharmacie());
		produit.setImage(this.getImage());
		return produit;
	}
	
	public ProduitData(Produit produit) {
		this.setIdProduit(produit.getIdProduit());
		this.setCategorie(produit.getCategorie());
		this.setDescription(produit.getDescription());
		this.setDesignation(produit.getDesignation());
		this.setFormat(produit.getFormat());
		this.setMarque(produit.getMarque());
		this.setPharmacie(produit.getPharmacie());
		this.setIdMarque(produit.getIdMarque());
		this.setIdPharmacie(produit.getIdPharmacie());
	}
	public ProduitData(Produit produit,Prix prix) {
		this.setIdProduit(produit.getIdProduit());
		this.setCategorie(produit.getCategorie());
		this.setDescription(produit.getDescription());
		this.setDesignation(produit.getDesignation());
		this.setFormat(produit.getFormat());
		this.setMarque(produit.getMarque());
		this.setPharmacie(produit.getPharmacie());
		this.setIdMarque(produit.getIdMarque());
		this.setIdPharmacie(produit.getIdPharmacie());
		this.setImage(produit.getImage());
		Set<Prix> setPrix = new HashSet<Prix>();
		setPrix.add(prix);
		this.setPrix(setPrix);
	}
}

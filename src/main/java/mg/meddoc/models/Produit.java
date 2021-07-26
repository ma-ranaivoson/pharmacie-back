package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "produit")
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "produit-sequence"
		)
		@SequenceGenerator(
		name = "produit-sequence",
		sequenceName = "seq_produit",
		allocationSize = 1,
		initialValue = 2
		)
	@Column(name = "id_produit")
	private long idProduit;
	@Column(name = "designation")
	private java.lang.String designation;
	@Column(name = "image")
	private java.lang.String image;
	@Column(name = "description")
	private java.lang.String description;
	@Column(name = "format")
	private java.lang.String format;
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_marque")
//	private Marque marque;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharmacie")
	@JsonBackReference(value="pharmacie-produit")
	private Pharmacie pharmacie;
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_categorie")
//	private Categorie categorie;
//	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_prix")
//	private Prix prix;
	
	public Produit() {
		
	}

	/**
	 * @param idProduit
	 * @param designation
	 * @param image
	 * @param description
	 * @param format
	 */
	public Produit(long idProduit, String designation, String image, String description, String format) {
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
	public long getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(long idProduit) {
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

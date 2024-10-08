package mg.meddoc.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "produit")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	private Long idProduit;
	@Column(name = "designation")
	private java.lang.String designation;
	@Column(name = "image")
	private java.lang.String image;
	@Column(name = "description")
	private java.lang.String description;
	@Column(name = "format")
	private java.lang.String format;
	@Column(name="id_marque")
	private Long idMarque;
	@Column(name="id_pharmacie")
	private Long idPharmacie;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_marque",insertable = false, updatable = false)
	private Marque marque;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH, orphanRemoval = true)
	@JoinTable(name = "rel_pharmacie_produit", 
	joinColumns = @JoinColumn(name = "id_produit"), 
	inverseJoinColumns = @JoinColumn(name = "id_pharmacie"))
//	@JsonBackReference(value="pharmacie-produit")
	private Set<Pharmacie> pharmacie;
	
//	@OneToMany(mappedBy = "produit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JsonManagedReference(value="produit-categorie")
//	private Set<Categorie> categorie;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.REFRESH)
    @JoinTable(name = "rel_sous_categorie_produit", 
    	joinColumns = @JoinColumn(name = "id_produit"),
    	inverseJoinColumns = @JoinColumn(name = "id_sous_categorie"))
	private Set<SousCategorie> categorie;
	
//	@ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "favoris", 
//    	joinColumns = @JoinColumn(name = "produit_id"), 
//    	inverseJoinColumns = @JoinColumn(name = "users_id"))
//    private Set<User> users = new HashSet<>();
	
//	@OneToMany(mappedBy = "produit", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JsonManagedReference(value="produit-prix")
//	private Set<Prix> prix;
	
	public Produit() {
		
	}
	
	public Produit(Long idProduit, String designation, String image, String description, String format) {
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

//	public Set<Prix> getPrix() {
//		return prix;
//	}
//
//	public void setPrix(Set<Prix> prix) {
//		this.prix = prix;
//	}
}

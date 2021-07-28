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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "categorie-sequence"
			)
			@SequenceGenerator(
			name = "categorie-sequence",
			sequenceName = "seq_categorie",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_categorie")
	private long idCategorie;
	@Column(name = "libelle")
	private java.lang.String libelle;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produit")
	@JsonBackReference(value="produit-categorie")
	private Produit produit;
	
	@OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference(value="categorie-souscategorie")
	private Set<SousCategorie> souscategorie;
	
	public Categorie() {
		
	}

	/**
	 * @param idCategorie
	 * @param libelle
	 */
	public Categorie(long idCategorie, String libelle) {
		super();
		this.idCategorie = idCategorie;
		this.libelle = libelle;
	}
	
	/**
	 * @return the idCategorie
	 */
	public long getIdCategorie() {
		return idCategorie;
	}
	
	/**
	 * @param idCategorie the idCategorie to set
	 */
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	/**
	 * @return the libelle
	 */
	public java.lang.String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(java.lang.String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

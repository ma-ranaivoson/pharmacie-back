package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sous_categorie")
public class SousCategorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "sous_categorie-sequence"
			)
			@SequenceGenerator(
			name = "sous_categorie-sequence",
			sequenceName = "seq_sous_categorie",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_sous_categorie")
	private Long idSouCategorie;
	@Column(name = "libelle")
	private java.lang.String libelle;
	@Column(name = "id_categorie")
	private long idCategorie; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_categorie", insertable=false, updatable=false)
	@JsonBackReference(value="categorie-souscategorie")
	private Categorie categorie;
	
	public SousCategorie() {
		
	}
	
	/**
	 * @param idSouCategorie
	 * @param libelle
	 */
	public SousCategorie(Long idSouCategorie, String libelle) {
		super();
		this.idSouCategorie = idSouCategorie;
		this.libelle = libelle;
	}
	
	/**
	 * @return the idSouCategorie
	 */
	public Long getIdSouCategorie() {
		return idSouCategorie;
	}

	/**
	 * @param idSouCategorie the idSouCategorie to set
	 */
	public void setIdSouCategorie(Long idSouCategorie) {
		this.idSouCategorie = idSouCategorie;
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
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}

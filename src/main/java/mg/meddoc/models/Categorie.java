package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_sous_categorie")
//	private SousCategorie souscategorie;
	
	
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

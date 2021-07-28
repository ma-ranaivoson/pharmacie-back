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
@Table(name = "galerie")
public class Galerie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "galerie-sequence"
			)
			@SequenceGenerator(
			name = "galerie-sequence",
			sequenceName = "seq_galerie",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_galerie")
	private long idGalerie;
	@Column(name = "album")
	private java.lang.String album;
	@Column(name = "nom_photo")
	private java.lang.String nom;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharmacie")
	@JsonBackReference(value="pharmacie-galerie")
	private Pharmacie pharmacie;
	
	public Galerie() {
		
	}

	/**
	 * @param idGalerie
	 * @param album
	 * @param nom
	 */
	public Galerie(long idGalerie, String album, String nom) {
		super();
		this.idGalerie = idGalerie;
		this.album = album;
		this.nom = nom;
	}

	/**
	 * @return the idGalerie
	 */
	public long getIdGalerie() {
		return idGalerie;
	}

	/**
	 * @param idGalerie the idGalerie to set
	 */
	public void setIdGalerie(long idGalerie) {
		this.idGalerie = idGalerie;
	}
	
	/**
	 * @return the album
	 */
	public java.lang.String getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(java.lang.String album) {
		this.album = album;
	}

	/**
	 * @return the nom
	 */
	public java.lang.String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(java.lang.String nom) {
		this.nom = nom;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

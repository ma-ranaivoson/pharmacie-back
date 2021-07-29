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
@Table(name = "galerie")
@IdClass(GaleriePK.class)
public class Galerie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_pharmacie")
	private Long idPharmacie;
	@Column(name = "album")
	private java.lang.String album;
	@Id
	@Column(name = "nom_photo")
	private java.lang.String nom;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharmacie",insertable = false, updatable = false)
	@JsonBackReference(value="pharmacie-galerie")
	private Pharmacie pharmacie;
	
	public Galerie() {
		
	}

	/**
	 * @param idGalerie
	 * @param album
	 * @param nom
	 */
	public Galerie(String album, String nom) {
		super();
		this.album = album;
		this.nom = nom;
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

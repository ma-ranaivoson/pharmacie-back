package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "prix")
public class Prix implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_prix")
	private long idPrix;
	@Column(name = "prix")
	private int prix;
	@Column(name = "unite")
	private java.lang.String unite;

//	Relation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pharmacie")
	@JsonBackReference(value="pharmacie-prix")
	private Pharmacie pharmacie;
		
	public Prix() {
		
	}

	/**
	 * @param idPrix
	 * @param prix
	 * @param unite
	 */
	public Prix(long idPrix, int prix, String unite) {
		super();
		this.idPrix = idPrix;
		this.prix = prix;
		this.unite = unite;
	}

	/**
	 * @return the idPrix
	 */
	public long getIdPrix() {
		return idPrix;
	}

	/**
	 * @param idPrix the idPrix to set
	 */
	public void setIdPrix(long idPrix) {
		this.idPrix = idPrix;
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

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

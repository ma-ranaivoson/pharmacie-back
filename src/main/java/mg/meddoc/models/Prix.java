package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

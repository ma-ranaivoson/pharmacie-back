package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_staff")
	private long idStaff;
	@Column(name = "nom_staf")
	private java.lang.String nom;
	
	public Staff() {
		
	}

	/**
	 * @param idStaff
	 * @param nom
	 */
	public Staff(long idStaff, String nom) {
		super();
		this.idStaff = idStaff;
		this.nom = nom;
	}

	/**
	 * @return the idStaff
	 */
	public long getIdStaff() {
		return idStaff;
	}

	/**
	 * @param idStaff the idStaff to set
	 */
	public void setIdStaff(long idStaff) {
		this.idStaff = idStaff;
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

/***********************************************************************
 * Module:  Commune.java
 * Author:  mihaj
 * Purpose: Defines the Class Commune
 ***********************************************************************/

package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commune")
public class Commune implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 6259005890643343530L;
	@Id
	@Column(name = "id_commune")
	private long idCommune;
	@Column(name = "nom_commune")
	private java.lang.String nomCommune;
   
	protected void finalize() {
		// TODO: implement
	}
   
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_district")
	private District district;
   
	public long getIdCommune() {
		return idCommune;
	}
   
	public void setIdCommune(long newIdCommune) {
		idCommune = newIdCommune;
	}
   
	public java.lang.String getNomCommune() {
		return nomCommune;
	}
   
	public void setNomCommune(java.lang.String newNomCommune) {
		nomCommune = newNomCommune;
	}
   
	public Commune() {
		// TODO: implement
	}

	public District getDistrict() {
		return district;
	}
	
	public void setDistrict(District district) {
		this.district = district;
	}
}
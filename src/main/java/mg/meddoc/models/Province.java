/***********************************************************************
 * Module:  Province.java
 * Author:  mihaj
 * Purpose: Defines the Class Province
 ***********************************************************************/

package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6259005890643343530L;
	@Id
	@Column(name = "id_province")
	private long idProvince;
	@Column(name = "nom_province")
	private java.lang.String nomProvince;
   
	protected void finalize() {
		// TODO: implement
	}
   
	public long getIdProvince() {
		return idProvince;
	}
   
	public void setIdProvince(long newIdProvince) {
		idProvince = newIdProvince;
	}
   
	public java.lang.String getNomProvince() {
		return nomProvince;
	}
   
	public void setNomProvince(java.lang.String newNomProvince) {
		nomProvince = newNomProvince;
	}
   
	public Province() {
		// TODO: implement
	}

}
/***********************************************************************
 * Module:  Region.java
 * Author:  mihaj
 * Purpose: Defines the Class Region
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
@Table(name = "region")
public class Region implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 6259005890643343530L;
	@Id
	@Column(name = "id_region")
	private long idRegion;
	@Column(name = "nom_region")
	private java.lang.String nomRegion;
	   
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_province")
	private Province province;
   
	protected void finalize() {
		// TODO: implement
	}
   
	public long getIdRegion() {
		return idRegion;
	}
   
	public void setIdRegion(long newIdRegion) {
		idRegion = newIdRegion;
	}
   
	public java.lang.String getNomRegion() {
		return nomRegion;
	}
   
	public void setNomRegion(java.lang.String newNomRegion) {
		nomRegion = newNomRegion;
	}
   
	public Region() {
		// TODO: implement
	}

	public Province getProvince() {
		return province;
	}
	
	public void setProvince(Province province) {
		this.province = province;
	}

}
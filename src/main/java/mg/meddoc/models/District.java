/***********************************************************************
 * Module:  District.java
 * Author:  mihaj
 * Purpose: Defines the Class District
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
@Table(name = "district")
public class District implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 6259005890643343530L;
	@Id
   	@Column(name = "id_district")
   	private long idDistrict;
   	@Column(name = "nom_district")
   	private java.lang.String nomDistrict;
   	@OneToOne(fetch=FetchType.EAGER)
  	@JoinColumn(name = "id_region")
  	private Region region;
  
   	protected void finalize() {
	   // TODO: implement
   	}
   
   	public long getIdDistrict() {
	   return idDistrict;
   	}
   
   	public void setIdDistrict(long newIdDistrict) {
	   idDistrict = newIdDistrict;
   	}
   
   	public java.lang.String getNomDistrict() {
	   return nomDistrict;
   	}
   
   	public void setNomDistrict(java.lang.String newNomDistrict) {
   		nomDistrict = newNomDistrict;
   	}
   
   	public District() {
      // TODO: implement
   	}

	public Region getRegion() {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
}
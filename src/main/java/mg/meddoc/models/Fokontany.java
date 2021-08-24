/***********************************************************************
 * Module:  Fokontany.java
 * Author:  mihaj
 * Purpose: Defines the Class Fokontany
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
@Table(name = "fokontany")
public class Fokontany implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 6259005890643343530L;
	@Id
	@Column(name = "id_fokontany")
	private long idFokontany;
	@Column(name = "nom_fokontany")
	private java.lang.String nomFokontany;
   
	protected void finalize() {
		// TODO: implement
	}
   
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_arrondissement")
	private Arrondissement arrondissement;
   
	public long getIdFokontany() {
		return idFokontany;
	}
   
	public void setIdFokontany(long newIdFokontany) {
		idFokontany = newIdFokontany;
	}
   
	public java.lang.String getNomFokontany() {
		return nomFokontany;
	}
   
	public void setNomFokontany(java.lang.String newNomFokontany) {
		nomFokontany = newNomFokontany;
	}
	
	public Fokontany() {
		// TODO: implement
	}

	public Arrondissement getArrondissement() {
		return arrondissement;
	}
	
	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}	
}
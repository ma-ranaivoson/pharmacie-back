/***********************************************************************
 * Module:  Arrondissement.java
 * Author:  mihaj
 * Purpose: Defines the Class Arrondissement
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
@Table(name = "arrondissement")
public class Arrondissement implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 6259005890643343530L;
	@Id
	@Column(name = "id_arrondissement")
	private long idArrondissement;
	@Column(name = "nom_arrondissement")
	private java.lang.String nomArrondissement;
   
	protected void finalize() {
		// TODO: implement
	}
   
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id_commune")
	private Commune commune;
   
	public long getIdArrondissement() {
		return idArrondissement;
	}
   
	public void setIdArrondissement(long newIdArrondissement) {
		idArrondissement = newIdArrondissement;
	}
   
	public java.lang.String getNomArrondissement() {
		return nomArrondissement;
	}
   
	public void setNomArrondissement(java.lang.String newNomArrondissement) {
		nomArrondissement = newNomArrondissement;
	}
   
	public Arrondissement() {
		// TODO: implement
	}

	public Commune getCommune() {
		return commune;
	}
	
	public void setCommune(Commune commune) {
		this.commune = commune;
	}
}
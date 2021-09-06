package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "mode_paiement")
public class ModePaiement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_mode_paiement")
	private Long idModePaiement;
	@Column(name = "valeur", insertable = false, updatable = false)
	private String valeur;
	@Column(name = "type", insertable = false, updatable = false)
	private String type;
	
	public ModePaiement() {
		super();
	}

	public ModePaiement(Long idModePaiement, String valeur, String type) {
		super();
		this.idModePaiement = idModePaiement;
		this.valeur = valeur;
		this.type = type;
	}

	public Long getIdModePaiement() {
		return idModePaiement;
	}

	public void setIdModePaiement(Long idModePaiement) {
		this.idModePaiement = idModePaiement;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}

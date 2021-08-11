package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "marque")
public class Marque implements Serializable{

	/**
	 * 
	 */
	private static final Long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "marque-sequence"
			)
			@SequenceGenerator(
			name = "marque-sequence",
			sequenceName = "seq_marque",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_marque")
	private Long idMarque;
	@Column(name = "nomination")
	private java.lang.String nomination;
	
//	@OneToOne(mappedBy= "marque")
//	private Produit produit;
	
	public Marque() {
		
	}

	/**
	 * @param idMarque
	 * @param nomination
	 */
	public Marque(Long idMarque, String nomination) {
		super();
		this.idMarque = idMarque;
		this.nomination = nomination;
	}

	/**
	 * @return the idMarque
	 */
	public Long getIdMarque() {
		return idMarque;
	}

	/**
	 * @param idMarque the idMarque to set
	 */
	public void setIdMarque(Long idMarque) {
		this.idMarque = idMarque;
	}

	/**
	 * @return the nomination
	 */
	public java.lang.String getNomination() {
		return nomination;
	}

	/**
	 * @param nomination the nomination to set
	 */
	public void setNomination(java.lang.String nomination) {
		this.nomination = nomination;
	}

	/**
	 * @return the serialversionuid
	 */
	public static Long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

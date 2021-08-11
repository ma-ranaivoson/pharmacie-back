package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paiement")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paiement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "paiement-sequence"
			)
			@SequenceGenerator(
			name = "paiement-sequence",
			sequenceName = "seq_paiement",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_paiement")
	private long idPaiement;
	@Column(name = "date_paiement")
	private java.sql.Date date_paiement;
	@Column(name = "montant_total")
	private Double montant_total;
	
//Relation
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_users")
//	private User users;
	
	public Paiement() {
		
	}

	/**
	 * @param idPaiement
	 * @param date_paiement
	 * @param montant_total
	 */
	public Paiement(long idPaiement, Date date_paiement, Double montant_total) {
		super();
		this.idPaiement = idPaiement;
		this.date_paiement = date_paiement;
		this.montant_total = montant_total;
	}

	/**
	 * @return the idPaiement
	 */
	public long getIdPaiement() {
		return idPaiement;
	}

	/**
	 * @param idPaiement the idPaiement to set
	 */
	public void setIdPaiement(long idPaiement) {
		this.idPaiement = idPaiement;
	}
	
	/**
	 * @return the date_paiement
	 */
	public java.sql.Date getDate_paiement() {
		return date_paiement;
	}
	
	/**
	 * @param date_paiement the date_paiement to set
	 */
	public void setDate_paiement(java.sql.Date date_paiement) {
		this.date_paiement = date_paiement;
	}
	
	/**
	 * @return the montant_total
	 */
	public Double getMontant_total() {
		return montant_total;
	}
	
	/**
	 * @param montant_total the montant_total to set
	 */
	public void setMontant_total(Double montant_total) {
		this.montant_total = montant_total;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "paiement")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Paiement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paiement-sequence")
	@SequenceGenerator(name = "paiement-sequence", sequenceName = "seq_paiement", allocationSize = 1, initialValue = 2)
	@Column(name = "id_paiement")
	private long idPaiement;
	@Column(name = "date_paiement")
	@CreationTimestamp
	private java.sql.Date datePaiement;
	@Column(name = "montant_total")
	private Double montantTotal;
	@Column(name = "id_mode_paiement")
	private Long idModePaiement;
	@Column(name = "valeur")
	private String valeur;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mode_paiement", insertable = false, updatable = false)
	ModePaiement modePaiement;

	public Paiement() {

	}

	public Paiement(Double montantTotal) {
		this.montantTotal = montantTotal;
	}
	
	public Paiement(Double montantTotal, Long idModePaiement, String valeur) {
		this.montantTotal = montantTotal;
		this.idModePaiement = idModePaiement;
		this.valeur = valeur;
	}

	/**
	 * @param idPaiement
	 * @param date_paiement
	 * @param montant_total
	 */
	public Paiement(long idPaiement, Date datePaiement, Double montantTotal) {
		super();
		this.idPaiement = idPaiement;
		this.datePaiement = datePaiement;
		this.montantTotal = montantTotal;
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
		return datePaiement;
	}

	/**
	 * @param date_paiement the date_paiement to set
	 */
	public void setDate_paiement(java.sql.Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	/**
	 * @return the montant_total
	 */
	public Double getMontant_total() {
		return montantTotal;
	}

	/**
	 * @param montant_total the montant_total to set
	 */
	public void setMontant_total(Double montantTotal) {
		this.montantTotal = montantTotal;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public java.sql.Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(java.sql.Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
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

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

}

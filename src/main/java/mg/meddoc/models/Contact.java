package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "contact")
public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "contact-sequence"
			)
			@SequenceGenerator(
			name = "contact-sequence",
			sequenceName = "seq_contact",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_contact")
	private long idContact;
	@Column(name = "valeur")
	private java.lang.String valeur;
	@Column(name = "statut")
	private int statut;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="id_pharmacie")
//	@JsonBackReference(value="pharmacie-contact")
//	private Pharmacie pharmacie;
//	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="id_type_contact")
//	private Type_Contact typeContact;
	
	public Contact() {	}

	/**
	 * @param idContact
	 * @param valeur
	 * @param statut
	 */
	public Contact(long idContact, String valeur, int statut) {
		super();
		this.idContact = idContact;
		this.valeur = valeur;
		this.statut = statut;
	}

	
	/**
	 * @return the idContact
	 */
	public long getIdContact() {
		return idContact;
	}

	/**
	 * @param idContact the idContact to set
	 */
	public void setIdContact(long idContact) {
		this.idContact = idContact;
	}

	/**
	 * @return the valeur
	 */
	public java.lang.String getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(java.lang.String valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the statut
	 */
	public int getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(int statut) {
		this.statut = statut;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

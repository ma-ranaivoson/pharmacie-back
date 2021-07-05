package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_contact")
	private long idContact;
	@Column(name = "valeur")
	private java.lang.String valeur;
	@Column(name = "statut")
	private int statut;
	
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

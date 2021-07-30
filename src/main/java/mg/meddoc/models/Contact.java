package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "contact")
@IdClass(ContactPK.class)
public class Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_entite")
	private Long idEntite;
	@Id
	@Column(name = "valeur")
	private java.lang.String valeur;
	@Column(name = "statut")
	private int statut;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_entite", insertable = false, updatable = false)
	@JsonBackReference(value="pharmacie-contact")
	private Pharmacie pharmacie;
//	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_type_contact")
	private Type_Contact typeContact;
	
	public Contact() {	}

	/**
	 * @param idContact
	 * @param valeur
	 * @param statut
	 */
	public Contact(Long idEntite, String valeur, int statut) {
		super();
		this.idEntite= idEntite;
		this.valeur = valeur;
		this.statut = statut;
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

	public Long getIdEntite() {
		return idEntite;
	}

	public void setIdEntite(Long idEntite) {
		this.idEntite = idEntite;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Type_Contact getTypeContact() {
		return typeContact;
	}

	public void setTypeContact(Type_Contact typeContact) {
		this.typeContact = typeContact;
	}
}

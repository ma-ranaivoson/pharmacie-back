package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "type_ontact")
public class Type_Contact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "typecontact-sequence"
			)
			@SequenceGenerator(
			name = "typecontact-sequence",
			sequenceName = "seq_typecontact",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_type_contact")
	private long idTypeContact;
	@Column(name = "libelle")
	private java.lang.String libelle;
	
	
	public Type_Contact() {
		
	}

	/**
	 * @param idTypeContact
	 * @param libelle
	 */
	public Type_Contact(long idTypeContact, String libelle) {
		super();
		this.idTypeContact = idTypeContact;
		this.libelle = libelle;
	}

	/**
	 * @return the idTypeContact
	 */
	public long getIdTypeContact() {
		return idTypeContact;
	}

	/**
	 * @param idTypeContact the idTypeContact to set
	 */
	public void setIdTypeContact(long idTypeContact) {
		this.idTypeContact = idTypeContact;
	}

	/**
	 * @return the libelle
	 */
	public java.lang.String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(java.lang.String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "staff")
public class Staff implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "staff-sequence"
			)
			@SequenceGenerator(
			name = "staff-sequence",
			sequenceName = "seq_staff",
			allocationSize = 1,
			initialValue = 2
			)
	@Column(name = "id_staff")
	private Long idStaff;
	@Column(name = "nom_staf")
	private java.lang.String nom;
	@Column(name = "poste")
	private java.lang.String poste;
	@Column(name="id_pharmacie")
	private Long idPharmacie;
	
// Relation....
	@ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="id_pharmacie", insertable=false, updatable=false)
	@JsonBackReference(value="pharmacie-staff")
	private Pharmacie pharmacie;

	public Staff() {
		
	}
	
	public Staff(Long id) {
		this.setIdStaff(id);
	}

	/**
	 * @param idStaff
	 * @param nom
	 */
	public Staff(Long idStaff, String nom) {
		super();
		this.idStaff = idStaff;
		this.nom = nom;
	}

	/**
	 * @return the idStaff
	 */
	public Long getIdStaff() {
		return idStaff;
	}

	/**
	 * @param idStaff the idStaff to set
	 */
	public void setIdStaff(Long idStaff) {
		this.idStaff = idStaff;
	}
	/**
	 * @return the poste
	 */
	public java.lang.String getPoste() {
		return poste;
	}

	/**
	 * @param poste the poste to set
	 */
	public void setPoste(java.lang.String poste) {
		this.poste = poste;
	}

	/**
	 * @return the nom
	 */
	public java.lang.String getNom() {
		return nom;
	}
	
	/**
	 * @param nom the nom to set
	 */
	public void setNom(java.lang.String nom) {
		this.nom = nom;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	/**
	 * @return the idPharmacie
	 */
	public Long getIdPharmacie() {
		return idPharmacie;
	}

	/**
	 * @param idPharmacie the idPharmacie to set
	 */
	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}	
}

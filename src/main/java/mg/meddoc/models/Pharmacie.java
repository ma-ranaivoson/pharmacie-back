package mg.meddoc.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pharmacie")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pharmacie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6100600048093734364L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharmacie-sequence")
	@SequenceGenerator(name = "pharmacie-sequence", sequenceName = "seq_pharmacie", allocationSize = 1, initialValue = 2)
	@Column(name = "id_pharmacie")
	private Long idPharmacie;

	@Column(name = "raison_social")
	private java.lang.String raisonSocial;
	@Column(name = "presentation")
	private java.lang.String presentation;
	@Column(name = "adresse")
	private java.lang.String adresse;
	@Column(name = "statut")
	private Integer statut;
	@Column(name = "longitude")
	private Double longitude;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "nif")
	private String nif;
	@Column(name = "stat")
	private String stat;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "rel_service_pharmacie", joinColumns = @JoinColumn(name = "id_pharmacie"), inverseJoinColumns = @JoinColumn(name = "id_service"))
	private Set<Service> service;

//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(name = "rel_pharmacie_produit", 
//			joinColumns = @JoinColumn(name = "id_pharmacie"), 
//			inverseJoinColumns = @JoinColumn(name = "id_produit"))
////	@JsonManagedReference(value="pharmacie-produit")
//	private Set<Produit> produit;

	@OneToMany(mappedBy = "pharmacie", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "pharmacie-contact")
	private Set<Contact> contact;
//	
	@OneToMany(mappedBy = "pharmacie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference(value = "pharmacie-staff")
	private Set<Staff> staff;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "rel_specialite_pharmacie", joinColumns = @JoinColumn(name = "id_pharmacie"), inverseJoinColumns = @JoinColumn(name = "id_specialite"))
	private Set<Specialite> specialite;
//	
	@OneToMany(mappedBy = "pharmacie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference(value = "pharmacie-galerie")
	private Set<Galerie> galerie;
//	
//	@OneToMany(mappedBy = "pharmacie", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JsonManagedReference(value="pharmacie-prix")
//	private Set<Prix> prix;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "rel_pharmacie_utilisateur", joinColumns = @JoinColumn(name = "id_pharmacie"), inverseJoinColumns = @JoinColumn(name = "id_utilisateur"))
	private Set<Utilisateur> utilisateurs;
	
	public Pharmacie() {

	}

	/**
	 * @param idPharmacie
	 * @param raison_social
	 * @param presentation
	 * @param adresse
	 * @param statut
	 * @param longitude
	 * @param latitude
	 */
	public Pharmacie(long idPharmacie, String raison_social, String presentation, String adresse, Integer statut,
			Double longitude, Double latitude) {
		super();
		// this.idPharmacie = idPharmacie;
		this.raisonSocial = raison_social;
		this.presentation = presentation;
		this.adresse = adresse;
		this.statut = statut;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Long getIdPharmacie() {
		return idPharmacie;
	}

	public void setIdPharmacie(Long idPharmacie) {
		this.idPharmacie = idPharmacie;
	}

	// Must not be null
	public java.lang.String getRaisonSocial() throws Exception {
		if(this.raisonSocial ==  null || this.raisonSocial.equals(""))
			throw new Exception("Raison sociale vide");
		
		return raisonSocial;
	}

	public void setRaisonSocial(java.lang.String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public java.lang.String getPresentation() throws Exception {
		if(this.presentation ==  null || this.presentation.equals(""))
			throw new Exception("Presentation sociale vide");
		
		return presentation;
	}

	public void setPresentation(java.lang.String presentation) {
		this.presentation = presentation;
	}

	public java.lang.String getAdresse() throws Exception {
		if(this.presentation ==  null || this.presentation.equals(""))
			throw new Exception("Adresse vide");
		
		return adresse;
	}

	public void setAdresse(java.lang.String adresse) {
		this.adresse = adresse;
	}

	public Integer getStatut() {
		return statut;
	}

	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Set<Service> getService() {
		return service;
	}

	public void setService(Set<Service> service) {
		this.service = service;
	}

//	public Set<Produit> getProduit() {
//		return produit;
//	}
//	public void setProduit(Set<Produit> produit) {
//		this.produit = produit;
//	}
	public Set<Contact> getContact() {
		return contact;
	}

	public void setContact(Set<Contact> contact) {
		this.contact = contact;
	}

	public Set<Staff> getStaff() {
		return staff;
	}

	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}

	public Set<Specialite> getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Set<Specialite> specialite) {
		this.specialite = specialite;
	}

	public Set<Galerie> getGalerie() {
		return galerie;
	}

	public void setGalerie(Set<Galerie> galerie) {
		this.galerie = galerie;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getStat() throws Exception {
		if(this.stat ==  null || this.stat.equals(""))
			throw new Exception("Stat vide");	
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}
}

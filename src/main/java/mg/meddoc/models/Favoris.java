package mg.meddoc.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favoris")
@IdClass(FavorisPK.class)
public class Favoris implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4066614379568307722L;
	@Id
	@Column(name = "produit_id")
	private Long produitId;
	@Id
	@Column(name = "users_id")
	private Long usersId;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name="produit_id", insertable = false, updatable = false)
	Produit produit;
	
	public Long getProduitId() {
		return produitId;
	}
	public void setProduitId(Long produitId) {
		this.produitId = produitId;
	}
	public Long getUsersId() {
		return usersId;
	}
	public void setUsersId(Long usersId) {
		this.usersId = usersId;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Favoris() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Favoris(Long produitId, Long usersId) {
		super();
		this.produitId = produitId;
		this.usersId = usersId;
	}
}

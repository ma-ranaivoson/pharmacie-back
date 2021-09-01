package mg.meddoc.models;

import java.io.Serializable;

public class FavorisPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3940490736201704951L;

	Long produitId;
	Long usersId;
	
	public FavorisPK(Long produitId, Long usersId) {
		super();
		this.produitId = produitId;
		this.usersId = usersId;
	}

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

	public FavorisPK() {
		super();
		// TODO Auto-generated constructor stub
	}
}

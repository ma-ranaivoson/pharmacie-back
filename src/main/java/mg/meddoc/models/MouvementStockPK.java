package mg.meddoc.models;

import java.io.Serializable;
import java.sql.Date;

public class MouvementStockPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -991101834801116185L;
	
	Long idPharmacie;
	Long idProduit;
	Date date_stock;
	
	public MouvementStockPK() {
		
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

	/**
	 * @return the idProduit
	 */
	public Long getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit the idProduit to set
	 */
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * @return the date_stock
	 */
	public Date getDate_stock() {
		return date_stock;
	}

	/**
	 * @param date_stock the date_stock to set
	 */
	public void setDate_stock(Date date_stock) {
		this.date_stock = date_stock;
	}
	
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

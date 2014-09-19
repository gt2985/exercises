/**
 * 
 */
package com.thoughtworks.product;

/**
 * This class represents a Product or an item which
 *  is being ordered.
 * @author gauravthakur
 *
 */
public class Product {

	/**
	 * Identifier for the product, can be the name of the product.
	 */
	private String identifier;
	/**
	 * Category of the product, required to find out if the product is
	 * exempted from sales tax.
	 */
	private String category;
	/**
	 * Price of the product.
	 */
	private float price;
	/**
	 * Quantity of the product ordered.
	 */
	private int quantity;
	/**
	 * If the product is imported, required to calculate the import tax.
	 */
	private boolean isImported;
	
	/**
	 * @return the isImported
	 */
	public boolean isImported() {
		return isImported;
	}
	/**
	 * @param isImported the isImported to set
	 */
	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}
	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the totalprice
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param totalprice the totalprice to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return quantity + " " + category + " : " + price + System.getProperty("line.separator");
	}
	
}

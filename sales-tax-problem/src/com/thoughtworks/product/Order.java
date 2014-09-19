/**
 * 
 */
package com.thoughtworks.product;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the order placed, containing the list of
 * products and totalPrice.
 * @author gauravthakur
 *
 */
public class Order {
	/**
	 * List of products in order.
	 */
	List<Product> productList;
	/**
	 * totalPrice of the order.
	 */
	float totalPrice;
	
	/**
	 * Add the product to the order.
	 * @param product
	 */
	public void addProduct(Product product) {
		if (productList ==null) {
			productList = new ArrayList<Product>();
		}
		productList.add(product);
	}
	
	/**
	 * @return the productList
	 */
	public List<Product> getProductList() {
		return productList;
	}
	
	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [productList=" + productList + ", totalPrice="
				+ totalPrice + "]";
	}
	
	

}

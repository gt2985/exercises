/**
 * 
 */
package com.thoughtworks.receipt;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.product.Product;

/**
 * This class represents the receipt that will contain the total amount
 * including the sales tax.
 * @author gauravthakur
 *
 */
public class Receipt {
	
	/**
	 * The list of products in the receipt.
	 */
	List<Product> productList;
	/**
	 * Total sales tax for the ordered products.
	 */
	float totalSalesTax;
	/**
	 * Total price after sales tax addition.
	 */
	float totalPrice;
	/**
	 * Default constructor.
	 */
	public Receipt() {
		totalPrice = (float) 0.00;
		totalSalesTax = (float) 0.00;
	}
	
	/**
	 * Adds the product to the list of product for a receipt.
	 * @param product
	 */
	public void addProduct (Product product){
		if(this.productList == null){
			this.productList = new ArrayList<Product>();
		}
		productList.add(product);
	}
	
	/**
	 * @return the prouductList
	 */
	public List<Product> getProuductList() {
		return productList;
	}
	/**
	 * @param prouductList the prouductList to set
	 */
	public void setProuductList(List<Product> prouductList) {
		this.productList = prouductList;
	}
	/**
	 * @return the totalSalesTax
	 */
	public float getTotalSalesTax() {
		return totalSalesTax;
	}
	/**
	 * @param totalSalesTax the totalSalesTax to set
	 */
	public void setTotalSalesTax(float totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
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
		String recepitPrint = productList.toString();
		recepitPrint = recepitPrint.substring(1, recepitPrint.length() - 1);
		recepitPrint = recepitPrint + System.getProperty("line.separator")
				+ "Sales Taxes:" + totalSalesTax + System.getProperty("line.separator")
				+ "Total:" + totalPrice;
		return recepitPrint;
	}

}

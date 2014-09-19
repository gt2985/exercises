/**
 * 
 */
package com.thoughtworks.processor;

import java.util.List;

import com.thoughtworks.product.Order;
import com.thoughtworks.product.Product;
import com.thoughtworks.receipt.Receipt;
import com.thoughtworks.salestax.util.TaxCalculator;

/**
 * This class will process the order and generate the receipt object.
 * @author gauravthakur
 *
 */
public class OrderProcessor {

	/**
	 * Tax calculator to be used to process the order.
	 */
	private TaxCalculator taxCalculator;

	/**
	 * List of categories exempted from sales tax.
	 */
	private static List<String> exemptedCategoryList = java.util.Arrays.asList("book","food","medical");
	
	/**
	 * Parameteried constructor accepting the TaxCalculator instance
	 * to be used to process the order.
	 * @param taxCalc
	 */
	public OrderProcessor(TaxCalculator taxCalc) {
		if (taxCalc != null) {
			taxCalculator = taxCalc;
		}  else {
			throw new RuntimeException("TaxCalculator being set is null");
		}
	}

	/**
	 * This method calculates the salesTax and importTax on the products based on
	 * the TaxCalculator instance that is passed. It also handles if the category of
	 * the product is exempted from sales tax. 
	 * @param order - Order
	 * @return receipt - Receipt
	 */
	public Receipt processOrder(Order order) {
		
		//create the receipt object
		Receipt receipt = new Receipt();
		//variable to hold the total sales tax
		float totalSalesTax = 0.00f;
		//variable to hold the total price
		float totalPrice = 0.00f;
		//loop through the products placed in the order
		for (Product productInOrder: order.getProductList()) {
			//variable to hold product salesTax
			float itemSalesTax = 0.00f;
			//if category is not exempted then calculate the salesTax
			if (!isCategoryTaxExempted(productInOrder.getCategory())){
				itemSalesTax = taxCalculator.getSalesTaxAmount(productInOrder.getPrice());
				totalSalesTax = totalSalesTax + itemSalesTax;

			}
			//variable to hold product import Tax
			float itemImportTax = 0.00f;
			//check if product is imported then calculate the importTax
			if (productInOrder.isImported()) {
				itemImportTax = taxCalculator.getImportTaxAmount(productInOrder.getPrice());
				totalSalesTax = totalSalesTax + itemImportTax;

			}
			//set the total price of product
			productInOrder.setPrice(itemSalesTax +itemImportTax + productInOrder.getPrice());
			//calculate the total price for receipt
			totalPrice = totalPrice + productInOrder.getPrice();
			//add the processed object to receipt
			receipt.addProduct(productInOrder);	
		}
		receipt.setTotalPrice(totalPrice);
		receipt.setTotalSalesTax(totalSalesTax);
		System.out.println(receipt.toString());
		return receipt;
	}

	/**
	 * This method checks if the category is exempted from sales tax.
	 * @param category
	 * @return Boolean(true/false)
	 */
	private boolean isCategoryTaxExempted(String category) {
		boolean isExempted = false;
		if(exemptedCategoryList.contains(category))
			isExempted = true;
		return isExempted;
	}
}

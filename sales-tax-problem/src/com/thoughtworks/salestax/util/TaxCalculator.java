/**
 * 
 */
package com.thoughtworks.salestax.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This class will be used to do tax calculations.
 * @author gauravthakur
 *
 */
public class TaxCalculator {
	
	
	private BigDecimal importTaxPercentBigDecimal;
	
	private BigDecimal salesTaxPercentBigDecimal;
	
	private static final BigDecimal ROUND_TO = new BigDecimal(0.05);
	
	/**
	 * Constructor to provide the sales tax and import tax percent.
	 * @param salesTaxPercent
	 * @param importTaxPercent
	 */
	public TaxCalculator(float salesTaxPercent, float importTaxPercent) {
		if (salesTaxPercent == Float.NaN) {
			 throw new RuntimeException("Please Set Sales Tax Percent For TaxCalculator Instance");
		}
		salesTaxPercentBigDecimal = new BigDecimal(salesTaxPercent);
		
		if (importTaxPercent == Float.NaN) {
			throw new RuntimeException("Please Set Import Tax Percent For TaxCalculator Instance");
		}
		importTaxPercentBigDecimal = new BigDecimal(importTaxPercent);
	}
	
	/**
	 * Default constructor.
	 */
	public TaxCalculator() {
		
	}

	/**
	 * This method will return the sales tax on the actual price passed,
	 * based on the sales tax percent associated with the Tax Calculator instance.
	 * @param actualPrice
	 * @return salesTax
	 */
	public float getSalesTaxAmount(float actualPrice) {
		
		BigDecimal actualPriceBigDecimal = new BigDecimal(actualPrice);
		BigDecimal salesTax  = actualPriceBigDecimal.multiply(salesTaxPercentBigDecimal).divide(new BigDecimal(100));
		salesTax = roundOff(salesTax);
		return salesTax.floatValue();
	}
	
	
	/**
	 * This method will return the import tax on the actual price passed,
	 * based on the import tax percent associated with the Tax Calculator instance.
	 * @param actualPrice
	 * @return importTax
	 */
	public float getImportTaxAmount(float actualPrice) {
		BigDecimal actualPriceBigDecimal = new BigDecimal(actualPrice);
		BigDecimal importTax  = actualPriceBigDecimal.multiply(importTaxPercentBigDecimal).divide(new BigDecimal(100));
		importTax = roundOff(importTax);
		return importTax.floatValue();
	}

	
	/** 
     * Returns the value rounded up to the nearest 0.05. 
     *  
     * @param value 
     *            value to be rounded 
     * @return double rounded up value 
     */  
    private BigDecimal roundOff(BigDecimal value) {   
        value = value.divide(ROUND_TO, RoundingMode.HALF_UP);  
        value = new BigDecimal(Math.ceil(value.doubleValue()));  
        value= value.multiply(ROUND_TO);  
        return value;  
    }  
}

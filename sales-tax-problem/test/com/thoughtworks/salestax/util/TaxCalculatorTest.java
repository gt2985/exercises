/**
 * 
 */
package com.thoughtworks.salestax.util;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author gauravthakur
 *
 */
public class TaxCalculatorTest {
	
	private TaxCalculator taxCalc;
	
	@Before
	public void setUp() {
		taxCalc = new TaxCalculator(10.0f, 5.0f);
	}
	
	/**
	 * Test method for {@link com.thoughtworks.salestax.util.TaxCalculator#getSalesTaxAmount(double)}.
	 */
	@Test
	public final void testGetSalesTaxAmountInputZero() {
		taxCalc = new TaxCalculator(0.0f, 5.0f);
		float salesTax = taxCalc.getSalesTaxAmount(new Float(1.00));
		assertEquals(new Float(salesTax), new Float(0.00));
	}


	/**
	 * Test method for {@link com.thoughtworks.salestax.util.TaxCalculator#getSalesTaxAmount(double)}.
	 */
	@Test
	public final void testGetSalesTaxAmountInputNonZero() {
		float salesTax = taxCalc.getSalesTaxAmount(new Float(10.00));
		assertEquals(new Float(salesTax), new Float(1.00));
	}
}

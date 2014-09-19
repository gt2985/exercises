/**
 * 
 */
package com.thoughtworks.processor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.thoughtworks.product.Order;
import com.thoughtworks.product.Product;
import com.thoughtworks.receipt.Receipt;
import com.thoughtworks.salestax.util.TaxCalculator;

/**
 * @author gauravthakur
 *
 */
public class OrderProcessorTest {
	
	private OrderProcessor orderProcessor;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		orderProcessor = new OrderProcessor(new TaxCalculator(10.00f, 5.00f));
	}

	/**
	 * Test method for {@link com.thoughtworks.processor.OrderProcessor#processOrder(com.thoughtworks.product.Order)}.
	 */
	@Test
	public final void testProcessOrderWithInput1() {
		//29.83
		Order order = new Order();
		Product bookProduct = new Product();
		bookProduct.setCategory("book");
		bookProduct.setIdentifier("book_id1");
		bookProduct.setImported(false);
		bookProduct.setQuantity(1);
		bookProduct.setPrice(12.49f);
		order.addProduct(bookProduct);
		
		Product chocolateProduct = new Product();
		chocolateProduct.setCategory("food");
		chocolateProduct.setIdentifier("cadbury");
		chocolateProduct.setImported(false);
		chocolateProduct.setQuantity(1);
		chocolateProduct.setPrice(0.85f);
		order.addProduct(chocolateProduct);
		
		Product musicCdProduct = new Product();
		musicCdProduct.setCategory("entertainment");
		musicCdProduct.setIdentifier("CD");
		musicCdProduct.setImported(false);
		musicCdProduct.setPrice(14.99f);
		musicCdProduct.setQuantity(1);
		order.addProduct(musicCdProduct);
		
		Receipt receipt = orderProcessor.processOrder(order);
		assertEquals(new Float(receipt.getTotalPrice()), new Float(29.83));
		assertEquals(new Float(receipt.getTotalSalesTax()), new Float(1.50));
	}
	@Test
	public final void testProcessOrderWithInput2() {
		//65.15
		// 47.50 - 4.75 - 2.375
		
		Order order = new Order();
		Product chocolateProduct = new Product();
		chocolateProduct.setCategory("food");
		chocolateProduct.setIdentifier("hersheys");
		chocolateProduct.setImported(true);
		chocolateProduct.setQuantity(1);
		chocolateProduct.setPrice(10.00f);
		order.addProduct(chocolateProduct);
		
		Product perfumeProduct = new Product();
		perfumeProduct.setCategory("cosmetic");
		perfumeProduct.setIdentifier("CK");
		perfumeProduct.setImported(true);
		perfumeProduct.setQuantity(1);
		perfumeProduct.setPrice(47.50f);
		order.addProduct(perfumeProduct);

		Receipt receipt = orderProcessor.processOrder(order);
		assertEquals(new Float(receipt.getTotalPrice()), new Float(65.15));
		assertEquals(new Float(receipt.getTotalSalesTax()), new Float(7.65));
	}

	@Test
	public final void testProcesOrderWithInput3() {
		
		Order order = new Order();
		Product impperfumeProduct = new Product();
		impperfumeProduct.setCategory("cosmetic");
		impperfumeProduct.setIdentifier("CK");
		impperfumeProduct.setImported(true);
		impperfumeProduct.setQuantity(1);
		impperfumeProduct.setPrice(27.99f);
		order.addProduct(impperfumeProduct);
		
		Product perfumeProduct = new Product();
		perfumeProduct.setCategory("perfume");
		perfumeProduct.setIdentifier("CK-One");
		perfumeProduct.setImported(false);
		perfumeProduct.setQuantity(1);
		perfumeProduct.setPrice(18.99f);
		order.addProduct(perfumeProduct);
		
		Product headAchePills = new Product();
		headAchePills.setCategory("medical");
		headAchePills.setIdentifier("Asprin");
		headAchePills.setImported(false);
		headAchePills.setQuantity(1);
		headAchePills.setPrice(9.75f);
		order.addProduct(headAchePills);
		
		Product impChocs = new Product();
		impChocs.setCategory("food");
		impChocs.setIdentifier("Choc1");
		impChocs.setImported(true);
		impChocs.setQuantity(1);
		impChocs.setPrice(11.25f);
		order.addProduct(impChocs);
		
		Receipt receipt = orderProcessor.processOrder(order);
		assertEquals(new Float(receipt.getTotalPrice()), new Float(74.68f));
		assertEquals(new Float(receipt.getTotalSalesTax()), new Float(6.70f));
	}
}

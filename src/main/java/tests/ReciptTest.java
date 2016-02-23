package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import productInfo.Product;
import productInfo.Receipt;

public class ReciptTest {	
	
	@Test
	public void NoNullProductAdding(){
		Receipt rTest = new Receipt();
		rTest.addProduct(null);
		assertTrue(rTest.getProductList().size() == 0);
	}
	@Test
	public void TotalCounting(){
		Receipt rTest = new Receipt();
		rTest.addProduct(new Product("bc1", "p1", 1.119));
		rTest.addProduct(new Product("bc2", "p2", -1.12));
		rTest.addProduct(new Product("bc3", "p3", 1.132));
		assertTrue(rTest.getTotal() == 3.37);
	}

	
}

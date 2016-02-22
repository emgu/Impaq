package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

import productInfo.Product;
import productInfo.Receipt;

public class ReciptTest {	
	
	@Test
	public void NoNullProductAdding(){
		Receipt rtest = Mockito.mock(Receipt.class);
		rtest = new Receipt();
		rtest.addProduct(null);
		assertTrue(rtest.getProductList().size() == 0);
	}
	@Test
	public void TotalCounting(){
		
		Receipt rtest = Mockito.mock(Receipt.class);
		rtest = new Receipt();

		rtest.addProduct(new Product("bc1", "p1", 1.119));
		rtest.addProduct(new Product("bc2", "p2", -1.12));
		rtest.addProduct(new Product("bc3", "p3", 1.132));
		
		assertTrue(rtest.getTotal() == 3.37);
	}

	
}

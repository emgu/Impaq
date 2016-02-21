package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

import productInfo.Product;

public class ProductTest {
	
	@Test
	public void ProductPriceNonNegativeRounded(){
		Product prod = new Product(Mockito.anyString(), Mockito.anyString(), -12.999999);
		double price = prod.getPrice();
		assertEquals(price, 13.00, 0.01);
	}
}

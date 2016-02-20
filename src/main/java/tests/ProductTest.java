package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import printbale.Product;

public class ProductTest {
	
	//Product prod;
	@Test
	public void RoundPriceReturnsDecimalTwoPlaces(){
		Product prod = new Product(Mockito.anyString(), Mockito.anyString(), 12.999999);
		double price = prod.getPrice();
		assertEquals(price, 13.00, 0.01);
	}
	
	@Test
	public void ProductPriceNonNegative(){
		Product prod = new Product(Mockito.anyString(), Mockito.anyString(), -12.999999);
		double price = prod.getPrice();
		assertEquals(price, 13.00, 0.01);
	}
}

package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;

import database.DataBase;
import productInfo.Product;

public class DataBaseTest {
	
	@Test
	public void IfBarCodeIsEmptyReturnEmptyProduct() {
		DataBase db = new DataBase(Mockito.anyString());
		Product prod = db.findProduct("");
		assertTrue(prod.isEmpty());
	}
	@Test
	public void ContentFileErrors(){
		DataBase db = Mockito.mock(DataBase.class); 
		
		db = new DataBase("data/test.csv");
		Product test1product = db.findProduct("test1");
		Product test2product = db.findProduct("test2");
		Product test3product = db.findProduct("test3");
		Product test4product = db.findProduct("test4");
	   			
		assertTrue(test1product.getBarCode().equals(""));
		assertTrue(test1product.getName().equals(""));
		assertTrue(test1product.getPrice() == 0.0);
		
		assertTrue(test2product.getBarCode().equals(""));
		assertTrue(test2product.getName().equals(""));
		assertTrue(test2product.getPrice() == 0.0);
		
		assertTrue(test3product.getBarCode().equals("test3"));
		assertTrue(test3product.getName().equals("test3name"));
		assertTrue(test3product.getPrice() == 3.3);
		
		assertTrue(test4product.getBarCode().equals(""));
		assertTrue(test4product.getName().equals(""));
		assertTrue(test4product.getPrice() == 0.0);
		
	}
	

}

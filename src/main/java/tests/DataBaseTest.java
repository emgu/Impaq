package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import database.DataBase;
import printbale.Product;

public class DataBaseTest {

	DataBase db;
	
	@Test
	public void IfBarCodeIsEmptyreturnEmptyProduct() {
		
		db = new DataBase(Mockito.anyString());
		Product prod = db.findProduct("");
		assertTrue(prod.isEmpty());
	}

}

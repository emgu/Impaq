package tests;

import org.junit.Test;
import org.mockito.Mockito;

import database.DataBase;
import in.BarCodeScanner;
import out.LCD;
import out.Printer;
import productInfo.Product;
import productInfo.Receipt;
import store.PointOfSale;

public class PointOfSaleTest {

	BarCodeScanner bcsTest = Mockito.mock(BarCodeScanner.class);
	LCD lcdTest = Mockito.mock(LCD.class);
	Printer printTest = Mockito.mock(Printer.class);
	DataBase dbTest = Mockito.mock(DataBase.class);
	Receipt rTest = Mockito.mock(Receipt.class);
	Product pTest = Mockito.mock(Product.class);
	
	@Test
	public void NoAddingToReceiptOnExit() {
			
		Mockito.when(bcsTest.getBarCode()).thenReturn("exit");
		PointOfSale pos = new PointOfSale(bcsTest, lcdTest, printTest, dbTest);
		
		pos.handleCustomer();
		
		Mockito.verify(lcdTest, Mockito.times(1)).print(Mockito.anyString());
		Mockito.verify(rTest, Mockito.times(0)).addProduct(pTest);;
	}
	@Test
	public void NoAddingToReceiptEmpty() {
			
		Mockito.when(bcsTest.getBarCode()).thenReturn("").thenReturn("exit");
		PointOfSale pos = new PointOfSale(bcsTest, lcdTest, printTest, dbTest);
		
		pos.handleCustomer();
		
		Mockito.verify(bcsTest, Mockito.times(2)).getBarCode();
		Mockito.verify(rTest, Mockito.times(0)).addProduct(pTest);
	}
	
	
}

package tests;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import out.LCD;
import productInfo.Product;
import productInfo.Receipt;

public class LCDTest {

	PrintStream psTest = Mockito.mock(PrintStream.class);
	LCD lcd = new LCD(psTest);
	
	@Test
	public void LcdPrintStringOnce(){
		this.lcd.print("text to print");
		Mockito.verify(psTest).println("text to print");
	}
	@Test
	public void LcdPrintProductGetsProductNameAndPriceOnce(){
		Product pTest = Mockito.mock(Product.class);
		lcd.print(pTest);
		
		Mockito.verify(pTest).getName();
		Mockito.verify(pTest).getPrice();
	}
	@Test
	public void LcdPrintReceiptRunsReciptNumAndTotalOnce(){
		Receipt rtest = Mockito.mock(Receipt.class);
		lcd.print(rtest);
		
		Mockito.verify(rtest).getReceiptNumber();
		Mockito.verify(rtest).getTotal();
	}

}

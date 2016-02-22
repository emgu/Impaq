package tests;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import out.LCD;
import productInfo.Product;
import productInfo.Receipt;

public class LCDTest {

	PrintStream pstest = Mockito.mock(PrintStream.class);
	LCD lcd = new LCD(pstest);
	
	@Test
	public void LcdPrintStringOnce(){
		this.lcd.print("text to print");
		Mockito.verify(pstest).println("text to print");
	}
	@Test
	public void LcdPrintReceiptRunsReciptNumAndTotalOnce(){
		Receipt rtest = Mockito.mock(Receipt.class);
		lcd.print(rtest);
		Mockito.verify(rtest).getReceiptNumber();
		Mockito.verify(rtest).getTotal();
	}
	@Test
	public void LcdPrintProductGetsProductNameAndPriceOnce(){
		Product ptest = Mockito.mock(Product.class);
		lcd.print(ptest);
		Mockito.verify(ptest).getName();
		Mockito.verify(ptest).getPrice();
		
	}
}

package tests;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.*;


import out.LCD;
import printbale.Product;

public class LCDTest {

	PrintStream pstest = Mockito.mock(PrintStream.class);
	LCD lcd = new LCD(pstest);
	
	@Test
	public void LcdPrintTestOnce(){
			
		this.lcd.print("text to print");
		Mockito.verify(pstest).println("text to print");
	}
	
	@Test
	public void LcdDontPrintEmptyString(){
			
		this.lcd.print("");
		Mockito.verify(pstest, Mockito.times(0)).println("");
	}
	
	@Test
	public void LcdPrintsProduct(){
			
		Product prod = new Product();
		this.lcd.print(prod);
		Mockito.verify(pstest).println("Bar code: " + prod.getBarCode() + 
							"Name:" + prod.getName() + 
							"Price:" + prod.getPrice());;
	}
}

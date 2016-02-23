package tests;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import out.Printer;
import productInfo.Product;
import productInfo.Receipt;

public class PrinterTest {

	PrintStream pstest = Mockito.mock(PrintStream.class);
	Printer printer = new Printer(pstest);
	
	@Test
	public void PrintRunsGetsFromReceiptOnce() {
		Receipt rtest = Mockito.mock(Receipt.class);
		printer.print(rtest);
		
		Mockito.verify(rtest).getReceiptNumber();
		Mockito.verify(rtest).getProductList();
		Mockito.verify(rtest).getTotal();

	}
	@Test
	public void PrintRunsGetsFromProductOnce() {
		Product ptest = Mockito.mock(Product.class);
		
		printer.print(ptest);
		
		Mockito.verify(ptest).getName();
		Mockito.verify(ptest).getPrice();
		
	}
	
}

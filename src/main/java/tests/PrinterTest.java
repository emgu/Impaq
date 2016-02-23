package tests;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.PrintStream;

import out.Printer;
import productInfo.Product;
import productInfo.Receipt;

public class PrinterTest {

	PrintStream psTest = Mockito.mock(PrintStream.class);
	Printer printer = new Printer(psTest);
	
	@Test
	public void PrintStringOnce(){
		printer.print("text to print");
		Mockito.verify(psTest).println("text to print");
	}
	@Test
	public void PrintReceiptRunsGetsFromReceiptOnce() {
		Receipt rTest = Mockito.mock(Receipt.class);
		printer.print(rTest);
		
		Mockito.verify(rTest).getReceiptNumber();
		Mockito.verify(rTest).getProductList();
		Mockito.verify(rTest).getTotal();
	}
	@Test
	public void PrintProductRunsGetsFromProductOnce() {
		Product pTest = Mockito.mock(Product.class);
		printer.print(pTest);
		
		Mockito.verify(pTest).getName();
		Mockito.verify(pTest).getPrice();
		
	}
	
}

package tests;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Test;
import org.mockito.Mockito;

import out.Printer;
import printbale.Receipt;

public class PrinterTest {

	@Test
	public void PrintRunsGetsFromReceiptOnce() {
		Receipt rtest = Mockito.mock(Receipt.class);
		
		PrintStream pstest = Mockito.mock(PrintStream.class);
		Printer printer = new Printer(pstest);
		printer.print(rtest);
		
		Mockito.verify(rtest, Mockito.times(1)).getReceiptNumber();
		Mockito.verify(rtest, Mockito.times(1)).getProductList();
		Mockito.verify(rtest, Mockito.times(1)).getTotal();

	}

}

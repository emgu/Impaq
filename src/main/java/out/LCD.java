package out;

import java.io.PrintStream;

import printbale.Printable;

public class LCD implements OutputDevice{
	private PrintStream ps;
	
	public LCD(PrintStream ps){
		this.ps=ps;
	}
	
	public void print(String str){
		if(!str.equals(""))
			ps.println(str);
	}
	@Override
	public void print(Printable p){

		ps.println	(		"Bar code: " + p.getBarCode() + 
							"Name:" + p.getName() + 
							"Price:" + p.getPrice()
							);
	}

}

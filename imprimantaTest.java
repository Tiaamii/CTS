package test;

import cts_facade.ExceptieDocumentNull;
import cts_facade.Imprimanta;
import cts_facade.stari;
import junit.framework.TestCase;

public class imprimantaTest  extends TestCase{

	Imprimanta i = new Imprimanta(1);
	
	void setUpImprimanta(){
		i.stare = stari.functional;
	}
	
	public void testNullDocumentScanare() throws ExceptieDocumentNull{
		setUpImprimanta();
		try{
		assertNull(i.scaneaza(null));
		}
		catch(ExceptieDocumentNull e){}
	}
	
	public void testNullDocumentPrintare() throws ExceptieDocumentNull{
		setUpImprimanta();
		try{
		assertNull(i.printeaza(null));
		}
		catch(ExceptieDocumentNull e){}
	}
		
	public void testNullDocumentXeroxeaza() throws ExceptieDocumentNull{
		setUpImprimanta();
		try{
		assertNull(i.printeaza(null));
		}
		catch(ExceptieDocumentNull e){}
	}
	
	
	
}

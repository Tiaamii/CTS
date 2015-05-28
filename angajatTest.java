package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import cts.ExceptieActivitatiNegative;
import cts.ExceptieFragmentareActivitate;
import cts.ExceptieLimitaSuperioaraPontaj;
import cts.ExceptiePontaj;
import cts.ExceptieZeroActivitati;
import cts.angajat;
import cts.angajat.AngajatBuilder;

public class angajatTest  extends TestCase{

	//fixture
	angajat ang;
	

	public void setUp(){
		System.out.println("setUp Unit test");
		ang = new AngajatBuilder(01,"Ion","Ionescu")
        .setManager(02).setSefDep(03).setNrAct(0).ACTIVARE();
	}
	

	//unit test pentru verificat metoda ponteazaActivitate(int nrAct)
	//testare valori normale (naturale > 0)
	public void testValoriNormalePontaj() throws ExceptieActivitatiNegative, ExceptieFragmentareActivitate, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj{
		
	    //valori de testat
		int expected = 1;
		
		assertEquals("Test ponteazaActivitate()",expected, ang.ponteazaActivitate(1),0.0);
		}
	
	
	//unit test pentru verificat metoda ponteazaActivitate(int nrAct)
		//testare valori negative (naturale < 0)
		public void testValoriNegativePontaj() throws ExceptieActivitatiNegative, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj, ExceptieFragmentareActivitate{
			try{
				setUp();
				ang.ponteazaActivitate(-1);
				assertFalse("Metoda nu arunca exceptii pevalori negative.",true);
			}
			catch(ExceptiePontaj ex){
				assertTrue(true);
			}
		}
				
			
		//unit test pentru verificat metoda ponteazaActivitate(int nrAct)
		//testare valori pozitive > 20
		public void testDepasireLimita(){
			try{
				setUp();
				int valoare = 100;
				ang.ponteazaActivitate(valoare);
				fail("Test ponteazaActivitate(int nrAct) cu valoare peste limita 20");
			}
			catch(ExceptiePontaj ex){
				
			}
				
			}
		
	}
	
	


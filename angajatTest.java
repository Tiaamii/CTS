package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import cts.ExceptieActivitatiNegative;
import cts.ExceptieConfuzieAnularePontaj;
import cts.ExceptieFragmentareActivitate;
import cts.ExceptieLimitaSuperioaraPontaj;
import cts.ExceptiePontaj;
import cts.ExceptieZeroActivitati;
import cts.angajat;
import cts.angajat.AngajatBuilder;

public class angajatTest  extends TestCase{

	//fixture
	angajat ang;
	int numar = 0;
	

	public void setUp(int numar){
		System.out.println("setUp Unit test");
		ang = new AngajatBuilder(01,"Ion","Ionescu")
        .setManager(02).setSefDep(03).setNrAct(numar).ACTIVARE();
	}
	

	//unit test pentru verificat metoda ponteazaActivitate(int nrAct)
	//testare valori normale (naturale > 0)
	public void testValoriNormalePontaj() throws ExceptieActivitatiNegative, ExceptieFragmentareActivitate, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj{
		
	    //valori de testat
		int expected = 1;
		setUp(0);
		assertEquals("Test ponteazaActivitate()",expected, ang.ponteazaActivitate(1),0.0);
		}
	
	
	//unit test pentru verificat metoda ponteazaActivitate(int nrAct)
	//testare valori negative (naturale < 0)
	public void testValoriNegativePontaj() throws ExceptieActivitatiNegative, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj, ExceptieFragmentareActivitate{
		try{
			setUp(0);
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
			setUp(0);
			int valoare = 100;
			ang.ponteazaActivitate(valoare);
			fail("Test ponteazaActivitate(int nrAct) cu valoare peste limita 20");
		}
		catch(ExceptiePontaj ex){}
	}
			

	//unit test pentru verificat metoda anuleazăActivitate(int nrAct)
	//testare valori normale (naturale > 0)
	public void testValoriNormaleAnularePontaj() throws ExceptieActivitatiNegative, ExceptieFragmentareActivitate, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj, ExceptieConfuzieAnularePontaj{
		setUp(20);
		//valori de testat
		int expected = 19;			
		assertEquals("Test ponteazaActivitate()",expected, ang.anuleazaActivitate(1),0.0);
	}
		
		
	//unit test pentru verificat metoda anulareActivitate(int nrAct)
	//testare valori negative (naturale < 0)
	public void testValoriNegativeAnularePontaj() throws ExceptieActivitatiNegative, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj, ExceptieFragmentareActivitate{
		try{
			setUp(20);
			ang.anuleazaActivitate(-1);
			assertFalse("Metoda nu arunca exceptii pevalori negative.",true);
			}
		catch(ExceptiePontaj ex){
			assertTrue(true); 
		}
	}
}
	
	


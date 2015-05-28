package test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

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
	public void testValoriNormalePontaj(){
		
	    //valori de testat
		int expected = 1;
		assertEquals("Test ponteazaActivitate()",expected, ang.ponteazaActivitate(1));
		}
	
	
	//unit test pentru verificat metoda ponteazaActivitate(int nrAct)
		//testare valori negative (naturale < 0)
		public void testValoriNegativePontaj(){
			
		    //valori de testat
			int expected = -1;
			assertEquals("Test ponteazaActivitate()", expected, ang.ponteazaActivitate(-1));
			}
	}

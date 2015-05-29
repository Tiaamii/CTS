package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

public class angajatiTestAutomat extends TestCase{

	angajat ang;
	String fileNamePontaj = "Valori_test.txt";
	String fileNameAnulare = "Valori_test_anulare_activitate.txt";
	
	public void setUp(int numar){
		System.out.println("setUp Unit test");
		ang = new AngajatBuilder(01,"Ion","Ionescu")
        .setManager(02).setSefDep(03).setNrAct(numar).ACTIVARE();
	}
	
	
	//testare valori normale si limite
	public void testePontaj() throws IOException, ExceptieActivitatiNegative, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj, ExceptieFragmentareActivitate{
		
		System.out.println("******************************************\n"
				         + "Testare valori normale si limite pontaj\n"
				         + "******************************************\n");
		
		File f = new File(fileNamePontaj);
		if(!f.exists())
			throw new FileNotFoundException("Nu exista fisierul " + this.fileNamePontaj);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String linie = null;
		while((linie = br.readLine())!=null){
			if(linie.startsWith("#"))      continue;
			if(linie.startsWith("-"))      continue;
			if(linie.startsWith("setUp"))  continue;
			if(linie.isEmpty())            continue;			
			
			String[] valori = linie.split("\t");
			if(valori.length == 1)         continue;
			setUp(0);
			int pontaj = Integer.parseInt(valori[0]);
			int expected = Integer.parseInt(valori[1]);
						
			assertEquals("Testare valori normale pontajActivitate() ", expected, ang.ponteazaActivitate(pontaj));
			System.out.println("Testare "+linie);			
		}
		br.close();
	}
		
		
	//testare valori negative
	public void testePontajNegativ() throws IOException, ExceptieActivitatiNegative, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj, ExceptieFragmentareActivitate{
			
		System.out.println("******************************************\n"
		         + "Testare valori negative pontaj\n"
		         + "******************************************\n");
		
		File f = new File(fileNamePontaj);
		if(!f.exists())
			throw new FileNotFoundException("Nu exista fisierul " + this.fileNamePontaj);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String linie = null;
		while((linie = br.readLine())!=null){
			if(linie.startsWith("#"))      continue;
			if(linie.startsWith("setUp"))  continue;
			if(linie.isEmpty())            continue;
			if(linie.startsWith("1"))	   continue;				
			if(linie.startsWith("2"))      continue;
			if(linie.startsWith("5"))      continue;
				
			String[] valori = linie.split("\t");
			if(valori.length == 0)         continue;
			int pontaj = Integer.parseInt(valori[0]);				
							
			try{
				setUp(0);
				ang.ponteazaActivitate(Integer.parseInt(valori[0]));
				assertFalse("Metoda nu arunca exceptii pevalori negative.",true);
			}
			catch(ExceptiePontaj ex){
				assertTrue(true);
			}
			System.out.println("Testare "+linie);				
		}
		
		br.close();
	}
			
	
	//testare valori normale si limite
	public void testeAnulareActivitate() throws IOException, ExceptieActivitatiNegative, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj, ExceptieFragmentareActivitate, ExceptieConfuzieAnularePontaj{
			
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
		         + "Testare valori normale si limite anulare activitate\n"
		         + "+++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		File f = new File(fileNameAnulare);
		if(!f.exists())
			throw new FileNotFoundException("Nu exista fisierul " + this.fileNameAnulare);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String linie = null;
		while((linie = br.readLine())!=null){
			if(linie.startsWith("#"))      continue;				
			if(linie.startsWith("setUp"))  continue;
			if(linie.startsWith("-"))      continue;
			if(linie.isEmpty())            continue;
			String[] valori = linie.split("\t");		
				
			if(valori.length == 1)         continue;
			setUp(20);
			int pontaj = Integer.parseInt(valori[0]);
			int expected = Integer.parseInt(valori[1]);
				
			assertEquals("Test anuleazaActivitate()",expected, ang.anuleazaActivitate(pontaj));
			System.out.println("Testare "+linie);				
		}
	    br.close();
	   }	
	
	//testare valori negative 
		public void testeAnulareActivitateNegativa() throws IOException, ExceptieActivitatiNegative, ExceptieZeroActivitati, ExceptieLimitaSuperioaraPontaj, ExceptieFragmentareActivitate, ExceptieConfuzieAnularePontaj{
				
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
			         + "Testare valori negative anulare activitate\n"
			         + "+++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
			
			File f = new File(fileNameAnulare);
			if(!f.exists())
				throw new FileNotFoundException("Nu exista fisierul " + this.fileNameAnulare);
			BufferedReader br = new BufferedReader(new FileReader(f));
			String linie = null;
			while((linie = br.readLine())!=null){
				if(linie.startsWith("#"))      continue;				
				if(linie.startsWith("setUp"))  continue;				
				if(linie.isEmpty())            continue;
				if(linie.startsWith("1"))	   continue;				
				if(linie.startsWith("2"))      continue;
				if(linie.startsWith("5"))      continue;
				String[] valori = linie.split("\t");		
					
				if(valori.length == 0)         continue;
				setUp(20);
				
				try{
					ang.anuleazaActivitate(Integer.parseInt(valori[0]));
					assertFalse("Metoda nu arunca exceptii pevalori negative.",true);
				}
				catch(ExceptiePontaj ex){
					assertTrue(true);
				}
				System.out.println("Testare "+linie);				
			}
		    br.close();
		   }
}
	



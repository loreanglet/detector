package com.magneto.detector.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.magneto.detector.modelo.Humano;
import com.magneto.detector.repository.HumanoRepository;

class MutantTests {
	HumanoRepository humanoRepository = new HumanoRepository();


	@Test 
	public void cadenaMutante_Ejemplo_True() {
	    try {
		Humano humano = new Humano();
	    String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"}; 
	    humano.setDna(dna);
	    Assert.assertEquals(humanoRepository.IsMutant(humano, true, true), true);
	    }
	    catch (Exception e) {
	    	Assert.fail();
	    }
	}
	
	@Test 
	public void cadenaHumano_Valida_False() {
	    try {
		Humano humano = new Humano();
	    String[] dna = {"AAATTG","TTAAAG","GGGTTC","TTGGGC","AAATTG","TTAAAG"};
	    humano.setDna(dna);
	    Assert.assertEquals(humanoRepository.IsMutant(humano, true, true), false);
	    }
	    catch (Exception e) {
	    	Assert.fail();
	    }
	}
	
	@Test 
	public void cadenaMutante_Horizontal_True() {
	    try {
		Humano humano = new Humano();
	    String[] dna = {"AAAATG","TTAAAG","GGGTTC","TTGGGC","AAATTG","TTAAAG"};
	    humano.setDna(dna);
	    Assert.assertEquals(humanoRepository.IsMutant(humano, true, true), true);
	    }
	    catch (Exception e) {
	    	Assert.fail();
	    }
	}
	
	@Test 
	public void cadenaMutante_Vertical_True() {
	    try {
		Humano humano = new Humano();
	    String[] dna = {"AAATTG","ATAAAG","AGGTTC","ATGGGC","AAATTG","TTAAAG"};
	    humano.setDna(dna);
	    Assert.assertEquals(humanoRepository.IsMutant(humano, true, true), true);
	    }
	    catch (Exception e) {
	    	Assert.fail();
	    }
	}
	@Test 
	public void cadenaMutante_Diagonal_True() {
	    try {
		Humano humano = new Humano();
	    String[] dna = {"AAATTG","TTAAAG","GGGATC","TTGGAC","AAATTG","TTAAAG"};
	    humano.setDna(dna);
	    Assert.assertEquals(humanoRepository.IsMutant(humano, true, true), true);
	    }
	    catch (Exception e) {
	    	Assert.fail();
	    }
	}
	
	@Test 
	public void cadenaInvalida_CharsInvalidos_Fail() {
	    try {
		Humano humano = new Humano();
	    String[] dna = {"ATGCGZ","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	    humano.setDna(dna);
	    Assert.assertEquals(humanoRepository.IsMutant(humano, true, true), false);
	    }
	    catch (Exception e) {
	    	Assert.assertEquals(true,true);
	    }
	}
	
	@Test 
	public void cadenaInvalida_UnaConMenosChar_Fail() {
	    try {
		Humano humano = new Humano();
	    String[] dna = {"ATGCG","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	    humano.setDna(dna);
	    Assert.assertEquals(humanoRepository.IsMutant(humano, true, true), false);
	    }
	    catch (Exception e) {
	    	Assert.assertEquals(true,true);
	    }
	}
	
	
}

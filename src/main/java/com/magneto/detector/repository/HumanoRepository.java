package com.magneto.detector.repository;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.magneto.detector.modelo.Humano;
import com.magneto.detector.modelo.Stats;


public class HumanoRepository {
   List<Humano> humanosComunes;
   List<Humano> humanosMutantes;
   
   public HumanoRepository() {
	   humanosComunes = new ArrayList();
	   humanosMutantes = new ArrayList();
   }
   
   public void AddHumanoComun(Humano humano) {
	   if(!humanosComunes.contains(humano))
	   humanosComunes.add(humano);
   }
   
   public void AddHumanoMutante(Humano humano) {
	   if(!humanosMutantes.contains(humano))
	   humanosMutantes.add(humano);
   }
   
   public Stats  GetStats() {
	    double cantidadMutantes= humanosMutantes.size();
	    double cantidadComunes=  humanosComunes.size();
	    double ratio= cantidadMutantes / cantidadComunes;
	    Stats stats = new Stats(cantidadMutantes,cantidadComunes, ratio);
	    return stats;
	   
   }
   
   public boolean IsMutant(Humano humano,boolean soloCharsValidos,boolean soloCadenasConMismoLength) throws Exception {
    if(humano== null || humano.getDna() == null) throw new Exception("No se pudo parsear los datos del humano para detectarlo!");
    String[] dna = humano.getDna();
   	int cantidadChars = dna[0].length();
       if(soloCharsValidos || soloCadenasConMismoLength) {
       	for(String string : dna) {
       		if(soloCharsValidos) {
       		String aux = string.replace('A', ' ');
       		 aux = aux.replace('T', ' ');
       		 aux = aux.replace('C', ' ');
       		 aux = aux.replace('G', ' ');
       		 if(!aux.trim().isEmpty()) {throw new Exception("Se encontro almenos un caracter no valido! chars detectados: "+ aux);}
       		}
       		if(soloCadenasConMismoLength) {
       		  if(string.length() != cantidadChars) {throw new Exception("Se encontro almenos una cadena con distinta cantidad de chars! cadena: "+ string);}
       		}
       	}
       }
       
   	 for (int i=0;i<dna.length;i++) {
       	if(dna[i].contains("AAAA") || dna[i].contains("TTTT") || dna[i].contains("CCCC") || dna[i].contains("GGGG")) {
       	if(dna[i].contains("AAAA") || dna[i].contains("TTTT") || dna[i].contains("CCCC") || dna[i].contains("GGGG")) { 
       	    return true;
       	}
       	else {
       		for(int i2 = 0; i2 < cantidadChars;i2++) {
       			System.out.print(dna[i].charAt(i2));
				boolean okDown =true;
				boolean okCross =true;
    			if(i+3 >= dna.length ) okDown = false;
    			if(!okDown ||  i2+3 >= cantidadChars) okCross = false;
    			if(!okDown && !okCross)  return false;
    			
    			if((okDown) && (dna[i].charAt(i2) == dna[i+1].charAt(i2) && dna[i].charAt(i2)== dna[i+2].charAt(i2) 
        					&& dna[i].charAt(i2)== dna[i+3].charAt(i2))) {
        				return true;
        			}
    			if((okDown && okCross) &&(dna[i].charAt(i2) == dna[i+1].charAt(i2+1) && dna[i].charAt(i2)== dna[i+2].charAt(i2+2) 
    					&& dna[i].charAt(i2)== dna[i+3].charAt(i2+3))) {
    				return true;
    			}	
    		}
       			
       		}
       	}
       return false;
   }
   
}

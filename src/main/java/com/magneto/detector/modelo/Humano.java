package com.magneto.detector.modelo;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

public class Humano {
  String[] dna ;
  
  public String[] getDna() {
	  return dna;
  }
  public void setDna(String[] dna) {
	  this.dna = dna;
  }
  
  @JsonbCreator
  public Humano(@JsonbProperty("dna") String[] dna) {
       this.dna = dna;
  }
  
  public Humano() {
	// TODO Auto-generated constructor stub
  }
}

package com.usuario;

public class Curso{
  
  private String id;
  private String nombre;

  public Curso(){}

  public void setNombre(String n) {
     nombre=n;
  }
  public void setId(String d) {
     id=d;
  }
  public String getNombre() {
     return nombre;
  }
  public String getId() {
     return id;
  }
} 
package com.usuario;

public class User {
  
  private String nombre;
  private String passwd;
  
  public void setNombre(String n) {
     nombre=n;
  }
  public void setPasswd(String d) {
     passwd=d;
  }
  public String getNombre() {
     return nombre;
  }
  public String getPasswd() {
     return passwd;
  }
} 
package com.usuario;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.*;

@Entity
@SequenceGenerator(name="IdGen", initialValue=1, allocationSize=100)
public class EntidadAl implements Serializable{

  @Id @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  private String nombre;
  private String passwd;
  
  public EntidadAl() {
	 super();
  }

  public EntidadAl(String nombre, String passwd) {
    super();
    this.nombre = nombre;
    this.passwd = passwd;
  }
  
  public void setId(long num) {
     id=num;
  }
  public void setNombre(String n) {
     nombre=n;
  }
  public void setPasswd(String d) {
     passwd=d;
  }
  public long getId() {
     return id;
  }
  public String getNombre() {
     return nombre;
  }
  public String getPasswd() {
     return passwd;
  }
} 

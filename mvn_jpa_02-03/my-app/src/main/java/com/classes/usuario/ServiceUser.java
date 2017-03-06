package com.usuario;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.usuario.User;
import com.usuario.Usuario;

@ManagedBean(name="unuser")
@SessionScoped
public class ServiceUser {
  private User us;
  private Usuario retorno;

  public ServiceUser() {
    us=new User();
  }
  public User getUs() {
    return us;
  }
  public void setUs(User u) {
    us=u;
  }

  //insertamos un nuevo get y set para la ppdad de la entidad -que necesitaremos para poder mostrar listas de resultados.

  public Usuario getRetorno() {
    return retorno;
  }
  public void setRetorno(Usuario u) {
    retorno=u;
  }

  public String logout() {
    us=new User();
    return "login";
  }
  public String cancel() {
    return "login";
  }
  public String login() {
    //creamos el entity manager

    System.out.println(us.getNombre()+us.getPasswd()+"--\n\n\n\n\n\n");
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceOrigin");
    EntityManager em = emf.createEntityManager();
    TypedQuery <Usuario> consulta = em.createQuery("select u from Usuario u where u.nombre=:nombre and u.passwd=:passwd", Usuario.class);
    consulta.setParameter("nombre", us.getNombre());
    consulta.setParameter("passwd", us.getPasswd());
    //lista = consulta.getResultList();
    retorno = consulta.getSingleResult();
    System.out.println("User:"+retorno.getNombre());
    return "result";



    //no controla si hay 0 o +de1. Retocar.
  }

}

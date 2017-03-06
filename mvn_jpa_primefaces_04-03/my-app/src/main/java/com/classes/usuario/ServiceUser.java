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
import com.usuario.EntidadAl;

@ManagedBean(name="unuser")
@SessionScoped
public class ServiceUser {
  
  private User us;
  private EntidadAl retorno;
  private List <EntidadAl> lista;

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

  public EntidadAl getRetorno() {
    return retorno;
  }
  public void setRetorno(EntidadAl u) {
    retorno=u;
  }

  public List getLista() {
    return lista;
  }
  public void setLista(List l) {
    lista=l;
  }

  public String logout() {
    us=new User();
    return "login";
  }
  
  public String cancel() {
    return "login";
  }

  public String login() {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceOrigin");
    EntityManager em = emf.createEntityManager();
    TypedQuery <EntidadAl> consulta = em.createQuery("select u from EntidadAl u where u.nombre=:nombre and u.passwd=:passwd", EntidadAl.class);
    consulta.setParameter("nombre", us.getNombre());
    consulta.setParameter("passwd", us.getPasswd());
    lista = consulta.getResultList();
    return "result";
  }

  public String list()
  {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceOrigin");
    EntityManager em = emf.createEntityManager();
    TypedQuery <EntidadAl> consulta = em.createQuery("from EntidadAl", EntidadAl.class);
    lista = consulta.getResultList();
    return "result2"; 
  }
}

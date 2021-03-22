/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.entidades.Usuario2;
import com.tareas.excepciones.UsuarioNotFoundException;
import com.tareas.servicios.UsuarioServiceLocal;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author user
 */
@Named(value = "gestionUsuariosMB")
//@RequestScoped
@ViewScoped
public class GestionUsuariosManagedBean implements Serializable{

    //Lista todos los usuarios
    private Collection<Usuario2> coleccion;
    private Usuario2 usuarioEncontrado, usNuevo;
    private int idInsertado;
    
    private String emailABuscar;
    
    @EJB 
    private UsuarioServiceLocal usuarioService;
    
    public GestionUsuariosManagedBean() {
        this.usNuevo= new Usuario2();
    }
    
    @PostConstruct
    public void inicializar(){
        this.coleccion = usuarioService.getAllUsuarios();
    }

    public Collection<Usuario2> getColeccion() {
        return coleccion;
    }

    public Usuario2 getUsuarioEncontrado() {
        return usuarioEncontrado;
    }     
    
    public String buscarUsuarioPorEmailEntrada(String email){
        return buscaPorEmail(email);
    }    
    
    public String buscarUsuario(){
        return buscaPorEmail(this.emailABuscar);
    }
    
    private String buscaPorEmail(String email){
        
        try {
            this.usuarioEncontrado = usuarioService.getUsuarioByEmail(email);
             return "detalle-usuario";      
        } catch (UsuarioNotFoundException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(ex.getMessage()));
            return null;
        }
         
    }  
    
    public String eliminarPorId(){
        try {
            this.usuarioService.borrarPorId(this.idInsertado);
            return "lista-usuarios?faces-redirect=true";
        } catch (UsuarioNotFoundException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("No se pudo borrar. " + ex.getMessage()));   
            return null;
        }
    }
    
    public String getEmailABuscar() {
        return emailABuscar;
    }
    
    

    public void setEmailABuscar(String emailABuscar) {
        this.emailABuscar = emailABuscar;
    }
    
    public int getIdInsertado() {
        return idInsertado;
    }

    public void setIdInsertado(int idInsertado) {
        this.idInsertado = idInsertado;
    }
    
    private Usuario2 buscarUser(){
        for(Usuario2 user: coleccion){
            if(this.idInsertado == user.getIdUsuario()){
                this.usuarioEncontrado = user;
                break;
            }
        }
        return this.usuarioEncontrado;
    }

    public void setUsNuevo(Usuario2 usNuevo) {
        this.usNuevo = usNuevo;
    }

    public Usuario2 getUsNuevo() {
        return usNuevo;
    }
    
    public String modificarUser(){
        try {
            this.usNuevo = usuarioService.getUsuario(this.idInsertado);
            this.usuarioService.modificar(usNuevo);
            return "lista-usuarios?faces-redirect=true";
        } catch (UsuarioNotFoundException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("No se pudo borrar. " + ex.getMessage()));   
            return null;
        }        
    }
    
//    public String modificarUser(){
//        System.out.println("Ha modificar " + this.usuarioEncontrado.getNombre());
//        FacesContext fc = FacesContext.getCurrentInstance();
//    }
    
}

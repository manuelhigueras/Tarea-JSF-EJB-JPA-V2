
package com.tareas.web;

import com.tareas.entidades.Usuario;
import com.tareas.excepciones.UsuarioNotFoundException;
import com.tareas.excepciones.UsuarioUpdateException;
import com.tareas.servicios.UsuarioServiceLocal;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@Named(value = "gestionUsuariosMB")
@ViewScoped
public class GestionUsuariosManagedBean implements Serializable {

    private Collection<Usuario> coleccionUsuarios;
    private Usuario usuarioEncontrado;
    
    private String emailABuscar;
    
    
    @EJB private UsuarioServiceLocal usuarioService;
    
    public GestionUsuariosManagedBean() {
        System.out.println(".... instanciando GsetionUsuarioNB");
    }
    
    @PostConstruct
    public void inicializar(){
        this.coleccionUsuarios =   usuarioService.getAllUsuarios();
    }

    public Collection<Usuario> getColeccionUsuarios() {
        return coleccionUsuarios;
    }

    public Usuario getUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    public String getEmailABuscar() {
        return emailABuscar;
    }

    public void setEmailABuscar(String emailABuscar) {
        this.emailABuscar = emailABuscar;
    }

    //acciones
    public String buscarUsuario(String email){
        System.out.println("... buscar " + email);
       return buscarPorMail(email);
    }
    
    public String buscarUsuarioPorEmailEntrada(){
        return buscarPorMail(this.emailABuscar);
    }

    private String buscarPorMail(String email){
        try {
            this.usuarioEncontrado = usuarioService.getUsuarioByEmail(email);
            return null;
        } catch (UsuarioNotFoundException ex) {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(ex.getMessage()));
            return null; // me quedo en la misma página 
        }
    }
    
    public String borrar(int idUsuarioABorrar){        
        try {
            this.usuarioService.borrar(idUsuarioABorrar);
             this.coleccionUsuarios =   usuarioService.getAllUsuarios();
        } catch (UsuarioNotFoundException ex) {            
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage("No se pudo borrar. " + ex.getMessage())); 
        }
        return null;
        
    }
    
    public String modificar(){
        System.out.println(" ha modificar " + this.usuarioEncontrado.getNombre());
        FacesContext fc = FacesContext.getCurrentInstance();
        try {           
            this.usuarioService.modificar(usuarioEncontrado);
            this.inicializar();
            return null;
        } catch (UsuarioNotFoundException | UsuarioUpdateException ex) {
             fc.addMessage(null, new FacesMessage("No se pudo modificar. " + ex.getMessage()));        
        }catch(Exception e){
              fc.addMessage(null, new FacesMessage("Error no controlado. " + e.getMessage())); 
              e.printStackTrace();
        }
        return null;
    }
    
}


package com.tareas.web;

import com.tareas.entidades.Usuario;
import com.tareas.excepciones.UsuarioNotFoundException;
import com.tareas.servicios.UsuarioServiceLocal;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;



@Named(value = "gestionUsuariosMB")
@RequestScoped
public class GestionUsuariosManagedBean {

    private Collection<Usuario> coleccionUsuarios;
    private Usuario usuarioEncontrado;
    
    private String emailABuscar;
    
    
    @EJB private UsuarioServiceLocal usuarioService;
    
    public GestionUsuariosManagedBean() {
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
       return buscarPorMail(email);
    }
    
    public String buscarUsuarioPorEmailEntrada(){
        return buscarPorMail(this.emailABuscar);
    }

    private String buscarPorMail(String email){
        try {
            this.usuarioEncontrado = usuarioService.getUsuarioByEmail(email);
            return "detalle-usuario";
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
    
}

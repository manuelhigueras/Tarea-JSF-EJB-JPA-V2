
package com.tareas.web;

import com.tareas.entidades.Usuario2;
import com.tareas.excepciones.UsuarioNotFoundException;
import com.tareas.servicios.UsuarioServiceLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "pruebasMB")
@RequestScoped
public class PruebasManagedBean {

    @EJB
    private UsuarioServiceLocal usuarioService;
    private Usuario2 usuarioEncontrado;
            
    public PruebasManagedBean() {
    }

    public Usuario2 getUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    public void setUsuarioEncontrado(Usuario2 usuarioEncontrado) {
        this.usuarioEncontrado = usuarioEncontrado;
    }
        
    //action 
    public void mostarUsuario(int i) throws UsuarioNotFoundException{
        this.usuarioEncontrado = usuarioService.getUsuario(i);
    }
    
   
    
}

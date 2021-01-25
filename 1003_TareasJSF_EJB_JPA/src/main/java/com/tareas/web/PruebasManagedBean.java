
package com.tareas.web;

import com.tareas.entidades.Usuario;
import com.tareas.servicios.UsuarioServiceLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "pruebasMB")
@RequestScoped
public class PruebasManagedBean {

    @EJB
    private UsuarioServiceLocal usuarioService;
    private Usuario usuarioEncontrado;
            
    public PruebasManagedBean() {
    }

    public Usuario getUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    public void setUsuarioEncontrado(Usuario usuarioEncontrado) {
        this.usuarioEncontrado = usuarioEncontrado;
    }
    
    
    //action 
    public void mostarUsuario(int i){
        this.usuarioEncontrado = usuarioService.getUsuario(i);
    }
    
}


package com.tareas.web.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;


@Named(value = "loginMB")
@SessionScoped
public class LoginManagedBean implements Serializable {

    private String usuario = null;
    
    public LoginManagedBean() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
}

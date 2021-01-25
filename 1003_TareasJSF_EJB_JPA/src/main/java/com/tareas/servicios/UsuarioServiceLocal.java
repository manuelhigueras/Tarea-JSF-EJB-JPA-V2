
package com.tareas.servicios;

import com.tareas.entidades.Usuario;
import javax.ejb.Local;

@Local
public interface UsuarioServiceLocal {
    
    public  Usuario getUsuario(int id);
    public void alta(Usuario usrNuevo);
            
}

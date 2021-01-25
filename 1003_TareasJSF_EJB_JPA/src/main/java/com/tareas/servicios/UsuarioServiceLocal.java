
package com.tareas.servicios;

import com.tareas.entidades.Usuario;
import com.tareas.excepciones.UsuarioNotFoundException;
import com.tareas.excepciones.UsuarioUpdateException;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface UsuarioServiceLocal {
    
    public  Usuario getUsuario(int id)  throws UsuarioNotFoundException;
    public void alta(Usuario usrNuevo);
    public Collection<Usuario> getAllUsuarios();
    public Usuario getUsuarioByEmail(String email) throws UsuarioNotFoundException;
    public void borrar(int id) throws UsuarioNotFoundException;
    
   public void modificar(Usuario usr) throws UsuarioNotFoundException, UsuarioUpdateException;
    
          
}

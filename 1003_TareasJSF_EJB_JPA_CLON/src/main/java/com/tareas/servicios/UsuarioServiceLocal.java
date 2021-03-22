
package com.tareas.servicios;

import com.tareas.entidades.Usuario2;
import com.tareas.excepciones.UsuarioNotFoundException;
import java.util.Collection;
import javax.ejb.Local;

@Local
public interface UsuarioServiceLocal {
    
    public Usuario2 getUsuario(int id) throws UsuarioNotFoundException;
    public void alta(Usuario2 usrNuevo);
    public Collection<Usuario2> getAllUsuarios();
    public Usuario2 getUsuarioByEmail(String email) throws UsuarioNotFoundException;
    public void borrarPorId(int id) throws UsuarioNotFoundException;
    public void modificar(Usuario2 user) throws UsuarioNotFoundException;
            
}

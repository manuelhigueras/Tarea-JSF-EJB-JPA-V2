/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.entidades.Usuario2;
import com.tareas.entidades2.Tareas;
import com.tareas.excepciones.TareasNotFoundException;
import com.tareas.excepciones.UsuarioNotFoundException;
import java.util.Collection;

public interface TareasServiceLocal {
    public Collection<Tareas> getTareas(Integer idUsuario, String estado);
    public void modificarTareas() throws TareasNotFoundException;
}


package com.tareas.servicios;

import com.tareas.dominio.Estados;
import com.tareas.dominio.Tarea;
import com.tareas.dominio.TareaJPA;
import com.tareas.excepciones.EstadoTareaException;
import com.tareas.excepciones.TareaException;
import java.sql.SQLException;
import java.util.List;


public interface TareasServiceInterface {
    public List<Tarea> getListaTareasPorEstado(Estados Estado)  throws SQLException, EstadoTareaException;
    public void modificarEstadoTarea(int idTarea, Estados estado) throws SQLException, EstadoTareaException;
    public void altaTarea(String descripcion) throws SQLException, TareaException;

    public TareaJPA getTareaJPA(Integer id);
}


package com.db;

import com.tareas.dominio.Estados;
import com.tareas.dominio.Tarea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DB {
    
    private static Map<Estados,List<Tarea>> mapTareas;
    
    static{
        mapTareas = new HashMap<Estados,List<Tarea>>();
        
        List<Tarea> toDo = new ArrayList<Tarea>();
        toDo.add(new Tarea(1, "Crear DB", Estados.TODO.name()));
        toDo.add(new Tarea(2, "Diseñar cabecera", Estados.TODO.name()));
        toDo.add(new Tarea(3, "Refactorizar Service", Estados.TODO.name()));
        
        mapTareas.put(Estados.TODO, toDo);  
    }

    public static List<Tarea> getTareasPorEstado(Estados estado) {
        return mapTareas.get(estado);
    }
    
    
    
    
}

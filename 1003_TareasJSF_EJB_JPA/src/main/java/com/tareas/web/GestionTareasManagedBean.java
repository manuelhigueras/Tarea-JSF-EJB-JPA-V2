
package com.tareas.web;

import com.tareas.entidades.Tarea;
import com.tareas.servicios.TareasServiceLocal;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "gestionTareasMB")
@RequestScoped
public class GestionTareasManagedBean {
    
    private Collection<Tarea> coleccionTareasTODO;
    
    @EJB
    private TareasServiceLocal tareasService;


    public GestionTareasManagedBean() {
        System.out.println(".... constuctor GestionTareasManagedBean");
    }
    
    @PostConstruct
    public void iniciar(){
        System.out.println(".... inicar tablas GestionTareasManagedBean");
        this.coleccionTareasTODO = this.tareasService.getTareas(1, "TO DO");
    }

    public Collection<Tarea> getColeccionTareasTODO() {
        return coleccionTareasTODO;
    }
  
}

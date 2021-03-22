/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web;

import com.tareas.entidades2.Tareas;
import com.tareas.servicios.TareasServiceLocal;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value = "GTMB")
@RequestScoped
public class GestionTareasManagedBean {

    private Collection<Tareas> coleccionTareaToDo;
    private Tareas nuevaTarea;
    
    @EJB
    private TareasServiceLocal tareasService;
    
    @PostConstruct
    public void iniciar(){
        this.coleccionTareaToDo = this.tareasService.getTareas(1, "TO DO");
        this.nuevaTarea = new Tareas();
    }
    
    public GestionTareasManagedBean() {
    }

    public Collection<Tareas> getColeccionTareaToDo() {
        return coleccionTareaToDo;
    }

    public Tareas getNuevaTarea() {
        return nuevaTarea;
    }

    public void setNuevaTarea(Tareas nuevaTarea) {
        this.nuevaTarea = nuevaTarea;
    }
    
    
    
}

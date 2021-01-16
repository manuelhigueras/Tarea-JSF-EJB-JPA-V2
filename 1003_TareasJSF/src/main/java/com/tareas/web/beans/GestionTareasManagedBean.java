/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.web.beans;

import com.sun.faces.util.MessageFactory;
import com.tareas.dominio.Estados;
import com.tareas.dominio.Tarea;
import com.tareas.excepciones.EstadoTareaException;
import com.tareas.servicios.TareasService;
import com.tareas.servicios.TareasServiceInterface;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author begonaolea
 */
@Named(value = "gestionTareasMB")
@RequestScoped
public class GestionTareasManagedBean {

    private static Logger log = Logger.getLogger("GestionTareasManagedBean");
   
    private Collection<Tarea> coleccionTareas;
    private Tarea tareaSel;
   
    private TareasServiceInterface  tareasService = new TareasService(); 
            
    public GestionTareasManagedBean() {
       refrescarListasTareas();
    }
    
    private void refrescarListasTareas(){
         try {
            this.coleccionTareas =
                    tareasService.getListaTareasPorEstado(Estados.TODO);
        } catch (SQLException | EstadoTareaException ex) {
            log.severe("Error refrescar lista tareas" + ex.getMessage());
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, MessageFactory.getMessage("tareas_listar_error", Estados.TODO.getValor()));
            this.coleccionTareas = new ArrayList();
        }
    }

    public Collection<Tarea> getColeccionTareas() {
        return coleccionTareas;
    }

    public void setTareaSel(Tarea tareaSel) {
        this.tareaSel = tareaSel;
    }

    public Tarea getTareaSel() {
        return tareaSel;
    }
  
    public void verTareaSel(){
        System.out.println("... seleccionó " + this.tareaSel);
    }
    
}

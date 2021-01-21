
package com.tareas.web.beans;

import com.sun.faces.util.MessageFactory;
import com.tareas.dominio.Estados;
import com.tareas.dominio.Tarea;
import com.tareas.dominio.TareaJPA;
import com.tareas.excepciones.EstadoTareaException;
import com.tareas.servicios.CalculadoraSessionBeanLocal;
import com.tareas.servicios.TareasServiceInterface;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
   
    @EJB 
    private TareasServiceInterface  tareasService;// = new TareasService(); 
         
    @EJB
    private CalculadoraSessionBeanLocal calculadoraService;
    
    
    public GestionTareasManagedBean() {}
    
    @PostConstruct
    public void iniciarlicarMB(){
        System.out.println(".... suma 3 + 9 " 
                + calculadoraService.suma(3, 9));
        
        System.out.println("... busco Tarea con id 1 ");
        TareaJPA t = tareasService.getTareaJPA(1);
        System.out.println(".... Tarea es " + t.getDescripcion());
        
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

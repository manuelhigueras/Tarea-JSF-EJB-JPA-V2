package com.tareas.servicios;

import com.db.DB;

import com.tareas.dominio.Estados;
import com.tareas.dominio.Tarea;
import com.tareas.dominio.TareaJPA;
import com.tareas.excepciones.EstadoTareaException;
import com.tareas.excepciones.TareaException;
import java.sql.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
// EJB DE SESION SIN ESTADO
@Stateless
public class TareasService implements TareasServiceInterface {

    //inyecta un nuevo EntityManager que se contruye a partir
    // de los datos del persistence.xml
    @PersistenceContext(unitName = "tareasPU")
    private EntityManager em; 
    
    public TareasService() {
        System.out.println(".... constructor TareasService");
    }
    
    @PostConstruct
    public void inicar(){
        System.out.println(".... en el postconstruct");
    }
    
    
    @Override
    public List<Tarea> getListaTareasPorEstado(Estados estado) 
            throws SQLException, EstadoTareaException {     
        // validar parametors
        if(estado == null){
            throw new EstadoTareaException("Debe indicar un estado válido.");
        }
        return DB.getTareasPorEstado(estado);
    }

    @Override
    public void modificarEstadoTarea(int idTarea, Estados estado) 
           throws SQLException, EstadoTareaException {
        // validar parametors
        if(estado == null){
            throw new EstadoTareaException("Debe indicar un estado válido.");
        }
       
       
    }
    
     @Override
    public void altaTarea(String descripcion) throws SQLException, TareaException {
        //validar parámetros
        if(descripcion == null || descripcion.trim().length() == 0){
            throw new TareaException("No se puede dar de alta la tarea. Debe indicar una descripción.");
        }
        
       
        
    }


    //no lo he necesitado
    private Estados convertirStringToEstados(String estado) {
        if (estado == null) {
            return null;
        }
        Estados e = null;
        switch (estado) {
            case "TO DO":
                e = Estados.TODO;
                break;
            case "IN PROGRESS":
                e = Estados.INPROGRESS;
                break;
            case "DONE":
                e = Estados.DONE;
                break;
        }
        return e;
    }

    @Override
    public TareaJPA getTareaJPA(Integer id) {
        //select * from tareas where idTarea = id
        TareaJPA t = new TareaJPA(1, "adfasf", Estados.DONE.getValor(), Boolean.TRUE) ;
        //em.find(TareaJPA.class, id);// 
        
        return t;
    }

   
    
   
}

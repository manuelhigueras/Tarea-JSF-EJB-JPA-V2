/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tareas.servicios;

import com.tareas.entidades.Usuario2;
import com.tareas.excepciones.TareasNotFoundException;
import com.tareas.entidades2.Tareas;
import com.tareas.excepciones.UsuarioNotFoundException;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class TareasService implements TareasServiceLocal {
    @PersistenceContext(unitName = "TareasPU")
    private EntityManager em;
    
    
    @Override
    public Collection<Tareas> getTareas(Integer idUsuario, String estado){
        Query query = em.createNamedQuery("Tareas.findbyEstadoAndUserId");
        query.setParameter("estado", estado);
        query.setParameter("idUsuario", idUsuario);
        return query.getResultList();
    }

//    public int getFindId(){
//        Query query = em.createNamedQuery("Tareas.findByIdTarea");
//        query.setParameter("estado", estado);
//        query.setParameter("idUsuario", idUsuario);    
//        return query.getResultList();
//    }
    
    @Override
    public void modificarTareas() throws TareasNotFoundException {
        //usr.getIdUsuario()
//        Tareas usrBd = this.getTareas();
        //Los metodos de un EJB hacen comit al final si no hay excepciones
        //Commit -> se sincroniza los objetos  de em con las tablas de la bd
//        em.merge(usrBd);        
    }
    
}

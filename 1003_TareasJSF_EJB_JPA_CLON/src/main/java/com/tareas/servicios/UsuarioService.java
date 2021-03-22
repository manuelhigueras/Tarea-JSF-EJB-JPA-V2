package com.tareas.servicios;

import com.tareas.entidades.Usuario2;
import com.tareas.excepciones.UsuarioNotFoundException;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuarioService implements UsuarioServiceLocal {

    @PersistenceContext(unitName = "TareasPU")
    private EntityManager em; 

    @Override
    public Usuario2 getUsuario(int id) throws UsuarioNotFoundException{
        Usuario2 u = em.find(Usuario2.class, id);
        if(u == null)
            throw new UsuarioNotFoundException("No existe el usuario solicitado");
        return u;
    }

    @Override
    public void alta(Usuario2 usr) {
       em.persist(usr);
    }

    @Override
    public Collection<Usuario2> getAllUsuarios() {
        //RECORDATORIO JPA QUERY SQL + JAVA
//        String consulta = "SELECT u FROM Usuario2 u";
        //sintaxis SQL
//        String consulta = "SELECT * FROM Usuario2 u";
//        Query query = em.createNativeQuery(consulta);
//        Query query = em.createQuery(consulta);
        //CREATE NAME QUERY
        Query query = em.createNamedQuery("Usuario.findAll");
       return query.getResultList();
    }

    @Override
    public Usuario2 getUsuarioByEmail(String email) throws UsuarioNotFoundException{
        Query query = em.createNamedQuery("Usuario.findByEmail");
        query.setParameter("email", email);
        try{
            Usuario2 usr = (Usuario2) query.getSingleResult();
            return usr;
        }
        catch(javax.persistence.NoResultException ex){
           throw new UsuarioNotFoundException("no existe un usuario con el email " + email); 
        }
    }

    @Override
    public void borrarPorId(int id) throws UsuarioNotFoundException {
        Usuario2 u = this.getUsuario(id);
        em.remove(u);
    }

    @Override
    public void modificar(Usuario2 usr) throws UsuarioNotFoundException{
        Usuario2 usrBd = this.getUsuario(usr.getIdUsuario());
        //Los metodos de un EJB hacen comit al final si no hay excepciones
        //Commit -> se sincroniza los objetos  de em con las tablas de la bd
        em.merge(usrBd);
    }
    
    
    
}

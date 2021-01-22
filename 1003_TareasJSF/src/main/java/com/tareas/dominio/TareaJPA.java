
package com.tareas.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "TAREAS")
//@NamedQueries({
//    @NamedQuery(name = "TareaJPA.findAll", query = "SELECT t FROM TareaJPA t"),
//    @NamedQuery(name = "TareaJPA.findByIdTarea", query = "SELECT t FROM TareaJPA t WHERE t.idTarea = :idTarea"),
//    @NamedQuery(name = "TareaJPA.findByDescripcion", query = "SELECT t FROM TareaJPA t WHERE t.descripcion = :descripcion"),
//    @NamedQuery(name = "TareaJPA.findByEstado", query = "SELECT t FROM TareaJPA t WHERE t.estado = :estado"),
//    @NamedQuery(name = "TareaJPA.findByArchivado", query = "SELECT t FROM TareaJPA t WHERE t.archivado = :archivado")})
public class TareaJPA implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TAREA")
    private Integer idTarea;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ESTADO")
    private String estado;

   // @Column(name = "ARCHIVADO")
    @Transient // no va a la tabla es solo para el codigo
    private Boolean archivado;

    public TareaJPA() {
    }

    public TareaJPA(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public TareaJPA(Integer idTarea, String descripcion, String estado, Boolean archivado) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.estado = estado;
        this.archivado = archivado;
    }

    public Integer getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Integer idTarea) {
        this.idTarea = idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getArchivado() {
        return archivado;
    }

    public void setArchivado(Boolean archivado) {
        this.archivado = archivado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTarea != null ? idTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TareaJPA)) {
            return false;
        }
        TareaJPA other = (TareaJPA) object;
        if ((this.idTarea == null && other.idTarea != null) || (this.idTarea != null && !this.idTarea.equals(other.idTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tareas.dominio.TareaJPA[ idTarea=" + idTarea + " ]";
    }
    
}

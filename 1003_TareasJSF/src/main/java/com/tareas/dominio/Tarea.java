package com.tareas.dominio;

import java.io.Serializable;

public class Tarea implements Serializable{
    
    private int idTarea;
    private String descripcion;
    private String estado;

    public Tarea(int idTarea, String descripcion, String estado) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
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

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idTarea;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tarea other = (Tarea) obj;
        if (this.idTarea != other.idTarea) {
            return false;
        }
        return true;
    }
      
    
}

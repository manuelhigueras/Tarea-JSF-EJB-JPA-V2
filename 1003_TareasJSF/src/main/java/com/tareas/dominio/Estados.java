package com.tareas.dominio;

public enum Estados {
    
    TODO("TO DO"), INPROGRESS("IN PROGRESS"), DONE("DONE");
    
    private String valor;

    private Estados(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    } 
    
}

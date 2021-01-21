
package com.tareas.servicios;

import javax.ejb.Stateless;

@Stateless
public class CalculadoraSessionBean implements CalculadoraSessionBeanLocal {

    
    
    @Override
    public int suma(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int resta(int num1, int num2) {
        return num1 - num2;
    }

    
}


package com.tareas.servicios;

import javax.ejb.Local;

@Local
public interface CalculadoraSessionBeanLocal {
    
    public int suma(int num1, int num2);
    public int resta(int num1, int num2);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;
import Tarea.Enumerados.TipoCombustible;

/**
 *
 * @author juanantonio
 * @version 1.0
 */
public abstract class Turismo extends Vehiculo{
    
    protected TipoCombustible combustible;
    protected int numeroPuertas;

    /**
     * 
     * @param combustible introduce por parametro el tipo de combustible
     * @param numeroPuertas introduce por parametro el numero de puertas
     * @param matricula introduce la matricula por parametro
     * @param marca introduce la marca por parametro
     * @param modelo introduce el modelo por parametro
     * @param cilindrada introduce la cilindrada por parametro
     */
    public Turismo(TipoCombustible combustible, int numeroPuertas, String matricula, String marca, String modelo, int cilindrada) {
        super(matricula, marca, modelo, cilindrada);
        this.combustible = combustible;
        this.numeroPuertas = numeroPuertas;
    }

    /**
     * 
     * @return un supertoString que muestra todos los valores del constructor
     */
    @Override
    public String toString() {
        String mensaje = super.toString();
        return mensaje;
    }
    
    
    
    
    
    
}

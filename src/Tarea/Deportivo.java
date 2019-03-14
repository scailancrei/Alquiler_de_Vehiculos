/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;
import Tarea.Enumerados.CajaCambios;
import Tarea.Enumerados.TipoCombustible;
/**
 *
 * @author juanantonio
 * @version 1.0
 */
public final class Deportivo extends Turismo{
    
    private boolean descapotable;
    private CajaCambios cambio;

    /**
     * 
     * @param cambio introduce por parametro el tipo de cambio del Deportivo
     * @param descapotable introduce por parametro si lleva o no descapotable
     * @param combustible introduce por parametro el tipo de combustible del deportivo
     * @param numeroPuertas introduce por parametro el numero de puertas del deportivo
     * @param matricula introduce por parametro la matricula del deportivo
     * @param marca introduce por parametro la marca del deportivo
     * @param modelo introduce por parametro el modelo del deportivo
     * @param cilindrada  introduce por parametro el numero de la cilindrada
     */
    public Deportivo(CajaCambios cambio, boolean descapotable, TipoCombustible combustible, int numeroPuertas, String matricula, String marca, String modelo, int cilindrada) {
        super(combustible, numeroPuertas, matricula, marca, modelo, cilindrada);
        this.cambio = cambio;
        this.descapotable = descapotable;
    }

    /**
     * 
     * @return devuelve si es descapotable o no
     */
    public boolean getDescapotable() {
        
        return descapotable;
    }

    /**
     * 
     * @return devuelve el tipo cambio
     */
    public CajaCambios getCambio() {
        return cambio;
    }

    /**
     * 
     * @return devuelve el tipo de combustible
     */
    public TipoCombustible getCombustible() {
        return combustible;
    }

    /**
     * 
     * @return devuelve el numero de puertas
     */
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    /**
     * 
     * @return Devuelve un super ToString que muestra los datos de la clase padre e hija
     */
    @Override
    public String toString() {
        String mensaje = super.toString();
        return mensaje + "\n El tipo combustible es: "+ combustible + "\n El tipo de caja de cambios es: "+cambio + "\n Descapotable: "+descapotable;
    }
    
    
    
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

import Tarea.Enumerados.Tamanio;

/**
 *
 * @author juanantonio
 * @version 1.0
 */
public class Furgoneta extends Mercancias {

    private boolean refrigerado;
    private Tamanio tamanio;

    /**
     * 
     * @param refrigerado tipo booleano que se introduce por parametro el true o false
     * @param tamanio tipo enumerado que introduce por parametro el tamaño de la furgoneta dando a elegir 3 opciones
     * @param pma introduce por parametro el valor de pma (Peso Maximo Autorizado)
     * @param volumen introduce por parametro el volumen de la furgoneta
     * @param matricula introduce por parametro la matricula de la furgoneta
     * @param marca introduce por parametro la marca de la furgoneta
     * @param modelo introduce por parametro el modelo de la furgoneta
     * @param cilindrada introduce por parametro el valor de la cilindrada
     */
    public Furgoneta(boolean refrigerado, Tamanio tamanio, int pma, int volumen, String matricula, String marca, String modelo, int cilindrada) {
        super(pma, volumen, matricula, marca, modelo, cilindrada);
        this.refrigerado = refrigerado;
        this.tamanio = tamanio;
    }

    /**
     * 
     * @return devuelve el valor de refrigerado: true o false
     */
    public boolean getRefrigerado() {
        return refrigerado;
    }

    /**
     * 
     * @return Devuelve el tamaño de la furgoneta
     */
    public Tamanio getTamanio() {
        return tamanio;
    }
    
    
    /**
     * 
     * @return devuelve el superToString de la clase furgoneta que contiene ademas los atributos de la clase abstracta mercancias
     */
    @Override
    public String toString(){
        return super.toString() + "\n El tamaño es: "+ tamanio +"\n Refrigerado: "+refrigerado;
    }
    
    
}

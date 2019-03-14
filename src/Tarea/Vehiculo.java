/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

/**
 *
 * @author juanantonio
 * @version 1.0
 */
public abstract class  Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private int cilindrada;
    private boolean disponible = true;

    /**
     * 
     * @param matricula introduce la matricula de un vehiculo
     * @param marca introduce la marca de un vehiculo
     * @param modelo introduce el modelo de un vehiculo
     * @param cilindrada  introduce la cilindrada de un vehiculo
     */
    public Vehiculo(String matricula, String marca, String modelo, int cilindrada) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;

    }

    Vehiculo(Vehiculo vehiculo) {
        
    }

    /**
     * 
     * @param disponible modifica true o false por parametro
     */
    public void  setDisponible (Boolean disponible){
        
    }

    /**
     * 
     * @return true o false
     */
    public boolean isDisponible() {
        return disponible;
    }
    
    /**
     * 
     * @return devuelve la matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * 
     * @return devuelve la marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }

    
    /**
     * 
     * @return devuelve el modelo del vehiculo 
     */
    public String getModelo() {
        return modelo;
    }

    
    /**
     * 
     * @return devuelve la cilindrada del vehiculo
     */
    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public String toString() {
        return " " + "\n matricula: " + matricula + "\n marca: " + marca + "\n modelo: " + modelo + "\n cilindrada: " + cilindrada;
    }

  
    
    
    
    
    
    
    
}

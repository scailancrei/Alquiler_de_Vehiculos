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
public abstract class Mercancias extends  Vehiculo{
    
    private int pma;
    private int volumen;

    /**
     * 
     * @param pma Este parametro introduce el valor del (PESO MAXIMO AUTORIZADO)
     * @param volumen Este parametro introduce el valor del volumen
     * @param matricula Este parametro introduce la matricula del vehiculo
     * @param marca Este parametro introduce la marca
     * @param modelo Este parametro introduce el modelo
     * @param cilindrada  Este parametro introduce la cilindrada
     */
    public Mercancias(int pma, int volumen, String matricula, String marca, String modelo, int cilindrada) {
        super(matricula, marca, modelo, cilindrada);
        this.pma = pma;
        this.volumen = volumen;
    }

    /**
     * 
     * @return Devuelve el valor del PMA
     */
    public int getPma() {
        return pma;
    }

    /**
     * 
     * @return Devuelve el Volumen
     */
    public int getVolumen() {
        return volumen;
    }

    /**
     * 
     * @return Devuelve un super toString
     */
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}

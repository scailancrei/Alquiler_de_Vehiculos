/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

/**
 *
 * @author juanantoio
 * @version 1.0
 */
public class Cliente {
    

    
    private String dni;
    private String nombre;
    private String direccion;
    private String localidad;
    private String codigoPostal;

    /**
     *
     * @param dni Almacena el dni del cliente
     * @param nombre Almacena el nombre del cliente
     * @param direccion Almacena la direccion del cliente
     * @param localidad Almacena la localidad del cliente
     * @param codigoPostal Almacena el codigoPostal del cliente
     */
    public Cliente(String dni, String nombre, String direccion, String localidad, String codigoPostal) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.codigoPostal = codigoPostal;
    }

    /**
     * 
     * @param cliente crea un metodo al que se le pase por parametro un objeto cliente
     */
    public Cliente(Cliente cliente) {

    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getLocalidad() {

        return localidad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    @Override
    public String toString() {
        return " " + "\n dni: " + dni + "\n nombre: " + nombre + "\n direccion: " + direccion + "\n localidad: " + localidad + "\n codigoPostal: " + codigoPostal + "\n";
    }

}

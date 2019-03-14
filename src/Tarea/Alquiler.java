/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import sun.util.calendar.CalendarDate;

/**
 *
 * @author JuanAntonio
 * @version 1.0
 */
public class Alquiler {

    private final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("'Hoy es dia' dd 'del mes ' MM ' del año ' yyyy");
    private final double PRECIO_DIA = 50;
    private final int MILISEGUNDOS_DIA = 86400000;
    private  Date fecha = new Date();
    private  int dias = 0;

    
    Vehiculo turismo = new Vehiculo("", "", "", 0) {};
    Cliente cliente = new Cliente("", "", "", "", "");
    /**
     * 
     * @param C introduce por parametro un parametro de tipo objeto de tipo cliente
     * @param V introduce por parametro un parametro de tipo objeto de tipo vehiculo
     */
    public Alquiler(Cliente C, Vehiculo V) {
        this.cliente = C;
        this.turismo = V;
        Date fecha;

    }

    /**
     * 
     * @return Devuelve un cliente 
     */
    public Cliente getCliente() {

        return cliente;
    }

    
    /**
     * 
     * @return me devuelve un objeto de tipo vehiculo
     */
    public Vehiculo getVehiculo() {
        return turismo;
    }
    
    /**
     * 
     * @return  me devuelve una fecha
     */

    public Date getFecha() {
        
        
        return fecha;
    }

    /**
     * 
     * @return me devuelve los dias de diferencia entre 2 fechas 
     */
    public int getDias() {
        getFecha().getTime();
        
        dias = (int) ((int) getFecha().getTime() - getFecha().getTime());
        return dias;
    }

    
    /**
     * El precio total se hace Multiplicando el Precio del dia por el numero de dias restantes + la cilindrada del turismo y divido entre 100
     * @return devuelve el precioTotal de un alquiler
     */
    public double precioAlquiler() {
        double precioTotal;

        precioTotal = PRECIO_DIA * dias + turismo.getCilindrada() / 100;

        return precioTotal;
    }

    /**
     * 
     * @param fecha introduce por parametro una fecha
     * @return devuelve la diferencia de dias de una fecha
     */
    private int diferenciaDias(Date fecha) {
        getDias();
                
        
        return dias;
    }

    /**
     * Cierra el alquiler dependiendo el numero de dias
     */
    public void cerrar() {
        diferenciaDias(fecha);

    }

    @Override
    public String toString() {
        return "Alquiler{" + "FORMATO_FECHA=" + FORMATO_FECHA + ", PRECIO_DIA=" + PRECIO_DIA + ", MILISEGUNDOS_DIA=" + MILISEGUNDOS_DIA + ", fecha=" + fecha + ", dias=" + dias + '}';
    }

}

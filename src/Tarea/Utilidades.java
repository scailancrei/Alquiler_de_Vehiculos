/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

import java.util.regex.*;

/**
 *
 * @author JuanAntonio
 * @version 1.0
 */
public class Utilidades {

    public Utilidades() {
    }

    /**
     * 
     * @param comprobacionMatricula introduce la matricula por parametro y la comprueba en este metodo
     * @return me devuelve la matricula si la comprobacion coincide con la expresion regular
     */
    public boolean comprobarMatricula(String comprobacionMatricula) {
        String comprobar = "[0-9]{4}[^aeiou,AEIOU]{3}";
        Pattern patron = Pattern.compile(comprobar);
        Matcher compararPatron = patron.matcher(comprobacionMatricula);

        return compararPatron.matches();
    }
    
    
    /**
     * 
     * @param comprobarCodPostal introduce el codigo postal por parametro y lo comprueba en este metodo
     * @return devuelve el codigo postal si la comprobacion coincide con la expresion regular
     */
    public boolean comprobarCodigoPostal(String comprobarCodPostal){
        
        Pattern comprobar = Pattern.compile("[01-53]{2}[0-9]{3}");
        Matcher validar = comprobar.matcher(comprobarCodPostal);
        
        if (validar.matches()) {
         
            return validar.matches();
        } else{
        
        return false;
        }
    }

    
    /**
     * 
     * @param comprobarTelefono introduce el numero de telefono por parametro y lo comprueba en este metodo
     * @return me devuelve el numero de telefono si la comprobacion coincide con la expresion regular
     */
    public boolean comprobarTelefonoEsp(String comprobarTelefono) {

        Pattern comprobar = Pattern.compile("34[0-9]{9}");
        Matcher validar = comprobar.matcher(comprobarTelefono);

        if (validar.matches()) {
            return validar.matches();
        } else {
            return false;
        }

    }

    /**
     * 
     * @param comprobarDni introduce el dni por parametro y lo comprueba en este metodo
     * @return me devuelve el dni si la comprobacion coincide con la expresion regular
     */
    public boolean comprobarDNI(String comprobarDni) {

        Pattern comprobar = Pattern.compile("[0-9]{8}[A-Za-z]{1}");
        Matcher validacion = comprobar.matcher(comprobarDni);

        if (validacion.matches()) {

            return validacion.matches();
        } else {

            return false;

        }

    }

}

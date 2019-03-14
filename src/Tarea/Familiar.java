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
public final class Familiar extends Turismo {

    private int numeroPlazas;
    private boolean sillaBebe;

    public Familiar(int numeroPlazas, boolean sillaBebe, Enumerados.TipoCombustible combustible, int numeroPuertas, String matricula, String marca, String modelo, int cilindrada) {
        super(combustible, numeroPuertas, matricula, marca, modelo, cilindrada);
        this.numeroPlazas = numeroPlazas;
        this.sillaBebe = sillaBebe;
    }

    public void setSillaBebe(boolean silla) {

    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public boolean getSillaBebe() {
        
        return sillaBebe;
    }

    public Enumerados.TipoCombustible getCombustible() {
        return combustible;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Combustible: " + combustible + "\n Numero de plazas: " + numeroPlazas + "\n Silla bebe: " + sillaBebe;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author JuanAntonio
 * @version 1.0
 */
public class ES {

    public ES() {
    }

    Scanner teclado = new Scanner(System.in);

    /**
     *
     * @return me devuelve un numero entero
     */
    public int leerEntero() {

        while (true) {
            try {

                return teclado.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Error!!!! No has introducido un dato valido, vuelve a intentarlo");
                teclado.nextLine();

            }

        }
    }

    /**
     *
     * @return me devuelve un numero float
     */
    public float leerReal() {

        while (true) {
            try {

                return teclado.nextFloat();

            } catch (InputMismatchException e) {
                System.out.println("Error!!!! No has introducido un dato valido, intentalo de nuevo");
                teclado.nextLine();
            }
        }
    }

    /**
     *
     * @param mensaje introduce un mensaje por defecto por paramentro
     * @param minimo introduce un valor minimo por parametro
     * @return devuelve un numero
     */
    public int leerEntero(String mensaje, int minimo) {
        int numero = 0;
        while (true) {

            numero = leerNumero(mensaje + minimo);

            if (numero < minimo) {
                escribirLn("El numero introducido ha de ser mayor a " + minimo);
                teclado.nextLine();
            } else {
                return numero;
            }

        }
    }

    /**
     *
     * @param mensaje introduce un mensaje por defecto por parametro
     * @param minimo introduce un valor minimo por parametro
     * @param maximo introduce un valor maximo por parametro
     * @return devuelve un valor en funcion del valor minimo y maximo
     */
    public int leerEntero(String mensaje, int minimo, int maximo) {
        while (true) {
            System.out.println(mensaje + minimo + " y maximo: " + maximo);
            int numero = leerEntero();
            if (minimo <= numero && maximo >= numero) {
                return numero;
            } else {
                System.out.println("El numero introducido no cumple las especificaciones");

            }
        }

    }

    /**
     *
     * @param mensaje introduce un mensaje por parametro
     * @param minimo introduce un valor minimo de tipo float
     * @return devuelve un numero de tipo float
     */
    public float leerReal(String mensaje, float minimo) {
        float numero;
        while (true) {
            escribirLn(mensaje + minimo);
            numero = leerReal();
            if (numero < minimo) {
                System.out.println("No puedes introducir un numero mas pequeño que " + minimo);
            } else {
                return numero;
            }

        }

    }

    /**
     *
     * @param mensaje introduce un mensaje por parametro
     * @return devuelve un numero largo
     */
    public long leerEnteroLargo(String mensaje) {

        while (true) {
            try {

                escribirLn(mensaje);
                return teclado.nextLong();

            } catch (InputMismatchException e) {
                System.out.println("El dato introducido no es valido prueba otra vez!!");
                teclado.nextLine();
            }

        }
    }

    public String leerCadena() {
        return teclado.next();
    }

    /**
     *
     * @param mensaje introduce un mensaje por parametro
     * @return una linea de caracteres introducida por teclado
     */
    public String leerCadena(String mensaje) {

        escribirLn(mensaje);

        return leerCadena();

    }

    /**
     *
     * @param mensaje introduce un mensaje por defecto por parametro
     * @return devuelve un numero
     */
    public int leerNumero(String mensaje) {

        escribirLn(mensaje);

        return leerEntero();
    }

    /**
     *
     * @param mensaje introduce un mensaje por defecto y lo muestra por pantalla
     */
    public void escribir(String mensaje) {

        System.out.print(mensaje);

    }

    /**
     *
     * @param mensaje introduce un mensaje por defecto por parametro y lo
     * muestra por pantalla e introduce una linea de salto
     */
    public void escribirLn(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Metodo estatico que permite guardar la informacion que recibe por
     * parametro en un archivo de texto.
     *
     * @param ruta cadena de caracteres que indica la ruta y el nombre del del
     * archivo donde se quieren guardar los datos
     * @param datos cadena de caracteres que contiene la informacion que se
     * quiere guarda.
     * @param sobrescribir booleano que en funcion de su valor indica si se
     * sobreescribe el contenido del archivo(verdadero) o se añade al final del
     * mismo(falso).
     * @throws IOException lanza un error en el caso de que no se encuentre el archivo o no se pueda escribir en el.
     * @return Booleano (verdadero) si se ha guardado correctamente el archivo y
     * falso si se ha dado algun error y no se ha podido guardar
     */
    public static boolean escribirArchivo(String ruta, String datos, boolean sobrescribir) throws IOException {

        try {

            File archivo = new File(ruta);
            FileWriter fw = new FileWriter(archivo, sobrescribir);
            BufferedWriter bw = new BufferedWriter(fw);
            

            
            
            
            
            if (datos != null) {
                bw.write(datos+System.lineSeparator());
                bw.close();
                
            } else{
                bw.close();
                
                
            }
            

        } catch (Exception e) {
            System.out.println("No se ha podido escribir en el archivo");

        }
        return sobrescribir;
    }

    /**
     * Metodo estatico que permite leer todo el contenido de un archivo.
     * @param ruta parametro que recibe el metodo con la ruta (y nombre del archivo) del que quiere realizar a lectura.
     * @return Devuelve el contenido como una cadena de caracteres
     */
    public static String leerArchivo(String ruta) {
        String cadena = null;

        try {
            File archivo = new File(ruta);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            while ((cadena = br.readLine())!= null) {

                String[] a = cadena.split("#");
                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i].toString());
                }
            }

        } catch (Exception e) {
        }

        return cadena;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea;

import java.util.Date;
import java.util.Scanner;
import Tarea.Enumerados.CajaCambios;
import Tarea.Enumerados.TipoCombustible;
import Tarea.Enumerados.Tamanio;
import com.sun.org.apache.xml.internal.security.transforms.TransformationException;
import java.io.IOException;

/**
 *
 * @author JuanAntonio
 * @version 1.0
 */
public class AlquilerVehiculos {

    private static final int MAX_VEHICULOS = 50;
    private static final int MAX_CLIENTES = 50;
    private static final int MAX_ALQUILERES = 50;
    private static Vehiculo[] vehiculo = new Vehiculo[MAX_VEHICULOS];
    private static Cliente[] clientes = new Cliente[MAX_CLIENTES];
    private static Alquiler[] alquileres = new Alquiler[MAX_ALQUILERES];

    public static ES teclado = new ES(); //Clase ES
    public static Utilidades utilidades = new Utilidades(); //Clase Utilidades

    public static void main(String[] args) throws IOException {
        boolean finalizar = true;
        boolean posibilidad = true;

        Cliente c = new Cliente("", "", "", "", "");
        Vehiculo v = new Vehiculo("", "", "", 0) {
        };
        Alquiler alquiler = new Alquiler(c, v);

        String ruta_Alquiler = "D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Alquiler.txt";
        String ruta_Cliente = "D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Cliente.txt";
        String ruta_Vehiculo = "D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Vehiculo.txt";

        do {

            teclado.escribirLn("Alquiler de Vehiculos");
            teclado.escribir("1.Añadir Cliente ");
            teclado.escribir(" 2.Borrar Cliente ");
            teclado.escribirLn(" 3.Listar clientes");
            teclado.escribir("4.Añadir vehiculo ");
            teclado.escribir("5.Borrar vehiculo ");
            teclado.escribirLn("6.Listar Vehiculo");
            teclado.escribir("7.Abrir alquiler ");
            teclado.escribir(" 8.Cerrar alquiler ");
            teclado.escribirLn("9.Listar Alquileres");
            teclado.escribir("10.Guardar Datos ");
            teclado.escribirLn(" 11. Leer Datos");
            teclado.escribirLn("0.Salir");

            int opcion = teclado.leerNumero("Introduzca una opcion: ");

            switch (opcion) {
                case 1:

                    for (int i = 0; i < clientes.length; i++) {

                        if (clientes[i] == null) {

                            System.out.println("Introduce un nuevo cliente");
                            añadirCliente(i);
                            System.out.println("cliente añadido con exito");

                        } else {
                            System.out.println("La base de datos ya esta llena");
                            break;
                        }

                        int tecla = teclado.leerNumero("Si desea introducir un nuevo cliente pulse 1\nEn caso contrario pulse 0");

                        if (tecla != 1) {
                            break;
                        }
                    }

                    break;
                case 2:

                    String dni = teclado.leerCadena("Introduzca el dni del cliente a eliminar");
                    borrarCliente(dni);

                    break;
                case 3:

                    do {
                        dni = teclado.leerCadena("Introduce el dni del cliente");
                        if (!utilidades.comprobarDNI(dni)) {

                            dni = teclado.leerCadena("Vuelve a introducir el dni del cliente");
                        }

                    } while (!utilidades.comprobarDNI(dni));

                    getCliente(dni);

                    break;
                case 4:

                    for (int j = 0; j < vehiculo.length; j++) {
                        if (vehiculo[j] == null) {
                            anadirVehiculo(j);
                        } else if (j == vehiculo.length) {

                            System.out.println("La base de datos ya esta llena.");
                        } else {
                            System.out.println("Ha habido un problema vuelva a intentarlo pulsando 1 a continuacion");
                        }
                        int tecla = teclado.leerNumero("Si desea introducir un nuevo vehiculo pulse 1\nEn caso contrario pulse 0");

                        if (tecla != 1) {
                            break;
                        }
                    }

                    break;
                case 5:
                    String matricula = teclado.leerCadena("Introduzca la matricula del vehiculo que desea borrar");
                    borrarVehiculo(matricula);

                    break;
                case 6:

                    do {
                        matricula = teclado.leerCadena("Introduce la matricula del vehiculo");
                        if (!utilidades.comprobarMatricula(matricula)) {

                            matricula = teclado.leerCadena("Vuelve a introducir la matricula del vehiculo");
                        }

                    } while (!utilidades.comprobarMatricula(matricula));

                    getVehiculo(matricula);

                    break;
                case 7:
                    for (int i = 0; i < alquileres.length; i++) {
                        if (alquileres[i] == null && clientes[i] != null && vehiculo[i] != null) {
                            c = clientes[i];
                            v = vehiculo[i];
                            nuevoAlquiler(c, v);
                            break;
                        } else {
                            System.out.println("No se ha podido crear un nuevo alquiler porque no hay ningun cliente y ningun vehiculo en la base de datos");
                            break;
                        }
                    }

                    break;
                case 8:

                    break;
                case 9:
                    break;

                case 10:

                    for (int i = 0; i < alquileres.length; i++) {
                        if (clientes[i] != null || vehiculo[i] != null || alquileres[i] != null) {

                            guardarDatos(clientes[i], vehiculo[i], alquileres[i]);
                        }
                    }

                    break;
                case 11:
                    leerDatos();

                    break;
                case 0:
                    finalizar = false;

                    System.out.println("¿Desea guardar los datos?");

                    int guardado = teclado.leerNumero("1. Si\n0. No");

                    break;
                default:
                    teclado.escribirLn("El dato introducido no corresponde a ninguna opcion");

            }

        } while (finalizar == true);

    } //Aqui finaliza el main

    /**
     * Este metodo me muestra los datos de los clientes al cual se le introduce
     * el dni
     *
     * @param dni comprobamos el parametro dni
     * @return Cliente[i]
     */
    private static Cliente getCliente(String dni) {
        int i;
        for (i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {

                if (dni.equalsIgnoreCase(clientes[i].getDni())) {
                    System.out.println("Hay un cliente con este mismo dni: " + clientes[i]);
                    return clientes[i];

                } else {
                    teclado.escribirLn("No hay ningun cliente con este mismo dni");
                    return clientes[i];

                }
            } else {
                System.out.println("Lo sentimos pero no hay ningun cliente de momento");
                break;
            }
        }
        return clientes[i];
    }

    /**
     *
     * @param posicion se introduce la posicion actual del array Este metodo se
     * encarga de añadir un cliente al array si dicha posicion es nula y si no
     * hay un cliente con el mismo dni
     */
    private static void añadirCliente(int posicion) {

        String dni;
        String codPostal;
        boolean comprobar = true;

        do {
            dni = teclado.leerCadena("Introduce dni");
            if (!utilidades.comprobarDNI(dni)) {
                System.out.println("No es posible introducir el dni intentelo de nuevo");
            }

        } while (!utilidades.comprobarDNI(dni));

        for (int j = posicion - 1; j >= 0; j--) {
            do {

                if (dni.equalsIgnoreCase(clientes[j].getDni())) {

                    System.out.println("Ya hay un cliente con ese mismo dni, vuelva a introducir el dni");
                    do {
                        dni = teclado.leerCadena("Introduzca el dni");
                        if (!utilidades.comprobarDNI(dni)) {
                            System.out.println("Vuelva a introducir el dni");
                        }

                    } while (!utilidades.comprobarDNI(dni));
                }

            } while (dni.equalsIgnoreCase(clientes[j].getDni()));

        }

        do {
            codPostal = teclado.leerCadena("Introduce el codigo postal");
            if (!utilidades.comprobarCodigoPostal(codPostal)) {
                System.out.println("El formato introducido no es valido pruebe de nuevo");
            }

        } while (!utilidades.comprobarCodigoPostal(codPostal));

        clientes[posicion] = new Cliente(dni,
                teclado.leerCadena("Introduce nombre"),
                teclado.leerCadena("Introduce la direccion"),
                teclado.leerCadena("Introduce localidad"),
                codPostal);

    }

    /**
     * Este metodo se encarga de eliminar un cliente del array
     *
     * @param dni busca el dni introducido por parametro en el array Una vez que
     * ha encontrado un cliente en el array que coincide con el dni pasado por
     * parametro el vehiculo es eliminado
     */
    private static void borrarCliente(String dni) {

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                teclado.escribirLn(clientes[i].toString());
                if (dni.equalsIgnoreCase(clientes[i].getDni())) {
                    System.out.println("Este cliente " + clientes[i] + " en la posicion " + i + " con el siguiente dni" + clientes[i].getDni() + " va a ser eliminado");
                    desplazarClientesNulos(i);
                    break;
                }

            }

        }

    }

    /**
     *
     * @param posicion este parametro se encarga de introducir la posicion
     * actual del array. Este metodo mueve de posicion las posiciones nulas del
     * array para no dejar hueco nulos
     */
    private static void desplazarClientesNulos(int posicion) {
        for (int i = posicion; i < clientes.length - 1; i++) {
            clientes[i] = clientes[i + 1]; //si la posicion i+1 (la siguiente posicion) es nula se la asigna a la posicion actual
            if (clientes[i] == null) {
                break;
            }
        }
        clientes[clientes.length - 1] = null;
    }

    /**
     *
     * @param posicion le introduzco por parametro la posicion del array en el
     * cual se me pediran los datos. Este metodo me va a permitir añadir un
     * nuevo vehiculo al array en el cual se piden los siguientes datos:
     * Matricula: introduce la matricula del vehiculo marca: introduce la marca
     * del vehiculo modelo: introduce el modelo del vehiculo cilindrada:
     * introduce la cilindrada del vehiculo
     */
    private static void anadirVehiculo(int posicion) {

        String matricula;

        do {
            matricula = teclado.leerCadena("Introduce la matricula");

            if (!utilidades.comprobarMatricula(matricula)) {
                matricula = teclado.leerCadena("El formato de matricula introducido no es valido");

            }

        } while (!utilidades.comprobarMatricula(matricula));

        for (int i = posicion - 1; i >= 0; i--) {
            do {
                if (vehiculo[i] != null) {

                    if (matricula.equalsIgnoreCase(vehiculo[i].getMatricula())) {

                        do {
                            matricula = teclado.leerCadena("Ya hay un vehiculo con esa matricula vuelve a introducirla");

                            if (!utilidades.comprobarMatricula(matricula)) {
                                teclado.escribirLn("El formato de la matricula no es valido");

                            }

                        } while (!utilidades.comprobarMatricula(matricula));

                    }
                }

            } while (matricula.equalsIgnoreCase(vehiculo[i].getMatricula()));
            //Este bucle me va a pedir la matricula una y otra vez 
            //siempre que encuentre un vehiculo en el array con la misma matricula introducida

        }

        //Voy a realizar un switch donde escogeré el tipo de vehiculo
        int numero = teclado.leerNumero("Escoge un tipo de vehiculo:\n1. Turismo 2. Mercancias(Actualmente solo es posible las furgonetas)");

        switch (numero) {

            case 1:
                //Seleccion entre Deportivo O Familiar
                numero = teclado.leerNumero("Escoge el tipo de turismo:\n1. Deportivo 2. Familiar");
                switch (numero) {
                    case 1:
                        anadirDeportivo(matricula, posicion);
                        break;
                    case 2:
                        anadirFamiliar(matricula, posicion);

                        break;
                    default:
                        System.out.println("Esta opcion no existe");
                        break;
                }

                break;
            case 2: //Introduce un vehiculo de tipo mercancias (furgoneta)
                System.out.println("Va a introducir un vehiculo de tipo mercancias: ");
                anadirFurgoneta(matricula, posicion);

                break;

            default:
                System.out.println("No hay ninguna opcion disponible");
                break;
        }

    }

    /**
     * Este metodo introducira por en el array de vehiculos un objeto de tipo
     * vehiculo de la clase Deportivo que hereda de la clase padre turismo
     *
     * @param matricula introduce por parametro la matricula que contendrá el
     * vehiculo
     * @param i introduce por parametro la posicion del array en el que se
     * introducira el vehiculo
     */
    public static void anadirDeportivo(String matricula, int i) {

        CajaCambios cajaCambios = null;
        TipoCombustible tipoCombustible = null;
        boolean descapotable;

        do {
            try {

                System.out.println("La caja de cambios son:\n" + cajaCambios.MANUAL + ", " + "\n" + cajaCambios.AUTOMATICA);
                cajaCambios = CajaCambios.valueOf(teclado.leerCadena("Introduzca el tipo de caja de cambios: ").toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de caja de cambios no es valido, vuelva a intentarlo");

            }
        } while (cajaCambios != CajaCambios.AUTOMATICA && cajaCambios != CajaCambios.MANUAL);

        do {

            try {

                System.out.println("El tipo de combustible es:\n" + TipoCombustible.DIESEL + ",\n" + tipoCombustible.ELECTRICO
                        + ",\n" + TipoCombustible.GASOLINA + ",\n" + tipoCombustible.HIBRIDO);
                tipoCombustible = TipoCombustible.valueOf(teclado.leerCadena("Introduzca el tipo de combustible").toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de combustible no es valido, vuelva a intentarlo");
            }
        } while (tipoCombustible != TipoCombustible.DIESEL && tipoCombustible != TipoCombustible.ELECTRICO
                && tipoCombustible != TipoCombustible.GASOLINA && tipoCombustible != TipoCombustible.HIBRIDO);

        int numero = teclado.leerNumero("¿Es descapotable?\n1.Si\n2.No");

        if (numero == 1) {
            descapotable = true;
        } else {
            descapotable = false;
        }
        vehiculo[i] = new Deportivo(cajaCambios, descapotable,
                tipoCombustible,
                teclado.leerNumero("Introduce el numero de puertas: "),
                matricula,
                teclado.leerCadena("Introduce la marca:"),
                teclado.leerCadena("Introduce el modelo:"),
                teclado.leerNumero("Introduce la cillindrada:"));

    }

    /**
     *
     * @param matricula le introduzco la matricula que contendra el vehiculo
     * familiar. Este metodo me permitira añadir al array un vehiculo del tipo
     * familiar heredado de la clase padre Turismo
     * @param matricula este parametro introduce la matricula del vehiculo, ademas se utiliza para buscar la matricula en el array y comprobar que no haya ningun vehiculo de tipo familiar con la misma matricula
     * @param i sirve para indicar la posicion en el array vehiculo en el que se va introducir el vehiculo.
     */
    public static void anadirFamiliar(String matricula, int i) {

        CajaCambios cajaCambios = null;
        TipoCombustible tipoCombustible = null;
        boolean sillaBebe;

        do {
            try {
                System.out.println("El tipo de combustible es:\n" + TipoCombustible.DIESEL + ",\n" + tipoCombustible.ELECTRICO
                        + ",\n" + TipoCombustible.GASOLINA + ",\n" + tipoCombustible.HIBRIDO);
                tipoCombustible = TipoCombustible.valueOf(teclado.leerCadena("Introduce el tipo de combustible").toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de combustible no es una opcion valida vuelva a intentarlo");

            }
        } while (tipoCombustible != TipoCombustible.DIESEL && tipoCombustible != TipoCombustible.ELECTRICO
                && tipoCombustible != TipoCombustible.GASOLINA && tipoCombustible != TipoCombustible.HIBRIDO);

        System.out.println("¿Tiene silla de bebe?");

        int opcion = teclado.leerNumero("Introduce una opcion: \n1.Si\n2.No");

        if (opcion == 1) {
            sillaBebe = true;
        } else {
            sillaBebe = false;
        }

        vehiculo[i] = new Familiar(teclado.leerEntero("Introduce el numero de plazas minimo: ", 4, 7),
                sillaBebe,
                tipoCombustible,
                teclado.leerNumero("Introduce el numero de puertas"),
                matricula,
                teclado.leerCadena("Introduce la marca"),
                teclado.leerCadena("Introduce el modelo"),
                teclado.leerNumero("Introduce la cilindrada"));

    }

    /**
     * Este metodo me va a introducir en el array vehiculos un vehiculo de tipo
     * furgoneta heredado de la clase padre mercancias
     *
     * @param matricula introduzco por parametro la matricula que tiene el
     * vehiculo
     * @param posicion introduzco por parametro la posicion del array en la que
     * se introducira el vehiculo
     */
    public static void anadirFurgoneta(String matricula, int posicion) {

        Tamanio tamanio = null;
        boolean refrigerado;

        do {
            try {
                System.out.println("Los tipos de tamaño son:\n" + tamanio.GRANDE + ",\n" + tamanio.MEDIANA + ",\n" + tamanio.PEQUEÑA);
                tamanio = Tamanio.valueOf(teclado.leerCadena("Introduce el tipo de tamaño").toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println("Este valor no coincide con los que se piden");
            }
        } while (tamanio != Tamanio.GRANDE && tamanio != Tamanio.MEDIANA && tamanio != Tamanio.PEQUEÑA);

        System.out.println("¿Es refrigerado?\n1.Si\n2.No");
        int numero = teclado.leerNumero("Introduce una opcion");
        if (numero == 1) {
            refrigerado = true;
        } else {
            refrigerado = false;
        }

        vehiculo[posicion] = new Furgoneta(refrigerado,
                tamanio,
                teclado.leerNumero("Introduce el Peso Maximo Autorizado"),
                teclado.leerNumero("Introduce el Volumen"),
                matricula,
                teclado.leerCadena("Introduce la marca"),
                teclado.leerCadena("Introduce el modelo"),
                teclado.leerNumero("Introduce la cilindrada"));

    }

    /**
     *
     * @param matricula introduzco la matricula por parametro del vehiculo que
     * quiero borrar Este metodo se encarga de borrar los vehiculos mediante la
     * matricula introducida y lo busca en el array
     */
    private static void borrarVehiculo(String matricula) {
        for (int i = 0; i < vehiculo.length; i++) {
            if (vehiculo[i] != null) {
                teclado.escribir(vehiculo[i].toString());
                if (matricula.equalsIgnoreCase(vehiculo[i].getMatricula())) {
                    System.out.println("Este vehiculo " + vehiculo[i] + " va a ser eliminado");
                    desplazarClientesNulos(i);
                    break;

                }
            }
        }

    }

    /**
     *
     * @param posicion introduzco la posicion actual por parametro del array
     * Este metodo se encarga de mover los elementos nulos de lugar
     */
    private static void desplazarVehiculosNulos(int posicion) {
        for (int i = posicion; i < vehiculo.length - 1; i++) {
            vehiculo[i] = vehiculo[i + 1];
            if (vehiculo[i] == null) {
                break;
            }

        }
        vehiculo[vehiculo.length - 1] = null;

    }

    /**
     * Este metodo me muestra la informacion del vehiculo introduciendo su
     * matricula
     *
     * @param matricula introduce la matricula del vehiculo que quiero mostrar
     * @return me devuelve el vehiculo una vez encontrado en el array
     */
    private static Vehiculo getVehiculo(String matricula) {

        int i;
        for (i = 0; i < vehiculo.length; i++) {
            if (vehiculo[i] != null) {
                if (matricula.equalsIgnoreCase(vehiculo[i].getMatricula())) {

                    if (vehiculo[i].getClass() == Deportivo.class) {
                        System.out.println("La matricula corresponde a un vehiculo de tipo: " + vehiculo[i].getClass().getSimpleName());

                        System.out.println("Los datos son: " + vehiculo[i].toString());
                    } else if (vehiculo[i].getClass() == Familiar.class) {
                        System.out.println("La matricula corresponde a un vehiculo de tipo: " + vehiculo[i].getClass().getSimpleName());
                        System.out.println("Los datos son: " + vehiculo[i].toString());
                    } else if (vehiculo[i].getClass() == Furgoneta.class) {
                        System.out.println("La matricula corresponde a un vehiculo de tipo: " + vehiculo[i].getClass().getSimpleName());
                        System.out.println("Los datos son: " + vehiculo[i].toString());
                    }
                    return vehiculo[i];

                } else {
                    teclado.escribirLn("No hay ningun vehiculo con esta misma matricula");
                    return vehiculo[i];

                }
            } else {
                System.out.println("Lo sentimos pero no hay ningun vehiculo de momento");
                break;
            }
        }
        return vehiculo[i];

    }

    /**
     *
     * @param c introduce por parametro un objeto de tipo cliente
     * @param v introduce por parametro un objeto de tipo vehiculo Introduce un
     * nuevo alquiler en el array alquileres si se dan las condiciones
     */
    private static void nuevoAlquiler(Cliente c, Vehiculo v) {
        Alquiler alquiler = new Alquiler(c, v);

        for (int i = 0; i < alquileres.length; i++) {

            alquileres[i] = alquiler;
            if (alquileres[i].cliente != null && alquileres[i].turismo != null) {

                System.out.println("El cliente " + i + " es: " + alquileres[i].cliente);
                System.out.println("El vehiculo " + i + " es: " + alquileres[i].turismo);
                System.out.println("La fecha es: " + alquiler.getFecha());
                double precioAlquiler = alquiler.precioAlquiler();
                System.out.println("El precio del alquier es: " + precioAlquiler);
                break;

            }

        }

    }

    private static void cerrarAlquiler(Cliente c, Vehiculo v) {

    }

    /**
     * Metodo que codifica todos los datos almacenados en los arrays y los
     * guarda en un archivo de texto. Para distinguir el contenido de un
     * atributo de otro se usará la almohadilla (#) como caracter delimitador.
     * 
     * @param c este parametro se utiliza para introducir el objeto de tipo cliente
     * @param v este parametro se utiliza para introducir el objeto de tipo vehiculo
     * @param a este parametro se utiliza para introducir el objeto de tipo alquiler
     *
     * @return Devolverá true si ha podido guardar los datos correctamente.
     */
    private static boolean guardarDatos(Cliente c, Vehiculo v, Alquiler a) throws IOException {

        try {

            String cadena;
            String ruta;

            System.out.println("Introduce los datos que deseas añadir");
            System.out.println("Cliente");
            System.out.println("Vehiculo");
            System.out.println("Alquiler");

            String tipo = teclado.leerCadena("Introduce el tipo de dato");
            switch (tipo.toLowerCase()) {
                case "cliente":

                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i] != null) {

                            cadena = clientes[i].getClass().getSimpleName() + "#" + clientes[i].getDni() + "#" + clientes[i].getNombre() + "#" + clientes[i].getDireccion() + "#" + clientes[i].getLocalidad() + "#" + clientes[i].getCodigoPostal();

                            teclado.escribirArchivo("D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Cliente.txt", cadena, true);

                        }
                    }

                    break;

                case "vehiculo":

                    for (int i = 0; i < vehiculo.length; i++) {
                        if (vehiculo[i] != null) {
                            tipo = teclado.leerCadena("Introduce el tipo de vehiculo\nDeportivo\nFamiliar\nFurgoneta");

                            switch (tipo.toLowerCase()) {
                                case "deportivo":
                                    if (vehiculo[i].getClass() == Deportivo.class) {

                                        cadena = vehiculo[i].getClass().getSimpleName() + "#"
                                                + vehiculo[i].getMatricula() + "#"
                                                + vehiculo[i].getMarca() + "#"
                                                + vehiculo[i].getModelo() + "#"
                                                + vehiculo[i].getCilindrada() + "#"
                                                + ((Deportivo) vehiculo[i]).getCombustible() + "#"
                                                + ((Deportivo) vehiculo[i]).getCambio() + "#"
                                                + ((Deportivo) vehiculo[i]).getDescapotable() + "#"
                                                + ((Deportivo) vehiculo[i]).getNumeroPuertas();
                                        teclado.escribirArchivo("D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Vehiculo.txt", cadena, true);
                                    } else {
                                        System.out.println("El vehiculo que vas a introducir no corresponde con el tipo de vehiculo");
                                    }
                                    break;
                                case "familiar":
                                    if (vehiculo[i].getClass() == Familiar.class) {

                                        cadena = vehiculo[i].getClass().getSimpleName() + "#"
                                                + vehiculo[i].getMatricula() + "#"
                                                + vehiculo[i].getMarca() + "#"
                                                + vehiculo[i].getModelo() + "#"
                                                + vehiculo[i].getCilindrada() + "#"
                                                + ((Familiar) vehiculo[i]).getCombustible() + "#"
                                                + ((Familiar) vehiculo[i]).getNumeroPlazas() + "#"
                                                + ((Familiar) vehiculo[i]).getNumeroPuertas() + "#"
                                                + ((Familiar) vehiculo[i]).getSillaBebe();
                                        teclado.escribirArchivo("D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Vehiculo.txt", cadena, true);
                                    } else {
                                        System.out.println("El vehiculo que vas a introducir no corresponde con el tipo de vehiculo");
                                    }
                                    break;
                                case "furgoneta":
                                    if (vehiculo[i].getClass() == Furgoneta.class) {

                                        cadena = vehiculo[i].getClass().getSimpleName() + "#"
                                                + vehiculo[i].getMatricula() + "#"
                                                + vehiculo[i].getMarca() + "#"
                                                + vehiculo[i].getModelo() + "#"
                                                + vehiculo[i].getCilindrada() + "#"
                                                + ((Furgoneta) vehiculo[i]).getPma() + "#"
                                                + ((Furgoneta) vehiculo[i]).getVolumen() + "#"
                                                + ((Furgoneta) vehiculo[i]).getRefrigerado() + "#"
                                                + ((Furgoneta) vehiculo[i]).getTamanio();
                                        teclado.escribirArchivo("D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Vehiculo.txt", cadena, true);
                                    } else {
                                        System.out.println("El vehiculo que vas a introducir no corresponde con el tipo de vehiculo");
                                    }
                                    break;

                            }

                        }
                    }

                    break;
                case "alquiler":
                    for (int i = 0; i < alquileres.length; i++) {
                        if (alquileres[i] != null) {
                            cadena = alquileres[i].cliente.toString() + "#" + alquileres[i].turismo.toString();
                            teclado.escribirArchivo("D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Alquiler.txt", cadena, true);
                        } else {
                            System.out.println("No es posible introducir un nuevo alquiler");
                        }

                    }

                    break;

                default:
                    System.out.println("Esa opcion no esta disponible");
                    break;

            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un problema a la hora de trabajar en el archivo");
        }

        return true;
    }

    /**
     * Metodo que permite leer los datos de un archivo de text y rellenar los
     * arrays con la informacion obtenida
     */
    private static void leerDatos() {

        System.out.println("¿Que archivo deseas leer?");
        int numero = teclado.leerNumero("1.Cliente\n2.Vehiculo\n3.Alquileres");
        switch (numero) {
            case 1:
                String cliente = "D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Cliente.txt";
                teclado.leerArchivo(cliente);
                break;
            case 2:
                String vehiculo = "D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Vehiculo.txt";
                teclado.leerArchivo(vehiculo);

                break;
            case 3:

                String alquiler = "D:\\DAW\\Tareas de programacion\\Unidad 7\\Tarea Online\\TareaOnline7\\src\\Tarea\\Alquiler.txt";
                teclado.leerArchivo(alquiler);

                break;

            default:
                System.out.println("Esta opcion no esta disponible");
                break;

        }

    }

}
/*
        AQUI FINALIZA LA CLASE ALQUILER VEHICULOS!!!!----
 */

package edu.upc.etsetb.poo.basededatos.iu;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Funciones auxiliares para el teclado.
 * <p><b>ESTA CLASE SE OS DA HECHA.</b></p>
 * <p>Asignando a atributo estático <code>desdeTeclado</code> el valor <code>true</code> 
 * la entrada deberá hacerse por teclado; asignándole el valor <code>false</code> el 
 * programa leerá los comandos desde el archivo input.txt presente en el directorio en 
 * el que se encuentra el proyecto NetBeans</p>
 */
public class Teclado {

    //// IMPORTANTE: esta clase se da hecha. No debéis modificar nada
    /**
     * Constructor privado que simplemente impide que la clase se instancie
     */
    private Teclado() {
        // Evita que la clase se instancie
    }

    /**
     * Lector de teclado
     */
    private static Scanner reader;

    /**
    ESTE ATRIBUTO ESTÁTICO, PUESTO A true HACE QUE EL PROGRAMA LEA DESDE 
    TECLADO; 
    PUESTO A false, HACE QUE EL PROGRAMA LEA DESDE EL ARCHVIVO input.txt QUE 
    DEBE ESTAR EN LA CARPETA QUE CONTIENE EL PROYECTO NETBEANS.
    POR TANTO PARA LEER DESDE ARCHIVO TENÉIS QUE ASIGNARLE EL VALOR false 
    */
    private static boolean desdeTeclado = false;

    static {
        /*
        ESTE BLOQUE CONTIENE CODIGO PARA ENTRAR LOS COMANDOS POR TECLADO
        (OPCIÓN 1) O DESDE UN ARCHIVO DE TEXTO (OPCIÓN 2). CUANDO SE ELIJA UNA
        DE LAS DOS OPCIONES, EL CÓDIGO CORRESPONDIENTE A LA OTRA DEBE COMENTARSE
         */
        // OPCION 1: TODO DEBE SER ENTRADO POR TECLADO
        if (desdeTeclado) {
            reader = new Scanner(System.in);
        } /*
        OPCIÓN 2: EN LUGAR DE ENTRAR POR TECLADO EL PROGRAMA LEE LOS COMANDOS 
        DEL ARCHIVO input.txt QUE SE ENCUENTRA EN EL DIRECTORIO QUE CONTIENE 
        EL PROYECTO NETBEANS.
         */ else {
            try {
                reader = new Scanner(new FileInputStream(System.getProperty("user.dir") + File.separator
                        + "input.txt"));
            } catch (Exception ex) {
                System.out.println("Error al crear el canal de lectura.");
                System.exit(-1);
            }
        }
    }

    /**
     * Lee una línea de texto del teclado y la retorna como un
     * <code>String</code>
     *
     * @return Una línea de texto leída del teclado.
     */
    public static String linea() {
        System.out.flush();
        /*
        ESTE MÉTODO CONTIENE CODIGO PARA ENTRAR LOS COMANDOS POR TECLADO
        (OPCIÓN 1) O DESDE UN ARCHIVO DE TEXTO (OPCIÓN 2). CUANDO SE ELIJA UNA
        DE LAS DOS OPCIONES, EL CÓDIGO CORRESPONDIENTE A LA OTRA DEBE COMENTARSE
         */
        // OPCION 1: PARA LECTURA DESDE TECLADO

        if (desdeTeclado) {
            return reader.nextLine();
        } /*
        OPCION 2: PARA LECTURA DESDE ARCHIVO. SE LEEN LAS LINEAS DEL ARCHVIO Y
        SE PRESENTAN POR PANTALLA PARA VER QUÉ COMANDOS HA IDO EJECUTANDO EL 
        PROGRAMA
//        */ else {
            String linea = reader.nextLine();
            System.out.println(linea);
            return linea;
        }
    }

    /**
     * Lee una línea de texto del teclado, y la retorna como un array de
     * <code>String</code>, en el que cada elemento se corresponde con una
     * palabra diferente. Por ejemplo, si el usuario introduce por teclado
     * <code>Esta es una frase cualquiera 123.</code> el método retornará un
     * array de String con el contenido:
     * <code>{"Esta", "es", "una", "frase", "cualquiera", "123"}</code>
     *
     * @return La línea de texto introducida mediante teclado, como un array de
     * <code>String</code>, en el que cada elemento se corresponde con una
     * palabra diferente.
     */
    public static String[] palabras() {
        return linea().split(" ");
    }
}

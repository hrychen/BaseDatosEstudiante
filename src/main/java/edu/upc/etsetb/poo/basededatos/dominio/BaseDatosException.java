package edu.upc.etsetb.poo.basededatos.dominio;

/**
 * Excepción genérica para errores de la base de datos
 */
public class BaseDatosException extends Exception {
    public BaseDatosException() {
        super();
    }

    public BaseDatosException(String message) {
        super(message);
    }
}

package edu.upc.etsetb.poo.basededatos.dominio.tabla;

import edu.upc.etsetb.poo.basededatos.dominio.BaseDatosException;

/**
 * Excepción que se lanza cuando se intenta acceder a una clave inexistente dentro de una {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos}
 */
public class ClaveInexistenteException extends BaseDatosException {
    private String nombreClave;

    public ClaveInexistenteException(String nombreClave) {
       super("La clave '" + nombreClave + "' no existe.");
        this.nombreClave = nombreClave;
    }

    public String getNombreClave() {
        return nombreClave;
    }
}

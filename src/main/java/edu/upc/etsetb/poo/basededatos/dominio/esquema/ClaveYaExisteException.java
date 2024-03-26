package edu.upc.etsetb.poo.basededatos.dominio.esquema;

import edu.upc.etsetb.poo.basededatos.dominio.BaseDatosException;

/**
 * Excepción que se lanza cuando se trata de añadir una clave que ya existe dentro de un {@link edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema}
 */
public class ClaveYaExisteException extends BaseDatosException {
    private String nombreClave;

    public ClaveYaExisteException(String nombreClave) {
        super("La clave '" + nombreClave + "' ya existe en el esquema.");
        this.nombreClave = nombreClave;
    }

    public String getNombreClave() {
        return nombreClave;
    }
}

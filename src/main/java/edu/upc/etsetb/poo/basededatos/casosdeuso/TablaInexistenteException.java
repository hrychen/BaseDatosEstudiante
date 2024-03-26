package edu.upc.etsetb.poo.basededatos.casosdeuso;

import edu.upc.etsetb.poo.basededatos.dominio.BaseDatosException;

/**
 * Excepción que se lanza cuando se intenta acceder a una tabla que no existe
 */
public class TablaInexistenteException extends BaseDatosException {
    private String nombreTabla;

    public TablaInexistenteException(String nombreTabla) {
        throw new UnsupportedOperationException("TablaInexistenteException::TablaInexistenteException(nombreTabla) no implementado.");
    }

    public String getNombreTabla() {
        throw new UnsupportedOperationException("TablaInexistenteException::getNombreTabla(nombreTabla) no implementado.");
    }
}

package edu.upc.etsetb.poo.basededatos.dominio.tabla;

import edu.upc.etsetb.poo.basededatos.dominio.BaseDatosException;

/**
 * Excepción que se lanza cuando se viola una clave única. Es decir, se intenta insertar una
 * {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos} dentro de una {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla} en la que el mismo valor de una clave única
 * ya existe en otra fila de la tabla.
 */
public class ValorClaveUnicaException extends BaseDatosException {
    private String nombreClave;
    private String valorDuplicado;

    public ValorClaveUnicaException(String nombreClave, String valorDuplicado) {
        super("Valor duplicado para la clave única '" + nombreClave + "': " + valorDuplicado);
        this.nombreClave = nombreClave;
        this.valorDuplicado = valorDuplicado;
    }

    public String getNombreClave() {
        return nombreClave;
    }

    public String getValorDuplicado() {
        return valorDuplicado;
    }
}

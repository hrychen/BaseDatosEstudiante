package edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda;

import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;

/**
 * Clase que implementa el criterio "igual", en el que que la
 * propiedad de una {@link FilaDatos} cuya nombreClave es igual a la propiedad
 * {@link #nombreClave} de la clase <code>criterio</code> ha de tener un valor
 * IGUAL al de la propiedad <code>valorAComprobar</code>.
 */
public class CriterioIgual extends Criterio {
    /**
     * {@inheritDoc}
     */
    public CriterioIgual(String nombreClave, String valorAComprobar) {
        super(nombreClave, valorAComprobar);
    }

    /**
     * <p>Retorna 'true' si la
     * propiedad de una {@link FilaDatos} cuya nombreClave es igual a la propiedad
     * {@link #nombreClave} de la clase <code>criterio</code> ha de tener un valor
     * IGUAL al de la propiedad <code>valorAComprobar</code>.
     *
     * <p>Las comprobaciones antes mencionadas <b>NO</b> deben distinguir entre mayúsculas
     * y minúsculas.</p>
     *
     * @param f Fila sobre la cual comprobar si se cumple el criterio
     * @return true si el criterio se cumple. false en caso contrario
     */
    @Override
    public boolean esCumplido(FilaDatos f) {
        throw new UnsupportedOperationException("CriterioIgual::esCumplido(f) no implementado.");
    }
}

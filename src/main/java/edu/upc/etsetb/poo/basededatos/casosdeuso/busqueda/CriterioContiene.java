package edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda;

import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;

/**
 * Clase que implementa el criterio "Contiene", en el que la
 * propiedad de una {@link FilaDatos} cuya nombreClave es igual a la propiedad
 * {@link #nombreClave} de la clase <code>criterio</code> debe contener (como una
 * subcadena) el valor de la propiedad <code>valorAComprobar</code>.
 */
public class CriterioContiene extends Criterio {
    /**
     * {@inheritDoc}
     */
    public CriterioContiene(String nombreClave, String valorAComprobar) {
        super(nombreClave, valorAComprobar);
    }

    /**
     * <p>Retorna 'true' si la
     * propiedad de una {@link FilaDatos} cuya nombreClave es igual a la propiedad
     {@link #nombreClave} de la clase <code>criterio</code> debe contener (como una
     * subcadena) el valor de la propiedad <code>valorAComprobar</code>.</p>
     *
     * <p>Las comprobaciones antes mencionadas <b>NO</b> deben distinguir entre mayúsculas
     * y minúsculas.</p>
     *
     * @param f Fila sobre la cual comprobar si se cumple el criterio
     * @return true si el criterio se cumple. false en caso contrario
     */
    @Override
    public boolean esCumplido(FilaDatos f) {
        String valor = f.get(this.nombreClave);
        if (valor == null) {
            return false; // Si el valor es null, no puede contener ninguna subcadena, por lo tanto, retorna falso.
        }
        return valor.toLowerCase().contains(this.valorAComprobar.toLowerCase());
    }
}

package edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda;

import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;

/**
 * Clase abstracta superclase de los criterios concretos.
 * <ul>
 *     <li><b>Es una clase abstracta, ahora los criterios de búsqueda se implementarán como subclases</b></li>
 *     <li><b>El método {@link #esCumplido(FilaDatos)} es abstracto y se debe implementar en las subclases</b></li>
 * </ul>
 */
public abstract class Criterio {
    /**
     * Clave de la {@link FilaDatos} cuyo valor se comparará con
     * {@link #valorAComprobar}
     */
    protected String nombreClave;

    /**
     * Valor de búsqueda, a comparar con la nombreClave de la {@link FilaDatos} cuyo
     * nombre coincide con la propiedad {@link #nombreClave} del criterio.
     */
    protected String valorAComprobar;

    /**
     * Instancia un criterio de búsqueda
     * @param clave Clave cuyo nombre debe coincidir con el de una nombreClave de
              {@link FilaDatos} sobre la que se buscará un valor
     * @param valorAComprobar Valor de búsqueda, que deberá coincidir o estar
     *                        contenido, según el valor del parámetro
     *                        <code>tipo</code>
     */
    public Criterio(String clave, String valorAComprobar) {
        throw new UnsupportedOperationException("Criterio::Criterio(clave,valorAComprobar) no implementado.");
    }

    /**
     * <p>Retorna <code>true</code> si el criterio se cumple para la 
     * {@link FilaDatos} pasada como argumento, es decir, si la {@link FilaDatos} tiene una pareja
     * [nombre de clave, valor de clave] cuya clave (nombre de clave) es el mismo que 
     * el atributo {@link Criterio#nombreClave} y cuyo valor (valor de clave)
     * cumple las condiciones especificadas en el método (a implementar por las subclases).
     * 
     * <p>En caso de que la {@link FilaDatos} no contenga ninguna pareja con la clave 
     * buscada, devuelve false si el atributo {@link Criterio#valorAComprobar} es 
     * distinto de null; devuelve true si el atributo {@link Criterio#valorAComprobar} es 
     * null.</p>
     *
     * @param f {@link FilaDatos} a comprobar si cumple con el criterio
     *
     * @return <code>true</code> si la {@link FilaDatos} cumple el criterio,
     *         <code>false</code> en caso contrario.
     */
    public abstract boolean esCumplido(FilaDatos f);
}

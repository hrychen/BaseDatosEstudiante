package edu.upc.etsetb.poo.basededatos.casosdeuso;

import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;
import java.util.Comparator;

/**
 * Una clase que implementa la interfaz {@link Comparator} y compara
 * {@link FilaDatos}, que nos servirá como clase auxiliar para ordenar las filas
 * de una tabla según los valores de una clave dada, y si se deben ordenar en
 * ascendente o descendente.
 */
public class ComparadorFilas implements Comparator<FilaDatos> {

    /**
     * Nombre de la clave de la tabla a comparar.
     */
    private String claveAComparar;

    /**
     * Si 'true', devuelve el orden natural de las filas comparadas (alfabética
     * o numéricamente). Si es 'false' devuelve el orden inverso ('Z' irá antes
     * que 'A' o '1234' irá antes que '1')
     */
    private boolean ascendente;

    /**
     * Constructor para el comparador de filas
     *
     * @param claveAComparar Nombre de la clave de la tabla a comparar.
     * @param ascendente Si 'true', devuelve el orden natural de las filas
     * comparadas. Si 'false', el inverso.
     */
    public ComparadorFilas(String claveAComparar, boolean ascendente) {
        this.claveAComparar = claveAComparar;
        this.ascendente = ascendente;
    }

    /**
     * <p>
     * Compara dos filas de datos según el valor de una clave, y retorna cuál
     * debe ir primero</p>
     * <p>
     * Si ninguna de las filas contiene la clave cuyo nombre se pasa a través
     * del argumento claveAComparar, devolverá 0.</p>
     * <p>
     * Si la fila pasada como primer argumento tiene la clave especificada para
     * la fila pasada como primer parámetro y la fila pasada como segundo
     * argumento no tiene dicha clave, devolverá un valor mayor que 0.</p>
     * <p>
     * Si la fila pasada como segundo argumento tiene la clave especificada para
     * la fila pasada como primer parámetro y la fila pasada como primer
     * argumento no tiene dicha clave, devolverá un valor nenor que 0.</p>
     * <p>
     * Si ambas filas tienen la clave, y sean 'val1' y 'val2' los valores
     * mapeados con la clave en las filas pasadas como primer y segundo
     * argumentos, respectivamente.</p>
     * <p>
     * Si los valores de la clave se pueden convertir a un número (usando el
     * método {@link Double#parseDouble(String)} para pasar de String a double)
     * y el modo de ordenación es 'ascendente':</p>
     * <ul>
     * <li>Retornará un número mayor que 0 si val1 &gt; val2</li>
     * <li>Retornará un número menor que 0 si val1 &lt; val2</li>
     * <li>Retornará un 0 si val1 == val2</li>
     * </ul>
     *
     * <p>
     * Si los valores de la clave NO se pueden convertir a un número (el método
     * {@link Double#parseDouble(String)} nos lanzará una
     * {@link NumberFormatException} y el método deberá capturarse) y el modo de
     * ordenación es 'ascendente':</p>
     * <ul>
     * <li>Retornará un número mayor que 0 si val1 es alfabéticamente posterior
     * a val2</li>
     * <li>Retornará un número menor que 0 si val1 es alfabéticamente anterior a
     * val2</li>
     * <li>Retornará un 0 si val1 es igual a val2</li>
     * </ul>
     * <p>
     * Si el modo de ordenación NO es 'ascendente', los casos anteriores se
     * invertirán.</p>
     *
     * @param o1 una de las filas comparadas
     * @param o2 otra de las filas comparadas
     * @return Un número menor que 0, igual a 0 o mayor que 0 si la fila o1 es
     * anterior, igual, o posterior a o2 en el orden que debe ocupar
     */
    @Override
    public int compare(FilaDatos o1, FilaDatos o2) {
        String val1 = o1.get(claveAComparar);
        String val2 = o2.get(claveAComparar);

        // Si ninguna o solo una de las filas contiene la clave
        if (val1 == null && val2 == null) {
            return 0;
        }
        if (val1 == null) {
            return ascendente ? -1 : 1; // Ajustar según si es ascendente o descendente
        }
        if (val2 == null) {
            return ascendente ? 1 : -1; // Ajustar según si es ascendente o descendente
        }

        try {
            // Intentar comparar como números
            double num1 = Double.parseDouble(val1);
            double num2 = Double.parseDouble(val2);
            return compareNumbers(num1, num2, ascendente);
        } catch (NumberFormatException e) {
            // Comparar como strings si no son números
            return compareStrings(val1, val2, ascendente);
        }
    }

    private int compareNumbers(double num1, double num2, boolean ascendente) {
        if (ascendente) {
            return Double.compare(num1, num2);
        } else {
            return Double.compare(num2, num1);
        }
    }

    private int compareStrings(String val1, String val2, boolean ascendente) {
        if (ascendente) {
            return val1.compareTo(val2);
        } else {
            return val2.compareTo(val1);
        }
    }
}

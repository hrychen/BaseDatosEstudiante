package edu.upc.etsetb.poo.basededatos.dominio.esquema;

import java.util.Objects;

/**
 * Clase que representa una columna dentro del {@link Esquema} de una
 * {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla}.
 */
public class Clave {
    /**
     * Nombre de la clave dentro del {@link Esquema}
     */
    private String nombre;
    /**
     * <p>Indica si la clave es única. Si es <code>true</code>, significa que
     * dentro de una {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla} no pueden haber dos
     * {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos} cuyas claves {@link #nombre} tengan el
     * mismo valor.</p>
     *
     * <p>Por ejemplo, dentro de una Tabla que guarde un censo de personas, no
     * podrán haber dos personas cuyo DNI sea el mismo.</p>
     *
     */
    private boolean unica;
    
    /**
     * Constructor para corrector. No tocar
     */
    public Clave(){
        
    }

    /**
     * Instancia una clave no unica con un nombre dado
     * @param nombre Nombre de la clave
     */
    public Clave(String nombre) {
        this.nombre = nombre;
        this.unica = false;
    }


    /**
     * Instancia una clave con un nombre dado, pudiendo especificar si esta es
 unica o no
     * @param nombre Nombre de la clave
     * @param unica Si es una clave unica o no
     */
    public Clave(String nombre, boolean unica) {
        this.nombre = nombre;
        this.unica = unica;
    }

    /**
     * Nombre de la clave dentro del {@link Esquema}
     * @return Nombre de la clave dentro del {@link Esquema}
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <p>Indica si la clave es única. Si es <code>true</code>, significa que
     * dentro de una {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla} no pueden haber dos
     * {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos} cuyas claves {@link #nombre} tengan el
     * mismo valor.</p>
     *
     * <p>Por ejemplo, dentro de una Tabla que guarde un censo de personas, no
     * podrán haber dos personas cuyo DNI sea el mismo.</p>
     *
     * @return <code>true</code> si la clave es unica. <code>false</code> en
     * caso contrario
     */
    public boolean isUnica() {
        return unica;
    }


    /**
     * Determina si este objeto Clave es igual al objeto Clave 
     * pasado como argumento. SE DA IMPLEMENTADA. NO TOCAR
     * @param obj el otro objeto Clave pasado como argumento
     * @return true si este objeto Clave es igual al otro objeto Clave
     * pasado como argumento
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clave other = (Clave) obj;
        if (this.unica != other.unica) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    /**
     * Método que genera un String con los detalles de sus atributos para que lo 
     * use el corrector; NO TOCAR.
     * 
     * @return String con los detalles de sus atributos
     */
    @Override
    public String toString() {
        return "Clave{" + "nombre=" + nombre + ", unica=" + unica + '}';
    }
    
}

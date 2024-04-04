package edu.upc.etsetb.poo.basededatos.dominio.esquema;


import java.util.*;

/**
 * Un Esquema indica la estructura de una {@link edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla}, es decir,
 * qué claves tiene ésta.
 */
public class Esquema {

    /**
     * {@link Map} cuya clave es el nombre de la {@link Clave} y cuyo valor es
     * el objeto {@link Clave} en cuestión.
     */
    private Map<String, Clave> campos;

    /**
     * Instancia un nuevo esquema vacío (sin claves)
     */
    public Esquema() {
        this.campos = new HashMap<>();
    }

    /**
     * Añade una clave al esquema
     *
     * <p><b>Cambios con respecto a v1:</b></p>
     * <ul>
     *     <li><b>Lanza {@link ClaveYaExisteException} en caso de que ya exista una clave con ese nombre en el esquema</b></li>
     * </ul>
     *
     * @param clave clave a añadir al esquema
     * @throws ClaveYaExisteException en caso de que ya exista una clave con ese nombre en el esquema
     *
     */
    public void addClave(Clave clave) throws ClaveYaExisteException {
        if(this.campos.containsKey(clave.getNombre())) {
            throw new ClaveYaExisteException("Una clave con el nombre '" + clave.getNombre() + "' ya existe en el esquema.");
        }
        this.campos.put(clave.getNombre(), clave);
    }

    /**
     * Retorna <code>true</code> si el esquema contiene una clave cuyo nombre
     * coincide con el argumento <code>nombre</code>
     *
     * @param nombre nombre de la clave a buscar
     * @return <code>true</code> si el esquema contiene una clave cuyo nombre
     * coincide con el argumento <code>nombre</code>. <code>false</code> en caso
     * contrario
     */
    public boolean contieneClave(String nombre) {
        return this.campos.containsKey(nombre);
    }

    /**
     * Genera y retorna un nuevo iterador a las {@link Clave}s del esquema
     *
     * @return nuevo iterador a las {@link Clave}s del esquema
     */
    public Iterator<Clave> iterator() {
        return this.campos.values().iterator();
    }
    
    /**
     * Devuelve el número de campos del esquema
     * @return 
     */
    public int getNumCampos(){
        return this.campos.size();
    }

    public Map<String, Clave> getCampos() {
        return campos;
    }

    public void setCampos(Map<String, Clave> campos) {
        this.campos = campos;
    }
    
    // Implementación del método getCabeceras
    public List<String> getCabeceras() {
        return new ArrayList<>(this.campos.keySet());
    }

    // Implementación del método getClave
    public Clave getClave(String nombre) {
        return this.campos.get(nombre);
    }

}

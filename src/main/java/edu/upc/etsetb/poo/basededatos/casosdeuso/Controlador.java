package edu.upc.etsetb.poo.basededatos.casosdeuso;

import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.Criterio;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioContiene;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioIgual;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla;
import edu.upc.etsetb.poo.basededatos.iu.InterfazUsuario;
import java.util.*;

/**
 * Controlador de la base de datos, que guardará las diferentes tablas y
 * facilitará la comunicación entre la {@link edu.upc.etsetb.poo.basededatos.iu.InterfazUsuario} y los
 * demás elementos de la base de datos.
 * <p>
 * <b>IMPORTANTE: SE OS ENTREGA EL SIGUIENTE CÓDIGO, QUE NO TENÉIS QUE
 * MODIFICAR:</b></p>
 * <ol>
 * <li><b>LAS DEFINICIONES DE LOS ATRIBUTOS PÚBLICOS FINALES Y ESTÁTICOS
 * (CONSTANTES) QUE DEFINEN CARACTERES ESPECIALES UTILIZADOS EN LOS COMANDOS QUE
 * CONLLEVEN BÚSQUEDA EN UNA TABLA, LOS COMANDOS, Y ANCHO DE COLUMNA</b></li>
 * </ol>
 *
 * <p><b>Cambios con respecto a v1:</b></p>
 * <ul>
 *     <li><b>Añadido comando CMD_EXPORTA, CMD_ORDENA y respectivos métodos</b></li>
 * </ul>
 */
public class Controlador {

    /**
     * Símbolo que, durante la definición del esquema de una tabla (comando
     * 'crea') delante del nombre de una clave indica que ésta es clave única
     */
    public static final char SIMB_CLAVE_ÚNICA = '*';

    /**
     * Símbolo que, durante la definición de un criterio de
     * búsqueda/eliminación, especifica que es un criterio del tipo
     * {@link CriterioIgual}
     */
    public static final String SIMB_IGUAL = "=";

    /**
     * Símbolo que, durante la definición de un criterio de
     * búsqueda/eliminación, especifica que es un criterio del tipo
     * {@link CriterioContiene}
     */
    public static final String SIMB_CONTIENE = "#";

    /**
     * Símbolo que, durante la definición de un criterio de
     * búsqueda/eliminación, especifica que es un criterio del tipo
     * {@link edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioMayorQue}
     */
    public static final String SIMB_MAYOR_QUE = ">";

    /**
     * Símbolo que, durante la definición de un criterio de
     * búsqueda/eliminación, especifica que es un criterio del tipo
     * {@link edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioMenorQue}
     */
    public static final String SIMB_MENOR_QUE = "<";


    /**
     * Cuando se muestran las filas de una tabla, el ancho de la columna (en
     * carácteres) que los valores de ésta ocuparán.
     */
    public static final int ANCHO_COLUMNA = 15;

    /**
     * Comando 'crear tabla'
     */
    public static final String CMD_CREA_TABLA = "crea";

    /**
     * Comando 'buscar en tabla'
     */
    public static final String CMD_BUSCA = "busca";

    /**
     * Comando 'anyadir datos a una tabla'
     */
    public static final String CMD_AÑADE = "añade";

    /**
     * Comando 'eliminar datos de una tabla'
     */
    public static final String CMD_ELIMINA = "elimina";

    /**
     * Comando 'crear tabla'
     */
    public static final String CMD_AYUDA = "ayuda";

    /**
     * Comando 'crear tabla'
     */
    public static final String CMD_SALIR = "salir";

    /**
     * Comando 'exportar datos a fichero'
     */
    public static final String CMD_EXPORTA = "exporta";

    /**
     * Comando 'ordenar tabla'
     */
    public static final String CMD_ORDENA = "ordena";

    /**
     * Tablas almacenadas por el usuario. La clave del Mapa pertenece al nombre
     * de la tabla.
     */
    private Map<String, Tabla> tablas;

    /**
     * El interfaz de usuario del programa
     */
    private InterfazUsuario iu;

    /**
     * Constructor sin argumentos que crea un nuevo mapa vacío
     */
    public Controlador() {
        throw new UnsupportedOperationException("Controlador::Controlador() no implementado.");
    }
    
    /**
     * Asigna valor a atributo iu
     *
     * @param iu el nuevo valor de atributo iu
     */
    public void setIu(InterfazUsuario iu) {
        throw new UnsupportedOperationException("Controlador::setIu(iu) no implementado.");
    }

    /**
     * <p>
     * Gestiona el comando 'crea', que se encarga de crear una tabla nueva con
     * un esquema dado.</p>
     * <p>
     * Crea una tabla dado un nombre y un esquema, y la guarda en el sistema. Si
     * ya existe una tabla con dicho nombre, no la creará y ordenará al interfaz
     * de usuario que presente un mensaje de error por pantalla. Hará lo mismo
     * si el formato del comando es erróneo (el número de palabras es menor que
     * 3).</p>
     *
     * <p>
     * Formato:
     * <code>alumnos crea nombre apellidos *dni año_nacimiento</code></p>
     *
     * <p>
     * Se debe considerar que las claves precedidas por el carácter
     * {@link #SIMB_CLAVE_ÚNICA} son claves únicas (es decir, su valor no puede
     * estar repetido en la tabla)</p>
     *
     * <p>
     * Si el usuario no introduce al menos una clave para la tabla, el sistema
     * muestra el mensaje: <code>Error en formato del comando</code>.</p>
     *
     * <p>
     * Para facilitar la tarea, asumiremos que las claves del esquema son
     * cadenas alfanuméricas sin espacios en blanco</p>
     *
     *
     * @param palabras Array con las palabras pertenecientes a un comando, por
     * ejemplo: <code>{ "canciones", "crea", "artista", "título",
     *                 "duración" }</code>
     */
    public void crearTabla(String[] palabras) {
        throw new UnsupportedOperationException("Controlador::crearTabla(palabras) no implementado.");
    }

    /**
     * <p>
     * Gestiona el comando 'añadir'. Para la tabla especificada por el usuario,
     * añadiendo todos los pares clave-valor dentro de una
     * {@link FilaDatos}.</p>.
     * <p>
 Si hay un error de formato en el comando (el número de palabras es menor
 que 3), o la tabla no existe o ha ocurrido algún otro problema a la hora
 de anyadir los datos, se invocará al método println() del interfaz de
 usuario para presentar por pantalla un mensaje informativo.</p>
     *
     * <p>
     * Formato:
     * <code>nombreTabla anyadir clave1=valor1 ... claveN=valorN</code></p>
     *
     * <p>
     * Si el conjunto de pares clave-valor no es válido el sistema muestra el
     * mensaje <code>Error añadiendo datos</code>.</p>
     *
     * <p>
     * Para facilitar la tarea, asumiremos que los pares clave-valor son cadenas
     * alfanuméricas sin espacios en blanco</p>
     *
     * @param palabras Un array con las diferentes palabras que el usuario ha
     * introducido en la línea de comandos, que conforman la orden completa, por
     * ejemplo: <code>{ "coches", "anyadir", "matricula=1234GGD",
 "marca=Seat", "modelo=Ibiza", "año=2009" }</code>
     *
     */
    public void anyadir(String[] palabras) {
        throw new UnsupportedOperationException("Controlador::anyadir(palabras) no implementado.");
    }


    /**
     * Retorna una lista con los nombres de las claves de una tabla dada
     *
     * @param nombreTabla Nombre de la tabla
     * @return Una lista con las getCabeceras, o <code>null</code> si la tabla
     * no existe
     */
    public List<String> getCabeceras(String nombreTabla) {
        throw new UnsupportedOperationException("Controlador::getCabeceras(nombreTabla) no implementado.");
    }
    
    /**
     * <p>
     * Dado un array perteneciente a las palabras que acompañan a las órdenes
     * 'busca' o 'elimina', interpreta el tipo de criterio que acompañarían a
     * éstas (que coincidiría con el contenido de <code>palabras[2]</code>)</p>
     *
     * <p>
     * Si el número de <code>palabras</code> es menor a 3, devolvería
     * <code>null</code>.</p>
     *
     * <p>
     * El comando debe considerar el operador de criterio que el usuario
     * especifique: {@link #SIMB_IGUAL} o {@link #SIMB_CONTIENE}</p>
     *
     * <p>
     * Para facilitar la tarea, asumiremos que los criterios de búsqueda son
     * cadenas alfanuméricas sin espacios en blanco</p>
     *
     * @param palabras Array con las palabras pertenecientes a un comando, por
     * ejemplo: <code>{ "peliculas", "busca", "título#Padrino" }</code>
     * @return Una instancia de {@link Criterio} correspondiente a la
     * interpretación de <code>palabras[2]</code>.
     */
    public static Criterio interpretaCriterio(String[] palabras) {
        throw new UnsupportedOperationException("Controlador::interpretaCriterio(palabras) no implementado.");
    }

    /**
     * <p>
     * Gestiona el comando 'busca': para la tabla especificada por el usuario,
     * presenta por pantalla los detalles todas las filas que cumplan con el 
     * criterio definido en el comando, invocando al método 
     * {@link edu.upc.etsetb.poo.basededatos.iu.InterfazUsuario#presentaResultados(java.util.List, 
     * java.util.List) }.</p>
     *
     * <p>
     * Formato: <code>nombreTabla busca</code> ó
     * <code>nombretabla busca criterio=valorBuscado</code> (el valor de criterio debe a 
     * ser igual a valorBuscado) ó <code>nombreTabla busca criterio#valorBuscado</code> (el
     * valor de criterio debe contener a valorBuscado) o 
     * <code>nombreTabla busca criterio>valorBuscado</code> (el valor del criterio 
     * debe ser mayor que valorBuscado)  o 
     * <code>nombreTabla busca criterio<valorBuscado</code> (el valor del criterio 
     * debe ser menor que valorBuscado.</p>
     *
     * <p>
     * Si el usuario no introduce criterio, se mostrarán todas las filas de la
     * tabla.</p>
     *
     * <p>
     * Debe usarse el método auxiliar {@link #interpretaCriterio(String[])}</p>
     *
     * <p>
     * Para facilitar la tarea, asumiremos que los criterios son cadenas
     * alfanuméricas sin espacios en blanco</p>
     *
     * <p>
     * Si el usuario introduce un nombre de tabla que no existe, el método
     * mostrará el mensaje: <code>Tabla errónea</code></p>
     *
     * <p>
     * Las tablas se mostrarán con columnas de ancho fijo
     * ({@link #ANCHO_COLUMNA}) mostrando una cabecera y las diferentes filas.
     * Si el contenido de una columna no cabe en {@link #ANCHO_COLUMNA}, ésta se
     * cortará. Podéis usar el método
     * {@link InterfazUsuario#anchoFijo(String, int)}</p>
     * 
     * <p>Las tablas se mostrarán invocando al método 
     * {@link edu.upc.etsetb.poo.basededatos.iu.InterfazUsuario#presentaResultados(java.util.List, 
     * java.util.List) }</p>
     *
     * <p>
     * Ejemplo:</p>
     * <pre>COMANDO&gt; canciones busca título#Bulería
     * =================================================
     * |Artista        |Título         |Duración       |
     * -------------------------------------------------
     * |David Bisbal   |Bulería        |2:33           |
     * |Camarón de la I|Bulerías inédit|3:15           |
     * |Pericón de Cádi|Papas Aliñá (Bu|1:44           |
     * =================================================
     * </pre>
     *
     * @param palabras Un array con las diferentes palabras que el usuario ha
     * introducido en la línea de comandos, que conforman la orden completa, por
     * ejemplo: <code>{ "alumnos", "busca", "apellido=Pérez"}</code>
     * @return lista de filas de datos que cumplen el criterio o lista vacía 
     * si se intenta buscar en una tabla que NO existe
     */
    public List<FilaDatos> buscar(String[] palabras) {
        throw new UnsupportedOperationException("Controlador::buscar(palabras) no implementado.");
    }
    
    /**
     * <p>
     * Gestiona el comando 'elimina'. Para la tabla especificada por el usuario,
     * elimina todas las filas que cumplan con el criterio.</p>
     *
     * <p>
     * Elimina las filas de la tabla cuyo nombre está en
     * <code>palabras[0]</code> que cumplan el criterio especificado. Una vez
     * eliminadas ordenará al interfaz de usuario presentar un mensaje que
     * indique el número de filas eliminadas. Si la tabla no existe, ordenará al
     * interfaz de usuario presentar un mensaje que lo indique. Si el comando
     * tiene un error de formato (un criterio erróneo) ordenará al interfaz de
     * usuario presentar un mensaje que lo indique.</p>
     *
     * <p>
     * Formato: <code>nombreTabla elimina clave#valor</code> ó
     * <code>clave=valor</code></p>
     *
     * <p>
     * Si el usuario no introduce criterio, o éste es erróneo, muestra el
     * mensaje <code>Error en formato del comando</code>.</p>
     *
     * <p>
     * Puede usarse el método auxiliar {@link #interpretaCriterio(String[])}</p>
     *
     * <p>
     * Para facilitar la tarea, asumiremos que los criterios son cadenas
     * alfanuméricas sin espacios en blanco</p>
     *
     * @param palabras Un array con las diferentes palabras que el usuario ha
     * introducido en la línea de comandos, que conforman la orden completa, por
     * ejemplo: <code>{ "alumnos", "elimina", "apellido=garcia"}</code>
     * 
     * @return la lista de filas eliminadas si se ha eliminado alguna fila. Una 
     * lista vacía si hay un error en el formato del comando o si el comando 
     * contiene el nombre de una tabla que no existe
     */
    public List<FilaDatos> eliminar(String[] palabras) {
        throw new UnsupportedOperationException("Controlador::eliminar(palabras) no implementado.");
    }

    /**
     * <p>Gestiona el comando 'exporta': guarda en un archivo de disco (cuyo nombre se pasa como parámetro)
     * la secuencia de comandos (uno por línea) que generaría las tablas que hay en memoria, con su contenido actual.</p>
     * <p>Por ejemplo, si tuviéramos las siguientes tablas en memoria:</p>
     * <pre>
     * TABLA coches:
     * =================================================
     * |marca          |matricula      |modelo         |
     * -------------------------------------------------
     * |Ferrari        |1566GGH        |Testarrossa    |
     * |Ford           |4566GGH        |Escort         |
     * |Seat           |4456GVG        |Córdoba        |
     * =================================================
     *
     * TABLA multas:
     * =================================
     * |cuantía        |matricula      | (matricula, además, es clave única)
     * ---------------------------------
     * |101            |2345FXZ        |
     * |100            |B1234XD        |
     * |60             |B1234XD        |
     * =================================
     * </pre>
     * <p>Y se invocara el método <code>exporta("tablas.txt")</code>, se generaría un archivo de texto
     * llamado 'tablas.txt' cuyo contenido sería el siguiente:</p>
     * <pre>
 multas crea cuantía matricula
 multas anyade cuantía=101 matricula=2345FXZ
 multas anyade cuantía=100 matricula=B1234XD
 multas anyade cuantía=60 matricula=B1234XD
 coches crea marca *matricula modelo
 coches anyade marca=Ferrari matricula=1566GGH modelo=Testarrossa
 coches anyade marca=Ford matricula=4566GGH modelo=Escort
 coches anyade marca=Seat matricula=4456GVG modelo=Córdoba
 </pre>
     * @param archivo Nombre del archivo en el que se guardará el archivo de exportación
     */
    public void exporta(String archivo) {
        throw new UnsupportedOperationException("Controlador::exporta(archivo) no implementado.");
    }


    /**
     * <p>Ordena la tabla cuyo nombre coincide con <code>palabras[0]</code> según la clave cuyo nombre
     * coincide con <code>palabras[2]</code></p>
     *
     * <p>Por defecto se ordena en orden ascendente, pero si se pasa la palabra 'desc' dentro de
     * <code>palabras[3]</code>, se ordenan en orden descendente.</p>
     * 
     * <p>Si la tabla cuyo nombre se pasa en el array de Strings no existe, 
     * invocar al método iu.println() con el argumento "Error. Tabla inexistente"</p>
     * 
     *<p>Si la tabla cuyo nombre se pasa en el array de Strings existe pero en 
     * ella no existe la columna cuyo nombre se pasa en el array de Strings, 
     * invocar al método iu.println() con el argumento "Error. Columna inexistente "</p>
     * 
     * @param palabras Array con las palabras pertenecientes a un comando, por
     * ejemplo: <code>{ "peliculas", "ordena", "título" } o { "peliculas", "ordena", "año", "desc" }</code>
     */
    public void ordenar(String[] palabras) {
        throw new UnsupportedOperationException("Controlador::ordenar(palabras) no implementado.");
    }
}

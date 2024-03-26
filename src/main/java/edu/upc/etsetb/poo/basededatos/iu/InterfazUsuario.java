package edu.upc.etsetb.poo.basededatos.iu;

import java.util.List;
import edu.upc.etsetb.poo.basededatos.casosdeuso.Controlador;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;

/**
 * Clase que implementa la interfaz de usuario.
 * <p><b>ESTA CLASE SE OS DA HECHA. NO DEBÉIS MODIFICARLA</b></p>
 * <p><b>Cambios con respecto a v1</b></p>
 * <ul>
 *     <li><b>Procesado de comando Exporta</b></li>
 *     <li><b>Procesado del comando Ordena</b></li>
 *     <li><b>Entradas extra en la ayuda</b></li>
 * </ul>
 */
public class InterfazUsuario {

    /**
     * {@link Controlador} de la base de datos
     */
    private Controlador controlador;

    /**
     * Construye una Interfaz de Usuario para interactuar con el
     * {@link Controlador} de base de datos pasado por parámetro
     *
     * @param controlador {@link Controlador} de la base de datos
     */
    public InterfazUsuario(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * <p>
     * Muestra '<code>COMANDO&gt;</code>' y a continuación lee la línea
     * introducida por el usuario (puedes usar {@link Teclado#palabras()})) e
     * interpreta el comando que el usuario desea ejecutar (identificado por uno
     * de los valores de {@link Controlador#CMD_SALIR},
     * {@link Controlador#CMD_AYUDA}, {@link Controlador#CMD_CREA_TABLA}, {@link Controlador#CMD_BUSCA},
     * {@link Controlador#CMD_AÑADE} o {@link Controlador#CMD_ELIMINA}) y llama a los métodos
     * pertinentes.</p>
     *
     * <p>
     * Si el usuario introduce un comando no reconocido, mostrará:</p>
     * <pre>
     * Error! Comando no reconocido.
     * Escribe 'ayuda' para conocer la lista de comandos.
     * </pre>
     *
     * @return <code>true</code> si el comando introducido es
     * {@link Controlador#CMD_SALIR}, <code>false</code> en caso contrario.
     */
    public boolean procesaComando() {
        System.out.print("COMANDO> ");
        String[] cmd = Teclado.palabras();
        if (cmd.length > 0) {
            if (Controlador.CMD_SALIR.equals(cmd[0])) {
                return true;
            } else if (Controlador.CMD_AYUDA.equals(cmd[0])) {
                ayuda();
            } else if (Controlador.CMD_EXPORTA.equals(cmd[0])) {
                this.controlador.exporta(cmd[1]);
            } else if (cmd.length > 1) {
                switch (cmd[1]) {
                    case Controlador.CMD_CREA_TABLA:
                        this.controlador.crearTabla(cmd);
                        break;
                    case Controlador.CMD_BUSCA:
                        this.controlador.buscar(cmd);
                        break;
                    case Controlador.CMD_AÑADE:
                        this.controlador.anyadir(cmd);
                        break;
                    case Controlador.CMD_ELIMINA:
                        this.controlador.eliminar(cmd);
                        break;
                    case Controlador.CMD_ORDENA:
                        this.controlador.ordenar(cmd);
                        break;
                    default:
                        System.out.println("Error! Comando no reconocido.");
                        System.out.println("Escribe '" + Controlador.CMD_AYUDA + "' para conocer la lista de comandos.");
                }
            } else {
                System.out.println("Error! Comando no reconocido.");
                System.out.println("Escribe '" + Controlador.CMD_AYUDA + "' para conocer la lista de comandos.");
            }
        }
        return false;
    }

    /**
     * Muestra un carácter repetido <code>nVeces</code>
     *
     * @param c Carácter a mostrar
     * @param nVeces Número de veces a repetir
     */
    public static void repite(char c, int nVeces) {
        for (int i = 0; i < nVeces; i++) {
            System.out.print(c);
        }
    }

    /**
     * Muestra un <code>texto</code> con un <code>ancho</code> fijado.
     * <ul>
     * <li>Si la longitud del <code>texto</code> es menor al valor del parámetro
     * <code>ancho</code>, el texto se rellena con espacios en blanco.</li>
     * <li>Si la longitud del <code>texto</code> es mayor al valor del parámetro
     * <code>ancho</code>, el texto se corta.</li>
     * </ul>
     *
     * @param texto Texto a mostrar
     * @param ancho Ancho, en carácteres, del espacio que ocupará el texto.
     */
    public static void anchoFijo(String texto, int ancho) {
        if (texto == null) {
            repite(' ', ancho);
        } else if (texto.length() > ancho) {
            System.out.print(texto.substring(0, ancho));
        } else {
            System.out.print(texto);
            repite(' ', ancho - texto.length());
        }
    }

    /**
     * Método que presenta el texto pasado como argumento por pantalla seguido
     * de un salto de línea. Método que debe usarse para presentar cualquier
     * mensaje por pantalla. Ningún método de ninguna otra clase (y en concreto
     * de Controlador) debe presentar un mensaje por pantalla invocando a
     * System.out.println(...). En su lugar, debe invocarse a este método.
     *
     * @param texto el texto a mostrarse por pantalla
     */
    public void println(String texto) {
        System.out.println(texto);
    }

    /**
     * Método que presena en pantalla un salto de línea. 
     *
     */    
    public void println() {
        System.out.println();
    }
     
    /**
     * Método que presenta el texto pasado como argumento por pantalla. 
     * Método que debe usarse para presentar cualquier
     * mensaje por pantalla. Ningún método de ninguna otra clase (y en concreto
     * de Controlador) debe presentar un mensaje por pantalla invocando a
     * System.out.print(...). En su lugar, debe invocarse a este método.
     *
     * @param texto el texto a mostrarse por pantalla
     */
     public void print(String texto) {
        System.out.print(texto);
    } 
    
    /**
     * Muestra por pantalla la ayuda del programa. Por ejemplo:
     *
     * <pre>
     * Lista de comandos:
     * ayuda : esta ayuda
     * salir : salir del programa
     *
     * &lt;nombreTabla&gt; crea [ &lt;clave&gt; ]
     *
     * - Crea una nueva tabla llamada &lt;nombretabla&gt;, cuyo esquema está descrito por una sucesión de &lt;clave&gt;
     *   Ejemplo: coches crea matricula marca modelo año
     *
     * &lt;nombreTabla&gt; anyadir [ &lt;clave&gt;=&lt;valor&gt; ó *&lt;clave&gt;=&lt;valor&gt;
     *
     * - Añade una nueva fila a la tabla &lt;nombretabla&gt;, descrita por una sucesión de pares &lt;clave&gt;=&lt;valor&gt;
 Las claves cuyo nombre tiene delante asterisco '*' son claves únicas
 Ejemplo: coches anyadir matricula=12345XD marca=Seat modelo=Ibiza año=2000

 &lt;nombreTabla&gt; busca
     *
     * - Muestra TODOS los datos de la tabla
     *
     * &lt;nombreTabla&gt; busca &lt;clave&gt;=&lt;valor&gt; ó &lt;clave&gt;#&lt;valor&gt;
     *
     * - Busca filas según UN criterio especificado por una clave y un valor.
     *   El operador '=' indica que el valor debe ser IGUAL al valor de la columna identificada por &lt;clave&gt;
     *   El operador '=' indica que el valor debe estar CONTENIDO al valor de la columna identificada por &lt;clave&gt;
     *   Ejemplo: coches busca matricula#123 --&gt; devolverá todos los coches cuya matrícula contenga la sucesión de números '123'
     *   coches busca marca=Seat --&gt; devolverá todos los coches cuya marca sea exactamente igual a Seat
     *
     * &lt;nombreTabla&gt; elimina &lt;clave&gt;=&lt;valor&gt; ó &lt;clave&gt;#&lt;valor&gt;
     *
     * - Elimina filas según UN criterio especificado por una clave y un valor.
     *   El uso es análogo al del comando busca
     * </pre>
     */
    private void ayuda() {
        System.out.println("Lista de comandos:");
        System.out.println(Controlador.CMD_AYUDA + " : esta ayuda");
        System.out.println(Controlador.CMD_SALIR + " : salir del programa");
        System.out.println("\n<nombreTabla> " + Controlador.CMD_CREA_TABLA + " [ <clave> ]\n");
        System.out.println("\t- Crea una nueva tabla llamada <nombretabla>, cuyo esquema está descrito por una sucesión de <clave>");
        System.out.println("\t  Ejemplo: coches crea matricula marca modelo año");

        System.out.println("\n<nombreTabla> " + Controlador.CMD_AÑADE + " [ <clave>=<valor> ó *<clave>=<valor>\n");
        System.out.println("\t- Añade una nueva fila a la tabla <nombretabla>, descrita por una sucesión de pares <clave>=<valor>");
        System.out.println("\t  Las claves cuyo nombre tiene delante asterisco '*' son claves únicas");
        System.out.println("\t  Ejemplo: coches añade matricula=12345XD marca=Seat modelo=Ibiza año=2000");

        System.out.println("\n<nombreTabla> " + Controlador.CMD_BUSCA + "\n");
        System.out.println("\t- Muestra TODOS los datos de la tabla");

        System.out.println("\n<nombreTabla> " + Controlador.CMD_BUSCA + " <clave>=<valor> ó <clave>#<valor>\n");
        System.out.println("\t- Busca filas según UN criterio especificado por una clave y un valor.");
        System.out.println("\t  El operador '=' indica que el valor debe ser IGUAL al valor de la columna identificada por <clave>");
        System.out.println("\t  El operador '=' indica que el valor debe estar CONTENIDO al valor de la columna identificada por <clave>");
        System.out.println("\t  Ejemplo: coches busca matricula#123 --> devolverá todos los coches cuya matrícula contenga la sucesión de números '123'");
        System.out.println("\t           coches busca marca=Seat --> devolverá todos los coches cuya marca sea exactamente igual a Seat");

        System.out.println("\n<nombreTabla> " + Controlador.CMD_ELIMINA + " <clave>=<valor> ó <clave>#<valor>\n");
        System.out.println("\t- Elimina filas según UN criterio especificado por una clave y un valor.");
        System.out.println("\t  El uso es análogo al del comando " + Controlador.CMD_BUSCA);

        System.out.println("\n<nombreTabla> " + Controlador.CMD_ORDENA + " <clave> [ desc ]\n");
        System.out.println("\t- Ordena la tabla según el valor de la clave de cada fila.");
        System.out.println("\t- Si se proporciona el argumento 'desc', ordena en orden descendente. Si no, ascendente");

        System.out.println("\n" + Controlador.CMD_EXPORTA + "<nombreArchivo> : exporta el contenido de la base de datos a un archivo\n");
    }
    /**
     * Método que presenta por pantalla los resultados 
 en forma de una nombreTabla
     * 
     * @param cabecerasTabla una lista de las cabeceras de la tabla sobre la que 
     * se ha obtenido el resultado
     * @param result lista de objetos FilaDatos que contienen las filas del resultado
     */
    public void presentaResultados(List<String> cabecerasTabla, List<FilaDatos> result) {
        int anchoTabla = (Controlador.ANCHO_COLUMNA + 1) * cabecerasTabla.size() + 1;
        this.repite('=', anchoTabla);
        System.out.println();
        for (String cabecera : cabecerasTabla) {
            System.out.print("|");
            this.anchoFijo(cabecera, Controlador.ANCHO_COLUMNA);
        }
        System.out.println("|");
        this.repite('-', anchoTabla);
        System.out.println() ;
        for (FilaDatos fila : result) {
            for (String cabecera : cabecerasTabla) {
                System.out.print("|");
                this.anchoFijo(fila.get(cabecera), Controlador.ANCHO_COLUMNA);
            }
            System.out.println("|");
        }
        this.repite('=', anchoTabla);
        System.out.println() ;

    }
   
}

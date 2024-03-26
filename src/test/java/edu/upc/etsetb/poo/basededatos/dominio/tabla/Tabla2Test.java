/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.dominio.tabla;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.Criterio;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioContiene;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioIgual;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioMayorQue;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioMenorQue;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Clave;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.ClaveYaExisteException;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema;
import edu.upc.etsetb.poo.corrector.TestAll;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(MockitoJUnitRunner.class)
public class Tabla2Test extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    private FilaDatos[] filasCreadasArray = new FilaDatos[5];
    private Set<FilaDatos> filasCreadas = new HashSet<>();

    public Tabla2Test() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        System.out.println("\nCorrigiendo los métodos de Tabla:\n\t "
                + "public List<FilaDatos> busca(Criterio criterio).\n\t "
                + "public List<FilaDatos> elimina(Criterio criterio).");
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Tabla2");
        nota.put("Tabla2", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01_busca() {
        double valorTotal = 4.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        int numTests = 5;
        this.printlnAlways("\n\tTabla::busca(criterio). Valor: " + valorTotal);
        try {
            //Crear un Esquema
            Esquema esquema = this.createEsquema();
            //Crear la tabla con el esquema
            String nombre = "nombreTabla";
            Tabla instance = new Tabla(nombre, esquema);
            //Crear las filas y añadirlas a la tabla
            this.addFilasATabla(instance);
            //
            this.printlnAlways("\tTest 1: Se invoca con un argumento null. Debe "
                    + "devolver todas las filas de la tabla");
            List<FilaDatos> result = instance.busca(null);
            this.checkBuscaResultConNull(result, valorTotal / numTests);
            //
            this.printlnAlways("\tTest 2: Se invoca con un objeto CriterioIgual.");
            Criterio criterio = new CriterioIgual("nombreClave-1", "1.0");
            result = instance.busca(criterio);
            this.checkBuscaResultConIgual(result, valorTotal / numTests);
            //
            this.printlnAlways("\tTest 3: Se invoca con un objeto CriterioMayorQue.");
            criterio = new CriterioMayorQue("nombreClave-1", "10.0");
            result = instance.busca(criterio);
            this.checkBuscaResultConMayorQue(result, valorTotal / numTests);
            //
            this.printlnAlways("\tTest 4: Se invoca con un objeto CriterioMenorQue.");
            criterio = new CriterioMenorQue("nombreClave-1", "10.0");
            result = instance.busca(criterio);
            this.checkBuscaResultConMenorQue(result, valorTotal / numTests);
            //
            this.printlnAlways("\tTest 5: Se invoca con un objeto CriterioContiene.");
            criterio = new CriterioContiene("nombreClave-1", "6");
            result = instance.busca(criterio);
            this.checkBuscaResultConContiene(result, valorTotal / numTests);

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
    }

    @Test
    public void test02_elimina() {
        double valorTotal = 6.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        int numTests = 5;
        this.printlnAlways("\n\tTabla::elimina(criterio). Valor: " + valorTotal);
        try {
            //Crear un Esquema
            Esquema esquema = this.createEsquema();
            //Crear la tabla con el esquema
            String nombre = "nombreTabla";
            Tabla instance = new Tabla(nombre, esquema);
            //Crear las filas y añadirlas a la tabla
            this.addFilasATabla(instance);
            //
            this.printlnAlways("\tTest 1: Se invoca con un argumento null. Debe "
                    + "devolver una lista vacía y dejar la lista de filas de la "
                    + "tabla inalterada");
            List<FilaDatos> result = instance.elimina(null);
            this.checkEliminaResultConNull(instance, result, valorTotal / numTests);
            //
            this.printlnAlways("\tTest 2: Se invoca con un argumento CriterioIgual. ");
            instance = new Tabla(nombre, esquema);
            this.addFilasATabla(instance);
            Criterio criterio = new CriterioIgual("nombreClave-1", "1.0");
            result = instance.elimina(criterio);
            this.checkEliminaResultConIgual(instance, result, valorTotal / numTests);
            //
            this.printlnAlways("\tTest 3: Se invoca con un argumento CriterioMayorQue. ");
            instance = new Tabla(nombre, esquema);
            this.addFilasATabla(instance);
            criterio = new CriterioMayorQue("nombreClave-1", "1.0");
            result = instance.elimina(criterio);
            this.checkEliminaResultConMayorQue(instance, result, valorTotal / numTests);
            //
            this.printlnAlways("\tTest 4: Se invoca con un argumento CriterioMenorQue. ");
            instance = new Tabla(nombre, esquema);
            this.addFilasATabla(instance);
            criterio = new CriterioMenorQue("nombreClave-1", "10.0");
            result = instance.elimina(criterio);
            this.checkEliminaResultConMenorQue(instance, result, valorTotal / numTests);
            //
            this.printlnAlways("\tTest 4: Se invoca con un argumento CriterioContiene. ");
            instance = new Tabla(nombre, esquema);
            this.addFilasATabla(instance);
            criterio = new CriterioContiene("nombreClave-1", "6");
            result = instance.elimina(criterio);
            this.checkEliminaResultConContiene(instance, result, valorTotal / numTests);

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        this.acumula(puntos);
        puntos(puntosAntes);
    }

    private void checkEliminaResultConNull(Tabla instance, List<FilaDatos> result, double val) {
        AssertionError error = null;
        AssertionError toThrow = null;
        //Comprobar lista devuelta
        error = this.sAssertEquals(0, result.size(), val / 2, "Error. "
                + "La lista devuelta debería estar vacía; sin embargo tiene "
                + result.size() + " filas");
        this.toThrow(error, toThrow);
        //Comprobar listas que quedan en tabla
        error = this.sAssertEquals(this.filasCreadas,
                new HashSet<>(instance.buscaTodo()), val / 2, "Error. "
                + "La lista de filas de la tabla debería haber permanecido "
                + "inalterada; sin embargo no ha sido así");
    }

    private void checkEliminaResultConIgual(Tabla instance, List<FilaDatos> result, double val) {
        AssertionError error = null;
        AssertionError toThrow = null;
        Set<FilaDatos> returnedExpected = new HashSet<>();
        returnedExpected.add(this.filasCreadasArray[4]);
        returnedExpected.add(this.filasCreadasArray[0]);
        //Comprobar lista devuelta
        error = this.sAssertEquals(returnedExpected, new HashSet(result), val / 2, "Error. "
                + "La lista devuelta no contiene las filas esperadas");
        this.toThrow(error, toThrow);

        //Comprobar listas que quedan en tabla
        Set<FilaDatos> remainingExpected = new HashSet<>();
        remainingExpected.add(this.filasCreadasArray[1]);
        remainingExpected.add(this.filasCreadasArray[2]);
        remainingExpected.add(this.filasCreadasArray[3]);
        //
        error = this.sAssertEquals(remainingExpected, new HashSet(instance.buscaTodo()), val / 2, "Error. "
                + "La tabla no ha quedado con las filas esperadas");
        this.toThrow(error, toThrow);
    }

    private void checkEliminaResultConMayorQue(Tabla instance, List<FilaDatos> result, double val) {
        AssertionError error = null;
        AssertionError toThrow = null;
        Set<FilaDatos> returnedExpected = new HashSet<>();
        returnedExpected.add(this.filasCreadasArray[1]);
        returnedExpected.add(this.filasCreadasArray[2]);
        returnedExpected.add(this.filasCreadasArray[3]);
        //Comprobar lista devuelta
        error = this.sAssertEquals(returnedExpected, new HashSet(result), val / 2, "Error. "
                + "La lista devuelta no contiene las filas esperadas");
        this.toThrow(error, toThrow);

        //Comprobar listas que quedan en tabla

        Set<FilaDatos> remainingExpected = new HashSet<>();
        remainingExpected.add(this.filasCreadasArray[4]);
        remainingExpected.add(this.filasCreadasArray[0]);
        //
        error = this.sAssertEquals(remainingExpected, new HashSet(instance.buscaTodo()), val / 2, "Error. "
                + "La tabla no ha quedado con las filas esperadas");
        this.toThrow(error, toThrow);
    }

    private void checkEliminaResultConMenorQue(Tabla instance, List<FilaDatos> result, double val) {
        AssertionError error = null;
        AssertionError toThrow = null;
        Set<FilaDatos> returnedExpected = new HashSet<>();
        returnedExpected.add(this.filasCreadasArray[0]);
        returnedExpected.add(this.filasCreadasArray[1]);
        returnedExpected.add(this.filasCreadasArray[4]);
        //Comprobar lista devuelta
        error = this.sAssertEquals(returnedExpected, new HashSet(result), val / 2, "Error. "
                + "La lista devuelta no contiene las filas esperadas");
        this.toThrow(error, toThrow);

        //Comprobar listas que quedan en tabla

        Set<FilaDatos> remainingExpected = new HashSet<>();
        remainingExpected.add(this.filasCreadasArray[2]);
        remainingExpected.add(this.filasCreadasArray[3]);
        //
        error = this.sAssertEquals(remainingExpected, new HashSet(instance.buscaTodo()), val / 2, "Error. "
                + "La tabla no ha quedado con las filas esperadas");
        this.toThrow(error, toThrow);
    }

    private void checkEliminaResultConContiene(Tabla instance,List<FilaDatos> result, double val) {
        AssertionError error = null;
        AssertionError toThrow = null;
        Set<FilaDatos> returnedExpected = new HashSet<>();
        returnedExpected.add(this.filasCreadasArray[1]);
        returnedExpected.add(this.filasCreadasArray[3]);
        //Comprobar lista devuelta
        error = this.sAssertEquals(returnedExpected, new HashSet(result), val / 2, "Error. "
                + "La lista devuelta no contiene las filas esperadas");
        this.toThrow(error, toThrow);

        //Comprobar listas que quedan en tabla

        Set<FilaDatos> remainingExpected = new HashSet<>();
        remainingExpected.add(this.filasCreadasArray[0]);
        remainingExpected.add(this.filasCreadasArray[2]);
        remainingExpected.add(this.filasCreadasArray[4]);
        //
        error = this.sAssertEquals(remainingExpected, new HashSet(instance.buscaTodo()), val / 2, "Error. "
                + "La tabla no ha quedado con las filas esperadas");
        this.toThrow(error, toThrow);
    }

    private void checkBuscaResultConContiene(List<FilaDatos> result, double val) {
        AssertionError toThrow = null;
        Set<FilaDatos> expected = new HashSet<>();
        expected.add(this.filasCreadasArray[3]);
        expected.add(this.filasCreadasArray[1]);
        try {
            Set<FilaDatos> setDevuelto = new HashSet<>(result);
            AssertionError error = this.sAssertEquals(expected, setDevuelto, val, "Error. "
                    + "El método NO ha devuelto la lista de filas que debería  "
                    + "haber devuelto");
            this.toThrow(error, toThrow);

        } catch (Exception ex) {
            this.printlnAlways("*** Consulta con profesor. El corrector "
                    + "ha lanzado una excepción que no debería haber lanzado");
            this.printStackTraceUpc(ex);
        }
    }

    private void checkBuscaResultConMenorQue(List<FilaDatos> result, double val) {
        AssertionError toThrow = null;
        Set<FilaDatos> expected = new HashSet<>();
        expected.add(this.filasCreadasArray[0]);
        expected.add(this.filasCreadasArray[1]);
        expected.add(this.filasCreadasArray[4]);
        try {
            Set<FilaDatos> setDevuelto = new HashSet<>(result);
            AssertionError error = this.sAssertEquals(expected, setDevuelto, val, "Error. "
                    + "El método NO ha devuelto la lista de filas que debería  "
                    + "haber devuelto");
            this.toThrow(error, toThrow);

        } catch (Exception ex) {
            this.printlnAlways("*** Consulta con profesor. El corrector "
                    + "ha lanzado una excepción que no debería haber lanzado");
            this.printStackTraceUpc(ex);
        }
    }

    private void checkBuscaResultConMayorQue(List<FilaDatos> result, double val) {
        AssertionError toThrow = null;
        Set<FilaDatos> expected = new HashSet<>();
        expected.add(this.filasCreadasArray[3]);
        expected.add(this.filasCreadasArray[2]);
        try {
            Set<FilaDatos> setDevuelto = new HashSet<>(result);
            AssertionError error = this.sAssertEquals(expected, setDevuelto, val, "Error. "
                    + "El método NO ha devuelto la lista de filas que debería  "
                    + "haber devuelto");
            this.toThrow(error, toThrow);

        } catch (Exception ex) {
            this.printlnAlways("*** Consulta con profesor. El corrector "
                    + "ha lanzado una excepción que no debería haber lanzado");
            this.printStackTraceUpc(ex);
        }
    }

    private void checkBuscaResultConIgual(List<FilaDatos> result, double val) {
        AssertionError toThrow = null;
        Set<FilaDatos> expected = new HashSet<>();
        expected.add(this.filasCreadasArray[0]);
        expected.add(this.filasCreadasArray[4]);
        try {
            Set<FilaDatos> setDevuelto = new HashSet<>(result);
            AssertionError error = this.sAssertEquals(expected, setDevuelto, val, "Error. "
                    + "El método NO ha devuelto la lista de filas que debería  "
                    + "haber devuelto");
            this.toThrow(error, toThrow);

        } catch (Exception ex) {
            this.printlnAlways("*** Consulta con profesor. El corrector "
                    + "ha lanzado una excepción que no debería haber lanzado");
            this.printStackTraceUpc(ex);
        }
    }

    private void checkBuscaResultConNull(List<FilaDatos> result, double val) {
        AssertionError toThrow = null;
        try {
            Set<FilaDatos> setDevuelto = new HashSet<>(result);
            AssertionError error = this.sAssertEquals(this.filasCreadas, setDevuelto, val, "Error. "
                    + "El método NO ha devuelto una lista con todas las filas "
                    + "de la tabla");
            this.toThrow(error, toThrow);

        } catch (Exception ex) {
            this.printlnAlways("*** Consulta con profesor. El corrector "
                    + "ha lanzado una excepción que no debería haber lanzado");
            this.printStackTraceUpc(ex);
        }
    }

    private void addFilasATabla(Tabla instance) {
        List<FilaDatos> filas = this.createFilasDatos();
        int j = 0;
        for (FilaDatos fila : filas) {
            try {
                instance.anyade(fila);
                this.filasCreadas.add(fila);
                this.filasCreadasArray[j] = fila;
                j++;
            } catch (ValorClaveUnicaException | ClaveInexistenteException ex) {
                System.out.println("Contacta con el profesorado. El "
                        + "corrector ha generado una fila de datos inválida cuando "
                        + "debería haberla generado válida. Excepción lanzada: "
                        + ex.getClass().getSimpleName());
            }
        }
        FilaDatos fila = new FilaDatos();
        double valor = 1;
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                fila.put("nombreClave-" + (i + 1), "37");
            } else {
                fila.put("nombreClave-" + (i + 1), String.valueOf(valor));
            }
        }
        valor = valor + 1.0;
        this.filasCreadas.add(fila);
        this.filasCreadasArray[j] = fila;

        try {
            instance.anyade(fila);
        } catch (ValorClaveUnicaException | ClaveInexistenteException ex) {
            System.out.println("Contacta con el profesorado. El "
                    + "corrector ha generado una fila de datos inválida cuando "
                    + "debería haberla generado válida. Excepción lanzada: "
                    + ex.getClass().getSimpleName());
        }
    }

    private Esquema createEsquema() {
        Esquema esquema = new Esquema();
        Clave clave = null;
        try {
            for (int i = 0; i < 5; i++) {
                if (i != 3) {
                    clave = new Clave("nombreClave-" + (i + 1), false);
                } else {
                    clave = new Clave("nombreClave-" + (i + 1), true);
                }
                esquema.addClave(clave);
            }
        } catch (ClaveYaExisteException ex) {
            this.printlnAlways("\n\tError al crear el esquema. No debería darse si el corrector "
                    + "ha otorgado las máximas puntuaciones en las clases Clave, Esquema y "
                    + "se han creado correctamente las clases BaseDatosException, "
                    + "ClaveYaExisteException, ClaveInexistenteException. Si todas estas "
                    + "condiciones se dan, consulta con el profesorado");
            return null;
        }
        return esquema;
    }

    private List<FilaDatos> createFilasDatos() {
        List<FilaDatos> result = new ArrayList<>();
        double valor = 1.0;
        for (int j = 0; j < 4; j++) {
            FilaDatos fila = new FilaDatos();
            for (int i = 0; i < 5; i++) {
                fila.put("nombreClave-" + (i + 1), String.valueOf(valor));
                valor = valor + 1.0;
            }
            result.add(fila);
        }
        return result;
    }
}

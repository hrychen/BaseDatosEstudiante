/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.dominio.tabla;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Clave;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.ClaveYaExisteException;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema;
import edu.upc.etsetb.poo.corrector.TestAll;
import java.util.Map;
import java.util.Optional;
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
public class FilaDatosTest extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public FilaDatosTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        System.out.println("\nCorrigiendo clase FilaDatos");
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "FilaDatos");
        nota.put("FilaDatos", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01_Constructor() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 2.0;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE

        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            this.printlnAlways("\n\tFilaDatos::FilaDatos(). Valor: " + valorTotal);
            FilaDatos instance = new FilaDatos();
            error = this.checkPrivateFieldExists(instance, "clavesValor", valorTotal / 2, toThrow);
            toThrow(error, toThrow);
            Optional<Object> camposVal = this.getPrivateFieldValue(instance, "clavesValor");
            if (camposVal.isPresent()) {
                error = this.checkPrivateFieldIsOfASpecificClass(instance,
                        "clavesValor", Map.class, valorTotal / 2, toThrow);
                toThrow(error, toThrow);
            }
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
    public void test02_put() {
        double valorTotal = 1.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tFilaDatos::put(nombreClave,valor). Valor: " + valorTotal);
        //
        try {
            String nombre = "nombreClave";
            String valor = "valor";
            FilaDatos instance = new FilaDatos();
            instance.put(nombre, valor);
            Optional<Object> clavesValorOpt = this.getPrivateFieldValue(instance, "clavesValor");
            if (clavesValorOpt.isPresent()) {
                Map<String, String> clavesValor = (Map<String, String>) clavesValorOpt.get();
                error = this.sAssertTrue(clavesValor.containsKey("nombreClave"), valorTotal / 2, "Error: debería "
                        + "haberse añadido un par <clave valor>, pero no se ha "
                        + "encontrado ningún par con la clave correcta");
                toThrow(error, toThrow);
                if (error == null) {
                    String retrieved = clavesValor.get("nombreClave");
                    error = this.sAssertEquals(valor, retrieved,
                            valorTotal / 2, "se ha añadido un par <clave,valor> pero"
                            + "el par añadido no es el que se pretendía añadir");
                    toThrow(error, toThrow);
                }
            }

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        this.acumula(puntos);
        puntos(puntosAntes);
    }

    @Test
    public void test03_get() {
        double valorTotal = 1.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tEsquema::get(nombreClave). Valor: " + valorTotal);
        //
        try {
            String nombre = "nombreClave";
            String valor = "valorDeClave";
            FilaDatos instance = new FilaDatos();
            instance.put(nombre, valor);
            String returned = instance.get(nombre);
            this.printlnAlways("\tTest 1: se invoca a get con el nombre de una clave que está en "
                    + "el objeto FilaDatos");
            error = this.sAssertEquals(valor, returned, valorTotal / 2,
                    "Error: Se ha mapeado el nombre \'nombreClave\' al valor \'valorDeClave\', pero "
                    + "el método ha devuelto como valor \'" + returned + "\'");
            toThrow(error, toThrow);
            this.printlnAlways("\tTest 2: se invoca a get con el nombre de una clave que NO está en "
                    + "el objeto FilaDatos");
            returned = instance.get("otroNombreClave");
            error = this.sAssertEquals(null, returned, valorTotal / 2,
                    "Error: Se ha mapeado el nombre \'nombreClave\' al valor \'valorDeClave\'; se "
                    + "ha invocado al get con \'otroNombreClave\', y sin embargo, el método ha "
                    + "devuelto una referencia NO NULA!!!");
            toThrow(error, toThrow);

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        this.acumula(puntos);
        puntos(puntosAntes);
    }

    @Test
    public void test04_valida() {
        double valorTotal = 6.0;
        int numTests = 6;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tFilaDatos::valida(esquema). Valor: " + valorTotal);
        //
        try {
            this.printlnAlways("\tTest 1: Esquema y FilaDatos vacíos");
            Esquema esquema = new Esquema();
            FilaDatos instance = new FilaDatos();
            try {
                instance.valida(esquema);
                this.sAssertTrue(true, valorTotal / numTests, "");
            } catch (Exception ex) {
                error = this.sAssertTrue(false, valorTotal / numTests, "Error: "
                        + "la fila está vacía y el esquema también. No debería "
                        + "haberse lanzado ninguna excepción, y sin embargo, se "
                        + "ha lanzado");
                toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\tTest 2: Esquema vacío y fila NO vacía");
            instance.put("clave1", "valor1");
            try {
                instance.valida(esquema);
                this.sAssertTrue(false, valorTotal / numTests, "Error: "
                        + "la fila NO está vacía pero el esquema lo está. Debería "
                        + "haberse lanzado ninguna excepción, y sin embargo, NO se "
                        + "ha lanzado");
                toThrow(error, toThrow);
            } catch (Exception ex) {
                if (ex instanceof ClaveInexistenteException) {
                    error = this.sAssertTrue(true, valorTotal / numTests, "");
                }
            }
            //
            this.printlnAlways("\tTest 3: Esquema NO vacío y fila vacía");
            instance = new FilaDatos();
            Clave clave1 = new Clave("nClave1");
            esquema.addClave(clave1);
            try {
                instance.valida(esquema);
                this.sAssertTrue(false, valorTotal / numTests, "Error: "
                        + "la fila  está vacía pero el esquema NO lo está. Debería "
                        + "haberse lanzado ninguna excepción, y sin embargo, NO se "
                        + "ha lanzado");
                toThrow(error, toThrow);
            } catch (Exception ex) {
                if (ex instanceof ClaveInexistenteException) {
                    error = this.sAssertTrue(true, valorTotal / numTests, "");
                }
            }
            //
            this.printlnAlways("\tTest 4: Esquema NO vacío y fila NO vacía Y diferentes tamaños");
            esquema = this.createEsquema();
            if (esquema != null) {
                instance = this.createFilaDatosNoValidaPorTamanyo();
                try {
                    instance.valida(esquema);
                    error = this.sAssertTrue(false, valorTotal / numTests, "Error: "
                            + "la fila generada NO es válida con respecto al esquema "
                            + "también creado, pero el método NO ha lanzado ninguna "
                            + "excepción instancia de ClaveInexistenteException");
                } catch (Exception ex) {
                    if (ex instanceof ClaveInexistenteException) {
                        error = this.sAssertTrue(true, valorTotal / numTests, "");
                        toThrow(error, toThrow);
                    } else {
                        error = this.sAssertTrue(false, valorTotal, "Error: "
                                + "la fila generada es NO válida con respecto al esquema "
                                + "también creado, pero el método ha lanzado una "
                                + "excepción que NO es instancia de ClaveInexistenteException, "
                                + "sino de la clase " + ex.getClass().getSimpleName());
                        toThrow(error, toThrow);
                    }
                }
            }
            //
            this.printlnAlways("\tTest 5: Esquema NO vacío y fila NO vacía E IGUALES tamaños "
                    + "pero hay una clave que NO está en el esquema");
            esquema = this.createEsquema();
            if (esquema != null) {
                instance = this.createFilaDatosNoValidaPorClave();
                try {
                    instance.valida(esquema);
                    error = this.sAssertTrue(false, valorTotal / numTests, "Error: "
                            + "la fila generada NO es válida con respecto al esquema "
                            + "también creado, pero el método NO ha lanzado ninguna "
                            + "excepción instancia de ClaveInexistenteException");
                } catch (Exception ex) {
                    if (ex instanceof ClaveInexistenteException) {
                        error = this.sAssertTrue(true, valorTotal / numTests, "");
                        toThrow(error, toThrow);
                    } else {
                        error = this.sAssertTrue(false, valorTotal, "Error: "
                                + "la fila generada es NO válida con respecto al esquema "
                                + "también creado, pero el método ha lanzado una "
                                + "excepción que NO es instancia de ClaveInexistenteException, "
                                + "sino de la clase " + ex.getClass().getSimpleName());
                        toThrow(error, toThrow);
                    }
                }
            }
            //
            this.printlnAlways("\tTest 6: Esquema NO vacío y fila NO vacía Y VÁLIDA");
            esquema = this.createEsquema();
            if (esquema != null) {
                instance = this.createFilaDatosValida();
                try {
                    instance.valida(esquema);
                    error = this.sAssertTrue(true, valorTotal / numTests, "");
                } catch (Exception ex) {
                    if (ex instanceof ClaveInexistenteException) {
                        error = this.sAssertTrue(false, valorTotal / numTests, "Error: "
                                + "la fila generada es válida con respecto al esquema "
                                + "también creado, pero el método ha lanzado una "
                                + "excepción instancia de ClaveInexistenteException");
                        toThrow(error, toThrow);
                    } else {
                        error = this.sAssertTrue(false, valorTotal / numTests, "Error: "
                                + "la fila generada es válida con respecto al esquema "
                                + "también creado, pero el método ha lanzado una "
                                + "excepción que NO es instancia de ClaveInexistenteException, "
                                + "sino de la clase " + ex.getClass().getSimpleName());
                        toThrow(error, toThrow);
                    }
                }
            }

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        this.acumula(puntos);
        puntos(puntosAntes);
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

    private FilaDatos createFilaDatosValida() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 5; i++) {
            fila.put("nombreClave-" + (i + 1), "valor-" + (i + 1));
        }
        return fila;
    }

    private FilaDatos createFilaDatosNoValidaPorTamanyo() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 4; i++) {
            fila.put("nombreClave-" + (i + 1), "valor-" + (i + 1));
        }
        return fila;
    }

    private FilaDatos createFilaDatosNoValidaPorClave() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 5; i++) {
            if (i < 4) {
                fila.put("nombreClave-" + (i + 1), "valor-" + (i + 1));
            } else {
                fila.put("malNombreClave", "valor-" + (i + 1));
            }
        }
        return fila;
    }

}

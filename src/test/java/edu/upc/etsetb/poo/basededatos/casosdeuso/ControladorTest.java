/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.casosdeuso;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.Criterio;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioContiene;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioIgual;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioMayorQue;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioMenorQue;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Clave;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla;
import edu.upc.etsetb.poo.basededatos.iu.InterfazUsuario;
import edu.upc.etsetb.poo.basededatos.iu.InterfazUsuarioParaCorrector;
import edu.upc.etsetb.poo.corrector.TestAll;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
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
public class ControladorTest extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    private static String[][] matrizDatosCoches = {
        {"marca", "Seat", "modelo", "Ibiza", "matricula", "B1234XD"},
        {"marca", "Seat", "modelo", "Córdoba", "matricula", "4456GVG"},
        {"marca", "Ford", "modelo", "Fiesta", "matricula", "2345FXZ"},
        {"marca", "Ferrari", "modelo", "Testarrossa", "matricula", "1566GGH"},
        {"marca", "Ford", "modelo", "Escort", "matricula", "4566GGH"},};

    private static String[][] matrizDatosMultas = {
        {"matricula", "B1234XD", "cuantía", "100"},
        {"matricula", "2345FXZ", "cuantía", "101"},
        {"matricula", "B1234XD", "cuantía", "60"},
        {"matricula", "1566GGH", "cuantía", "100"},};

    private Tabla tablaCoches;
    private Tabla tablaMultas;
    private List<FilaDatos> filasTablaCoches = new ArrayList<>();
    private List<FilaDatos> filasTablaMultas = new ArrayList<>();

    public ControladorTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        System.out.println("\nCorrigiendo clase Controlador.");
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Controlador");
        nota.put("Controlador", puntosTotales);
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
        double valorTotal = 0.25;
        int numTests = 6;
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
            this.printlnAlways("\n\tControlador::Controlador(nombre,esquema). Valor: " + valorTotal);
            Controlador instance = new Controlador();
            double individualVal = valorTotal / numTests;
            double individualPer = valorTotal / numTests;
            //Comprobar atributo 'nombre'
            this.printlnAlways("\tTest 1: comprobación de que el atributo \'iu\' existe");
            error = this.checkPrivateFieldExists(instance, "iu",
                    individualVal, null);
            toThrow = toThrow(error, toThrow);
            if (error == null) {
                this.printlnAlways("\tTest 2: comprobación de que el atributo \'iu\' tiene un valor null");
                Optional<Object> attrValOpt = this.getPrivateFieldValue(instance, "iu");
                if (!attrValOpt.isPresent()) {
                    this.sAssertTrue(true, individualVal, "");
                } else {
                    error = this.sAssertTrue(false, 0, "Error. El "
                            + "atributo \'iu\' tiene un valor distinto de null");
                    toThrow = toThrow(error, toThrow);
                }
            }
            //Comprobar atributo 'tablas'
            // . Comprobar que existe
            this.printlnAlways("\tTest 3: comprobación de que el atributo \'tablas\' existe");
            error = this.checkPrivateFieldExists(instance, "tablas", individualVal, toThrow);
            toThrow(error, toThrow);
            Optional<Field> fieldOpt = this.getPrivateField(instance, "tablas");
            if (fieldOpt.isPresent()) {
                // . Comprobar que es una lista
                this.printlnAlways("\tTest 4: comprobación de que el atributo \'tablas\' es un mapa");
                error = this.checkPrivateFieldIsOfASpecificClass(instance,
                        "tablas", Map.class, individualVal, toThrow);
                toThrow(error, toThrow);
                // . Comprobar que es una lista vacía
                if (error == null) {
                    Optional<Object> fieldValOpt = this.getPrivateFieldValue(instance, "tablas");
                    this.printlnAlways("\tTest 5: comprobación de que el valor de \'tablas\' NO es null");
                    error = this.sAssertTrue(fieldValOpt.isPresent(), individualVal,
                            "Error. El atributo \'tablas\' debe NO tener un valor null, "
                            + "pero lo tiene");
                    toThrow(error, toThrow);
                    if (error == null) {
                        this.printlnAlways("\tTest 6: comprobación de que el mapa \'tablas\' está vació");
                        error = this.sAssertTrue(((Map) fieldValOpt.get()).size() == 0, individualVal,
                                "Error. El atributo \'tablas\' debe ser un mapa vacío, "
                                + "pero NO lo está");
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
        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
    }

    @Test
    public void test02_setIu() {
        double valorTotal = 0.25;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        int numTests = 1;
        //
        this.printlnAlways("\n\tControlador::setIu(iu). Valor: " + valorTotal);
        try {
            Controlador instance = new Controlador();
            InterfazUsuario expectedIu = new InterfazUsuario(instance);
            instance.setIu(expectedIu);
            Optional<Object> retrievedIu = this.getPrivateFieldValue(instance, "iu");
            if (retrievedIu.isPresent()) {
                error = this.sAssertEquals(expectedIu, retrievedIu.get(),
                        valorTotal, "Error. El valor del atributo "
                        + "\'iu\' no es el que se pasó como argumento");
                this.toThrow(error, toThrow);
            } else {
                error = this.sAssertTrue(false, 0, "Error. El valor "
                        + "del atributo \'iu\' es null después de invocar al "
                        + "método pasándole una referencia no null");
                this.toThrow(error, toThrow);
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
    public void test03_creaTabla() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.5;
        int numTests = 14;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tControlador::creaTabla(). Valor: " + valorTotal);
        try {
            Controlador instance = new Controlador();
            InterfazUsuarioParaCorrector iu = new InterfazUsuarioParaCorrector(instance);
            this.setPrivateField(instance, "iu", iu);
            String comando;
            //
            //Comando de menos de 3 palabras
            this.printlnAlways("\tTest 1: comando de menos de 3 palabras");
            comando = "coches crea";
            //
            instance.crearTabla(comando.split(" "));
            //
            //Comprobando que se ha intentado escribir un mensaje a través de iu
            error = this.sAssertFalse(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método debería haber "
                    + "enviado un mensaje a iu, pero no lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobando que NO se ha creado ninguna tabla
            Map<String, Tabla> tablas = this.getTablas(instance);
            error = this.sAssertEquals(0, tablas.size(),
                    valorTotal / numTests, "Error. El controlador NO debería "
                    + "haber creado ninguna tabla, pero ha creado alguna.");
            this.toThrow(error, toThrow);

            //Se pasan dos claves iguales. Lanzamiento y recogida de ClaveYaExisteException
            this.printlnAlways("\tTest 2: comando con dos claves idénticas");
            comando = "coches crea marca marca *matricula";
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            this.setPrivateField(instance, "iu", iu);
            //
            instance.crearTabla(comando.split(" "));
            //
            //Comprobando que se ha intentado escribir un mensaje a través de iu
            error = this.sAssertFalse(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método debería haber "
                    + "enviado un mensaje a iu, pero no lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobando que se ha creado la tabla
            tablas = this.getTablas(instance);
            error = this.sAssertEquals(1, tablas.size(),
                    valorTotal / numTests, "Error. El controlador debería "
                    + "haber creado la tabla, pero NO ha creado alguna.");
            this.toThrow(error, toThrow);
            //
            // Se intenta crear una tabla con un nombre ya asociado a otra tabla. 
            // Mensaje de advertencia. No se genera tabla
            this.printlnAlways("\tTest 3: tabla con nombre ya asociado a otra tabla existente");
            //
            comando = "coches crea marca modelo *matricula";
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            //
            instance.crearTabla(comando.split(" "));
            //
            error = this.sAssertFalse(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método debería haber "
                    + "enviado un mensaje a iu, pero no lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobando que NO se ha creado ninguna tabla
            tablas = this.getTablas(instance);
            error = this.sAssertEquals(1, tablas.size(),
                    valorTotal / numTests, "Error. El controlador NO debería "
                    + "haber creado ninguna tabla, pero ha creado alguna.");
            this.toThrow(error, toThrow);

            //
            //Comando sin problemas. se crea la tabla y se añade
            this.printlnAlways("\tTest 4: comando correcto");
            comando = "libros crea *ISBN Titulo Autores";
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            //
            instance.crearTabla(comando.split(" "));
            //
            error = this.sAssertTrue(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método NO debería haber "
                    + "enviado ningún mensaje a iu, pero lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobando que se ha creado ninguna tabla
            tablas = this.getTablas(instance);
            error = this.sAssertEquals(2, tablas.size(),
                    valorTotal / numTests, "Error. El controlador debería "
                    + "haber creado una tabla, pero NO ha creado ninguna.");
            this.toThrow(error, toThrow);
            if (error == null) {
                this.comprobarTablaDeLibrosCreada(tablas, valorTotal / numTests, instance);
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
    public void test04_anyadir() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.5;
        int numTests = 16;
        double indTestVal = valorTotal / numTests;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tControlador::anyadir(). Valor: " + valorTotal);
        try {
            Controlador instance = new Controlador();
            InterfazUsuarioParaCorrector iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            String comando;
            //
            //Comando de menos de 3 palabras
            this.printlnAlways("\tTest 1: comando de menos de 3 palabras");
            comando = "coches anyadir";
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }            //
            instance.anyadir(comando.split(" "));
            //
            List<FilaDatos> filasRetrieved = this.getFilasDeDatosTabla(instance, "coches");
            //Comprobando que se ha intentado escribir un mensaje a través de iu
            error = this.sAssertFalse(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método debería haber "
                    + "enviado un mensaje a iu, pero no lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobar que hay 1 fila de datos en la tabla
            error = this.sAssertEquals(0, filasRetrieved.size(), indTestVal,
                    "Error. En la tabla \'coches\' NO debería haber ninguna fila "
                    + "de datos; sin embargo hay " + filasRetrieved);
            this.toThrow(error, toThrow);
            //
            //Comando con error en el nombre de la tabla
            this.printlnAlways("\tTest 2: el nombre de la tabla es incorrecto");
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            comando = "coche anyadir matricula=1234GGD marca=Seat modelo=Ibiza";
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }            //
            instance.anyadir(comando.split(" "));
            //
            filasRetrieved = this.getFilasDeDatosTabla(instance, "coches");
            //Comprobando que se ha intentado escribir un mensaje a través de iu
            error = this.sAssertFalse(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método debería haber "
                    + "enviado un mensaje a iu, pero no lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobar que hay 1 fila de datos en la tabla
            error = this.sAssertEquals(0, filasRetrieved.size(), indTestVal,
                    "Error. En la tabla \'coches\' NO debería haber ninguna fila "
                    + "de datos; sin embargo hay " + filasRetrieved);
            this.toThrow(error, toThrow);
            //
            //Comando con error en una de las claves
            this.printlnAlways("\tTest 3: hay una clave errónea");
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            comando = "coches anyadir matriculas=1234GGD marca=Seat modelo=Ibiza";
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }            //
            instance.anyadir(comando.split(" "));
            //
            filasRetrieved = this.getFilasDeDatosTabla(instance, "coches");
            //Comprobando que se ha intentado escribir un mensaje a través de iu
            error = this.sAssertFalse(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método debería haber "
                    + "enviado un mensaje a iu, pero no lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobar que hay 1 fila de datos en la tabla
            error = this.sAssertEquals(0, filasRetrieved.size(), indTestVal,
                    "Error. En la tabla \'coches\' NO debería haber ninguna fila "
                    + "de datos; sin embargo hay " + filasRetrieved);
            this.toThrow(error, toThrow);
            //
            //Comando correcto: se añade una fila
            this.printlnAlways("\tTest 4: comando correcto. Se añade una fila");
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            comando = "coches anyadir matricula=1234GGD marca=Seat modelo=Ibiza";
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }            //
            instance.anyadir(comando.split(" "));
            //
            filasRetrieved = this.getFilasDeDatosTabla(instance, "coches");
            //Comprobando que NO se ha intentado escribir un mensaje a través de iu
            error = this.sAssertTrue(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método debería haber "
                    + "enviado un mensaje a iu, pero no lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobar que hay 1 fila de datos en la tabla
            error = this.sAssertEquals(1, filasRetrieved.size(), indTestVal,
                    "Error. En la tabla \'coches\' NO debería haber ninguna fila "
                    + "de datos; sin embargo hay " + filasRetrieved);
            this.toThrow(error, toThrow);
            //Comprobar si la fila de datos es la correcta
            error = this.sAssertEquals(this.getPrimeraFilaDatosCoches(), filasRetrieved.get(0), indTestVal * 3,
                    "Error. En la tabla \'coches\' NO debería haber ninguna fila "
                    + "de datos; sin embargo hay " + +filasRetrieved.size() + ": " + filasRetrieved);
            this.toThrow(error, toThrow);
            //
            //Valor de clave única repetido
            this.printlnAlways("\tTest 5: valor de clave única repetida");
            iu.resetLastPrintlnConArg();
            comando = "coches anyadir matricula=1234GGD marca=Renault modelo=Laguna";
            //
            instance.anyadir(comando.split(" "));
            //
            filasRetrieved = this.getFilasDeDatosTabla(instance, "coches");
            //Comprobando que se ha intentado escribir un mensaje a través de iu
            error = this.sAssertFalse(iu.getLastPrintlConArg().isEmpty(),
                    valorTotal / numTests, "Error. El método debería haber "
                    + "enviado un mensaje a iu, pero no lo ha hecho.");
            this.toThrow(error, toThrow);
            //Comprobar que hay 1 fila de datos en la tabla
            error = this.sAssertEquals(1, filasRetrieved.size(), indTestVal,
                    "Error. En la tabla \'coches\'  debería haber 1 fila "
                    + "de datos; sin embargo hay " + filasRetrieved.size() + ": " + filasRetrieved);
            this.toThrow(error, toThrow);
            //Comprobar si la fila de datos es la correcta
            error = this.sAssertEquals(this.getPrimeraFilaDatosCoches(), filasRetrieved.get(0), indTestVal * 3,
                    "Error. En la tabla \'coches\' NO debería haber ninguna fila "
                    + "de datos; sin embargo hay " + filasRetrieved);
            this.toThrow(error, toThrow);

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
    public void test05_getCabeceras() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 0.25;
        int numTests = 1;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tControlador::getCabeceras(). Valor: " + valorTotal);
        try {
            Controlador instance = new Controlador();
            InterfazUsuarioParaCorrector iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }            //
            Set<String> cabeceras = new HashSet<>(instance.getCabeceras("coches"));
            //
            String[] expectedArray = {"marca", "modelo", "matricula"};
            Set<String> expected = new HashSet<String>(Arrays.asList(expectedArray));
            error = this.sAssertEquals(expected, cabeceras,
                    valorTotal / numTests, "Error. Las cabeceras de la tabla \'coches\' devueltas "
                    + "NO son las esperadas.");
            this.toThrow(error, toThrow);
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
    public void test06_interpretaCriterio() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.25;
        int numTests = 14;
        double indVal = valorTotal / numTests;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tControlador::interpretaCriterio(). Valor: " + valorTotal);
        try {
            Controlador instance = new Controlador();
            InterfazUsuarioParaCorrector iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            String comando;
            //
            //El comando tiene menos de 3 palabras
            //
            this.printlnAlways("\tTest 1: comando de menos de 3 palabras");
            //
            Criterio criterio = Controlador.interpretaCriterio("coche busca".split(" "));
            error = this.sAssertNull(criterio, indVal,
                    "Error. El comando tenía menos de tres palabras y "
                    + "sin embargo el método ha devuelto una referencia "
                    + "no nula; debería haber devuelto null");
            this.toThrow(error, toThrow);
            //
            //El comando no contiene el símbolo de ningún criterio válido
            //
            this.printlnAlways("\tTest 2: comando no contiene el símbolo de ningún criterio válido");
            //
            criterio = Controlador.interpretaCriterio("coche busca matricula&12345".split(" "));
            error = this.sAssertNull(criterio, indVal,
                    "Error. El comando tenía menos de tres palabras y "
                    + "sin embargo el método ha devuelto una referencia "
                    + "no nula; debería haber devuelto null");
            this.toThrow(error, toThrow);
            //
            //El comando no contiene el símbolo = (CriterioIgual)
            //
            this.printlnAlways("\tTest 3: comando contiene el símbolo = (CriterioIgual)");
            //
            criterio = Controlador.interpretaCriterio("coche busca matricula=12345".split(" "));
            error = this.sAssertTrue(criterio instanceof CriterioIgual, indVal,
                    "Error. El comando contenía el símbolo \'=\' pero el "
                    + "objeto devuelto es de la clase " + criterio.getClass().getSimpleName());
            this.toThrow(error, toThrow);
            this.compruebaAtributosDeCriterio(criterio, "matricula",
                    "12345", indVal, 4, "CriterioIgual");
            //
            //El comando no contiene el símbolo # (CriterioContiene)
            //
            this.printlnAlways("\tTest 6: comando contiene el símbolo = (CriterioIgual)");
            //
            criterio = Controlador.interpretaCriterio("coche busca matricula#12345".split(" "));
            error = this.sAssertTrue(criterio instanceof CriterioContiene, indVal,
                    "Error. El comando contenía el símbolo \'#\' pero el "
                    + "objeto devuelto es de la clase " + criterio.getClass().getSimpleName());
            this.toThrow(error, toThrow);
            this.compruebaAtributosDeCriterio(criterio, "matricula",
                    "12345", indVal, 7, "CriterioContiene");
            //
            //El comando no contiene el símbolo > (CriterioMayorQue)
            //
            this.printlnAlways("\tTest 9: comando contiene el símbolo > (CriterioMayorQue)");
            //
            criterio = Controlador.interpretaCriterio("coche busca matricula>12345".split(" "));
            error = this.sAssertTrue(criterio instanceof CriterioMayorQue, indVal,
                    "Error. El comando contenía el símbolo \'>\' pero el "
                    + "objeto devuelto es de la clase " + criterio.getClass().getSimpleName());
            this.toThrow(error, toThrow);
            this.compruebaAtributosDeCriterio(criterio, "matricula",
                    "12345", indVal, 10, "CriterioMayorQue");
            //
            //El comando no contiene el símbolo < (CriterioMenorQue)
            //
            this.printlnAlways("\tTest 12: comando contiene el símbolo < (CriterioMenorQue)");
            //
            criterio = Controlador.interpretaCriterio("coche busca matricula<12345".split(" "));
            error = this.sAssertTrue(criterio instanceof CriterioMenorQue, indVal,
                    "Error. El comando contenía el símbolo \'<\' pero el "
                    + "objeto devuelto es de la clase " + criterio.getClass().getSimpleName());
            this.toThrow(error, toThrow);
            this.compruebaAtributosDeCriterio(criterio, "matricula",
                    "12345", indVal, 13, "CriterioMenorQue");
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
    public void test07_buscar() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.5;
        int numTests = 14;
        double indVal = valorTotal / numTests;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tControlador::buscar(). Valor: " + valorTotal);
        try {
            Controlador instance = new Controlador();
            InterfazUsuarioParaCorrector iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            String comando;
            //
            //Intenta buscar en tabla que NO existe
            //
            this.printlnAlways("\tTest 1: intento de búsqueda en tabla que NO existe");
            comando = "coche busca matricula#1234GGD";
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }            //
            List<FilaDatos> retrieved = instance.buscar(comando.split(" "));
            //
            //Comprobar que se ha escrito un mensaje de aviso
            error = this.sAssertFalse(iu.getLastPrintlConArg().isEmpty(),
                    indVal, "Error. Se ha pasado el nombre de una "
                    + "tabla que no existe y el método NO ha escrito ningún "
                    + "mensaje de aviso");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista devuelta está vacía
            error = this.sAssertEquals(0, retrieved.size(), indVal,
                    "Error. La lista de filas devuelta NO está vacía; "
                    + "debería estarlo");
            this.toThrow(error, toThrow);
            //
            // Crea y rellena la tabla de coches y la tabla de multas
            // para uso del resto de pruebas
            //
            try {
                this.creaYRellenaTablaDeCoches(instance);
                this.creaYRellenaTablaDeMultas(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            //
            this.printlnAlways("\tTest 2: intento de búsqueda sin criterio");
            iu.resetLastPrintlnConArg();
            comando = "coches busca";
            //
            retrieved = instance.buscar(comando.split(" "));
            //
            //Comprobar que se NO ha escrito un mensaje de aviso
            error = this.sAssertTrue(iu.getLastPrintlConArg().isEmpty(),
                    indVal, "Error. Se ha pasado un comando correcto "
                    + "y el método ha escrito un mensaje de aviso; no debería "
                    + "haberlo hecho");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene todas
            //las filas de la tabla
            error = this.sAssertEquals(new HashSet<FilaDatos>(this.filasTablaCoches),
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Búsqueda con criterio =
            //
            this.printlnAlways("\tTest 3: intento de búsqueda con criterio = NO numérico");
            iu.resetLastPrintlnConArg();
            comando = "coches busca marca=Seat";
            //
            retrieved = instance.buscar(comando.split(" "));
            //
            Set<FilaDatos> expected = new HashSet<>();
            expected.add(this.filasTablaCoches.get(0));
            expected.add(this.filasTablaCoches.get(1));
            //
            //Comprobar que se NO ha escrito un mensaje de aviso
            error = this.sAssertTrue(iu.getLastPrintlConArg().isEmpty(),
                    indVal, "Error. Se ha pasado un comando correcto "
                    + "y el método ha escrito un mensaje de aviso; no debería "
                    + "haberlo hecho");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las
            //filas adecuadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Búsqueda con criterio =
            //
            this.printlnAlways("\tTest 4: intento de búsqueda con criterio = numérico");
            iu.resetLastPrintlnConArg();
            comando = "multas busca cuantía=100";
            //
            retrieved = instance.buscar(comando.split(" "));
            //
            expected = new HashSet<>();
            expected.add(this.filasTablaMultas.get(0));
            expected.add(this.filasTablaMultas.get(3));
            //
            //Comprobar que se NO ha escrito un mensaje de aviso
            error = this.sAssertTrue(iu.getLastPrintlConArg().isEmpty(),
                    indVal, "Error. Se ha pasado un comando correcto "
                    + "y el método ha escrito un mensaje de aviso; no debería "
                    + "haberlo hecho");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las
            //filas adecuadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //
            //Búsqueda con criterio >
            //
            this.printlnAlways("\tTest 5: intento de búsqueda con criterio > numérico");
            iu.resetLastPrintlnConArg();
            comando = "multas busca cuantía>60";
            //
            retrieved = instance.buscar(comando.split(" "));
            //
            expected = new HashSet<>();
            expected.add(this.filasTablaMultas.get(0));
            expected.add(this.filasTablaMultas.get(1));
            expected.add(this.filasTablaMultas.get(3));
            //
            //Comprobar que se NO ha escrito un mensaje de aviso
            error = this.sAssertTrue(iu.getLastPrintlConArg().isEmpty(),
                    indVal, "Error. Se ha pasado un comando correcto "
                    + "y el método ha escrito un mensaje de aviso; no debería "
                    + "haberlo hecho");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las
            //filas adecuadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //
            //Búsqueda con criterio <
            //
            this.printlnAlways("\tTest 6: intento de búsqueda con criterio < numérico");
            iu.resetLastPrintlnConArg();
            comando = "multas busca cuantía<101";
            //
            retrieved = instance.buscar(comando.split(" "));
            //
            expected = new HashSet<>();
            expected.add(this.filasTablaMultas.get(0));
            expected.add(this.filasTablaMultas.get(2));
            expected.add(this.filasTablaMultas.get(3));
            //
            //Comprobar que se NO ha escrito un mensaje de aviso
            error = this.sAssertTrue(iu.getLastPrintlConArg().isEmpty(),
                    indVal, "Error. Se ha pasado un comando correcto "
                    + "y el método ha escrito un mensaje de aviso; no debería "
                    + "haberlo hecho");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las
            //filas adecuadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Búsqueda con criterio #
            //
            this.printlnAlways("\tTest 7: intento de búsqueda con criterio # (contiene)");
            iu.resetLastPrintlnConArg();
            comando = "coches busca marca#Fo";
            //
            retrieved = instance.buscar(comando.split(" "));
            //
            expected = new HashSet<>();
            expected.add(this.filasTablaCoches.get(2));
            expected.add(this.filasTablaCoches.get(4));
            //
            //Comprobar que se NO ha escrito un mensaje de aviso
            error = this.sAssertTrue(iu.getLastPrintlConArg().isEmpty(),
                    indVal, "Error. Se ha pasado un comando correcto "
                    + "y el método ha escrito un mensaje de aviso; no debería "
                    + "haberlo hecho");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las
            //filas adecuadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
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
    public void test08_eliminar() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.5;
        int numTests = 19;
        double indVal = valorTotal / numTests;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tControlador::eliminar(). Valor: " + valorTotal);
        try {
            Controlador instance = new Controlador();
            InterfazUsuarioParaCorrector iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            String comando;
            //
            //Error en formato de comando
            //
            this.printlnAlways("\tTest 1: error en formato de comando");
            comando = "coches elimina";
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }            //
            List<FilaDatos> retrieved = instance.eliminar(comando.split(" "));
            //
            //Comprobar que se ha escrito el mensaje de aviso "Error en formato del comando" 
            error = this.sAssertEquals("Error en formato del comando",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Error en formato del comando\"");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista devuelta está vacía
            error = this.sAssertEquals(0, retrieved.size(), indVal,
                    "Error. La lista de filas devuelta NO está vacía; "
                    + "debería estarlo");
            this.toThrow(error, toThrow);
            //
            //Intenta buscar en tabla que NO existe
            //
            this.printlnAlways("\tTest 2: intento de búsqueda en tabla que NO existe");
            comando = "coche elimina matricula#1234GGD";
            try {
                this.crearYAnyadirTablaDeCoches(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }            //
            retrieved = instance.eliminar(comando.split(" "));
            //
            //Comprobar que se ha escrito el mensaje de aviso "ENo existe la tabla coche" 
            error = this.sAssertEquals("No existe la tabla coche",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Error en formato del comando\"");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista devuelta está vacía
            error = this.sAssertEquals(0, retrieved.size(), indVal,
                    "Error. La lista de filas devuelta NO está vacía; "
                    + "debería estarlo");
            this.toThrow(error, toThrow);
            //
            // Crea y rellena la tabla de coches y la tabla de multas
            // para uso del resto de pruebas
            //
            try {
                this.creaYRellenaTablaDeCoches(instance);
                this.creaYRellenaTablaDeMultas(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            //
            //Eliminación con criterio =
            //
            this.printlnAlways("\tTest 3: intento de eliminación con criterio = NO numérico");
            iu.resetLastPrintlnConArg();
            comando = "coches elimina marca=Seat";
            //
            retrieved = instance.eliminar(comando.split(" "));
            //
            Set<FilaDatos> expected = new HashSet<>();
            expected.add(this.filasTablaCoches.get(0));
            expected.add(this.filasTablaCoches.get(1));
            //
            //Comprobar que se ha escrito el mensaje "Eliminadas 2 filas"
            error = this.sAssertEquals("Eliminadas 2 filas",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Eliminadas 2 filas\"");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas es correcta
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Comprobar que las filas que quedan en la tabla son las correctas
            Set<FilaDatos> remaining = new HashSet<>(
                    this.getFilasDeDatosTabla(instance, "coches"));
            Set<FilaDatos> expectedRemaining = new HashSet<>();
            expectedRemaining.add(this.filasTablaCoches.get(2));
            expectedRemaining.add(this.filasTablaCoches.get(3));
            expectedRemaining.add(this.filasTablaCoches.get(4));
            error = this.sAssertEquals(expectedRemaining,
                    remaining, indVal, "Error. Las filas de datos que "
                    + "quedan en la tabla NO son las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Búsqueda con criterio =
            //
            this.printlnAlways("\tTest 4: intento de búsqueda con criterio = numérico");
            iu.resetLastPrintlnConArg();
            comando = "multas busca cuantía=100";
            //
            retrieved = instance.eliminar(comando.split(" "));
            //
            expected = new HashSet<>();
            expected.add(this.filasTablaMultas.get(0));
            expected.add(this.filasTablaMultas.get(3));
            //
            //Comprobar que se ha escrito el mensaje "Eliminadas 2 filas"
            error = this.sAssertEquals("Eliminadas 2 filas",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Eliminadas 2 filas\"");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las 
            //dos filas eliminadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Comprobar que las filas que quedan en la tabla son las correctas
            remaining = new HashSet<>(
                    this.getFilasDeDatosTabla(instance, "multas"));
            expectedRemaining = new HashSet<>();
            expectedRemaining.add(this.filasTablaMultas.get(1));
            expectedRemaining.add(this.filasTablaMultas.get(2));
            error = this.sAssertEquals(expectedRemaining,
                    remaining, indVal, "Error. Las filas de datos que "
                    + "quedan en la tabla NO son las esperadas.");
            this.toThrow(error, toThrow);
            //
            //
            //Búsqueda con criterio >
            //
            this.printlnAlways("\tTest 5: intento de búsqueda con criterio > numérico");
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.creaYRellenaTablaDeCoches(instance);
                this.creaYRellenaTablaDeMultas(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            comando = "multas elimina cuantía>60";
            //
            retrieved = instance.eliminar(comando.split(" "));
            //
            expected = new HashSet<>();
            expected.add(this.filasTablaMultas.get(0));
            expected.add(this.filasTablaMultas.get(1));
            expected.add(this.filasTablaMultas.get(3));
            //
            //Comprobar que se ha escrito el mensaje "Eliminadas 3 filas"
            error = this.sAssertEquals("Eliminadas 3 filas",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Eliminadas 3 filas\"");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las
            //filas adecuadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Comprobar que las filas que quedan en la tabla son las correctas
            remaining = new HashSet<>(
                    this.getFilasDeDatosTabla(instance, "multas"));
            expectedRemaining = new HashSet<>();
            expectedRemaining.add(this.filasTablaMultas.get(2));
            error = this.sAssertEquals(expectedRemaining,
                    remaining, indVal, "Error. Las filas de datos que "
                    + "quedan en la tabla NO son las esperadas.");
            this.toThrow(error, toThrow);
            //
            //
            //Búsqueda con criterio <
            //
            this.printlnAlways("\tTest 6: intento de búsqueda con criterio < numérico");
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.creaYRellenaTablaDeCoches(instance);
                this.creaYRellenaTablaDeMultas(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            comando = "multas elimina cuantía<101";
            //
            retrieved = instance.eliminar(comando.split(" "));
            //
            expected = new HashSet<>();
            expected.add(this.filasTablaMultas.get(0));
            expected.add(this.filasTablaMultas.get(2));
            expected.add(this.filasTablaMultas.get(3));
            //
            //Comprobar que se ha escrito el mensaje "Eliminadas 3 filas"
            error = this.sAssertEquals("Eliminadas 3 filas",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Eliminadas 3 filas\"");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las
            //filas adecuadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Comprobar que las filas que quedan en la tabla son las correctas
            remaining = new HashSet<>(
                    this.getFilasDeDatosTabla(instance, "multas"));
            expectedRemaining = new HashSet<>();
            expectedRemaining.add(this.filasTablaMultas.get(1));
            error = this.sAssertEquals(expectedRemaining,
                    remaining, indVal, "Error. Las filas de datos que "
                    + "quedan en la tabla NO son las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Búsqueda con criterio #
            //
            this.printlnAlways("\tTest 7: intento de búsqueda con criterio # (contiene)");
            instance = new Controlador();
            iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.creaYRellenaTablaDeCoches(instance);
                this.creaYRellenaTablaDeMultas(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            comando = "coches elimina marca#Fo";
            //
            retrieved = instance.eliminar(comando.split(" "));
            //
            expected = new HashSet<>();
            expected.add(this.filasTablaCoches.get(2));
            expected.add(this.filasTablaCoches.get(4));
            //
            //Comprobar que se ha escrito el mensaje "Eliminadas 2 filas"
            error = this.sAssertEquals("Eliminadas 2 filas",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Eliminadas 2 filas\"");
            this.toThrow(error, toThrow);
            //
            //Comprobar que la lista de filas de datos devueltas contiene las
            //filas adecuadas
            error = this.sAssertEquals(expected,
                    new HashSet<FilaDatos>(retrieved), indVal,
                    "Error. Las filas de datos devueltas NO son "
                    + "las esperadas.");
            this.toThrow(error, toThrow);
            //
            //Comprobar que las filas que quedan en la tabla son las correctas
            remaining = new HashSet<>(
                    this.getFilasDeDatosTabla(instance, "coches"));
            expectedRemaining = new HashSet<>();
            expectedRemaining.add(this.filasTablaCoches.get(0));
            expectedRemaining.add(this.filasTablaCoches.get(1));
            expectedRemaining.add(this.filasTablaCoches.get(3));
            error = this.sAssertEquals(expectedRemaining,
                    remaining, indVal, "Error. Las filas de datos que "
                    + "quedan en la tabla NO son las esperadas.");
            this.toThrow(error, toThrow);
            //
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
    public void test09_ordenar() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.0;
        int numTests = 7;
        double indVal = valorTotal / numTests;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tControlador::ordenar(). Valor: " + valorTotal);
        try {
            //
            //
            //Búsqueda con criterio <
            //
            this.printlnAlways("\tTest 1: intento de ordenar una tabla inexistente");
            Controlador instance = new Controlador();
            InterfazUsuarioParaCorrector iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.creaYRellenaTablaDeCoches(instance);
                this.creaYRellenaTablaDeMultas(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            String comando = "multa ordena cuantía";
            //
            instance.ordenar(comando.split(" "));
            //
            //Comprobar que se ha escrito el mensaje de aviso "Error. Tabla inexistente" 
            error = this.sAssertEquals("Error. Tabla inexistente",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Error. Tabla inexistente\"");
            this.toThrow(error, toThrow);
            //
            //Columna inexistente
            //
            this.printlnAlways("\tTest 2: intento de ordenar por una columna inexistente");
            iu.resetLastPrintlnConArg();
            comando = "multas ordena foo";
            instance.ordenar(comando.split(" "));
            //
            //Comprobar que se ha escrito el mensaje de aviso "Error. Columna inexistente" 
            error = this.sAssertEquals("Error. Columna inexistente",
                    iu.getLastPrintlConArg().replaceAll("\\s{2,}", " "), indVal,
                    "Error. El mensaje generado no es \"Error. Columna inexistente\"");
            this.toThrow(error, toThrow);
            //Comprobar que las filas de datos de la tabla NO han cambiado
            List<FilaDatos> expected = this.filasTablaMultas;
            List<FilaDatos> retrieved = this.getFilasDeDatosTabla(instance, "multas");
            error = this.sAssertEquals(expected, retrieved, indVal,
                    "Error. Se ha alterado el orden de las filas de datos; no"
                    + "debería haberse alterado");
            this.toThrow(error, toThrow);
            //
            //Ordenación ascendente
            //
            this.printlnAlways("\tTest 3: intento de ordenación ascendente");
            iu.resetLastPrintlnConArg();
            //Modificar la lista de filas de datos para que no haya dos 
            //filas con la misma cuantía. Podría haber problemas en la comprobación
            //
            this.filasTablaMultas.get(0).put("cuantía", "90");
            comando = "multas ordena cuantía";
            instance.ordenar(comando.split(" "));
            //
            //Comprobar que se ha escrito el mensaje de aviso "Error. Columna inexistente" 
            error = this.sAssertTrue(iu.getLastPrintlConArg().length() == 0, indVal,
                    "Error. No debería haberse generado ningún mensaje de "
                    + "aviso; sin embargo, se ha generado");
            this.toThrow(error, toThrow);
            //Comprobar que las filas de datos de la tabla se han ordenado
            //en orden de cuantía ascendente 
            expected = new ArrayList<FilaDatos>();
            expected.add(this.filasTablaMultas.get(2));
            expected.add(this.filasTablaMultas.get(0));
            expected.add(this.filasTablaMultas.get(3));
            expected.add(this.filasTablaMultas.get(1));
            retrieved = this.getFilasDeDatosTabla(instance, "multas");
            error = this.sAssertEquals(expected, retrieved, indVal,
                    "Error. Se ha alterado el orden de las filas de datos; no"
                    + "debería haberse alterado");
            this.toThrow(error, toThrow);
            //
            //Ordenación descendente
            //
            this.printlnAlways("\tTest 4: intento de ordenación descendente");
            try {
                this.creaYRellenaTablaDeCoches(instance);
                this.creaYRellenaTablaDeMultas(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            //Modificar la lista de filas de datos para que no haya dos 
            //filas con la misma cuantía. Podría haber problemas en la comprobación
            //
            this.filasTablaMultas.get(0).put("cuantía", "90");
            comando = "multas ordena cuantía desc";
            instance.ordenar(comando.split(" "));
            //
            //Comprobar que se ha escrito el mensaje de aviso "Error. Columna inexistente" 
            error = this.sAssertTrue(iu.getLastPrintlConArg().length() == 0, indVal,
                    "Error. No debería haberse generado ningún mensaje de "
                    + "aviso; sin embargo, se ha generado");
            this.toThrow(error, toThrow);
            //Comprobar que las filas de datos de la tabla se han ordenado
            //en orden de cuantía ascendente 
            expected = new ArrayList<FilaDatos>();
            expected.add(this.filasTablaMultas.get(1));
            expected.add(this.filasTablaMultas.get(3));
            expected.add(this.filasTablaMultas.get(0));
            expected.add(this.filasTablaMultas.get(2));
            retrieved = this.getFilasDeDatosTabla(instance, "multas");
            error = this.sAssertEquals(expected, retrieved, indVal,
                    "Error. Se ha alterado el orden de las filas de datos; no"
                    + "debería haberse alterado");
            this.toThrow(error, toThrow);

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
    public void test10_exportar() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 1.0;
        int numTests = 12;
        double indVal = valorTotal / numTests;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tControlador::exporta(). Valor: " + valorTotal);
        try {
            //
            //
            //Búsqueda con criterio <
            //
            this.printlnAlways("\tTest 1: intento de exprotar todas las tablas");
            Controlador instance = new Controlador();
            InterfazUsuarioParaCorrector iu = new InterfazUsuarioParaCorrector(instance);
            instance.setIu(iu);
            this.setPrivateField(instance, "iu", iu);
            try {
                this.creaYRellenaTablaDeCoches(instance);
                this.creaYRellenaTablaDeMultas(instance);
            } catch (CorrectorException ex) {
                this.println("\tATENCIÓN. " + ex.getMessage());
                return;
            }
            //
            String fName = System.getProperty("user.dir") + "/paracorreccion/baseDatosExportada.txt";
            instance.exporta(fName);
            //
            Scanner scannerRef = new Scanner(new FileInputStream(System.getProperty("user.dir") + "/paracorreccion/referencia_baseDatosExportada.txt"));
            Scanner scannerExportada = new Scanner(new FileInputStream(fName));
            int i = 1;
            while (scannerRef.hasNextLine() && scannerExportada.hasNextLine()) {
                String lineaRef = scannerRef.nextLine().replaceAll("\\s{2,}", " ");
                String lineaExportada = scannerExportada.nextLine().replaceAll("\\s{2,}", " ");
                error = this.sAssertEquals(lineaRef, lineaExportada, indVal, "Error. La línea "
                        + "número " + i + " no es la que debería ser");
                this.toThrow(error, toThrow);
                i++;
            }
            error = this.sAssertFalse(scannerRef.hasNextLine() || scannerExportada.hasNextLine(),
                     indVal, "Error. El archivo generado NO tiene "
                    + "el número de líneas que debiera");
            this.toThrow(error, toThrow);
            //
            scannerRef.close();
            scannerExportada.close();
            
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

    /**
     * ***********************************************************************
     *
     * Métodos auxiliares privados
     *
     ************************************************************************
     */
    //
    private void creaYRellenaTablaDeCoches(Controlador c) throws CorrectorException {
        this.crearYAnyadirTablaDeCoches(c);
        this.crearYAnyadirFilasATabla(this.tablaCoches, ControladorTest.matrizDatosCoches);
    }

    private void creaYRellenaTablaDeMultas(Controlador c) throws CorrectorException {
        this.crearYAnyadirTablaDeMultas(c);
        this.crearYAnyadirFilasATabla(this.tablaMultas, ControladorTest.matrizDatosMultas);
    }

    private void compruebaAtributosDeCriterio(Criterio cr, String clave,
            String valorAComprobar, double indVal, int numTest, String nombreCriterio) {
        AssertionError toThrow = null;
        AssertionError error = null;
        try {
            this.printlnAlways("\tTest " + numTest + ": comprobando atributo \'nombreClave\' de objeto " + nombreCriterio);
            Optional<Object> attrRetOpt = this.getPrivateFieldValue(cr, "nombreClave");
            if (attrRetOpt.isPresent()) {
                error = this.sAssertEquals(clave, (String) attrRetOpt.get(),
                        indVal, "Error. El atributo \'nombreClave\' del "
                        + "criterio NO es el esperado.");
                this.toThrow(error, toThrow);
            } else {
                error = this.sAssertTrue(false, 0, "Error. El "
                        + "objeto " + nombreCriterio + " NO tiene el atributo \'nombreClave\'");
            }
            this.printlnAlways("\tTest " + (numTest + 1) + ": comprobando atributo \'valorAComprobar\' de objeto " + nombreCriterio);
            attrRetOpt = this.getPrivateFieldValue(cr, "valorAComprobar");
            if (attrRetOpt.isPresent()) {
                error = this.sAssertEquals(valorAComprobar, (String) attrRetOpt.get(),
                        indVal, "Error. El atributo \'valorAComprobar\' del "
                        + "criterio NO es el esperado.");
                this.toThrow(error, toThrow);
            } else {
                error = this.sAssertTrue(false, 0, "Error. El "
                        + "objeto " + nombreCriterio + " NO tiene el atributo \'valorAComprobar\'");
            }

        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
    }

    private FilaDatos getPrimeraFilaDatosCoches() throws CorrectorException {
        try {
            Class cFilaDatos = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos");
            FilaDatos filaDatos = (FilaDatos) cFilaDatos.getDeclaredConstructor().newInstance();
            Map<String, String> clavesValor = new HashMap<>();
            clavesValor.put("matricula", "1234GGD");
            clavesValor.put("marca", "Seat");
            clavesValor.put("modelo", "Ibiza");
            this.setPrivateField(filaDatos, "clavesValor", clavesValor);
            return filaDatos;
        } catch (Exception ex) {
            throw new CorrectorException("Contacta con el profesorado. Se ha "
                    + "lanzado una excepción de clase " + ex.getClass().getSimpleName()
                    + " mientras se estaba ejecutando el método ControladorTest::crearYAnyadirTablaDeCoches."
                    + " Detalles de excepción: " + ex.getMessage());
        }
    }

    private List<FilaDatos> getFilasDeDatosTabla(Controlador c, String nombreTabla) {
        Optional<Object> tablasOpt = this.getPrivateFieldValue(c, "tablas");
        if (tablasOpt.isPresent()) {
            return ((Map<String, Tabla>) tablasOpt.get()).get(nombreTabla).buscaTodo();
        }
        return new ArrayList<FilaDatos>();
    }

    private void comprobarTablaDeLibrosCreada(Map<String, Tabla> tablas, double indVal, Controlador c) {
        AssertionError toThrow = null;
        AssertionError error = null;
        try {
            Tabla tabla = tablas.get("libros");
            error = this.sAssertNotNull(tabla, indVal, "Error. No se "
                    + "ha creado ninguna tabla con el nombre \'libros\'");
            this.toThrow(error, toThrow);
            if (error == null) {
                Esquema esquema = tabla.getEsquema();
                error = this.sAssertNotNull(esquema, indVal, "Error. El "
                        + "atributo \'esquema\' de la tabla con el nombre \'libros\' "
                        + "es null");
                this.toThrow(error, toThrow);
                if (error == null) {
                    Optional<Object> camposOpt = this.getPrivateFieldValue(esquema, "campos");
                    if (!camposOpt.isPresent()) {
                        return;
                    }
                    Map<String, Clave> camposRetrieved = (Map<String, Clave>) camposOpt.get();
                    Map<String, Clave> camposExpected = this.crearYDevolverCamposDeTablaDeLibros(c);
                    error = this.sAssertEquals(camposExpected, camposRetrieved, indVal * 4,
                            "Error. Los campos del esquema de la tabla \'libros\' creada no son los "
                            + "esperados");
                    this.toThrow(error, toThrow);
                }
            }
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
    }

    private void crearYAnyadirTablaDeCoches(Controlador c) throws CorrectorException {
        try {
            //Crear esquema usando reflection para independizarlo del código
            //de las otras clases
            Class cEsquema = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema");
            Esquema esquema = (Esquema) cEsquema.getDeclaredConstructor().newInstance();
            Map<String, Clave> campos = new HashMap<>();
            //
            //Crear las claves y el mapa de campos de la tabla usando reflection
            Class cClave = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.esquema.Clave");
            Class[] cArgs = {String.class, Boolean.class};
            Class[] ccArgs = {};
            Constructor claveConstructor = cClave.getConstructor(ccArgs);
            //
            Clave clave = (Clave) claveConstructor.newInstance();
            this.setPrivateField(clave, "nombre", "marca");
            this.setPrivateField(clave, "unica", false);
            campos.put("marca", clave);
            //
            clave = (Clave) claveConstructor.newInstance();
            this.setPrivateField(clave, "nombre", "modelo");
            this.setPrivateField(clave, "unica", false);
            campos.put("modelo", clave);
            //
            clave = (Clave) claveConstructor.newInstance();
            this.setPrivateField(clave, "nombre", "matricula");
            this.setPrivateField(clave, "unica", true);
            campos.put("matricula", clave);
            //
            // Añadir campos a esquema y llenarla
            //
            this.setPrivateField(esquema, "campos", campos);
            //
            //Crear la tabla usando reflection
            Class cTabla = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla");
            Tabla tabla = (Tabla) cTabla.getDeclaredConstructor().newInstance();
            this.setPrivateField(tabla, "nombre", "coches");
            this.setPrivateField(tabla, "esquema", esquema);
            this.setPrivateField(tabla, "filas", new LinkedList<FilaDatos>());
            //
            //Añadir tabla a objeto Controlador
            Map<String, Tabla> tablas = this.getTablas(c);
            tablas.put("coches", tabla);
            this.tablaCoches = tabla;
        } catch (Exception ex) {
            throw new CorrectorException("Contacta con el profesorado. Se ha "
                    + "lanzado una excepción de clase " + ex.getClass().getSimpleName()
                    + " mientras se estaba ejecutando el método ControladorTest::crearYAnyadirTablaDeCoches."
                    + " Detalles de excepción: " + ex.getMessage());
        }
    }

    private void crearYAnyadirTablaDeMultas(Controlador c) throws CorrectorException {
        try {
            //Crear esquema usando reflection para independizarlo del código
            //de las otras clases
            Class cEsquema = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.esquema.Esquema");
            Esquema esquema = (Esquema) cEsquema.getDeclaredConstructor().newInstance();
            Map<String, Clave> campos = new HashMap<>();
            //
            //Crear las claves y el mapa de campos de la tabla usando reflection
            Class cClave = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.esquema.Clave");
            Class[] cArgs = {String.class, Boolean.class};
            Class[] ccArgs = {};
            Constructor claveConstructor = cClave.getConstructor(ccArgs);
            //
            Clave clave = (Clave) claveConstructor.newInstance();
            this.setPrivateField(clave, "nombre", "cuantía");
            this.setPrivateField(clave, "unica", false);
            campos.put("cuantía", clave);
            //
            clave = (Clave) claveConstructor.newInstance();
            this.setPrivateField(clave, "nombre", "matricula");
            this.setPrivateField(clave, "unica", true);
            campos.put("matricula", clave);
            //
            // Añadir campos a esquema y llenarla
            //
            this.setPrivateField(esquema, "campos", campos);
            //
            //Crear la tabla usando reflection
            Class cTabla = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla");
            Tabla tabla = (Tabla) cTabla.getDeclaredConstructor().newInstance();
            this.setPrivateField(tabla, "nombre", "multas");
            this.setPrivateField(tabla, "esquema", esquema);
            this.setPrivateField(tabla, "filas", new LinkedList<FilaDatos>());
            //
            //Añadir tabla a objeto Controlador
            Map<String, Tabla> tablas = this.getTablas(c);
            tablas.put("multas", tabla);
            this.tablaMultas = tabla;
        } catch (Exception ex) {
            throw new CorrectorException("Contacta con el profesorado. Se ha "
                    + "lanzado una excepción de clase " + ex.getClass().getSimpleName()
                    + " mientras se estaba ejecutando el método ControladorTest::crearYAnyadirTablaDeCoches."
                    + " Detalles de excepción: " + ex.getMessage());
        }
    }

    private Map<String, Clave> crearYDevolverCamposDeTablaDeLibros(Controlador c) throws CorrectorException {
        try {
            Map<String, Clave> campos = new HashMap<>();
            //
            //Crear las claves y el mapa de campos de la tabla usando reflection
            Class cClave = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.esquema.Clave");
            Class[] cArgs = {String.class, Boolean.class};
            Class[] ccArgs = {};
            Constructor claveConstructor = cClave.getConstructor(ccArgs);
            //
            Clave clave = (Clave) claveConstructor.newInstance();
            this.setPrivateField(clave, "nombre", "ISBN");
            this.setPrivateField(clave, "unica", true);
            campos.put("ISBN", clave);
            //
            clave = (Clave) claveConstructor.newInstance();
            this.setPrivateField(clave, "nombre", "Titulo");
            this.setPrivateField(clave, "unica", false);
            campos.put("Titulo", clave);
            //
            clave = (Clave) claveConstructor.newInstance();
            this.setPrivateField(clave, "nombre", "Autores");
            this.setPrivateField(clave, "unica", false);
            campos.put("Autores", clave);
            //
            return campos;
        } catch (Exception ex) {
            throw new CorrectorException("Contacta con el profesorado. Se ha "
                    + "lanzado una excepción de clase " + ex.getClass().getSimpleName()
                    + " mientras se estaba ejecutando el método ControladorTest::crearYAnyadirTablaDeCoches."
                    + " Detalles de excepción: " + ex.getMessage());
        }
    }

    private Map<String, Tabla> getTablas(Controlador c) {
        Optional<Object> tablas = this.getPrivateFieldValue(c, "tablas");
        return (Map<String, Tabla>) tablas.get();
    }

    private void crearYAnyadirFilasATabla(Tabla tabla, String[][] matrizDatos) throws CorrectorException {
        try {
            if (tabla == this.tablaCoches) {
                this.filasTablaCoches = new ArrayList<>();
            } else if (tabla == this.tablaMultas) {
                this.filasTablaMultas = new ArrayList<>();
            }
            List<FilaDatos> filas = new ArrayList<>();
            Class cFilaDatos = Class.forName("edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos");
            for (int i = 0; i < matrizDatos.length; i++) {
                FilaDatos fila = (FilaDatos) cFilaDatos.getDeclaredConstructor().newInstance();
                Map<String, String> campos = new HashMap<>();
                for (int j = 0; j < matrizDatos[i].length; j += 2) {
                    campos.put(matrizDatos[i][j], matrizDatos[i][j + 1]);
                }
                this.setPrivateField(fila, "clavesValor", campos);
                filas.add(fila);
                if (tabla == this.tablaCoches) {
                    this.filasTablaCoches.add(fila);
                } else if (tabla == this.tablaMultas) {
                    this.filasTablaMultas.add(fila);
                }
            }
            this.setPrivateField(tabla, "filas", filas);
        } catch (Exception ex) {
            throw new CorrectorException("Contacta con el profesorado. Se ha "
                    + "lanzado una excepción de clase " + ex.getClass().getSimpleName()
                    + " mientras se estaba ejecutando el método ControladorTest::crearYAnyadirTablaDeCoches."
                    + " Detalles de excepción: " + ex.getMessage());
        }
    }

}

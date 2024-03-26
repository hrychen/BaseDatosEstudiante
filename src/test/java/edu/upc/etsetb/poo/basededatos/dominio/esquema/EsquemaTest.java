/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.dominio.esquema;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import java.util.Iterator;
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
public class EsquemaTest extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public EsquemaTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        System.out.println("\nCorrigiendo clase Esquema");
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Esquema");
        nota.put("Esquema", puntosTotales);
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
        double valorTotal = 1.0;
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
            this.printlnAlways("\n\tEsquema::Esquema(). Valor: " + valorTotal);
            Esquema instance = new Esquema();
            error = this.checkPrivateFieldExists(instance, "campos", valorTotal / 2, toThrow);
            toThrow(error, toThrow);
            Optional<Object> camposVal = this.getPrivateFieldValue(instance, "campos");
            if (camposVal.isPresent()) {
                error = this.checkPrivateFieldIsOfASpecificClass(instance,
                        "campos", Map.class, valorTotal / 2, toThrow);
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
    public void test02_addClave() {
        double valorTotal = 6.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tEsquema::addClave(clave). Valor: " + valorTotal);
        //
        try {
            Clave clave = new Clave("nombreClave");
            Esquema instance = new Esquema();
            this.println("\tTest 1: se añade una clave que no existía en el esquema ");
            instance.addClave(clave);
            Optional<Object> camposOpt = this.getPrivateFieldValue(instance, "campos");
            if (camposOpt.isPresent()) {
                Map<String, Clave> campos = (Map<String, Clave>) camposOpt.get();
                error = this.sAssertTrue(campos.containsKey("nombreClave"), valorTotal / 3, "Error: debería "
                        + "haberse añadido un par <clave valor>, pero no se ha "
                        + "encontrado ningún par con la clave correcta");
                toThrow(error, toThrow);
                if (error == null) {
                    Clave retrieved = campos.get("nombreClave");
                    error = this.sAssertEquals(clave, retrieved,
                            valorTotal / 3, "Error: se ha añadido un par <clave,valor> pero"
                            + "el par añadido no es el que se pretendía añadir");
                    toThrow(error, toThrow);
                }
            }
            this.println("\tTest 2: se añade una clave que ya existía en el esquema ");
            try {
                clave = new Clave("nombreClave");
                instance.addClave(clave);
                error = this.sAssertTrue(false, valorTotal / 3, "Error: al "
                        + "intentar añadir una clave con un nombre de otra clave "
                        + "ya presente en el esquema debería haberse arrojado "
                        + "una excepción ClaveYaExisteException, pero NO "
                        + "se ha arrojado ninguna excepción");
                toThrow(error, toThrow);
            } catch (Exception ex) {
                if (ex instanceof ClaveYaExisteException) {
                    error = this.sAssertTrue(true, valorTotal / 3, "");
                } else {
                    error = this.sAssertTrue(false, valorTotal / 3, "Error: al "
                            + "intentar añadir una clave con un nombre de otra clave "
                            + "ya presente en el esquema debería haberse arrojado "
                            + "una excepción ClaveYaExisteException; se ha arrojado "
                            + "una excepción, pero NO de esa clase sino de la clase "
                            + ex.getClass().getSimpleName());
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
    public void test03_contieneClave() {
        double valorTotal = 1.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tEsquema::contieneClave(nombre). Valor: " + valorTotal);
        //
        try {
            Clave clave = new Clave("nombreClave");
            Esquema instance = new Esquema();
            instance.addClave(clave);
            //
            this.println("\tTest 1: se invoca pasando un nombre de clave que NO está en el esquema ");
            error = this.sAssertFalse(instance.contieneClave("otroNombre"),
                    valorTotal / 2, "Error: se ha pasado el nombre de una clave que NO está en el "
                    + "esquema, y sin embargo, el método ha devuelto el valor true");
            toThrow(error, toThrow);
            //
            this.println("\tTest 2: se invoca pasando un nombre de clave que SÍ está en el esquema ");
            error = this.sAssertTrue(instance.contieneClave("nombreClave"),
                    valorTotal / 2, "Error: se ha pasado el nombre de una clave que SÍ está en el "
                    + "esquema, y sin embargo, el método ha devuelto el valor false");
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
    public void test04_iterator() {
        double valorTotal = 1.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tEsquema::iterator(). Valor: " + valorTotal);
        //
        try {
            Clave clave = new Clave("nombreClave");
            Esquema instance = new Esquema();
            instance.addClave(clave);
            Object iterator = instance.iterator();
            if (iterator instanceof Iterator) {
                Object first = ((Iterator) iterator).next();
                if (first instanceof Clave) {
                    error = this.sAssertTrue(true, valorTotal, "");
                } else {
                    error = this.sAssertTrue(false, valorTotal, "Error: el método "
                            + "devuelve un iterador que NO es un iterador sobre objetos "
                            + "de clase Clave");
                    toThrow(error, toThrow);
                }
            } else {
                error = this.sAssertTrue(false, valorTotal, "El método "
                        + "NO devuelve un iterador");
                toThrow(error, toThrow);
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
    public void test05_getNumCampos() {
        double valorTotal = 1.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tEsquema::getNumCampos(). Valor: " + valorTotal);
        //
        try {
            Clave clave1 = new Clave("nombreClave1");
            Clave clave2 = new Clave("nombreClave2", true);
            Esquema esquema = new Esquema();
            esquema.addClave(clave1);
            esquema.addClave(clave2);
            int returned = esquema.getNumCampos();
            error = this.sAssertEquals(2, returned, valorTotal, "Error: "
                    + "se ha creado un esquema con dos claves; sin embargo el método "
                    + "ha devuelto el valor: " + returned);
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
}

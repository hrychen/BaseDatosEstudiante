/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.dominio.esquema;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.corrector.TestAll;
import java.util.Map;
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
public class ClaveTest extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public ClaveTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        System.out.println("\nCorrigiendo clase Clave");
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Clave");
        nota.put("Clave", puntosTotales);
        puntosTotales = 0;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test01_ConstructorCon1Argumento() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 3.0;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE

        Clave instance = null;
        String nombre = "claveUnica";
        boolean unica = true;
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            this.printlnAlways("\n\tClave::Clave(nombre). Valor: " + valorTotal);
            instance = new Clave(nombre);
            this.checkAttributeAfterConstructor(instance, "nombre", nombre,
                    valorTotal, 0.25, 0.25, 1);
            this.checkAttributeAfterConstructor(instance, "unica", false,
                    valorTotal, 0.25, 0.25, 3);
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
    public void test01_ConstructorCon2Argumentos() {
        //PONER EN TODOS: ES EL VALOR DEL MÉTODO QUE SE PRUEBA
        double valorTotal = 5.0;
        //PONER EN TODOS: PARA GESTIONAR LOS ERRORES
        AssertionError toThrow = null;
        AssertionError error = null;
        //PONER EN TODOS: SON LOS PUNTOS ASIGNADOS ANTES DE EJECUTAR ESTE TEST
        double puntosAntes = puntosTotales;
        //PONER EN TODOS: UN MENSAJE QUE DIGA QUÉ MÉTODO SE PRUEBA Y
        //QUÉ VALOR TIENE

        Clave instance = null;
        String nombre = "claveUnica";
        boolean unica = true;
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            double valor = 5.0;
            this.printlnAlways("\n\tClave::Clave(nombre,unica). Valor: " + valorTotal);
            instance = new Clave(nombre, unica);
            this.checkAttributeAfterConstructor(instance, "nombre", nombre,
                    valorTotal, 0.25, 0.25, 1);
            this.checkAttributeAfterConstructor(instance, "unica", unica,
                    valorTotal, 0.25, 0.25, 3);
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
     * Test of getNombre method, of class Clave.
     */
    @Test
    public void test03_getNombre() {
        double valorTotal = 1.0;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tClave::getNombre(). Valor: " + valorTotal);
        //
        try {
            Clave instance = new Clave("nombreClave");
            this.println("\tTest 1: comprobar que se retorna el valor de "
                    + " \'nombre\' al invocar este método.");
            error = this.checkFieldValue(instance, "nombre", instance.getNombre(),
                    valorTotal, toThrow);
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
    public void test04_isUnica() {
        double valorTotal = 1.0;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tClave::isUnica(). Valor: " + valorTotal);
        //
        try {
            Clave instance = new Clave("nombreClaveUnica", true);
            this.println("\tTest 1: comprobar que se retorna el valor de "
                    + " \'unica\' al invocar este método.");
            error = this.checkFieldValue(instance, "unica", instance.isUnica(),
                    valorTotal, toThrow);
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

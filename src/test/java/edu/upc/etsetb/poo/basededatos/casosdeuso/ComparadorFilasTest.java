/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.casosdeuso;

import edu.upc.ac.corrector.SuperClassForTests;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;
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
public class ComparadorFilasTest extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public ComparadorFilasTest() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        System.out.println("\nCorrigiendo clase ComparadorFilas");
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "ComparadorFilas");
        nota.put("ComparadorFilas", puntosTotales);
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

        ComparadorFilas instance = null;
        String nombre = "claveUnica";
        boolean unica = true;
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            //String claveAComparar, boolean ascendente
            this.printlnAlways("\n\tComparadorFilas::ComparadorFilas(claveACompar,ascendente). Valor: " + valorTotal);
            String claveAComparar = "cAComparar";
            boolean ascendente = true;
            instance = new ComparadorFilas(claveAComparar, ascendente);
            this.checkAttributeAfterConstructor(instance, "claveAComparar", claveAComparar,
                    valorTotal, 0.25, 0.25, 1);
            this.checkAttributeAfterConstructor(instance, "ascendente", ascendente,
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
    public void test02_compare(){
        double valorTotal = 9.0;
        int numTests = 18;
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;
        
        this.testAscendente(valorTotal,numTests);
        this.testDescendente(valorTotal,numTests);

        //AÑADIR SIEMPRE PARA ACUMULAR LOS PUNTOS
        this.acumula(puntos);
        //AÑADIR SIEMPRE PARA MOSTRAR LOS PUNTOS OBTENIDOS Y LOS ACUMULADOS 
        //EN LA CLASE
        puntos(puntosAntes);
        //AÑADIR SIEMPRE PARA ENCADENAR MENSAJES DE ERROR
    }

    private void testAscendente(double valorTotal,int numTests) {
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        ComparadorFilas instance = null;
        String claveAComparar = "claveAComparar";
        boolean unica = true;
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        this.printlnAlways("\n\tComparadorFilas::compare(o1,o2). Valor: " + valorTotal);
        try {
            boolean ascendente = true;
            FilaDatos fila1 = new FilaDatos();
            fila1.put("fila1Clave", "27");
            FilaDatos fila2 = new FilaDatos();
            fila2.put("fila2Clave", "28");
            int devuelto;
            //
            this.printlnAlways("\tTest 1: Ascendente. Las 2 filas sin la clave");
            instance = new ComparadorFilas("otraClaveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertEquals(0, devuelto,
                    valorTotal/numTests, "Error: ninguna de las filas tiene la clave "
                    + "a comparar; sin embargo el método NO ha devuelto el valor 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 2: Ascendente. La primera fila con la clave, la segunda sin la clave");
            instance = new ComparadorFilas("fila1Clave", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto>0,
                    valorTotal/numTests, "Error: la primera fila tiene la clave "
                    + "a comparar; la segunda no la tiene; sin embargo el método NO ha devuelto un "
                            + "valor mayor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 3: Ascendente. La primera fila sin la clave, la segunda con la clave");
            instance = new ComparadorFilas("fila2Clave", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto<0,
                    valorTotal/numTests, "Error: la primera fila no tiene la clave "
                    + "a comparar; la segunda la tiene; sin embargo el método NO ha devuelto un "
                            + "valor menor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            // Casos de ambas filas con clave y valores de claves: representaciones textuales de números
            //
            this.printlnAlways("\tTest 4: Ascendente. Las dos filas tienen la clave, los valores son "
                    + "representaciones textuales de números, ambos valores son iguales");
            fila1.put(claveAComparar, "1");
            fila2.put(claveAComparar, "1");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto==0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave y sus valores "
                    + "son idénticos; sin embargo el método NO ha devuelto un "
                            + "0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 5: Ascendente. Las dos filas tienen la clave, los valores son "
                    + "representaciones textuales de números, el valor de la "
                    + "primera es mayor que el de la segunda");
            fila1.put(claveAComparar, "2");
            fila2.put(claveAComparar, "1");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto>0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave, el valor de la "
                    + "primera es mayor que el de la segunda; sin embargo el"
                            + " método NO ha devuelto un valor mayor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 6: Ascendente. Las dos filas tienen la clave, los valores son "
                    + "representaciones textuales de números, el valor de la "
                    + "primera es menor que el de la segunda");
            fila1.put(claveAComparar, "2");
            fila2.put(claveAComparar, "4");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto<0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave, el valor de la "
                    + "primera es menor que el de la segunda; sin embargo el"
                            + " método NO ha devuelto un valor menor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            // Casos de ambas filas con clave y valores de claves: NO representaciones textuales de números
            //
            this.printlnAlways("\tTest 7: Ascendente. Las dos filas tienen la clave, los valores NO son "
                    + "representaciones textuales de números, ambos valores son iguales");
            fila1.put(claveAComparar, "valor");
            fila2.put(claveAComparar, "valor");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto==0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave y sus valores "
                    + "son idénticos; sin embargo el método NO ha devuelto un "
                            + "0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 8: Ascendente. Las dos filas tienen la clave, los valores NO son "
                    + "representaciones textuales de números, el valor de la "
                    + "primera es mayor que el de la segunda");
            fila1.put(claveAComparar, "Defectuoso");
            fila2.put(claveAComparar, "Correcto");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto>0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave, el valor de la "
                    + "primera es mayor que el de la segunda; sin embargo el"
                            + " método NO ha devuelto un valor mayor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 9: Ascendente. Las dos filas tienen la clave, los valores NO son "
                    + "representaciones textuales de números, el valor de la "
                    + "primera es menor que el de la segunda");
            fila1.put(claveAComparar, "Correcto");
            fila2.put(claveAComparar, "Defectuoso");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto<0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave, el valor de la "
                    + "primera es menor que el de la segunda; sin embargo el"
                            + " método NO ha devuelto un valor menor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

    private void testDescendente(double valorTotal,int numTests) {
        AssertionError toThrow = null;
        AssertionError error = null;
        double puntosAntes = puntosTotales;

        ComparadorFilas instance = null;
        String claveAComparar = "claveAComparar";
        boolean unica = true;
        //
        //AQUÍ COMIENZAN LAS TAREAS DE PRUEBA PROPIAMENTE DICHAS
        //
        // HAY QUE ENCAPSULAR CADA PRUEBA EN UN TRY-CATCH QUE CAPTURE
        // EXCEPCIONES LANZADAS POR EL CÓDIGO DE LOS ESTUDIANTES
        try {
            boolean ascendente = false;
            FilaDatos fila1 = new FilaDatos();
            fila1.put("fila1Clave", "27");
            FilaDatos fila2 = new FilaDatos();
            fila2.put("fila2Clave", "28");
            int devuelto;
            //
            this.printlnAlways("\tTest 10: Descendente. Las 2 filas sin la clave");
            instance = new ComparadorFilas("otraClaveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertEquals(0, devuelto,
                    valorTotal/numTests, "Error: ninguna de las filas tiene la clave "
                    + "a comparar; sin embargo el método NO ha devuelto el valor 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 11: Descendente. La primera fila con la clave, la segunda sin la clave");
            instance = new ComparadorFilas("fila1Clave", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto<0,
                    valorTotal/numTests, "Error: la primera fila tiene la clave "
                    + "a comparar; la segunda no la tiene; sin embargo el método NO ha devuelto un "
                            + "valor menor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 12: Descendente. La primera fila sin la clave, la segunda con la clave");
            instance = new ComparadorFilas("fila2Clave", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto>0,
                    valorTotal/numTests, "Error: la primera fila no tiene la clave "
                    + "a comparar; la segunda la tiene; sin embargo el método NO ha devuelto un "
                            + "valor mayor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            // Casos de ambas filas con clave y valores de claves: representaciones textuales de números
            //
            this.printlnAlways("\tTest 13: Descendente. Las dos filas tienen la clave, los valores son "
                    + "representaciones textuales de números, ambos valores son iguales");
            fila1.put(claveAComparar, "1");
            fila2.put(claveAComparar, "1");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto==0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave y sus valores "
                    + "son idénticos; sin embargo el método NO ha devuelto un "
                            + "0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 14: Descendente. Las dos filas tienen la clave, los valores son "
                    + "representaciones textuales de números, el valor de la "
                    + "primera es mayor que el de la segunda");
            fila1.put(claveAComparar, "2");
            fila2.put(claveAComparar, "1");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto<0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave, el valor de la "
                    + "primera es mayor que el de la segunda; sin embargo el"
                            + " método NO ha devuelto un valor menor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 15: Descendente. Las dos filas tienen la clave, los valores son "
                    + "representaciones textuales de números, el valor de la "
                    + "primera es menor que el de la segunda");
            fila1.put(claveAComparar, "2");
            fila2.put(claveAComparar, "4");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto>0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave, el valor de la "
                    + "primera es menor que el de la segunda; sin embargo el"
                            + " método NO ha devuelto un valor mayor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            // Casos de ambas filas con clave y valores de claves: NO representaciones textuales de números
            //
            this.printlnAlways("\tTest 16: Descendente. Las dos filas tienen la clave, los valores NO son "
                    + "representaciones textuales de números, ambos valores son iguales");
            fila1.put(claveAComparar, "valor");
            fila2.put(claveAComparar, "valor");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto==0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave y sus valores "
                    + "son idénticos; sin embargo el método NO ha devuelto un "
                            + "0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 17: Descendente. Las dos filas tienen la clave, los valores NO son "
                    + "representaciones textuales de números, el valor de la "
                    + "primera es mayor que el de la segunda");
            fila1.put(claveAComparar, "Defectuoso");
            fila2.put(claveAComparar, "Correcto");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto<0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave, el valor de la "
                    + "primera es mayor que el de la segunda; sin embargo el"
                            + " método NO ha devuelto un valor menor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            //
            this.printlnAlways("\tTest 18: Descendente. Las dos filas tienen la clave, los valores NO son "
                    + "representaciones textuales de números, el valor de la "
                    + "primera es menor que el de la segunda");
            fila1.put(claveAComparar, "Correcto");
            fila2.put(claveAComparar, "Defectuoso");
            instance = new ComparadorFilas("claveAComparar", ascendente);
            devuelto = instance.compare(fila1, fila2);
            error = this.sAssertTrue(devuelto>0,
                    valorTotal/numTests, "Error: Ambas filas tienen la clave, el valor de la "
                    + "primera es menor que el de la segunda; sin embargo el"
                            + " método NO ha devuelto un valor mayor que 0. Ha devuelto: " + devuelto);
            toThrow(error, toThrow);
            
        } catch (Exception ex) {
            this.printlnAlways("*** Se ha capturado una excepción que probablemente "
                    + "ha sido lanzada por tu código. Mira la traza para "
                    + "detectar en qué punto ha sido creada y lanzada...");
            this.printStackTraceUpc(ex);
        }
    }

}

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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
public class Tabla1Test extends SuperClassForTests {

    private static int numErrorsBefore;

    private static int numInstances = 0;

    private static Map<String, Double> nota;

    public Tabla1Test() {
        super();
        numInstances++;
        if (numInstances == 1) {
            numErrorsBefore = SuperClassForTests.indErrors.size();
        }
    }

    @BeforeClass
    public static void setUpClass() {
        nota = TestAll.notas;
        System.out.println("\nCorrigiendo clase Tabla menos métodos:\n\t "
                + "public List<FilaDatos> busca(Criterio criterio).\n\t "
                + "public List<FilaDatos> elimina(Criterio criterio).");
    }

    @AfterClass
    public static void tearDownClass() {
        showErrors(indErrors, "Tabla1");
        nota.put("Tabla1", puntosTotales);
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
            this.printlnAlways("\n\tTabla::Tabla(nombre,esquema). Valor: " + valorTotal);
            Esquema esquema = this.createEsquema();
            String nombre = "nombreTabla";
            Tabla instance = new Tabla(nombre, esquema);
            double individualVal = valorTotal / 7;
            double individualPer = 1.0 / 7;
            //Comprobar atributo 'nombre'
            this.checkAttributeAfterConstructor(instance, "nombre", nombre,
                    valorTotal, individualPer, individualPer, 1);
            //Comprobar atributo 'esquema'
            this.checkAttributeAfterConstructor(instance, "esquema", esquema,
                    valorTotal, individualPer, individualPer, 3);

            //Comprobar atributo 'filas'
            // . Comprobar que existe
            this.printlnAlways("\tTest 5: comprobación de que el atributo \'filas\' existe");
            error = this.checkPrivateFieldExists(instance, "filas", individualVal, toThrow);
            toThrow(error, toThrow);
            Optional<Object> filasValOpt = this.getPrivateFieldValue(instance, "filas");
            if (filasValOpt.isPresent()) {
                // . Comprobar que es una lista
                this.printlnAlways("\tTest 6: comprobación de que el atributo \'filas\' es una lista");
                error = this.checkPrivateFieldIsOfASpecificClass(instance,
                        "filas", List.class, individualVal, toThrow);
                toThrow(error, toThrow);
                // . Comprobar que es una lista vacía
                if (error == null) {
                    List filasVal = (List) filasValOpt.get();
                    this.printlnAlways("\tTest 7: comprobación de que la lista \'filas\' está vacía");
                    error = this.sAssertTrue(filasVal.size() == 0, individualVal,
                            "Error. El atributo \'filas\' debe ser una lista vacía, "
                            + "pero tiene " + filasVal.size() + " elementos");
                    toThrow(error, toThrow);
                }
            } else {
                error = this.sAssertTrue(false, 0, "Error. "
                        + "el atributo \'filas\' tiene un valor null");
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
    public void test02_anyade() {
        double valorTotal = 5.5;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        int numTests = 7;
        this.printlnAlways("\n\tTabla::anyade(filaDatos). Valor: " + valorTotal);
        try {
            this.printlnAlways("\tTest 1: Se añade una fila correcta a una tabla vacía");
            Tabla instance;
            //Crear un Esquema
            Esquema esquema = this.createEsquema();
            //Crear la tabla con el esquema
            String nombre = "nombreTabla";
            Tabla nonEmptyInstance = new Tabla(nombre, esquema);
            //Crear una fila y añadirla a la tabla
            FilaDatos filaCorrecta = this.createFilaDatosValida();
            try {
                nonEmptyInstance.anyade(filaCorrecta);
                this.sAssertTrue(true, valorTotal / numTests, "");
            } catch (Exception ex) {
                error = this.sAssertTrue(false, 0.0, "Error. Se ha intentado añadir "
                        + "una fila válida con respecto al esquema, pero el método ha "
                        + "lanzado una excepción de clase " + ex.getClass().getSimpleName());
                toThrow(error, toThrow);
            }
            try {
                this.printlnAlways("\tTest 2: Se intenta añadir una fila que no tiene la "
                        + "clave única a una tabla vacía");
                //Crear un Esquema
                esquema = this.createEsquema();
                //Crear la tabla con el esquema
                instance = new Tabla(nombre, esquema);
                //Crear una fila y añadirla a la tabla
                FilaDatos filaIncorrecta = this.createFilaDatosNoValidaPorClave();
                //
                instance.anyade(filaIncorrecta);
                error = this.sAssertTrue(false, 0.0, "Error. Se ha podido añadir "
                        + "una fila inválida con respecto al esquema, cuando el método debería haber "
                        + "lanzado una excepción");
                toThrow(error, toThrow);
            } catch (Exception ex) {
                if (!(ex instanceof ClaveInexistenteException)) {
                    error = this.sAssertTrue(false, 0.0, "Error. Se ha intentado añadir "
                            + "una fila inválida con respecto al esquema, porque no tiene la "
                            + "clave única pero el método NO ha "
                            + "lanzado una excepción de clase ClaveInexistenteException; "
                            + "en su lugar ha lanzado una excepción de clase" + ex.getClass().getSimpleName());
                    toThrow(error, toThrow);
                } else {
                    this.sAssertTrue(true, valorTotal / numTests, "");
                }
            }
            //
            try {
                this.printlnAlways("\tTest 3: Se intenta añadir una fila que tiene la "
                        + "clave única pero tiene claves que no están en el esquema a una tabla vacía");
                //Crear un Esquema
                esquema = this.createEsquema();
                //Crear la tabla con el esquema
                instance = new Tabla(nombre, esquema);
                //Crear una fila y añadirla a la tabla
                FilaDatos filaIncorrecta = this.createFilaDatosNoValidaPorTamanyo();
                //
                instance.anyade(filaIncorrecta);
                error = this.sAssertTrue(false, 0.0, "Error. Se ha podido añadir "
                        + "una fila inválida con respecto al esquema, cuando el método debería haber "
                        + "lanzado una excepción");
                toThrow(error, toThrow);
            } catch (Exception ex) {
                if (!(ex instanceof ClaveInexistenteException)) {
                    error = this.sAssertTrue(false, 0.0, "Error. Se ha intentado añadir "
                            + "una fila inválida con respecto al esquema, porque no tiene la "
                            + "clave única pero el método NO ha "
                            + "lanzado una excepción de clase ClaveInexistenteException; "
                            + "en su lugar ha lanzado una excepción de clase" + ex.getClass().getSimpleName());
                    toThrow(error, toThrow);
                } else {
                    this.sAssertTrue(true, valorTotal / numTests, "");
                }
            }
            //
            try {
                this.printlnAlways("\tTest 4: Se intenta añadir una fila correcta en "
                        + "una tabla no vacía");
                //Crear una fila y añadirla a la tabla
                filaCorrecta = this.createOtraFilaDatosValida();
                //
                nonEmptyInstance.anyade(filaCorrecta);
                this.sAssertTrue(true, valorTotal / numTests, "");
            } catch (Exception ex) {
                error = this.sAssertTrue(false, 0.0, "Error. Se ha intentado añadir "
                        + "una fila válida con respecto al esquema, pero el método ha "
                        + "lanzado una excepción de clase " + ex.getClass().getSimpleName());
                toThrow(error, toThrow);
            }
            //
            try {
                this.printlnAlways("\tTest 5: Se intenta añadir una fila incorrecta "
                        + "porque contiene una clave única con un valor que ya "
                        + "está en otra fila, en una tabla no vacía");
                //Crear una fila y añadirla a la tabla
                FilaDatos filaIncorrecta = this.createOtraFilaDatosNoValidaPorValorClaveUnica();
                //
                nonEmptyInstance.anyade(filaIncorrecta);
                error = this.sAssertTrue(false, 0.0, "Error. Se ha podido añadir "
                        + "una fila inválida que contiene la clave única repetida, cuando el método debería haber "
                        + "lanzado una excepción");
                toThrow(error, toThrow);
            } catch (Exception ex) {
                if (!(ex instanceof ValorClaveUnicaException)) {
                    error = this.sAssertTrue(false, 0.0, "Error. Se ha intentado añadir "
                            + "una fila inválida con respecto al esquema, porque no tiene la "
                            + "clave única pero el método NO ha "
                            + "lanzado una excepción de clase ValorClaveUnicaException; "
                            + "en su lugar ha lanzado una excepción de clase" + ex.getClass().getSimpleName());
                    toThrow(error, toThrow);
                } else {
                    this.sAssertTrue(true, valorTotal / numTests, "");
                }
            }
            //
            try {
                this.printlnAlways("\tTest 6: Se intenta añadir una fila incorrecta "
                        + "porque contiene una clave que no existe en el "
                        + "esquema, en una tabla no vacía");
                //Crear una fila y añadirla a la tabla
                FilaDatos filaIncorrecta = this.createOtraFilaDatosNoValidaPorClaveInexistente();
                //
                nonEmptyInstance.anyade(filaIncorrecta);
                error = this.sAssertTrue(false, 0.0, "Error. Se ha podido añadir "
                        + "una fila inválida que contiene una clave inexistente en "
                        + "el esquema, cuando el método debería haber lanzado una excepción");
                toThrow(error, toThrow);
            } catch (Exception ex) {
                if (!(ex instanceof ClaveInexistenteException)) {
                    error = this.sAssertTrue(false, 0.0, "Error. Se ha intentado añadir "
                            + "una fila inválida con respecto al esquema, porque contiene una "
                            + "clave inexistente pero el método NO ha lanzado "
                            + "una excepción de clase ClaveInexistenteException; "
                            + "en su lugar ha lanzado una excepción de clase" + ex.getClass().getSimpleName());
                    toThrow(error, toThrow);
                } else {
                    this.sAssertTrue(true, valorTotal / numTests, "");
                }
            }
            //
            try {
                this.printlnAlways("\tTest 7: Se intenta añadir una fila incorrecta "
                        + "porque no contiene el mismo número de claves que el "
                        + "esquema, en una tabla no vacía");
                //Crear una fila y añadirla a la tabla
                FilaDatos filaIncorrecta = this.createFilaDatosNoValidaPorTamanyo();
                //
                nonEmptyInstance.anyade(filaIncorrecta);
                error = this.sAssertTrue(false, 0.0, "Error. Se ha podido añadir "
                        + "una fila inválida que contiene una clave inexistente en "
                        + "el esquema, cuando el método debería haber lanzado una excepción");
                toThrow(error, toThrow);
            } catch (Exception ex) {
                if (!(ex instanceof ClaveInexistenteException)) {
                    error = this.sAssertTrue(false, 0.0, "Error. Se ha intentado añadir "
                            + "una fila inválida con respecto al esquema, porque contiene una "
                            + "clave inexistente pero el método NO ha lanzado "
                            + "una excepción de clase ClaveInexistenteException; "
                            + "en su lugar ha lanzado una excepción de clase" + ex.getClass().getSimpleName());
                    toThrow(error, toThrow);
                } else {
                    this.sAssertTrue(true, valorTotal / numTests, "");
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
    }

    @Test
    public void test03_buscaTodo() {
        double valorTotal = 0.5;
        int numTests = 4;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tTabla::buscaTodo(). Valor: " + valorTotal);
        //
        try {
            //Crear un Esquema
            Esquema esquema = this.createEsquema();
            //Crear la tabla con el esquema
            String nombre = "nombreTabla";
            Tabla instance = new Tabla(nombre, esquema);
            FilaDatos fila = this.createFilaDatosValida();
            instance.anyade(fila);
            fila = this.createOtraFilaDatosValida();
            instance.anyade(fila);
            fila = this.createTerceraFilaDatosValida();
            instance.anyade(fila);

            Optional<Object> filasAttrOpt = this.getPrivateFieldValue(instance, "filas");
            if (filasAttrOpt.isPresent()) {
                List<FilaDatos> filasAttr = (List<FilaDatos>) filasAttrOpt.get();
                List<FilaDatos> filas = instance.buscaTodo();
                error = this.sAssertEquals(filasAttr.size(), filas.size(),
                        valorTotal / numTests, "Error. El número de filas en la "
                        + "lista recuperada NO es el mismo que el "
                        + "número de filas en el atributo \'filas\'");
                this.toThrow(error, toThrow);
                if (error == null) {
                    Iterator<FilaDatos> itToCheck = filas.iterator();
                    Iterator<FilaDatos> itForAttr = filasAttr.iterator();
                    int count = 0;
                    while (itForAttr.hasNext()) {
                        if (itToCheck.next() == itForAttr.next()) {
                            this.sAssertTrue(true, valorTotal / numTests, "");
                        } else {
                            this.sAssertTrue(false, 0, "Error. "
                                    + "Las filas con índice " + count + " NO son "
                                    + "el mismo objeto; deberían serlo");
                            toThrow(error, toThrow);
                        }
                        count++;
                    }
                }
            } else {
                error = this.sAssertTrue(false, 0, "Error. The "
                        + "Table object does not has a non null value for attribute "
                        + "\'filas\'");
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
    public void test04_getEsquema() {
        double valorTotal = 0.5;
        int numTests = 1;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tTabla::getEsquema(). Valor: " + valorTotal);
        //
        try {
            //Crear un Esquema
            Esquema esquema = this.createEsquema();
            //Crear la tabla con el esquema
            String nombre = "nombreTabla";
            Tabla instance = new Tabla(nombre, esquema);
            Esquema retrieved = instance.getEsquema();
            Optional<Object> inAttrOpt = this.getPrivateFieldValue(instance, "esquema");
            if (inAttrOpt.isPresent()) {
                error = this.sAssertEquals(inAttrOpt.get(), retrieved,
                        valorTotal / numTests, "Error. El esquema retornado no es "
                        + "el mismo que el esquema que hay en el atributo "
                        + "\'esquema\'");
                toThrow(error, toThrow);
            } else {
                error = this.sAssertTrue(false, 0, "Error. El valor "
                        + "del atributo \'esquema\' es null. No debería serlo");
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
    public void test05_getCabeceras() {
        double valorTotal = 2;
        int numTests = 1;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tTabla::getCabeceras(). Valor: " + valorTotal);
        //
        try {
            //Crear un Esquema
            Esquema esquema = this.createEsquema();
            //Crear la tabla con el esquema
            String nombre = "nombreTabla";
            Tabla instance = new Tabla(nombre, esquema);
            Set<String> expected = new HashSet<>();
            for (int i = 0; i < 5; i++) {
                expected.add("nombreClave-" + (i + 1));
            }
            Set<String> retrieved = new HashSet(instance.getCabeceras());
            error = this.sAssertEquals(expected, retrieved, valorTotal / numTests,
                    "Error. La lista de cabeceras recuperada no es la esperada.");
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
    public void test06_ordena() {
        double valorTotal = 0.5;
        int numTests = 2;
        AssertionError error = null;
        AssertionError toThrow = null;
        double puntosAntes = puntosTotales;
        this.printlnAlways("\n\tTabla::ordena(). Valor: " + valorTotal);
        //
        try {
            //Crear un Esquema
            Esquema esquema = this.createEsquema();
            //Crear la tabla con el esquema
            String nombre = "nombreTabla";
            Tabla instance = new Tabla(nombre, esquema);
            FilaDatos fila_1 = this.createFilaDatosValida();
            instance.anyade(fila_1);
            FilaDatos fila_2 = this.createOtraFilaDatosValida();
            instance.anyade(fila_2);
            FilaDatos fila_3 = this.createTerceraFilaDatosValida();
            instance.anyade(fila_3);
            //
            this.printlnAlways("\tTest 1: Se ordena en orden ascendente");
            instance.ordena("nombreClave-3", true);
            List<FilaDatos> filas = instance.buscaTodo();
            if(filas.get(0)==fila_3 && filas.get(1)==fila_1
                    && filas.get(2)==fila_2){
                this.sAssertTrue(true, valorTotal/numTests,"");
            }else{
                error = this.sAssertTrue(false, 0,"Error. "
                        + "La lista de filas NO está ordenada en orden ascendente "
                        + "según la columna \'nombreClave-3\'");
                this.toThrow(error, toThrow);
            }
            //
            this.printlnAlways("\tTest 2: Se ordena en orden descendente");
            instance.ordena("nombreClave-3", false);
            filas = instance.buscaTodo();
            if(filas.get(0)==fila_2 && filas.get(1)==fila_1
                    && filas.get(2)==fila_3){
                this.sAssertTrue(true, valorTotal/numTests,"");
            }else{
                error = this.sAssertTrue(false, 0,"Error. "
                        + "La lista de filas NO está ordenada en orden descendente "
                        + "según la columna \'nombreClave-3\'");
                this.toThrow(error, toThrow);
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

    private FilaDatos createOtraFilaDatosValida() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 5; i++) {
            fila.put("nombreClave-" + (i + 1), "valor-" + (i + 500));
        }
        return fila;
    }

    private FilaDatos createTerceraFilaDatosValida() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 5; i++) {
            fila.put("nombreClave-" + (i + 1), "valor-" + (i + 200));
        }
        return fila;
    }

    private FilaDatos createOtraFilaDatosNoValidaPorValorClaveUnica() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 5; i++) {
            fila.put("nombreClave-" + (i + 1), "valor-" + (i + 1));
        }
        return fila;
    }

    private FilaDatos createOtraFilaDatosNoValidaPorClaveInexistente() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                fila.put("nombreClave-" + (i + 1), "valor-" + 200);
            } else if (i == 1) {
                fila.put("nombreClave-" + 20, "valor-" + 200);
            } else {
                fila.put("nombreClave-" + (i + 1), "valor-" + (i + 1));
            }
        }
        return fila;
    }

    private FilaDatos createFilaDatosNoValidaPorTamanyo() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 4; i++) {
            if (i == 3) {
                fila.put("nombreClave-" + (i + 1), "valor-" + 350);
            } else {
                fila.put("nombreClave-" + (i + 1), "valor-" + (i + 1));
            }
        }
        return fila;
    }

    private FilaDatos createFilaDatosNoValidaPorClave() {
        FilaDatos fila = new FilaDatos();
        for (int i = 0; i < 4; i++) {
            if (i < 4) {
                fila.put("nombreClave-" + (i + 1), "valor-" + (i + 1));
            } else {
                fila.put("malNombreClave", "valor-" + (i + 1));
            }
        }
        return fila;
    }

}

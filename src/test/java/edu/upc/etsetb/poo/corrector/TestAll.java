/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.corrector;

import edu.upc.ac.corrector.SuperClassForTests;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.rules.ErrorCollector;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
public class TestAll {

    private static String[] clases = {
        "Clave", "Esquema", "FilaDatos",
        "ComparadorFilas", "Tabla1",
        "CriterioIgual", "CriterioContiene", "CriterioMenorQue",
        "CriterioMayorQue","Tabla2","Controlador"};

    public static final double[] tantosPorCiento = {
        5, //Clave
        7.5, //Esquema
        7.5, //FilaDatos
        7.5, //ComparadorFilas
        7.5, //Tabla1
        7.5,//CriterioIgual
        7.5,//CriterioContiene
        7.5,//CriterioMenorQue
        7.5,//CriterioMayorQue
        7.5,//Tabla2
        27.5//Controlador
    };

    public static Map<String, Double> notas;
    public static Map<String, Double> porcentajes;
    public static Map<String, List<AssertionError>> errorsByClass ;

    public static ErrorCollector allCollector;

    static {
        notas = new HashMap<>();
        porcentajes = new HashMap<>();
        int i = -1;
        for (String className : clases) {
            i++;
            notas.put(className, 0.0);
            porcentajes.put(className, tantosPorCiento[i]);
        }
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);
        errorsByClass = SuperClassForTests.getErrorsByClass();
        System.out.println("\n\nResumen de notas obtenidas en corrección automática:\n");
        double notaFinal = 0;
        double notaParcial;
        for (Map.Entry<String, Double> nota : notas.entrySet()) {
            String className = nota.getKey();
            notaParcial = nota.getValue() * porcentajes.get(className) / 100;
            notaFinal += notaParcial;
            System.out.println("Nota en clase " + className
                    + ": " + SuperClassForTests.withMathRound(nota.getValue(), 3) + " (Porcentaje en nota final: "
                    + porcentajes.get(className) + "%). Contribución a nota final: " + notaParcial);
            
        }
        System.out.println("\nNota final de corrección automática: " + SuperClassForTests.withMathRound(notaFinal, 3));
        StringBuilder errores = new StringBuilder("\nListado de errores detectados:\n");
        for(String clase: errorsByClass.keySet()){
            if(errorsByClass.get(clase).size()!=0){
                List<AssertionError> assertions = errorsByClass.get(clase);
                errores.append("\tErrores detectados por clase " + clase +"\n");
                for(AssertionError error: assertions){
                    errores.append("\t\t"+error.getMessage()+"\n");
                }
            }
        }
        String erroresMssg = errores.toString();
        if(!erroresMssg.equals("\nListado de errores detectados:\n")){
            System.out.println(errores.toString());
        }
    }
}

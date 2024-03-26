/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.poo.corrector;

import edu.upc.etsetb.poo.basededatos.casosdeuso.ComparadorFilasTest;
import edu.upc.etsetb.poo.basededatos.casosdeuso.ControladorTest;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioContieneTest;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioIgualTest;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioMayorQueTest;
import edu.upc.etsetb.poo.basededatos.casosdeuso.busqueda.CriterioMenorQueTest;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.ClaveTest;
import edu.upc.etsetb.poo.basededatos.dominio.esquema.EsquemaTest;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatosTest;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla1Test;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.Tabla2Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author Juan Carlos Cruellas at Universidad Politécnica de Cataluña
 */
@RunWith(Suite.class)
@SuiteClasses({
ClaveTest.class,
EsquemaTest.class,
FilaDatosTest.class,
ComparadorFilasTest.class,
Tabla1Test.class,
CriterioIgualTest.class,
CriterioContieneTest.class,
CriterioMenorQueTest.class,
CriterioMayorQueTest.class,
Tabla2Test.class,
ControladorTest.class

})


public class TestSuite {


}

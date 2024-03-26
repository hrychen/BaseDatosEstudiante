package edu.upc.etsetb.poo.basededatos.iu;


import edu.upc.etsetb.poo.basededatos.casosdeuso.Controlador;
import edu.upc.etsetb.poo.basededatos.iu.InterfazUsuario;

/**
 * Clase con el método main().
 * <p><b>ESTA CLASE SE OS DA HECHA. NO DEBÉIS MODIFICARLA</b></p>
 */
public class Main {

    public static final void main(String[] args) {

//        BateriaDePruebas.ejecutaTodas();

        System.out.println("Gestor de base de datos 2.0");
        System.out.println("===========================\n");
        Controlador controlador = new Controlador() ;
        InterfazUsuario iu = new InterfazUsuario(controlador);
        controlador.setIu(iu);
        while(!iu.procesaComando());
        System.out.println("\nAdiós!\n");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.iu;

import edu.upc.etsetb.poo.basededatos.casosdeuso.Controlador;
import edu.upc.etsetb.poo.basededatos.dominio.tabla.FilaDatos;
import java.util.List;

/**
 *
 * @author JuanCarlos
 */
public class InterfazUsuarioParaCorrector extends InterfazUsuario {

    private String lastPrintlnConArg = "";
    
    private String lastPrintConArg = "";
    
    private String lastPrintlnSinArg = "";
    
    public InterfazUsuarioParaCorrector(Controlador controlador) {
        super(controlador);
    }
    
    public boolean procesaComando(){
        return true;
    }
    
    public static void anchoFijo(String texto, int ancho){
        
    }
    
    public static void repite(char c, int nVeces){
        
    }
    
    private void ayuda(){
        
    }

    public void presentaResultados(List<String> cabecerasTabla, List<FilaDatos> result){
        
    }
    
    public void println(String texto) {
        this.lastPrintlnConArg=texto;
    }

    public void print(String texto) {
        this.lastPrintConArg=texto;
    }

    public void print() {
        this.lastPrintlnSinArg="\n";
    }
    
    public String getLastPrintlConArg(){
        return this.lastPrintlnConArg;
    }
    
    public String getLastPrintConArg(){
        return this.lastPrintConArg;
    }
    
    public String getLastPrintlnSinArg(){
        return this.lastPrintlnSinArg;
    }
    
    public void resetLastPrintlnConArg(){
        this.lastPrintlnConArg="";
    }
    
    public void resetLastPrintlnSinArg(){
        this.lastPrintlnSinArg="";
    }
    
    public void resetLastPrintConArg(){
        this.lastPrintConArg="";
    }

}

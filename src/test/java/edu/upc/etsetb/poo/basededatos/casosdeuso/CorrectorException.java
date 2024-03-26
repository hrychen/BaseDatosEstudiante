/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package edu.upc.etsetb.poo.basededatos.casosdeuso;

/**
 *
 * @author JuanCarlos
 */
public class CorrectorException extends Exception {

    /**
     * Creates a new instance of <code>CorrectorException</code> without detail
     * message.
     */
    public CorrectorException() {
    }

    /**
     * Constructs an instance of <code>CorrectorException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CorrectorException(String msg) {
        super(msg);
    }
}

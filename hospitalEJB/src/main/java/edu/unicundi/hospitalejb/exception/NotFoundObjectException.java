/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicundi.hospitalejb.exception;

/**
 * @author Erika Moreno
 * @author Anderson Nevao
 * @since  25/04/2021 
 * @version 1.0.0
 */
public class NotFoundObjectException extends Exception {
    public NotFoundObjectException(String string) {
        super(string);
    }
}

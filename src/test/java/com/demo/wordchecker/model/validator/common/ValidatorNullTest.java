/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.demo.wordchecker.model.validator.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Admin
 */
public class ValidatorNullTest {
    
    public ValidatorNullTest() {
    }

    /**
     * Test of valid method, of class ValidatorNull.
     */
    @Test
    public void testValid() {
        
       ValidatorNull validatorNull = new ValidatorNull();
       
        String okString = "test";
        boolean result = validatorNull.valid(okString);
        assertTrue(result);
        
        String notOkString = null;
        result = validatorNull.valid(notOkString);
        assertFalse(result);
        
        notOkString = "";
        result = validatorNull.valid(notOkString);
        assertFalse(result);
       
       
    }
    
}

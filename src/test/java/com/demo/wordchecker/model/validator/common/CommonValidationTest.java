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
public class CommonValidationTest {

    /**
     * Test of isValid method, of class CommonValidation.
     */
    @Test
    public void testIsValid() {
        
        CommonValidation commonValidation = new CommonValidation();
        String numString = "1234";
        boolean result = commonValidation.isValid(numString);
        assertFalse(result);
        
        String spaceString = "1 34";
        result = commonValidation.isValid(spaceString);
        assertFalse(result);
        
        
        String nullString = null;
        result = commonValidation.isValid(nullString);
        assertFalse(result);
        
        
        String okString = "test";
        result = commonValidation.isValid(okString);
        assertTrue(result);
    }
    
}

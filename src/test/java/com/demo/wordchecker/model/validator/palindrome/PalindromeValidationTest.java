/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.demo.wordchecker.model.validator.palindrome;

import com.demo.wordchecker.model.validator.common.CommonValidation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Admin
 */
public class PalindromeValidationTest {
    
    public PalindromeValidationTest() {
    }

    /**
     * Test of isValid method, of class PalidroneValidation.
     */
    @Test
    public void testIsValid() {
        CommonValidation commonValidation = new CommonValidation();
        ValidatorPalindrome validatorPalidrone = new ValidatorPalindrome();
        PalindromeValidation palidroneValidation = new PalindromeValidation(commonValidation, validatorPalidrone);
        
        String numString = "1234";
        boolean result = palidroneValidation.isValid(numString);
        assertFalse(result);
        
        String spaceString = "1 34";
        result = palidroneValidation.isValid(spaceString);
        assertFalse(result);
        
        
        String nullString = null;
        result = palidroneValidation.isValid(nullString);
        assertFalse(result);
        
        
        String falseString = "test";
        result = palidroneValidation.isValid(falseString);
        assertFalse(result);
        
        String okString = "teset";
        result = palidroneValidation.isValid(okString);
        assertTrue(result);
    }
    
}

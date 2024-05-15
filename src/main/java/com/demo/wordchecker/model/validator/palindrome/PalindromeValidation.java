/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.model.validator.palindrome;

import com.demo.wordchecker.model.validator.common.CommonValidation;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public class PalindromeValidation {
    
    
    private final CommonValidation commonValidation;
    private final ValidatorPalindrome validatorPalidrone;
    
    public PalindromeValidation(CommonValidation commonValidation, ValidatorPalindrome validatorPalidrone){
        this.commonValidation = commonValidation;
        this.validatorPalidrone = validatorPalidrone;
    }
    
    public boolean isValid(String text){
        if(!commonValidation.isValid(text)){
            return false;
        } 
        
        return validatorPalidrone.valid(text);
    }
}

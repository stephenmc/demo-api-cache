/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.model.validator.common;


import com.demo.wordchecker.model.validator.Validator;
import org.apache.commons.lang3.StringUtils;

public class ValidatorNumber implements Validator{

    @Override
    public boolean valid(String text) {
    String result = StringUtils.getDigits(text);
    if(result != null && !result.isEmpty()){
        return false;
    }
    
    return true;
    
    }
}

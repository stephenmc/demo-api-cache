/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.model.validator.common;

import com.demo.wordchecker.model.validator.Validator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public class CommonValidation {
    
    
    private final List<Validator> validators = new ArrayList<>();
    
    public CommonValidation(){
        validators.add(new ValidatorNull());
        validators.add(new ValidatorSpace());
        validators.add(new ValidatorNumber());
    }
    
    public boolean isValid(String text){
        return validators.stream().allMatch( v -> v.valid(text));
    }
}

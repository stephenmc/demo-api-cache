/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.model.validator.common;

import com.demo.wordchecker.model.validator.Validator;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class ValidatorNull implements Validator{

    @Override
    public boolean valid(String text) {
        if(text == null || text.trim().length() == 0){
            return false;
        }
        return true;
    }
}

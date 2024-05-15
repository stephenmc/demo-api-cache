/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.model.validator.common;

import com.demo.wordchecker.model.validator.Validator;
import org.apache.commons.lang3.StringUtils;

public class ValidatorSpace implements Validator {

    final String SPACE = " ";

    @Override
    public boolean valid(String text) {
        if (text == null) {
            return false;
        }

        if (StringUtils.contains(text, SPACE)) {
            return false;
        }

        return true;
    }
}

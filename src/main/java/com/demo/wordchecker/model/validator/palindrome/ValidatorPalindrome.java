/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.model.validator.palindrome;

import com.demo.wordchecker.model.validator.Validator;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
public class ValidatorPalindrome implements Validator {

    @Override
    public boolean valid(String text) {
        return Objects.equals(text, StringUtils.reverse(text));
    }
}

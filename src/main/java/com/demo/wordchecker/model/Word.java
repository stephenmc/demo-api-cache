/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.model;

import com.demo.wordchecker.model.enums.WordType.WordTypes;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Word implements Serializable{

 Long id;
 String text;
 String type;

}

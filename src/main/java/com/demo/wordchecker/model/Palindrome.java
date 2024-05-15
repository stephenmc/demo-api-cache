/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.model;

import com.demo.wordchecker.model.enums.WordType.WordTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PALINDROME")
public class Palindrome extends Word implements Serializable {

    public Palindrome(String text, boolean valid) {
        super();
        this.text = text;
        this.valid = valid;
    }
    
    public Palindrome(Long id, String text, boolean valid) {
        super();
        this.id = id;
        this.text = text;
        this.valid = valid;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String text;
    private String type = WordTypes.PALINDROME.name();
    private boolean valid;
    
    @Override
    public boolean equals(Object obj){
        
        if(!(obj  instanceof  Palindrome)){
            return false;
        }
        
        Palindrome check = (Palindrome)obj;
        return (Objects.equals(this.text, check.text));
    }
    
    

}

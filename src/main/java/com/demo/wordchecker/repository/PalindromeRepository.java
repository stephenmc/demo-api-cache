/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.repository;

import com.demo.wordchecker.model.Palindrome;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface PalindromeRepository extends CrudRepository<Palindrome, Long> {

    @Query("SELECT p FROM Palindrome p WHERE p.text = ?1 ")
    Palindrome findByText(String text);
}

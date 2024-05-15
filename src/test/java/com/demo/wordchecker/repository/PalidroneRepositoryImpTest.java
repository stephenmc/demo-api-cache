/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.demo.wordchecker.repository;

import com.demo.wordchecker.model.Palindrome;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Admin
 */
@SpringBootTest
public class PalidroneRepositoryImpTest {
    
    @Autowired
    private PalindromeRepositoryImp palidroneRepositoryImp;

    /**
     * Test of save method, of class PalidroneRepositoryImp.
     */
    @Test
    public void testSave() {
        Palindrome palidroneTest = new Palindrome("MadaM", true);
        Palindrome result = palidroneRepositoryImp.save(palidroneTest);
        
        assertEquals(palidroneTest, result);
    }

    /**
     * Test of findAll method, of class PalidroneRepositoryImp.
     */
    @Test
    public void testFindAll() {
        
        
        Palindrome palidroneTest = new Palindrome("MadaM", true);
        Palindrome result = palidroneRepositoryImp.findByText(palidroneTest.getText());
        //ensure there is 1 record in DB
        if(result == null){
            result = palidroneRepositoryImp.save(palidroneTest);
        }
        List<Palindrome> results = palidroneRepositoryImp.findAll();
        assertEquals(1, results.size());
    }
    
    @Test
    public void findByTextTest(){
        String text = "xMadaMx";
        Palindrome palidroneTest = new Palindrome(text, true);
        Palindrome result = palidroneRepositoryImp.save(palidroneTest);
        assertEquals(palidroneTest, result);
        
        result = palidroneRepositoryImp.findByText(text);
        assertEquals(palidroneTest, result);
    }
    
}

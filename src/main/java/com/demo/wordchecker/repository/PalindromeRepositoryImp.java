/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.repository;

import com.demo.wordchecker.model.Palindrome;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class PalindromeRepositoryImp  {
    
    final private PalindromeRepository palidroneRepository;
    
    public PalindromeRepositoryImp(PalindromeRepository palidroneRepository){
        this.palidroneRepository = palidroneRepository;
    }    

    public Palindrome save(Palindrome p) {
        log.debug("Saving Palindrome to DB");
       return palidroneRepository.save(p);
    }



    public boolean existsById(Long id) {
        return palidroneRepository.findById(id).isPresent();
    }

    public List<Palindrome> findAll() {
        log.debug("Getting all Palindromes from DB");     
        Iterable<Palindrome> dbItems = palidroneRepository.findAll();
        List<Palindrome> palidrones = new ArrayList<>();
        dbItems.forEach(
                db -> palidrones.add(new Palindrome(db.getId(), db.getText(), db.isValid())));
        
        log.debug("Items found: "+palidrones.size()); 
        return palidrones;
    }
    
    public Palindrome findByText(String text){
        return palidroneRepository.findByText(text);
    }


}

package com.demo.wordchecker.service;

import org.springframework.stereotype.Service;
import com.demo.wordchecker.model.Palindrome;
import com.demo.wordchecker.model.validator.palindrome.PalindromeValidation;
import com.demo.wordchecker.repository.PalindromeRepositoryImp;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;

@Service
@Slf4j
public class WordService {
    
    final private PalindromeValidation palidroneValidation;
    final private PalindromeRepositoryImp palidroneRepositoryImp;
    
    public WordService(PalindromeValidation palidroneValidation,
            PalindromeRepositoryImp palidroneRepositoryImp){
        this.palidroneValidation = palidroneValidation;
        this.palidroneRepositoryImp = palidroneRepositoryImp;
    }

    @Cacheable(value ="palindrome", key = "#text")
    public Palindrome check(String text) {
        System.out.println("Working on it: "+text);
        log.debug("checking text: "+text);
        return calulate(text);
 
    }
    
    public Palindrome calulate(String text){
        log.debug("calculating text: "+text);        
        return new Palindrome(text, palidroneValidation.isValid(text));
    }
    
    public List<Palindrome> findAll(){
        log.debug("Getting all Palidrones");     
        return palidroneRepositoryImp.findAll();
    }

    public Palindrome save(Palindrome palindrome) {
        log.debug("Saving Palindrome attempt: "+palindrome.getText());
        return palidroneRepositoryImp.save(palindrome);
    }
    
    public Palindrome findByText(String text) {
        log.debug("checking whether Palindrome exists for: "+text);
        return palidroneRepositoryImp.findByText(text);
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.demo.wordchecker.service;

import com.demo.wordchecker.config.CachingTestConfig;
import com.demo.wordchecker.model.Palindrome;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AopTestUtils;

@ContextConfiguration(classes = { CachingTestConfig.class })
@ExtendWith(SpringExtension.class)
public class WordServiceTest {
    
    private WordService mock;

    @Autowired
    private WordService wordService;
    
    @Autowired
    private CacheManager cacheManager;
        
    private static final Palindrome TEST = new Palindrome("Test", false);

    @BeforeEach
    void setUp() {
        mock = AopTestUtils.getTargetObject(wordService);

        when(mock.check(eq("Test")))
                .thenReturn((TEST));


    }
    
    /**
     * Test of check method, of class WordService.
     */
    @Test
    public void testCheck() {
        String text = "Test";
        assertEquals(TEST, wordService.check(text));
        verify(mock).check("Test");

        assertEquals(TEST, wordService.check(text));
        assertEquals(TEST, wordService.check(text));

        verifyNoMoreInteractions(mock);
        
        Collection<String> names = cacheManager.getCacheNames();
        Cache cache = cacheManager.getCache("palindrome");
        ValueWrapper result = null;
        
        if(cache != null){
            result = cache.get(text);
        }
        if(result == null){
            //throw exception
            assertFalse(true);
        }
        else{
            Palindrome palResult = (Palindrome)result.get();
            assertEquals(TEST, palResult);
            assertFalse(palResult.isValid());
        }
        
    }
    

    
}

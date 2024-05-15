/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.demo.wordchecker.cache;

import com.demo.wordchecker.config.CachingTestConfig;
import com.demo.wordchecker.model.Palindrome;
import com.demo.wordchecker.service.WordService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import static org.mockito.Mockito.verify;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.AopTestUtils;

@ContextConfiguration(classes = {CachingTestConfig.class})
@ExtendWith(SpringExtension.class)
public class CacheLoadTest {

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

    @Test
    public void loadTest() {
        Palindrome tested = new Palindrome("tested", false);
        cacheManager.getCache("palindrome").put(tested.getText(), tested);
        
        Palindrome result = wordService.check(tested.getText());
        assertEquals(tested, result);

        verify(mock, never()).check(tested.getText());
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.demo.wordchecker.controller;

import com.demo.wordchecker.ApiApplication;
import com.demo.wordchecker.config.SecurityConfiguration;

import com.demo.wordchecker.constants.AppConstants;
import com.demo.wordchecker.messaging.jms.Producer;
import com.demo.wordchecker.model.Palindrome;
import com.demo.wordchecker.service.WordService;
import jakarta.jms.Queue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(value = WordController.class)
@ContextConfiguration(classes = { ApiApplication.class, SecurityConfiguration.class })
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    
    @MockBean
    private WordService wordService;
    
    @MockBean
    private Producer producer;


   @Test
    public void testgetPalidroneFalse() throws Exception {
        
        Palindrome palMock = new Palindrome("test", false);
        when(wordService.check(palMock.getText())).thenReturn(palMock);

        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/" + AppConstants.API_WORD + "/palindrome")
                        .param("username", "user1")
                        .param("text", "test")
                        .contentType("application/json")
                        .content(""))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

    }

}

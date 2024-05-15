/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 * @author Admin
 */
@Component
@Slf4j
public class AsyncSave {
    
   
    public void saveAsync(Runnable job){
        new Thread(() -> {
            try{
                job.run();
            }
            catch(Exception ex){
                log.error(ex.getMessage());
            }
        }).start();
    }


    
}

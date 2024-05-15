/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.messaging.jms;

/**
 *
 * @author Admin
 */
import com.demo.wordchecker.config.JmsConfig;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class Consumer {

  @JmsListener(destination = JmsConfig.ORDER_QUEUE)
  public void processMessage(String message) {
    System.out.println("New Message Received -- \n"+message);
  }
}

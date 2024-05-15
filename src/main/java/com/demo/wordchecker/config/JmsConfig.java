/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.wordchecker.config;

import jakarta.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class JmsConfig {

	public static final String ORDER_QUEUE = "order.queue";

	// When spring boot initializes, this active mq queue will be auto created.
	@Bean
	public Queue queue() {
		try {
			return new ActiveMQQueue(ORDER_QUEUE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

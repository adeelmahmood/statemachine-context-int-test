package com.example.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

@SpringBootApplication
public class StatemachineApplication {

    @Autowired
    private StateMachine<String, String> stateMachine;

    @Autowired
    private StateMachineFactory<String, String> stateMachineFactory;

    @Bean
    CommandLineRunner clr() {
        return args -> {
            System.out.println("Sending Event E1 to sm");
            stateMachine.sendEvent("E1");
            System.out.println("Event  Sent");

            System.out.println("------");

            System.out.println("Sending Event E1 to smf");
            stateMachineFactory.getStateMachine().sendEvent("E1");
            System.out.println("Event  Sent");
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(StatemachineApplication.class, args);
    }
}

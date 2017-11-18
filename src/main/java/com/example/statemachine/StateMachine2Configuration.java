package com.example.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableStateMachine
public class StateMachine2Configuration extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config)
            throws Exception {
        config
                .withConfiguration()
                .machineId("sm")
                .autoStartup(true);
    }

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states)
            throws Exception {
        Set<String> s = new HashSet<>();
        s.add("S1");
        s.add("S2");
        states
                .withStates()
                .initial("S1")
                .states(s);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source("S1").target("S2").event("E1");
    }
}


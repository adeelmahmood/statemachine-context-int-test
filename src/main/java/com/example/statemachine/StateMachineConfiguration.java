package com.example.statemachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineModelConfigurer;
import org.springframework.statemachine.config.model.*;

import java.util.ArrayList;
import java.util.Collection;

@Configuration
@EnableStateMachineFactory
public class StateMachineConfiguration extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config)
            throws Exception {
        config
                .withConfiguration()
                .machineId("smf")
                .autoStartup(true);
    }

    @Override
    public void configure(StateMachineModelConfigurer<String, String> model) throws Exception {
        model.withModel().factory(modelFactory());
    }

    @Bean
    public StateMachineModelFactory<String, String> modelFactory() {
        return new CustomStateMachineModelFactory();
    }

    public static class CustomStateMachineModelFactory implements StateMachineModelFactory<String, String> {
        @Override
        public StateMachineModel<String, String> build() {
            ConfigurationData configuration = new ConfigurationData();

            Collection<StateData<String, String>> states = new ArrayList<>();
            states.add(new StateData<String, String>("S1", true));
            states.add(new StateData<String, String>("S2"));
            StatesData<String, String> statesData = new StatesData<>(states);

            Collection<TransitionData<String, String>> transitions = new ArrayList<>();
            transitions.add(new TransitionData<String, String>("S1", "S2", "E1"));
            TransitionsData<String, String> transitionsData = new TransitionsData<>(transitions);

            StateMachineModel<String, String> model = new DefaultStateMachineModel<>(configuration, statesData, transitionsData);
            return model;
        }

        @Override
        public StateMachineModel<String, String> build(String s) {
            return build();
        }
    }
}

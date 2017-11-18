package com.example.statemachine;

import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.WithStateMachine;

@WithStateMachine
public class StateChangeBean {

    @OnStateChanged
    public void test() {
        System.out.println("\n\n\nSTATE CHANGE DETECTED\n\n");
    }
}

package testRunner;

import components.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MachineGenerator {

    MachineTypes machineType;

    public MachineGenerator(MachineTypes machineType) {
        this.machineType = machineType;
    }

    private Transitions generateTransitions(HashMap delta){
        DFATransitions dfaTransitions = new DFATransitions();
        for (Object key : delta.keySet()) {
            HashMap value = (HashMap)delta.get(key);
            for (Object alphabet : value.keySet()) {
                State initial= new State((String)key);
                State nextState = new State((String)value.get(alphabet));
                dfaTransitions.addTransition(initial,(String) alphabet, nextState);
            }
        }
        return dfaTransitions;
    }

    public LanguageVerifiers generate(HashMap data) {

        ArrayList<String> givenStates = (ArrayList<String>) data.get("states");

        HashSet<State> states = new HashSet<State>();

        for(String state: givenStates){
            states.add(new State(state));
        }

        ArrayList<String> alphabets = (ArrayList<String>) data.get("alphabets");
        State initialState = new State((String) data.get("start-state"));
        ArrayList<String> givenFinalStates = (ArrayList<String>) data.get("final-states");
        HashSet <State> finalStates = new HashSet<State>();

        for(String state:givenFinalStates){
            finalStates.add(new State(state));
        }

        HashMap delta = (HashMap) data.get("delta");

        Transitions dfaTransitions = generateTransitions(delta);

        LanguageVerifiers languageVerifiers;
        if(machineType.equals(MachineTypes.DFA))
            languageVerifiers = new DFA(states,alphabets,dfaTransitions,initialState,finalStates);
        else
            languageVerifiers = new NFA(states,alphabets,dfaTransitions,initialState,finalStates);

        return languageVerifiers;
    }
}

package components;

import java.util.ArrayList;

public class DFA implements LanguageVerifiers{
    ArrayList<String> alphabets;
    ArrayList<State> states;
    private final DFATransitions transitions;
    private final State initialState;
    private final ArrayList<State> finalStates;
    private State currentState;

    public DFA(ArrayList<State> states, ArrayList<String> alphabets, DFATransitions transitions, State initialState, ArrayList<State> finalStates) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    public boolean isLanguage(String givenCase) {
        currentState = initialState;
        for (String alphabet : givenCase.split("")){
            currentState = transitions.getNextState(currentState,alphabet);
        }
        for (State state:finalStates){
            if (currentState.equals(state))
                return true;
        }
        return false;

    }


}


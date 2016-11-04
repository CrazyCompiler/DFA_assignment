package components;

import java.util.ArrayList;

public class NFA {
    String[] alphabets;
    State[] states;
    private final NFATransitions transitions;
    private final State initialState;
    private final State[] finalStates;
    private ArrayList<State> currentStates = new ArrayList<State>();

    public NFA(State[] states, String[] alphabets, NFATransitions transitions, State initialState, State[] finalStates) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    private ArrayList<State> getFinalStates (ArrayList<State> currentStates, String alphabet){
        ArrayList<State> finalStates = new ArrayList<State>();
        int count = 0;
        while (currentStates.size() > count) {
            finalStates.addAll(transitions.getNextStates(currentStates.get(count),alphabet));
            count++;
        }
        return finalStates;
    }

    public boolean isLanguage(String givenCase) {
        currentStates.add(initialState);
        for (String alphabet : givenCase.split("")){
            currentStates = getFinalStates(currentStates,alphabet);
        }

        for (State state:finalStates){
            if (currentStates.contains(state))
                return true;
        }
        return false;
    }

}

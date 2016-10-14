
public class DFA {
    String[] alphabets;
    State[] states;
    private final Transitions transitions;
    private final State initialState;
    private final State finalState;
    private State currentState;

    public DFA(State[] states, String[] alphabets, Transitions transitions, State initialState, State finalState) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public boolean isLanguage(String givenCase) {
        currentState = initialState;
        for (String alphabet : givenCase.split("")){
            currentState = transitions.getNextState(currentState,alphabet);
        }
        return currentState.equals(finalState);
    }


}


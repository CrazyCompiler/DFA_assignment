
public class DFA {
    String[] alphabets;
    State[] states;
    private final Transition[] transitions;
    private final State initialState;
    private final State finalState;
    private State currentState;

    public DFA(State[] states, String[] alphabets, Transition[] transitions, State initialState, State finalState) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    private void updateCurrentState(char currentAlphabet){
        for(Transition transition : transitions){
            if(transition.hasSameFromAndAlphabet(currentState, currentAlphabet)){
                currentState = transition.getNextState();
            }
        }
    }

    public boolean isLanguage(String language) {
        currentState = initialState;
        for(int i = 0; i < language.length(); i++)
        {
            char givenAlphabets = language.charAt(i);
            updateCurrentState(givenAlphabets);
        }
        return currentState.equals(finalState);
    }


}


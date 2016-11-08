package components;
import java.util.ArrayList;

public class DFA implements LanguageVerifiers{
    ArrayList<String> alphabets;
    States states;
    private final Transitions transitions;
    private final State initialState;
    private final States finalStates;
    private State currentState;

    public DFA(States states, ArrayList<String> alphabets, Transitions transitions, State initialState, States finalStates) {
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
        States currentStates = new States();
        currentStates.add(currentState);

        return finalStates.intersects(currentStates);
    }


}


package components;

import java.util.ArrayList;
import java.util.HashSet;

public class NFA implements LanguageVerifiers{
    private ArrayList<String> alphabets;
    private final States states;
    private final Transitions transitions;
    private final State initialState;
    private final States finalStates;

    public NFA(States states, ArrayList<String> alphabets, Transitions transitions, State initialState, States finalStates) {
        this.alphabets = alphabets;
        this.states = states;
        this.transitions = transitions;
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    private States getFinalStates (States currentStates, String alphabet){
        States finalStates = new States();
        for (State state: currentStates) {
            finalStates.addAll(transitions.getNextState(state,alphabet));
        }
        return finalStates;
    }

    public boolean isLanguage(String givenCase) {
        States currentStates = new States();
        currentStates.add(initialState);
        for (String alphabet : givenCase.split("")){
            currentStates = getFinalStates(currentStates,alphabet);
        }

        return finalStates.intersects(currentStates);
    }

}

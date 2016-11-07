package components;

import java.util.ArrayList;
import java.util.HashSet;

public class NFA implements LanguageVerifiers{
    ArrayList<String> alphabets;
    HashSet<State> states;
    private final Transitions transitions;
    private final State initialState;
    private final HashSet<State> finalStates;
    private ArrayList<State> currentStates = new ArrayList<State>();

    public NFA(HashSet<State> states, ArrayList<String> alphabets, Transitions transitions, State initialState, HashSet<State> finalStates) {
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
//            finalStates.addAll(transitions.getNextStates(currentStates.get(count),alphabet));
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

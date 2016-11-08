package components;

import java.util.HashMap;

public class NFATransitions implements Transitions {

    private HashMap<State,HashMap<String,States>> transitions= new HashMap<>();

    public void addTransition(State initial, String alphabet, States next) {
        States nextStates = new States();
        HashMap<String,States> nextStateTransition= new HashMap<String,States>();

        if (transitions.containsKey(initial)){
            if(transitions.get(initial).containsKey(alphabet))
                transitions.get(initial).get(alphabet).addAll(next);
            else {
                nextStates.addAll(next);
                nextStateTransition.put(alphabet, nextStates);
                transitions.get(initial).put(alphabet,nextStates);
            }
        }else {
            nextStates.addAll(next);
            nextStateTransition.put(alphabet, nextStates);
            transitions.put(initial,nextStateTransition);
        }
    }

    @Override
    public States getNextState(State currentState, String currentAlphabet) {

        if (transitions.containsKey(currentState))
            if (transitions.get(currentState).containsKey(currentAlphabet)) {
                return transitions.get(currentState).get(currentAlphabet);
            }
            if(transitions.get(currentState).containsKey("e"))
                return transitions.get(currentState).get("e");
        return new States();
    }
}

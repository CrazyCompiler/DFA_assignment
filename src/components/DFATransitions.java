package components;

import java.util.HashMap;

public class DFATransitions {

    private HashMap<State,HashMap<String, State>> transitions=new HashMap<State,HashMap<String, State>>();

    public void addTransition(State initial, String alphabet, State next) {
        HashMap<String, State> nextStateTransition= new HashMap<String, State>();
        if (transitions.containsKey(initial)){
            transitions.get(initial).put(alphabet,next);
        }else {
            nextStateTransition.put(alphabet, next);
            transitions.put(initial,nextStateTransition);
        }
    }

    public State getNextState(State currentState, String currentAlphabet){
        HashMap<String, State> nextStateTransition = transitions.get(currentState);
        return nextStateTransition.get(currentAlphabet);
    }
}

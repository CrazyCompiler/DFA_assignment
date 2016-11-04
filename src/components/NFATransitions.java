package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NFATransitions {

    private HashMap<State,HashMap<String,ArrayList<State>>> transitions=new HashMap<State,HashMap<String,ArrayList<State>>>();

    public void addTransition(State initial, String alphabet, State[] next) {
        ArrayList<State> nextStates = new ArrayList<State>();
        HashMap<String,ArrayList<State>> nextStateTransition= new HashMap<String,ArrayList<State>>();
        if (transitions.containsKey(initial)){
            if(transitions.get(initial).containsKey(alphabet))
                transitions.get(initial).get(alphabet).addAll(Arrays.asList(next));
            else {
                nextStates.addAll(Arrays.asList(next));
                nextStateTransition.put(alphabet, nextStates);
                transitions.get(initial).put(alphabet,nextStates);
            }
        }else {
            nextStates.addAll(Arrays.asList(next));
            nextStateTransition.put(alphabet, nextStates);
            transitions.put(initial,nextStateTransition);
        }
    }

    public ArrayList<State> getNextStates(State currentStates, String alphabet) {
        if(transitions.containsKey(currentStates))
            if(transitions.get(currentStates).containsKey(alphabet)) {
                return transitions.get(currentStates).get(alphabet);
            }
        return new ArrayList<>();
    }
}

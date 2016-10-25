import java.util.ArrayList;
import java.util.HashMap;

public class NFATransitions {

    private HashMap<State,HashMap<String,ArrayList<State>>> transitions=new HashMap<State,HashMap<String,ArrayList<State>>>();

    public void addTransition(State initial, String alphabet, State next) {
        ArrayList<State> nextStates = new ArrayList<State>();
        HashMap<String,ArrayList<State>> nextStateTransition= new HashMap<String,ArrayList<State>>();
        if (transitions.containsKey(initial)){
            if(transitions.get(initial).containsKey(alphabet))
                transitions.get(initial).get(alphabet).add(next);
            else {
                nextStates.add(next);
                nextStateTransition.put(alphabet, nextStates);
                transitions.get(initial).put(alphabet,nextStates);
            }
        }else {
            nextStates.add(next);
            nextStateTransition.put(alphabet, nextStates);
            transitions.put(initial,nextStateTransition);
        }
    }

    public ArrayList<State> getNextStates(State currentStates, String alphabet) {

        if(transitions.containsKey(currentStates))
            return transitions.get(currentStates).get(alphabet);
        return new ArrayList<>();
    }
}

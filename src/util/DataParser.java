package util;

import components.DFA;
import components.DFATransitions;
import components.State;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class DataParser {

    private ArrayList rawData;

    public DataParser(ArrayList rawData) {
        this.rawData = rawData;
    }

    private DFA generateDFA(HashMap data){

        ArrayList<String> givenStates = (ArrayList<String>) data.get("states");

        ArrayList<State> states = new ArrayList<State>();

        for(int i=0 ;i < givenStates.size() ; i++){
            states.add(new State(givenStates.get(i)));
        }

        ArrayList<String> alphabets = (ArrayList <String>) data.get("alphabets");
        State initialState = new State((String) data.get("start-state"));
        ArrayList<String> givenFinalStates = (ArrayList<String>) data.get("final-states");
        ArrayList <State> finalStates = new ArrayList<State>();

        for(int i=0 ;i < givenFinalStates.size() ; i++){
            finalStates.add(new State(givenFinalStates.get(i)));
        }

        HashMap delta = (HashMap) data.get("delta");

        DFATransitions dfaTransitions = new DFATransitions();
        for (Object key : delta.keySet()) {
            HashMap value = (HashMap)delta.get(key);
            for (Object alphabet : value.keySet()) {
                State initial= new State((String)key);
                State nextState = new State((String)value.get(alphabet));
                dfaTransitions.addTransition(initial,(String) alphabet, nextState);
            }
        }

        DFA dfa = new DFA(states,alphabets,dfaTransitions,initialState,finalStates);
        return dfa;
    }

    public ArrayList parse(){
        ArrayList machinesData = new ArrayList();

        for(int i=0; i < rawData.size(); i++){
            HashMap machineData = new HashMap();
            HashMap rawMachineData = (HashMap)rawData.get(i);

            if( rawMachineData.get("type").equals("dfa")) {

                HashMap tuple = (HashMap) rawMachineData.get("tuple");
                DFA machine = generateDFA(tuple);
                machineData.put("machine",machine);
                machineData.put("name",rawMachineData.get("name"));
                machineData.put("pass-cases",(ArrayList<String>)rawMachineData.get("pass-cases"));
                machineData.put("fail-cases",(ArrayList<String>)rawMachineData.get("fail-cases"));
                machinesData.add(machineData);
            }
        }

        return machinesData;
    }
}



package util;

import components.LanguageVerifiers;
import components.MachineTypes;
import testRunner.MachineGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class DataParser {

    private ArrayList rawData;

    public DataParser(ArrayList rawData) {
        this.rawData = rawData;
    }

    public ArrayList parse(){
        ArrayList machinesData = new ArrayList();

        for(int i=0; i < rawData.size(); i++){
            HashMap machineData = new HashMap();
            HashMap rawMachineData = (HashMap)rawData.get(i);

            if( rawMachineData.get("type").equals("dfa")) {
                HashMap tuple = (HashMap) rawMachineData.get("tuple");
                MachineGenerator machineGenerator = new MachineGenerator(MachineTypes.DFA);
                LanguageVerifiers machine = machineGenerator.generate(tuple);
                machineData.put("machine",machine);
            }

            machineData.put("name",rawMachineData.get("name"));
            machineData.put("pass-cases",(ArrayList<String>)rawMachineData.get("pass-cases"));
            machineData.put("fail-cases",(ArrayList<String>)rawMachineData.get("fail-cases"));
            machinesData.add(machineData);
        }

        return machinesData;
    }
}



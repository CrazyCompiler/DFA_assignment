package testRunner;

import components.LanguageVerifiers;

import java.util.ArrayList;
import java.util.HashMap;

public class AutomataTestRunner {


    private ArrayList<HashMap> data;

    public AutomataTestRunner(ArrayList<HashMap> data) {

        this.data = data;
    }

    public void run(){
        for (int i=0; i < data.size(); i++){
            LanguageVerifiers languageVerifiers = (LanguageVerifiers) data.get(i).get("machine");
            ArrayList<String> passCases = (ArrayList<String>) data.get(i).get("pass-cases");
            ArrayList<String> failCases = (ArrayList<String>) data.get(i).get("fail-cases");

            System.out.println(data.get(i).get("name"));

            for(String givenCase :  passCases){
                if(languageVerifiers.isLanguage(givenCase) == true)
                    System.out.println(givenCase + "==> passed");
            }

            for(String givenCase :  failCases){
                if(languageVerifiers.isLanguage(givenCase) == false)
                    System.out.println(givenCase + "==> failed");
            }
        }
    }
}

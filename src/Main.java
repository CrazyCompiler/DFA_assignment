
import parser.JSONParser;
import testRunner.AutomataTestRunner;
import util.DataParser;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        String filePath = "./data/examples.json";
        List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());
        String providedData = lines.get(0);
        JSONParser jsonParser = new JSONParser();
        ArrayList rawData =  (ArrayList) jsonParser.parse(providedData).get("result");

        DataParser dataParser = new DataParser(rawData);

        ArrayList givenData = dataParser.parse();
        AutomataTestRunner automataTestRunner = new AutomataTestRunner(givenData);
        automataTestRunner.run();
    }

}

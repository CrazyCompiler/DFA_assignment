
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        String filePath = "./data/examples.json";
        List<String> lines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());
        String providedData = lines.get(0);

        System.out.println(providedData);

    }

}

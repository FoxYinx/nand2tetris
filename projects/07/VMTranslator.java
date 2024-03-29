import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VMTranslator {

    public static void main(String[] args) {
        try {
            String fileName = args[0];
            File file = new File(fileName);
            Parser myParser = new Parser(file);
            myParser.readLinesAndWrite(myParser.getScanner(), fileName);
            myParser.closeFile(myParser.getScanner());
        } catch (FileNotFoundException e){
            System.out.println("The file wasn't found");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

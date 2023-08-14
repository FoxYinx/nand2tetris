import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HackAssembler {

    public static void main(String[] args) {
        try {
            File file = new File("add/add.asm");
            Parser myParser = new Parser(file);
            myParser.readLinesAndWrite(myParser.getScanner(), "add");
            myParser.closeFile(myParser.getScanner());
        } catch (FileNotFoundException e){
            System.out.println("The file wasn't found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

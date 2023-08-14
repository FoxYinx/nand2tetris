import java.io.File;
import java.io.FileNotFoundException;

public class HackAssembler {

    public static void main(String[] args) {
        try {
            File file = new File("add/add.asm");
            Parser myParser = new Parser(file);
            myParser.readLines(myParser.getScanner());
            myParser.closeFile(myParser.getScanner());
        } catch (FileNotFoundException e){
            System.out.println("The file wasn't found");
        }
    }

}

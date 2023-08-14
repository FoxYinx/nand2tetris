import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {

    private Scanner scanner;

    Parser (File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
    }

    public void readLines(Scanner scanner){
        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            System.out.println(data);
        }
    }

    public void closeFile(Scanner scanner){
        scanner.close();
    }

    public Scanner getScanner() {
        return scanner;
    }
}

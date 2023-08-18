import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private Scanner scanner;

    public Parser (File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
    }

    public void closeFile(Scanner scanner){
        scanner.close();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void readLinesAndWrite(Scanner scanner, String fileName) throws IOException {
        //Setting up the output file
        fileName = fileName.substring(0, fileName.length()-3);
        File file = new File(fileName + ".asm");
        file.delete();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".asm", true));
        int nb=0;

        while(scanner.hasNextLine()){
            //Handling comments and whitespaces
            String data = scanner.nextLine();
            data = data.split("//")[0];
            if(data.isEmpty()) continue;
            while (data.charAt(0)==' '){
                data = data.substring(1);
            }
            while (data.charAt(data.length()-1)==' '){
                data = data.substring(0, data.length()-1);
            }

            //Start of the translation
            String[] datas = data.split(" ");
            Code code;
            if (datas.length==1){
                code = new Code(datas[0], "", "");
            } else {
                code = new Code(datas[0], datas[1], datas[2]);
            }

            //Getting the translation
            ArrayList<String> ops = code.process(fileName, nb);
            nb++;
            for (String text:ops) {
                writer.append(text);
                writer.newLine();
            }
        }

        writer.close();
    }
}

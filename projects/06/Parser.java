import java.io.*;
import java.util.Scanner;

public class Parser {

    private Scanner scanner;
    private Code code;

    public Parser (File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
        this.code = new Code();
    }

    public void readLinesAndWrite(Scanner scanner, String folderName, String fileName) throws IOException {
        String output;
        File file = new File(folderName + "/" + fileName + ".hack");
        file.delete();
        BufferedWriter writer = new BufferedWriter(new FileWriter(folderName + "/" + fileName + ".hack", true));
        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            data = data.split("//")[0];
            if(data.isEmpty()) continue;
            if (data.charAt(0)=='@'){
                output = code.toBinary(data.split("@")[1]);
            } else {
                if(data.split("=").length!=1){
                    String dest = code.toDest(data.split("=")[0]);
                    String comp = code.toComp(data.split("=")[1].split(";")[0]);
                    String jump;
                    if (dest.split(";").length !=1){
                        jump = code.toJump(data.split("=")[1].split(";")[1]);
                    } else {
                        jump = code.toJump(null);
                    }
                    output = "111" + comp + dest + jump;
                } else {
                    String comp = code.toComp(data.split(";")[0]);
                    String jump = code.toJump(data.split(";")[1]);
                    output = "111" + comp + "000" + jump;
                }

            }
            writer.append(output);
            writer.newLine();
        }
        writer.close();
    }

    public void closeFile(Scanner scanner){
        scanner.close();
    }

    public Scanner getScanner() {
        return scanner;
    }
}

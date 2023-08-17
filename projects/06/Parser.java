import java.io.*;
import java.util.Scanner;

public class Parser {

    private Scanner scanner;
    private Code code;
    private SymbolTable symbolTable;

    public Parser (File file) throws FileNotFoundException {
        this.scanner = new Scanner(file);
        this.code = new Code();
        this.symbolTable = new SymbolTable();
    }

    public void readLinesAndWrite(Scanner scanner, String fileName, Parser myParser2, Parser myParser3) throws IOException {
        String output;
        File file = new File(fileName + ".hack");
        file.delete();
        fileName = fileName.substring(0, fileName.length()-4);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".hack", true));
        int lineNumber = 0;

        while(scanner.hasNextLine()) {
            String data = scanner.nextLine();
            data = data.split("//")[0];
            if (data.isEmpty()) continue;
            while (data.charAt(0) == ' ') {
                data = data.substring(1);
            }
            if(data.charAt(0)=='('){
                this.symbolTable.setSymbolValue(data.substring(1, data.length()-1), "" + lineNumber);
            } else{
                lineNumber++;
            }
        }

        scanner = myParser2.getScanner();

        int variableNumber = 16;

        while(scanner.hasNextLine()) {
            String data = scanner.nextLine();
            data = data.split("//")[0];
            if (data.isEmpty()) continue;
            while (data.charAt(0) == ' ') {
                data = data.substring(1);
            }
            if(data.charAt(0)=='@'){
                data = data.substring(1);
                try {
                    Integer.parseInt(data);
                } catch (NumberFormatException e){
                    if(!this.symbolTable.containsKey(data)){
                        this.symbolTable.setSymbolValue(data, String.valueOf(variableNumber));
                        variableNumber++;
                    }
                }
            }
        }

        scanner = myParser3.getScanner();

        while(scanner.hasNextLine()){
            String data = scanner.nextLine();
            data = data.split("//")[0];
            if(data.isEmpty()) continue;
            while (data.charAt(0)==' '){
                data = data.substring(1);
            }
            if(data.charAt(0)=='(') continue;
            while (data.charAt(data.length()-1)==' '){
                data = data.substring(0, data.length()-1);
            }
            if (data.charAt(0)=='@'){
                if(this.symbolTable.containsKey(data.split("@")[1])){
                    output = code.toBinary(this.symbolTable.getSymbolValue(data.split("@")[1]));
                } else {
                    output = code.toBinary(data.split("@")[1]);
                }
            } else {
                if(data.split("=").length!=1){
                    String dest = code.toDest(data.split("=")[0]);
                    String comp = code.toComp(data.split("=")[1].split(";")[0]);
                    String jump;
                    if (dest.split(";").length !=1){
                        jump = code.toJump(data.split("=")[1].split(";")[1]);
                    } else {
                        jump = code.toJump("null");
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

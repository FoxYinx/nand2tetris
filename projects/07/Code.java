import java.util.ArrayList;

public class Code {

    private final String commandType;
    private final String arg1;
    private final String arg2;

    public Code(String commandType, String arg1, String arg2){
        this.commandType = commandType;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public ArrayList<String> process(String filename, int nb) {
        ArrayList<String> output = new ArrayList<>();
        output.add("// " + commandType + " " + arg1 + " " + arg2);
        if(commandType.equals("push")){
            output.addAll(pushProcess(arg1, arg2, filename));
        } else if (commandType.equals("pop")){
            output.addAll(popProcess(arg1, arg2, filename));
        } else {
            output.addAll(arithAndLogicProcess(commandType, nb));
        }
        return output;
    }

    public ArrayList<String> pushProcess(String arg1, String arg2, String filename){
        ArrayList<String> instructions = new ArrayList<>();
        if (arg1.equals("constant")){
            instructions.add("@" + arg2);
            instructions.add("D=A");
        } else if (arg1.equals("static")){
            filename = filename.substring(3);
            instructions.add("@" + filename + "." + arg2);
            instructions.add("D=M");
        } else if (arg1.equals("pointer")){
            if(arg2.equals("0")){
                instructions.add("@THIS");
            } else {
                instructions.add("@THAT");
            }
            instructions.add("D=M");
        } else if (arg1.equals("temp")){
            instructions.add("@5");
            instructions.add("D=A");
            instructions.add("@" + arg2);
            instructions.add("A=A+D");
            instructions.add("D=M");
        } else {
            if (arg1.equals("local")) instructions.add("@LCL");
            if (arg1.equals("argument")) instructions.add("@ARG");
            if (arg1.equals("this")) instructions.add("@THIS");
            if (arg1.equals("that")) instructions.add("@THAT");
            instructions.add("D=M");
            instructions.add("@" + arg2);
            instructions.add("A=A+D");
            instructions.add("D=M");
        }
        instructions = increaseSP(instructions);

        return instructions;
    }

    public ArrayList<String> popProcess(String arg1, String arg2, String filename){
        ArrayList<String> instructions = new ArrayList<>();
        if(arg1.equals("static")){
            filename = filename.substring(3);
            instructions.add("@" + filename + "." + arg2);
            instructions.add("D=A");
        } else if (arg1.equals("pointer")) {
            if(arg2.equals("0")){
                instructions.add("@THIS");
            } else {
                instructions.add("@THAT");
            }
            instructions.add("D=A");
        } else if (arg1.equals("temp")) {
            instructions.add("@5");
            instructions.add("D=A");
            instructions.add("@" + arg2);
            instructions.add("D=D+A");
        } else {
            if (arg1.equals("local")) instructions.add("@LCL");
            if (arg1.equals("argument")) instructions.add("@ARG");
            if (arg1.equals("this")) instructions.add("@THIS");
            if (arg1.equals("that")) instructions.add("@THAT");
            instructions.add("D=M");
            instructions.add("@" + arg2);
            instructions.add("D=D+A");
        }
        instructions = popSP(instructions);

        return instructions;
    }

    public ArrayList<String> arithAndLogicProcess(String commandType, int nb){
        ArrayList<String> instructions = new ArrayList<>();
        switch (commandType) {
            case "add" -> {
                instructions.add("@SP");
                instructions.add("M=M-1");
                instructions.add("A=M");
                instructions.add("D=M");
                instructions.add("A=A-1");
                instructions.add("M=D+M");
            }
            case "sub" -> {
                instructions.add("@SP");
                instructions.add("M=M-1");
                instructions.add("A=M-1");
                instructions.add("D=M");
                instructions.add("@SP");
                instructions.add("A=M");
                instructions.add("D=D-M");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D");
            }
            case "neg" -> {
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=-M");
            }
            case "not" -> {
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=!M");
            }
            case "or" -> {
                instructions.add("@SP");
                instructions.add("AM=M-1");
                instructions.add("D=M");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D|M");
            }
            case "and" -> {
                instructions.add("@SP");
                instructions.add("AM=M-1");
                instructions.add("D=M");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D&M");
            }
            case "eq" -> {
                instructions.add("@SP");
                instructions.add("AM=M-1");
                instructions.add("D=M");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D-M");
                instructions.add("D=M");
                instructions.add("@EQUAL"+nb);
                instructions.add("D;JEQ");
                instructions.add("@0");
                instructions.add("D=A");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D");
                instructions.add("@ENDE"+nb);
                instructions.add("0;JMP");
                instructions.add("(EQUAL"+nb+")");
                instructions.add("@0");
                instructions.add("D=A");
                instructions.add("D=!D");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D");
                instructions.add("(ENDE"+nb+")");
            }
            case "gt" -> {
                instructions.add("@SP");
                instructions.add("AM=M-1");
                instructions.add("D=M");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D-M");
                instructions.add("D=M");
                instructions.add("@GREATER"+nb);
                instructions.add("D;JLT");
                instructions.add("@0");
                instructions.add("D=A");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D");
                instructions.add("@ENDG"+nb);
                instructions.add("0;JMP");
                instructions.add("(GREATER"+nb+")");
                instructions.add("@0");
                instructions.add("D=A");
                instructions.add("D=!D");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D");
                instructions.add("(ENDG"+nb+")");
            }
            default -> {
                instructions.add("@SP");
                instructions.add("AM=M-1");
                instructions.add("D=M");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D-M");
                instructions.add("D=M");
                instructions.add("@LESSER"+nb);
                instructions.add("D;JGT");
                instructions.add("@0");
                instructions.add("D=A");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D");
                instructions.add("@ENDL"+nb);
                instructions.add("0;JMP");
                instructions.add("(LESSER"+nb+")");
                instructions.add("@0");
                instructions.add("D=A");
                instructions.add("D=!D");
                instructions.add("@SP");
                instructions.add("A=M-1");
                instructions.add("M=D");
                instructions.add("(ENDL"+nb+")");
            }
        }
        return instructions;
    }

    public ArrayList<String> increaseSP(ArrayList<String> instructions){
        instructions.add("@SP");
        instructions.add("A=M");
        instructions.add("M=D");
        instructions.add("@SP");
        instructions.add("M=M+1");
        return instructions;
    }

    public ArrayList<String> popSP(ArrayList<String> instructions){
        instructions.add("@R13");
        instructions.add("M=D");
        instructions.add("@SP");
        instructions.add("AM=M-1");
        instructions.add("D=M");
        instructions.add("@R13");
        instructions.add("A=M");
        instructions.add("M=D");
        return instructions;
    }
}



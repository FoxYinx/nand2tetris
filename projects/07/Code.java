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

    public ArrayList<String> process() {
        ArrayList<String> output = new ArrayList<>();
        output.add("// " + commandType + " " + arg1 + " " + arg2);
        if(commandType.equals("push")){
            output.addAll(pushProcess(arg1, arg2));
        } else if (commandType.equals("pop")){
            output.addAll(popProcess(arg1, arg2));
        } else {
            output.addAll(arithAndLogicProcess(commandType));
        }
        return output;
    }

    public ArrayList<String> pushProcess(String arg1, String arg2){
        ArrayList<String> instructions = new ArrayList<>();
        if (arg1.equals("constant")){
            instructions.add("@" + arg2);
            instructions.add("D=A");
        } else if (arg1.equals("static")){

        } else if (arg1.equals("pointer")){

        } else if (arg1.equals("temp")){

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
        instructions.add("@SP");
        instructions.add("A=M");
        instructions.add("M=D");
        instructions.add("@SP");
        instructions.add("M=M+1");
        return instructions;
    }

    public ArrayList<String> popProcess(String arg1, String arg2){
        return new ArrayList<>();
    }

    public ArrayList<String> arithAndLogicProcess(String commandType){
        return new ArrayList<>();
    }
}

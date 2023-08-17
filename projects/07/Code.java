import java.util.ArrayList;

public class Code {

    private String commandType;
    private String arg1;
    private String arg2;

    public Code(String commandType, String arg1, String arg2){
        this.commandType = commandType;
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public ArrayList<String> process() {
        return new ArrayList<>();
    }
}

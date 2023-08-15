import java.util.HashMap;
import java.util.Set;

public class SymbolTable {

    private HashMap<String, String> symbolTable;

    public SymbolTable(){
        this.symbolTable = new HashMap<>();
        for(int i=0;i<16;i++){
            this.symbolTable.put("R" + i, "" + i);
        }
        this.symbolTable.put("SCREEN", "16384");
        this.symbolTable.put("KBD", "24576");
        this.symbolTable.put("SP", "0");
        this.symbolTable.put("LCL", "1");
        this.symbolTable.put("ARG", "2");
        this.symbolTable.put("THIS", "3");
        this.symbolTable.put("THAT", "4");
    }

    public String getSymbolValue(String key) {
        return this.symbolTable.get(key);
    }

    public void setSymbolValue(String key, String value) {
        this.symbolTable.put(key, value);
    }

    public Set<String> getKeySet(){
        return this.symbolTable.keySet();
    }

    public boolean containsKey(String value){
        return this.symbolTable.containsKey(value);
    }
}

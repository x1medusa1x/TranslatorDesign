package cup.example;

enum IdentifierScope { Local, Global };
enum SymbolType { Function, Variable, DataType, Object, Namespace, AccessSpecifier};

public class SymTableEntry {

    public String symbolName;
    public String dataType;
    public SymbolType symbolType;
    public IdentifierScope symbolScope;
    public String contextName;
    public String value;
    public String secondValue;
    
    @Override
    public String toString() {
    	String val = "";
    	if(this.dataType != null) {
			val = val + "DATATYPE: " + this.dataType + " ";
		}
		if(this.symbolName != null) {
			val = val + "SYMBOLNAME: " + this.symbolName + " ";
		}
		if(this.symbolType != null) {
			val = val + "SYMBOLTYPE: " + this.symbolType + " ";
		}
		if(this.value != null) {
			val = val + "= " + this.value;
		}
		if(this.secondValue != null) {
			val = val + "(" + this.secondValue + ") ";
		}
//		if(arr.contextName != "") {
//			System.out.print(arr.contextName + " ");
//		}
		return val;
    }

};
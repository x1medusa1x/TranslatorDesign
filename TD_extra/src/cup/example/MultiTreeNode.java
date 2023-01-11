package cup.example;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiTreeNode {
	
	private String data;
	private SymTableEntry dataSym;
	private String extraData;
	private String vDString;
	private Integer vDInteger;
	private char vDChar;
	private Double vDDouble;
	private Float vDFloat;
	private ArrayList<MultiTreeNode> children;	
	private int descendentsCount = 0; 
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;	
		
	}
	
	public int getDescendentsCount()
	{		
		return descendentsCount;
	}

	public MultiTreeNode[] getChildren() {
		MultiTreeNode[] childrenArray = new MultiTreeNode[children.size()];		
		return children.toArray(childrenArray);
	}
	
	public void print(SymTableEntry arr) {
		if(arr.dataType != null) {
			System.out.print(arr.dataType + " ");
		}
		if(arr.symbolName != null) {
			System.out.print(arr.symbolName + " ");
		}
		if(arr.symbolType != null) {
			System.out.print(arr.symbolType + " ");
		}
		if(arr.value != null) {
			System.out.print( "= " + arr.value);
		}
		if(arr.secondValue != null) {
			System.out.print("(" + arr.secondValue + ") ");
		}
//		if(arr.contextName != "") {
//			System.out.print(arr.contextName + " ");
//		}
	}
	
	public MultiTreeNode(String data, Integer[] elementType)
	{
		this.data = data;
		SymTableEntry entry = new SymTableEntry();
		if(elementType[0] == 3) {
			entry.dataType = data;
			entry.symbolScope = IdentifierScope.Local;
			this.dataSym = entry;
		}else {
			if(elementType[0] == 4) {
				entry.dataType = data;
				entry.symbolType = SymbolType.Object;
				entry.symbolScope = IdentifierScope.Local;
				this.dataSym = entry;
			}else {
				if(elementType[0] == 5) {
					entry.dataType = data;
					entry.symbolType = SymbolType.Namespace;
					entry.symbolScope = IdentifierScope.Local;
					this.dataSym = entry;
				}else {
					if(elementType[0] == 6) {
						entry.dataType = data;
						entry.symbolType = SymbolType.AccessSpecifier;
						entry.symbolScope = IdentifierScope.Local;
						this.dataSym = entry;
					}
				}
			}
		}
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, Integer[] elementType)
	{
		this.data = data;
		this.extraData = extraData;
		SymTableEntry entry = new SymTableEntry();
		if(elementType[0] == 0) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Function;
			entry.symbolScope = IdentifierScope.Local;
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}else if(elementType[0] == 4) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Object;
			entry.symbolScope = IdentifierScope.Local;
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}else if(elementType[0] == 1) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Variable;
			entry.symbolScope = IdentifierScope.Local;
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}else if(elementType[0] == 5) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Namespace;
			entry.symbolScope = IdentifierScope.Local;
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}
		children = new ArrayList<MultiTreeNode>();
	}	
	
	public MultiTreeNode(String data, String extraData)
	{
		this.data = data;
		this.extraData = extraData;
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, String vDString)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDString = vDString;
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, Integer vDInteger)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDInteger = vDInteger;
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, char vDChar)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDChar = vDChar;
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, Double vDDouble)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDDouble = vDDouble;
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, Float vDFloat)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDFloat = vDFloat;
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, String vDString, Integer[] elementType)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDString = vDString;
		SymTableEntry entry = new SymTableEntry();
		if(elementType[0] == 1) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Variable;
			entry.symbolScope = IdentifierScope.Local;
			entry.value = vDString;
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}else if(elementType[0] == 4) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Object;
			entry.symbolScope = IdentifierScope.Local;
			entry.value = String.valueOf(vDString);
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, String vDString, String vDStringSecundary, Integer[] elementType)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDString = vDString;
		SymTableEntry entry = new SymTableEntry();
		if(elementType[0] == 4) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Object;
			entry.symbolScope = IdentifierScope.Local;
			entry.value = String.valueOf(vDString);
			entry.secondValue = String.valueOf(vDStringSecundary);
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, Integer vDInteger, Integer[] elementType)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDInteger = vDInteger;
		SymTableEntry entry = new SymTableEntry();
		if(elementType[0] == 1) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Variable;
			entry.symbolScope = IdentifierScope.Local;
			entry.value = String.valueOf(vDInteger);
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, char vDChar, Integer[] elementType)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDChar = vDChar;
		SymTableEntry entry = new SymTableEntry();
		if(elementType[0] == 1) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Variable;
			entry.symbolScope = IdentifierScope.Local;
			entry.value = String.valueOf(vDChar);
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, Double vDDouble, Integer[] elementType)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDDouble = vDDouble;
		SymTableEntry entry = new SymTableEntry();
		if(elementType[0] == 1) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Variable;
			entry.symbolScope = IdentifierScope.Local;
			entry.value = String.valueOf(vDDouble);
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}
		
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(String data, String extraData, Float vDFloat, Integer[] elementType)
	{
		this.data = data;
		this.extraData = extraData;
		this.vDFloat = vDFloat;
		SymTableEntry entry = new SymTableEntry();
		if(elementType[0] == 1) {
			entry.dataType = data;
			entry.symbolName = extraData;
			entry.symbolType = SymbolType.Variable;
			entry.symbolScope = IdentifierScope.Local;
			entry.value = String.valueOf(vDFloat);
			if(Context.getContext() != "") {
				entry.contextName = Context.getContext();
			}
			this.dataSym = entry;
		}
		children = new ArrayList<MultiTreeNode>();
	}
	
	public MultiTreeNode(MultiTreeNode children) {
		this.children = new ArrayList<MultiTreeNode>();
		this.children.add(children);
	}
	
	public MultiTreeNode(String data) 
	{
		this(data, "");
	}

	
	public MultiTreeNode addChild(String childData)
	{
		MultiTreeNode addedNode = new MultiTreeNode(childData);
		children.add(addedNode);
		return addedNode;
	}
	
	public void addChild(MultiTreeNode node, String context)
	{
		children.add(node);
		Context.setContext(context);
		descendentsCount += node.descendentsCount + 1;
	}
	
	public void addChild(MultiTreeNode node)
	{
		children.add(node);
		descendentsCount += node.descendentsCount + 1;
	}
	
	public void printNode(int level)
	{
		for (int i = 0; i < level; i++)
		{
			System.out.print(" ");
		}
		if(data != null){
			System.out.print(data);
		}
		
		if(extraData != null) {
			System.out.print(" " + extraData);
		}
	
		
		if(vDString != null && vDString.length() > 0) 
		{
			System.out.print(" = " + vDString);
		}
			
		if(vDInteger != null)
		{
			System.out.print(" = " + vDInteger);
		} 
			
		if(((int)vDChar) != 0)
		{
			System.out.print(" = " + vDChar);
		} 
			
		if(vDDouble != null)
		{
			System.out.print(" = " + vDDouble);
		} 
			
		if(vDFloat != null)
		{
			System.out.print(" = " + vDFloat);
		}
		System.out.println("");
		
		for (MultiTreeNode multiTreeNode : children) {
			multiTreeNode.printNode(level + 1);
		}
	}
	
	public void addToHashMap(int level, HashMap<String, ArrayList<SymTableEntry>> hashMap) {
		if(dataSym != null){
			if(hashMap.containsKey(dataSym.symbolName)) {
				hashMap.get(dataSym.symbolName).add(dataSym);
			}else {
				ArrayList<SymTableEntry> entry = new ArrayList<SymTableEntry>();
				entry.add(dataSym);
				hashMap.put(dataSym.symbolName, entry);
			}
		}
		
		for (MultiTreeNode multiTreeNode : children) {
			multiTreeNode.addToHashMap(level, hashMap);
		}
	}

}

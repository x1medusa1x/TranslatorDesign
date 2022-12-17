package cup.example;

import java.util.ArrayList;

public class MultiTreeNode {
	
	private String data;
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
		
		if (extraData != null && extraData.length() > 0)
		{
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

}

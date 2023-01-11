package cup.example;

import java.util.ArrayList;

public class ParserWithTree extends Parser{

	public ParserWithTree() 
	{
		super();
	}
	protected MultiTreeNode createDeclarationNode(MultiTreeNode declaration) 
	{ 
		return declaration;
	}
	
 	protected MultiTreeNode createFunctionDeclarationNode(String typeSpecifier, String identifierName, MultiTreeNode paramsList, MultiTreeNode compoundStatement) 	
 	{ 
 		Integer[] type = new Integer[1];
 		type[0] = 0;
 		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, type);
 		if (paramsList != null)
 			newNode.addChild(paramsList, identifierName);
 		newNode.addChild(compoundStatement, identifierName);
 		return newNode; 
 	}
 	protected MultiTreeNode createObjDeclarationNode(String typeSpecifier, String identifierName, MultiTreeNode compoundStatement) 	
 	{ 
 		Integer[] type = new Integer[1];
 		type[0] = 4;
 		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, type);
 		if(compoundStatement != null)
 			newNode.addChild(compoundStatement, identifierName);
 		return newNode; 
 	}
 	protected MultiTreeNode createNamespaceDeclarationNode(String typeSpecifier, String identifierList, MultiTreeNode scopeList, MultiTreeNode compoundStatement) 	
 	{ 
 		Integer[] type = new Integer[1];
 		type[0] = 5;
 		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierList, type);
 		if(scopeList != null)
 			newNode.addChild(scopeList);
 		newNode.addChild(compoundStatement);
 		return newNode; 
 	}
 	protected MultiTreeNode createAccessSpecifiersDeclarationNode(String typeSpecifier, MultiTreeNode compoundStatement) 	
 	{ 
 		Integer[] type = new Integer[1];
 		type[0] = 6;
 		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, type);
 		if(compoundStatement != null)
 			newNode.addChild(compoundStatement);
 		return newNode; 
 	}
 	protected MultiTreeNode createInstanceDeclarationNode(String typeSpecifier, String identifierName, String paramsList, String value) 	
 	{ 
 		Integer[] type = new Integer[1];
 		type[0] = 4;
 		MultiTreeNode newNode = null;
 		if(identifierName != null && paramsList != null) {
 			newNode = new MultiTreeNode(typeSpecifier, identifierName, paramsList, value, type);
 		}else {
 			if(paramsList != null) {
 				newNode = new MultiTreeNode(typeSpecifier, identifierName, paramsList, type);
 			}else {
 				newNode = new MultiTreeNode(typeSpecifier, identifierName, type);
 			}
 		}
 		return newNode; 
 	}
  	protected MultiTreeNode createTypeSpecifier(String typeName)
  	{ 
 		Integer[] type = new Integer[1];
 		type[0] = 4;
  		MultiTreeNode newNode = new MultiTreeNode("TypeSpecifier", typeName, type);
  		return newNode;
  	} 	

  	protected MultiTreeNode createTypeSpecifier(String typeName, String typeNameVal)
  	{ 
 		Integer[] type = new Integer[1];
 		type[0] = 4;
 		if(typeNameVal == "namespace") {
 			type[0] = 5;
 		}
  		MultiTreeNode newNode = new MultiTreeNode(typeName, type);
  		return newNode;
  	}

  	protected MultiTreeNode createValueLiteral(String typeName)
  	{ 
  		MultiTreeNode newNode = new MultiTreeNode("String", typeName);
  		return newNode;
  	}
  	protected MultiTreeNode createValueLiteral(Integer typeName)
  	{ 
  		MultiTreeNode newNode = new MultiTreeNode("Integer", "" + typeName);
  		return newNode;
  	}
  	protected MultiTreeNode createValueLiteral(double typeName)
  	{ 
  		MultiTreeNode newNode = new MultiTreeNode("Double", "" + typeName);
  		return newNode;
  	}
  	protected MultiTreeNode createValueLiteral(float typeName)
  	{ 
  		MultiTreeNode newNode = new MultiTreeNode("Float", "" + typeName);
  		return newNode;
  	}

  	protected MultiTreeNode createValueLiteral(char typeName)
  	{ 
  		MultiTreeNode newNode = new MultiTreeNode("Char", "" + typeName);
  		return newNode;
  	}
	protected MultiTreeNode createListNode(String listName, MultiTreeNode firstChild)
	{
		MultiTreeNode newNode = new MultiTreeNode(listName);
		if(firstChild != null) {
			newNode.addChild(firstChild);
		}
		return newNode;
	}
	protected MultiTreeNode createListNode(String listName, String firstChild)
	{
		Integer[] type = new Integer[1];
 		type[0] = 3;
		MultiTreeNode newNode = new MultiTreeNode(listName, type);
		newNode.addChild(new MultiTreeNode("", "" + firstChild), listName);
		return newNode;
	}

	protected MultiTreeNode createListNode(MultiTreeNode firstChild)
	{
		MultiTreeNode newNode = new MultiTreeNode("");
		if(firstChild != null) {
			newNode.addChild(firstChild);
		}
		return newNode;
	}
	protected MultiTreeNode createListNode(String firstChild)
	{
		Integer[] type = new Integer[1];
 		type[0] = 3;
		MultiTreeNode newNode = new MultiTreeNode("", type);
		newNode.addChild(new MultiTreeNode("", "" + firstChild));
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, Integer value )
	{
		Integer[] type = new Integer[1];
 		type[0] = 1;
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value, type);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, Float value )
	{
		Integer[] type = new Integer[1];
 		type[0] = 1;
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value, type);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, Double value )
	{
		Integer[] type = new Integer[1];
 		type[0] = 1;
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value, type);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, String value )
	{
		Integer[] type = new Integer[1];
 		type[0] = 1;
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value, type);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName)
	{
		Integer[] type = new Integer[1];
 		type[0] = 1;
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, type);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, char value )
	{
		Integer[] type = new Integer[1];
 		type[0] = 1;
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value, type);
		if(typeSpecifier != null) {
			newNode.addChild(typeSpecifier);		
			newNode.addChild(new MultiTreeNode("CharValue", "" + value));
		}
		return newNode;
	}
	protected MultiTreeNode createCompoundStatement(MultiTreeNode declarations, MultiTreeNode instructions)
	{
		MultiTreeNode newNode = new MultiTreeNode("CompoundStatement");
		if (declarations != null)
			newNode.addChild(declarations);
		if (instructions != null)
			newNode.addChild(instructions);
		return newNode;
	}
	protected MultiTreeNode createIfStatement(String identifier, MultiTreeNode ifInstructions, MultiTreeNode elseInstructions)
	{
		MultiTreeNode newNode = new MultiTreeNode("IfStatement", identifier);
		newNode.addChild(ifInstructions);
		if (elseInstructions != null)
			newNode.addChild(elseInstructions);
		return newNode;
	}
	protected MultiTreeNode createCallFunction(String identifier, String parameters)
	{
		String entry = "";
		Integer[] type = new Integer[1];
		type[0] = 0;
		if(parameters != null)
			entry = parameters;
		MultiTreeNode newNode = new MultiTreeNode(identifier, entry, type);
		return newNode;
	}
}

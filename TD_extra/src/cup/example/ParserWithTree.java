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
 		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier + " function", identifierName);
 		if (paramsList != null)
 			newNode.addChild(paramsList);
 		newNode.addChild(compoundStatement);
 		return newNode; 
 	}
 	protected MultiTreeNode createObjDeclarationNode(String typeSpecifier, String identifierName, MultiTreeNode compoundStatement) 	
 	{ 
 		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName);
 		if(compoundStatement != null)
 			newNode.addChild(compoundStatement);
 		return newNode; 
 	}
 	protected MultiTreeNode createNamespaceDeclarationNode(MultiTreeNode typeSpecifier, String identifierList, MultiTreeNode scopeList, MultiTreeNode compoundStatement) 	
 	{ 
 		MultiTreeNode newNode = new MultiTreeNode("NamespaceDeclaration");
 		newNode.addChild(typeSpecifier);
 		newNode.addChild(new MultiTreeNode("Identifier", identifierList));
 		if(scopeList != null)
 			newNode.addChild(scopeList);
 		newNode.addChild(compoundStatement);
 		return newNode; 
 	}
 	protected MultiTreeNode createAccessSpecifiersDeclarationNode(MultiTreeNode typeSpecifier, MultiTreeNode compoundStatement) 	
 	{ 
 		MultiTreeNode newNode = new MultiTreeNode("AccessSpecifierDeclaration");
 		newNode.addChild(typeSpecifier);
 		if(compoundStatement != null)
 			newNode.addChild(compoundStatement);
 		return newNode; 
 	}
 	protected MultiTreeNode createInstanceDeclarationNode(String typeSpecifier, String identifierName, String paramsList, String value) 	
 	{ 
 		MultiTreeNode newNode = new MultiTreeNode("InstanceDeclaration");
 		newNode.addChild(new MultiTreeNode("TypeSpecifier", typeSpecifier));
 		newNode.addChild(new MultiTreeNode("VariableName", identifierName));
 		if (paramsList != null)
 			newNode.addChild(new MultiTreeNode("InstanceName", paramsList));
 		if (value != null)
 			newNode.addChild(new MultiTreeNode("ParametersList", value));
 		return newNode; 
 	}
  	protected MultiTreeNode createTypeSpecifier(String typeName)
  	{ 
  		MultiTreeNode newNode = new MultiTreeNode("TypeSpecifier", typeName);
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
		MultiTreeNode newNode = new MultiTreeNode(listName);
		newNode.addChild(new MultiTreeNode("", "" + firstChild));
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, Integer value )
	{
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, Float value )
	{
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, Double value )
	{
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, String value )
	{
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName, value);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName)
	{
		MultiTreeNode newNode = new MultiTreeNode(typeSpecifier, identifierName);
		return newNode;
	}
	protected MultiTreeNode createVarDeclaration(String typeSpecifier, String identifierName, char value )
	{
		MultiTreeNode newNode = new MultiTreeNode("Var Declaration", identifierName);
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
		MultiTreeNode newNode = new MultiTreeNode("FunctionCall", identifier);
		if(parameters != null)
			newNode.addChild(new MultiTreeNode("Parameters", parameters));
		return newNode;
	}
}

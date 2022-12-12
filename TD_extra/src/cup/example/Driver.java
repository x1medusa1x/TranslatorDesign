package cup.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java_cup.runtime.*;

class Driver {

	public static void main(String[] args) throws Exception {
		ParserWithTree parser = new ParserWithTree();
		parser.parse();
		
		MultiTree tree = parser.getSyntaxTree();
		tree.printTree();
	}
	
	
}
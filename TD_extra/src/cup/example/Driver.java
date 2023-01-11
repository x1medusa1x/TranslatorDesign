package cup.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java_cup.runtime.*;

import java.util.ArrayList;
import java.util.HashMap;



class Driver {

	public static void main(String[] args) throws Exception {
		ParserWithTree parser = new ParserWithTree();
		parser.parse();
		
		MultiTree tree = parser.getSyntaxTree();
		HashMap<String, ArrayList<SymTableEntry>> hashMap = getHashMap(tree);

		hashMap.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " -> " + entry.getValue());
		});
		
	}
	
	public static HashMap<String, ArrayList<SymTableEntry>> getHashMap(MultiTree tree) {
		HashMap<String, ArrayList<SymTableEntry>> hashMap = new HashMap<String, ArrayList<SymTableEntry>>();
		tree.getHashMap(hashMap);
		return hashMap;
	}
	
}
package app;

import app.input.CSVParser;
import app.model.avl.AVLTree;
import app.model.binary.BinaryTree;

public class App {
	public static void main(String[] args) {
		String filePath = "population-and-demography.csv";
		
		BinaryTree binTree = CSVParser.generateBinaryTree(filePath);
		AVLTree avlTree = CSVParser.generateAVLTree(filePath);
		
//		binTree.print();
//		
//		avlTree.print();
	}
}
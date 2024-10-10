package app;


import java.util.Date;

import app.input.CSVParser;
import app.model.avl.AVLTree;
import app.model.binary.BinaryTree;

public class App {
	public static void main(String[] args) {
		String filePath = "population-and-demography.csv";
		
		System.out.println("Data de execução: " + new Date());
		BinaryTree binTree = CSVParser.generateBinaryTree(filePath);
		AVLTree avlTree = CSVParser.generateAVLTree(filePath);
		Date inicio;
		Date fim;
		
		inicio = new Date();
		binTree.search("Brazil");
		fim = new Date();
		System.out.println("Search for Brazil in Binary Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		avlTree.search("Brazil");
		fim = new Date();
		System.out.println("Search for Brazil in AVL Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		binTree.search("Pakistan");
		fim = new Date();
		System.out.println("Search for Pakistan in Binary Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		avlTree.search("Pakistan");
		fim = new Date();
		System.out.println("Search for Pakistan in AVL Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		binTree.search("Albania");
		fim = new Date();
		System.out.println("Search for Albania in Binary Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		avlTree.search("Albania");
		fim = new Date();
		System.out.println("Search for Albania in AVL Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		binTree.search("Fiji");
		fim = new Date();
		System.out.println("Search for Fiji in Binary Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		avlTree.search("Fiji");
		fim = new Date();
		System.out.println("Search for Fiji in AVL Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		binTree.search("Moldova");
		fim = new Date();
		System.out.println("Search for Moldova in Binary Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		avlTree.search("Moldova");
		fim = new Date();
		System.out.println("Search for Moldova in AVL Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		binTree.search("Togo");
		fim = new Date();
		System.out.println("Search for Togo in Binary Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		avlTree.search("Togo");
		fim = new Date();
		System.out.println("Search for Togo in AVL Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		binTree.search("Zimbabwe");
		fim = new Date();
		System.out.println("Search for Zimbabwe in Binary Tree " + (inicio.getTime() - fim.getTime()));
		
		inicio = new Date();
		avlTree.search("Zimbabwe");
		fim = new Date();
		System.out.println("Search for Zimbabwe in AVL Tree " + (inicio.getTime() - fim.getTime()));
		
		System.out.println("altura AVL: " + avlTree.height());
		System.out.println("altura binária: " + binTree.height());
	}
}
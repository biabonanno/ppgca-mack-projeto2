package app.input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import app.model.avl.AVLTree;
import app.model.binary.BinaryTree;

public class CSVParser {

	public static BinaryTree generateBinaryTree(String file) {
		BinaryTree tree = new BinaryTree();
		ArrayList<String> treeElements = readFile(file);
		Date dataInicio = new Date();

		for (String input : treeElements) {
			String[] dividedInput = input.split(",");
			try {
				tree.insert(dividedInput[0], Integer.parseInt(dividedInput[2]), Long.parseLong(dividedInput[3]));
			} catch (Exception e) {
				continue;
			}
		}
		Date dataFim = new Date();
		System.out.println("Insert in BinaryTree" + (dataFim.getTime() - dataInicio.getTime()));
		return tree;
	}

	public static AVLTree generateAVLTree(String file) {
		AVLTree tree = new AVLTree();
		ArrayList<String> treeElements = readFile(file);
		Date dataInicio = new Date();

		for (String input : treeElements) {
			String[] dividedInput = input.split(",");
			try {
				tree.insert(dividedInput[0], Integer.parseInt(dividedInput[2]), Long.parseLong(dividedInput[3]));
			} catch (Exception e) {
				continue;
			}
		}
		Date dataFim = new Date();

		System.out.println("Insert in AVL Tree" + (dataFim.getTime() - dataInicio.getTime()));

		return tree;
	}

	private static ArrayList<String> readFile(String filePath) {
		ArrayList<String> input = new ArrayList<String>();
		String line = "";
		boolean firstLine = true;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((line = br.readLine()) != null) {
				if (firstLine) {
					firstLine = false;
					continue;
				}
				input.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}
}

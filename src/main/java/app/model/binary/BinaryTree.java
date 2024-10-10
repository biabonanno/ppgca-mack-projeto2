package app.model.binary;

import java.util.HashMap;

public class BinaryTree {

    private BinaryNode root;

    public void insert(String country, int year, Long population) {
        root = insert(root, country, year, population);
    }

    private BinaryNode insert(BinaryNode main, String country, int year, Long population) {
        if (main == null) {
            return new BinaryNode(country, year, population);   //condição de parada. Caso base
        }

        if (country.compareTo(main.getCountry()) < 0) {
            main.setLeft(insert(main.getLeft(), country, year, population));
        } else if (country.compareTo(main.getCountry()) > 0) {
            main.setRight(insert(main.getRight(), country, year, population));
        }else {
        	main.getData().put(year, population);
        }
        
        return main;
    }

    public BinaryNode find(String country) {
        return find(country, root);
    }

    private BinaryNode find(String country, BinaryNode main) {
        if (main == null || main.getCountry().equals(country)) { //condição de parada. Caso base
            return main;  
        }

        if (country.compareTo(main.getCountry()) < 0) {
            return find(country, main.getLeft());
        } else {
            return find(country, main.getRight());
        }
    }

    public void print() {
        print(root);
    }
    
    public HashMap<Integer, Long> search(String country) {
        return search(country, root);
    }

    private HashMap<Integer, Long>search(String country, BinaryNode root) {
        if (root == null) {
            return null;
        }

        if (root.getCountry().equals(country)) {
            return root.getData();
        }

        if (country.compareTo(root.getCountry()) < 0) {
            return search(country, root.getLeft());
        } else {
            return search(country, root.getRight());
        }
    }
    
    public int height () {
    	return height (root);
    }
    private int height(BinaryNode main) {
        if (main == null) {
            return 0;
        }

        int alturaEsquerda = height(main.getLeft());
        int alturaDireita = height(main.getRight());

        return Math.max(alturaEsquerda, alturaDireita) + 1;
    }

    private void print(BinaryNode main) {
        if (main != null) {
            print(main.getLeft());
            for(Integer year : main.getData().keySet()) {
            	System.out.println("País: " + main.getCountry() + ", Ano: " + year + ", População: " + main.getData().get(year));
            }
            print(main.getRight());
        }
    }
}

package app.model.avl;

import java.util.HashMap;

public class AVLTree {

	private AVLNode root;

    public void insert(String country, int year, Long population) {
        root = insert(root, country, year, population);
    }

    // Função recursiva para inserir um nó e balancear a árvore AVL
    private AVLNode insert(AVLNode main, String country, int year, Long population) {
        if (main == null) {
            return new AVLNode(country, year, population);  
        }

        if (country.compareTo(main.getCountry()) < 0) {
            main.setLeft(insert(main.getLeft(), country, year, population));
        } else if (country.compareTo(main.getCountry()) > 0) {
            main.setRight(insert(main.getRight(), country, year, population));
        } else {
            main.getData().put(year, population);
        }

        // Atualizar a altura do nó atual
        main.setHeight(1 + Math.max(height(main.getLeft()), height(main.getRight())));

        // Verificar e corrigir o balanceamento da árvore
        int balanceamento = getBalancingQuote(main);

        //Rotação simples à direita
        if (balanceamento > 1 && country.compareTo(main.getLeft().getCountry()) < 0) {
            return rotacaoDireita(main);
        }

        // Rotação simples à esquerda
        if (balanceamento < -1 && country.compareTo(main.getRight().getCountry()) > 0) {
            return rotacaoEsquerda(main);
        }

        // Rotação dupla (esquerda-direita)
        if (balanceamento > 1 && country.compareTo(main.getLeft().getCountry()) > 0) {
            main.setLeft(rotacaoEsquerda(main.getLeft()));
            return rotacaoDireita(main);
        }

        // Rotação dupla (direita-esquerda)
        if (balanceamento < -1 && country.compareTo(main.getRight().getCountry()) < 0) {
            main.setRight(rotacaoDireita(main.getRight()));
            return rotacaoEsquerda(main);
        }

        return main;  
    }

    private AVLNode rotacaoDireita(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode temp = x.getRight();

        x.setRight(y); 
        y.setLeft(temp);

        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    private AVLNode rotacaoEsquerda(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode temp = y.getLeft();

        y.setLeft(x);
        x.setRight(temp); 

        x.setHeight( Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight( Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    private int height(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalancingQuote(AVLNode node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public HashMap<Integer,Long>search(String country) {
        return search(country, root);
    }

    private HashMap<Integer,Long> search(String country, AVLNode main) {
        if (main == null || main.getCountry().equals(country)) {
            return main.getData();  
        }

        if (country.compareTo(main.getCountry()) < 0) {
            return search(country, main.getLeft());
        } else {
            return search(country, main.getRight());
        }
    }
    
    public int height () {
    	return root.getHeight();
    }

    public void print() {
        print(root);
    }

    private void print(AVLNode main) {
        if (main != null) {
            print(main.getLeft());
            for(Integer year : main.getData().keySet()) {
            	System.out.println("País: " + main.getCountry() + ", Ano: " + year + ", População: " + main.getData().get(year));
            }
            print(main.getRight());
        }
    }
}

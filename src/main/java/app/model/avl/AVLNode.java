package app.model.avl;

import java.util.HashMap;

public class AVLNode {

	private String country;
    private HashMap<Integer, Long> data;
    private int height;
    private AVLNode left;
    private AVLNode right;

    public AVLNode(String country, int year, Long totalPopulation) {
        this.country = country;
        data = new HashMap<Integer, Long>();
        data.put(year, totalPopulation);
        this.height = 1;  
        this.left = null;
        this.right = null;
    }

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public HashMap<Integer, Long> getData() {
		return data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public AVLNode getLeft() {
		return left;
	}

	public void setLeft(AVLNode left) {
		this.left = left;
	}

	public AVLNode getRight() {
		return right;
	}

	public void setRight(AVLNode right) {
		this.right = right;
	}
    
}
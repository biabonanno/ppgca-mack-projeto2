package app.model.binary;

import java.util.HashMap;

public class BinaryNode {

	private BinaryNode left;
	private BinaryNode right;
    private String country;  //this will be our Unique identifier since year and population can be repeated
    private HashMap<Integer,Long> data;

    
    public BinaryNode(String country, int year, Long totalPopulation) {
        this.country = country;
        data = new HashMap<Integer, Long>();
        data.put(year, totalPopulation);
        this.left = null;
        this.right= null;
    }


	public BinaryNode getLeft() {
		return left;
	}


	public void setLeft(BinaryNode left) {
		this.left = left;
	}


	public BinaryNode getRight() {
		return right;
	}


	public void setRight(BinaryNode right) {
		this.right = right;
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

}

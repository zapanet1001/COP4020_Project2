package Huffman;
public class HuffTree{
	//data
	private HuffBaseNode root;
	private char c;
	
	//constructors
	public HuffTree(char c, int w) {					//leaf node
		this.root = new HuffLeafNode(c,w);
		this.c =c;
	}
	
	public HuffTree(HuffTree l, HuffTree r, int w) { //internal node
		this.root = new HuffInternalNode(l,r,w);
	}
	
	//methods
	public HuffBaseNode getRoot() {
		return root;
	}
	
	public int getWeight() {
		return root.getWeight();
	}

	public char getElement() {
		return c;
	}
	

}


package Huffman;
public class HuffInternalNode implements HuffBaseNode{
	private int weight;
	private HuffTree left;
	private HuffTree right;
	private char c;
	
	public HuffInternalNode(HuffTree l, HuffTree r, int w) {
		this.weight = w;
		this.left = l;
		this.right = r;
		this.c=' ';
	}
	
	public HuffTree getLeftChild() { 
		return left;
	}

	public HuffTree getRightChild() { 
		return right;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public char getElement() {
		return c;
	}



}

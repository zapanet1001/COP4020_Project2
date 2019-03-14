package Huffman;
public class HuffLeafNode implements HuffBaseNode{
	private char element;
	private int weight;
	private HuffTree left;
	private HuffTree right;
	
	public HuffLeafNode(char c, int w) {
		this.element = c;
		this.weight = w;
		this.left = null;
		this.right = null;
	}
	
	public char getElement() {
		return element;
	}
	
	@Override
	public int getWeight() {
		return weight;
	}
	
	@Override
	public boolean isLeaf() {
		return true;
	}

	@Override
	public HuffTree getLeftChild() {
		return left;
	}

	@Override
	public HuffTree getRightChild() {
		return right;
	}


}

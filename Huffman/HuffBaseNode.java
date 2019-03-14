package Huffman;
public interface HuffBaseNode {
	boolean isLeaf();
	int getWeight();
	
	public HuffTree getLeftChild();
	public HuffTree getRightChild();
	public char getElement();

}

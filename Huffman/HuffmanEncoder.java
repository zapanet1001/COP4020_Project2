package Huffman;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class HuffmanEncoder implements HuffmanCoding{
	int[] frequencyTable = new int[256];
	String[] codeTable = new String[256];
	
	//take a file as input and create a table with characters and frequencies
	//print the characters and frequencies
	public String getFrequencies(File inputFile){
		String data = fileToString(inputFile);	//get file as string
		
		/*Calculate the frequency of each character
		  and place in table indexed by character*/
		for(int i=0; i< data.length(); i++) {
			char c = data.charAt(i);
			frequencyTable[c]++;
		}
		
		StringBuilder freq = new StringBuilder();	//create string of frequencies
		for(int i=0; i<256; i++) { 
			if(frequencyTable[i] >0) {
				char b = (char)i;
				freq.append(b);
				freq.append(" ");
				freq.append(frequencyTable[i]);
				freq.append("\n");
			}
		}
		return freq.toString();
	}
	
	
	
			public String fileToString(File fileName) {
				Scanner s;
				StringBuilder str = new StringBuilder();	//string to store file
				try {
					s = new Scanner(fileName);		//scan file
					str.append(s.nextLine());		//add next line to string
					while(s.hasNextLine()) {			//add rest of file to string
						str.append(s.nextLine());
					}
					
				}
				catch(FileNotFoundException e) {
					System.out.println("ERROR: FILE NOT FOUND");
				}
				
				return str.toString();
			}

	
	
	//take a file as input and create a Huffman Tree
	public HuffTree buildTree(File inputFile) {
		//get characters/frequencies from file
		String data = fileToString(inputFile);
		for(int i=0; i< data.length(); i++) {
			char c = data.charAt(i);
			frequencyTable[c]++;
		}
		
		//create list of HuffTree leaf nodes
		ArrayList<HuffTree> list = new ArrayList<HuffTree>();			//list to hold trees
		for(int i=0; i<frequencyTable.length; i++) {					//iterate through frequency data
			if(frequencyTable[i]>0) {
				HuffTree h = new HuffTree((char)i, frequencyTable[i]);	//create HuffTree(Leaf)for each character with its frequency
				list.add(h);												//add HuffTree to List
			}
		}
	
		//create MinHeap of HuffTree leaf nodes
		MinHeap heap = new MinHeap(list);
		
		//build the Huffman Tree
		HuffTree tree1, tree2, huffmanTree = null;
		while(heap.getHeapSize() >1) {
			tree1 = heap.removeMin();	//get first minimum
			tree2 = heap.removeMin();	//get next minimum
			huffmanTree= new HuffTree(tree1,tree2, tree1.getWeight()+tree2.getWeight());	//create internal node with children
			heap.insert(huffmanTree);	//insert the tree back into the heap
		}
		
		return huffmanTree;
	}
	
	


	//take a file and a HuffTree and encode the file.  
	//output a string of 1's and 0's representing the file
	public String encodeFile(File inputFile, HuffTree huffTree) {
		//create string for bits
		StringBuilder fileAsBits = new StringBuilder();
		
		//File to String
		String data = fileToString(inputFile);

		//Traverse String characters and add encoded char to fileAsBits
		traverse(huffTree, "");
		for(int i=0;i<data.length(); i++) {
			fileAsBits.append(codeTable[(int)data.charAt(i)]);
		}
		return fileAsBits.toString();
	}


	//take a String and HuffTree and output the decoded words
	public String decodeFile(String code, HuffTree huffTree) {
		StringBuilder bitString = new StringBuilder(); //stores one char bit string
		StringBuilder decoded = new StringBuilder();	  //stores entire file as String

		for(int i=0;i<code.length();i++) {
			//develop bitString
			bitString.append(code.charAt(i));
			
			//search for bitString in codeTable 
			for(int j=0; j<codeTable.length;j++) {
				if(codeTable[j] != null && codeTable[j].equals(bitString.toString())) {
					decoded.append((char)j);
					bitString.setLength(0);
					break;
				}
			}
			
		}
		return decoded.toString();
	}

	//print the characters and their codes
	public String traverseHuffmanTree(HuffTree huffTree) {
		traverse(huffTree, "");
		StringBuilder codes = new StringBuilder();
		for(int i=0; i<256; i++) { 
			if(codeTable[i] != null) {
				char b = (char)i;
				codes.append(b);				//add character to string
				codes.append(" ");
				codes.append(codeTable[i]);	//add bitstring to string
				codes.append("\n");
			}
		}
		return codes.toString();
	}
			//stores bit strings for each character in code table
			public void traverse(HuffTree h, String s) {		
				if (h.getRoot().isLeaf()) {
		            codeTable[(int)h.getElement()] = s;
					return;
		        }
		
		        // recursive calls for left and right sub-tree
		        traverse(h.getRoot().getLeftChild(), s + "0");		// if we go left add "0" to bitstring
		        traverse(h.getRoot().getRightChild(), s + "1");	    // if we go right add "1" to bitstring
			}
			

			
	

}

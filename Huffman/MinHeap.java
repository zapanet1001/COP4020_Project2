package Huffman;
import java.util.ArrayList;
import java.util.Collections;

public class MinHeap {
	private ArrayList<HuffTree> list;
	

	public MinHeap(ArrayList<HuffTree> items) {
		//System.out.println("MINHEAP");
		this.list = items;
		buildHeap();
	}
	
	
	public void buildHeap() {
		for(int i=(int)Math.floor(list.size()/2); i>=0; i--) {
			heapify(i);
		}

	}
	
	/*adds new element to end of heap*/
	public void insert(HuffTree x) {
		list.add(x);							//add element to end of tree
		int addedElement = list.size() - 1;	// get index of last added element
		
		int parent = parent(addedElement);  	//get index of the parent of the added element
		//check if the last element is less than parent to swap and satisfy minheap conditions
		while(list.get(parent).getWeight() != list.get(addedElement).getWeight() && list.get(addedElement).getWeight() < list.get(parent).getWeight()) {
			Collections.swap(list, addedElement, parent);
			for(int i=(int)Math.floor(list.size()/2); i>=0; i--) {
				heapify(i);
			}
		}
		
	}

	
	/*Removes the root/minimum from top of heap and rebalances tree*/
	public HuffTree removeMin() {
		//check if list is empty
		if(list.size()==0) {
			throw new IllegalStateException("MinHeap is Empty");
		}
		//check if one item left in list
		else if (list.size()==1) {
			HuffTree min = list.remove(0);	//removes last HuffTree
			return min;	
		}
		
		HuffTree min = list.remove(0);		//get root/minimum
		heapify(0);							//reorder the tree
		
		return min;							//returns removed minimum/root
	}
	
	/*reorders heap to satisfy minHeap requirements*/
	public void heapify(int x) {
		int l = leftChild(x); 	//gets left child index
		int r = rightChild(x);	//gets right child index
		int min = x;
		
		//find minimum of current node and children
		int minChild;
		if(l<= list.size()-1 && r<=list.size()-1) {
			minChild = list.get(l).getWeight()<=list.get(r).getWeight() ? l:r;
			if(minChild<= list.size()-1 && list.get(minChild).getWeight()<list.get(x).getWeight()) {
				min = minChild;
			}
		}
		else if(l<= list.size()-1 && r>list.size()-1) {
			minChild = l;
			if(minChild<= list.size()-1 && list.get(minChild).getWeight()<list.get(x).getWeight()) {
				min = minChild;
			}
		}
		else {
			min = x;
		}
		
		//reorder heap if parent is not minimum
		if(min != x) {
			Collections.swap(list,x,min);
			heapify(min);
		}
			
	}
	
	/*swaps two values in the heap*/
	public void swap(int x, int parent) {
		Collections.swap(list, x, parent);
	}
	
	/*Returns the value of the minimum element at top of heap*/
	public int getMin() {
		return list.get(0).getWeight();
	}
	
	/*Returns the index of the parent node of x*/
	private int parent(int x) {
		if(x%2 == 1) {
			return x/2;
		}
		return (x-1)/2;
	}
	
	/*Returns the index of the right child node of x*/
	private int rightChild(int x) {
		return 2*x+2;
	}
	
	/*Returns the index of the left child node of x*/
	private int leftChild(int x) {
		return 2*x+1;
	}

	/*Returns the size of the heap*/
	public int getHeapSize() {
		return list.size();
	}
	
	/*Prints the order of the heap in array form*/	
	/*public void printHeap() {
		System.out.println("\nHEAP::");

		for(int i=0;i<list.size();i++) {
			System.out.println(i+" : "+list.get(i).getWeight());
		}
	}*/

}

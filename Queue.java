package dataStructures;

//this implementation is based on Queue
//I need for your feed back to improve my next codes

public class Queue <X> {
	
	private Node firstNode=null;
	private Node currentNode=null;
	private Node lastNode=null;
	private int numberOfNodes=0;
//---------------------------------------------------------------------------------------
	private class Node { 
	
		Node (X data){
			this.data=data;
		}
		X data=null;
		int position;
		Node before=null;
		Node next=null;
				
	}
	public void enqueue(X data) {
		Node node = new Node(data); //always
		if (firstNode!=null) {
			node.next=firstNode;
			firstNode.before=node;
			
		}else {
			lastNode=node; //because, if the first is empty so the last
		}
			
		firstNode=node;
		numberOfNodes++; //always
		setPosition();

   }
   	public void dequeue() {
		if (numberOfNodes >= 2) {
			lastNode.before.next=null;
			lastNode=lastNode.before;
			numberOfNodes--;
			setPosition();

		} else if (numberOfNodes==1){
			firstNode=null;
			lastNode=null;
			numberOfNodes--;
		}

	}
	private void setPosition(){
		Node node = firstNode;
		int p = 1;
		while (node!=null){
			node.position=p;
			node=node.next;
			p++;
		}	
	}
	public void printAll(){

		System.out.println("number of nodes : "+numberOfNodes);
		Node node= firstNode;
		if (numberOfNodes==0) System.out.println("the list is empty");
		while (node!=null){
			System.out.println(node.position+": "+node.data);
			node=node.next;
		}
		   
   }
	public X undo(){
		if (currentNode!=null && currentNode!=firstNode) {
				currentNode=currentNode.before;
				return currentNode.data;
		} else {
				return null;
		}	
	}
	public X redo(){
		if (currentNode!=null && currentNode!=lastNode) {
				currentNode=currentNode.next;
				return currentNode.data;
		} else {
				return null;
		}
	
	}
	public X getCurrentNode(){
		return currentNode.data;
	}
	public int getNumberOfNodes(){
		return numberOfNodes;
	}
}
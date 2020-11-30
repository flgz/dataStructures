package dataStructures;

//I need for your feed back to improve my next codes

public class DoubleLinkedList <X> {
	
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
	public void addAtEnd (X data) {
		
		Node node = new Node(data); //always
		if (lastNode!=null){
			lastNode.next=node;
			node.before=lastNode;
		}
		else {
			firstNode=node; //because, if the last is empty so the first
			
		}
		
		lastNode = node;
		numberOfNodes++; //always
		setPosition();
		currentNode=node; //the last added node is the current, going forward
   }
	public void addAtFirst (X data) {
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
	private void setPosition (){
		Node node = firstNode;
		int p = 1;
		while (node!=null){
			node.position=p;
			node=node.next;
			p++;
		}	
	}
	public void remove(X data) {
		
		Node vrf = firstNode;
		while (vrf!=null){
			
			if (vrf.data.equals (data)){
				if (vrf!=lastNode){
					vrf.next.before=vrf.before; //e.g to remove 'b' : a-b-c-d -> a-c-d
				} 
				else {
					lastNode=vrf.before;
				}
				if (vrf!=firstNode) {
					vrf.before.next=vrf.next;
				}
				else {
					firstNode = vrf.next;
			
				}
			numberOfNodes--;
			}
			vrf=vrf.next;
		}
	setPosition();
	
	}
	public void removeLastNode () {
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
	public void removeFirstNode () {
		if (numberOfNodes >= 2){
				firstNode.next.before=null;
				firstNode=firstNode.next;
				numberOfNodes--;
				setPosition();
		} else if (numberOfNodes==1){
			firstNode=null;
			lastNode=null;
		numberOfNodes--;
			}
			
}
	public void printAll (){

		System.out.println("number of nodes : "+numberOfNodes);
		Node node= firstNode;
		if (numberOfNodes==0) System.out.println("the list is empty");
		while (node!=null){
			System.out.println(node.position+": "+node.data);
			node=node.next;
		}
		   
   }
	public X undo (){
		if (currentNode!=null && currentNode!=firstNode) {
				currentNode=currentNode.before;
				return currentNode.data;
		} else {
				return null;
		}	
	}
	public X redo (){
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
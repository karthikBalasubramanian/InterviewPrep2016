import java.util.Random;

public class LinkedListApplications {
	
	 public Node reverseList(Node head) {
		 if(head!=null){
		     Node curr = head;
		     Node prev = null;
		     Node next;
		     while(curr!=null){
		    	 next = curr.next;
		    	 curr.next = prev;
		    	 prev = curr;
		    	 curr = next;
		     }
		     head= prev;
			 return head;
		 }
		 else{
			 return null;
		 }
	    }
	 
	 public void recursiveReversePrint(Node head){
//		 here we traverse in the forward direction and then reverse in the backward direction.
		 if(head==null){
			 return;
		 }
		 recursiveReversePrint(head.next);
		 System.out.println(head.data);
	 }
	 
	 public void recursiveReverse(Node curr,LinkedList obj){
		 if(curr.next==null){
			 obj.head = curr;
			 return;
		 }
		 recursiveReverse(curr.next, obj);
		 Node newPrev = curr.next;
		 newPrev.next =curr;
		 curr.next= null;
		 
	 }
	 
	public Node reverseBetweenMandN(Node head,int m,int n){
		// given m < n < total size
		int i =1;
		Node curr = head;
		Node prev = null;
		Node next = null;
		// 1 3 4 6 7 9
		while(i<=m){
			prev = curr;
			curr = curr.next;
			
			i++;
		}
		Node start = prev;
		while(i<n){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return head;
	}

	public Node recursiveReverse(Node currNode){
		if(currNode==null || currNode.next==null){
			return currNode;
		}
		Node nextNode = currNode.next;
		Node newHead = recursiveReverse(nextNode);
		// always send newHead back. its the same
		nextNode.next = currNode;
		currNode.next=null;
		return newHead;
		
		
	}
	
	public boolean checkIfLoop(Node head){
		// hare and tortoise problem.
		
		Node hare = head;
		Node tortoise = head;
		while(true){
			if(hare==null){
				return false;
			}
			hare = hare.next;
			if(hare==null){
				return false;
			}
			hare = hare.next;
			tortoise = tortoise.next;
			if(hare==tortoise){
				return true;
			}
		}
	}
	
	public Node findStartNodeInLoop(Node head){
		
		Node hare = head;
		Node tortoise = head;
		while(true){
			if(hare==null){
				break;
			}
			hare = hare.next;
			if(hare==null){
				break;
			}
			hare = hare.next;
			tortoise = tortoise.next;
			if(hare==tortoise){
				tortoise =head;
				while(hare!=tortoise){
					hare = hare.next;
					tortoise = tortoise.next;
				}
				return tortoise;
			}
		}
		
		
		return null;
	}
	
	public Node mergeTwoLists(Node l1, Node l2) {
		// trick is to use two nodes.
		// one that traverses all the way to end
		// other points to head of the first.
		// situations if l1.next is null,
		// situations if l2.next is null
		Node current = new Node(0);
		Node head = current;
		while (l1 != null && l2 != null) {
			if (l1.data <= l2.data) {
				current.next = l1;
				l1 = l1.next;
				current = current.next;
			} else {
				current.next = l2;
				l2 = l2.next;
				current = current.next;
			}
		}

		if (l1 == null && l2 != null) {
			current.next = l2;
		} else if (l2 == null && l1 != null) {
			current.next = l1;
		}

		return head.next;

	}
	
	public Node recursiveMergeTwoLists(Node l1, Node l2){
		if(l1==null)
			return l2;
		if(l2==null)
			return l1;
		
		if(l1.data<=l2.data){
			l1.next =  recursiveMergeTwoLists(l1.next, l2);
			return l1;
		}
		if(l1.data>l2.data){
			l2.next = recursiveMergeTwoLists(l1, l2.next);
			return l2;
		}
		return null;
		
	}
	
	public int lengthOfLinkedList(Node l1){
		int len = 0;
		while(l1!=null){
			l1 = l1.next;
			len++;
		}
		return len;
	}
	
	public Node findMergingNodeInTwoLists(Node l1, Node l2){
		// think about delhi metro as example
		// find the length of two linked lists
		// subtract the difference.
		// then finally start searching for only the common length shared between the two.
		
		int len1 = lengthOfLinkedList(l1);
		int len2 = lengthOfLinkedList(l2);
		int distance =0;
		if(len1>len2){
			Node temp = l1;
			l1 = l2;
			l2 = temp;
			distance = len1-len2;
		}
			distance = len2-len1;
			for (int i =0; i<distance; i++){
				l2 = l2.next;
			}
			while(l1!=null && l2!=null){
				if(l1==l2) return l1;
				l1 = l1.next;
				l2 =l2.next;
			}
			
			return null;
		
		
	}
	public static void main(String[] args) {
		Random myRandom = new Random(20);
		int[] generator = myRandom.ints(1,50).distinct().limit(5).toArray();
		LinkedList myList = new LinkedList();

		for (int i = 0; i < 5; i++) {
			myList.add(generator[i]);

		}
		myList.display(myList.head);
		LinkedListApplications app = new LinkedListApplications();
		myList.head = app.reverseList(myList.head);
		System.out.println();
		System.out.println("reversing!!!");
		System.out.println();
		myList.display(myList.head);
		LinkedList oneNodeList = new LinkedList();
		System.out.println();
		System.out.println("null list check");
		System.out.println();
		Node oneNodeReverse = app.reverseList(null);
		oneNodeList.display(oneNodeReverse);
		System.out.println();
		System.out.println("trying recursive reverse print");
		System.out.println();
		app.recursiveReversePrint(myList.head);
		System.out.println();
		System.out.println("Recursive return");
		app.recursiveReverse(myList.head, myList);
		System.out.println();
		System.out.println("printing reverse list");
		System.out.println();
		myList.display(myList.head);
		System.out.println();
		System.out.println("using node to return");
		System.out.println();
		myList.head = app.recursiveReverse(myList.head);
		myList.display(myList.head);
		System.out.println();
		System.out.println("between M and N");
		app.reverseBetweenMandN(myList.head,0, 3);

	}

}

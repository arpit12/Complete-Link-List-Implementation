// insert, delete, inbetw, last whatever type must be node bec, there will always be change in strucutre of list..

import java.util.NoSuchElementException;
class Node{

int data;
Node next;

public Node(int data, Node next)
{
  this.data = data;
	this.next = next;
}

public String toString()
{
	return ""+data;
}

}

public class LinkList1 {

private Node head;

public void insert(int data)
{
if(head==null)
{
head = new Node(data,null);
}
else
head= new Node(data,head);
}

public void print(Node head)
{
	for(Node node = head;node!=null;node=node.next)
	{
	System.out.print(node.data+" ");
	}
}

public void sum(Node head)
{
	int evensum = 0;
	int oddsum = 0;
	for(Node node = head;node!=null;node=node.next)
	{
	
	if(node.data%2==0)
	{
	evensum = evensum + node.data;
	}
	else 
	{
	oddsum = oddsum + node.data;
	}

	}
 	System.out.println(" Sum of Link List 1 even numbers : "+evensum );
 	System.out.println(" Sum of Link List 1 odd numbers : "+oddsum );

}

public void addLast(int data)
{
	if(head==null)
	{
	insert(data);
	}
	
	else{
	addLast(head,data);
	}
}

public void addLast(Node node,int data)
{
 	if(node.next!=null)
	{
	addLast(node.next,data);
	}
	else
	node.next = new Node(data,null);
}



public int getFirst()
{
Node tmp =head;
return tmp.data;
}

public void removeFirst()
{
  head = head.next;
   
}

public int getLast()
{
Node tmp =head;
while(tmp.next!=null)
{
tmp = tmp.next;
}

return tmp.data;
}

public void delete(int key)
{
Node prev = null;
Node curr = head;

while(curr.next!=null && curr.data!=key)
{
		prev = curr;
		curr = curr.next;
}

	prev.next = curr.next;

}

    public void reverse( Node node ) {
        if( node != null ) {
             reverse(node.next);
            System.out.print( node.data + " " );
        }
    }
  
 
	public int len()
	{
		int count=0;
		for(Node cur = head; cur.next!=null;cur = cur.next)
		{
		count++;
		}
	return count;
	}

	// recursion way
   public Node search (Node l, int value)
  {
    if (l == null || l.data == value)
      return l;
    else
      return search(l.next, value);
  }
  
  // // insert, delete, inbetw, last whatever type must be node bec, there will always be change in strucutre of list..

 
	// iteration way..
   public Node lookup(Node h,  int n) {
       for(Node p = h.next; p != null; p = p.next )
          if( p.data == n ) 
              return p; 
         return null;             // return null if item not found
    }
	
// Appending two lists is a simple way of creating a single list from two. This function adds the second list to the end of the first list:

	  public static Node append( Node p, Node q ) 
	  {
        if ( p == null) 
           return q; 
        else {
          p.next = append( p.next, q );
          return p;
        }
     }
// Here is a more complex function to combine two lists; it simply zips up two lists, taking a node from one, then from the other. 
 // If head points to 3 4 7 and anotherlist points to 2 5 6 8, then at the end of this call to zip, head will point to 3 2 4 5 7 6 8

   
	public static Node zip( Node p, Node q ) {
        if ( p == null) 
           return q;
        else if ( q == null) 
           return p;
        else {
           p.next = zip( q, p.next );     // Note how we exchange p and q here
           return p;
        }
     }
   
//Here is another more complex function to combine two lists; this one merges nodes from two sorted lists,
//  preserving their order:

 public static Node merge( Node p, Node q )
 {
        if ( p == null) 
           return q;
        else if ( q == null) 
           return p;
        else if (p.data < q.data) {
           p.next = merge( p.next, q );
           return p;
        }
        else {
           q.next = merge( p, q.next );
           return q;
        }
     }
   
   
	public static Node copy( Node p ) {
       if( p == null )
          return null; 
       else 
          return new Node(p.data, copy( p.next )); // recursion always uses function name so copy( p.next ), instead of p.next
    } 
   
    public static Node insertInOrder( int k, Node p ) {
       // for head only
	   if( p == null || p.data <= k ) 
          return new Node( k, p ); 		 
        // for remaining list..
		if(p.next!=null && p.data < k)
		 p=p.next; 
		 
		 else {
				p.next= insertInOrder( k, p.next ); // p.next use only when there are more nodes after current particluar node..
			}
          return p;
       
    } 
	
	
	
	public void displayLastNElements(Node head, int n){
    if (head.next == null) {
        System.out.println("The linked list is empty.");
    }else{
        Node first = head;
		Node second = head;
        int distanceBetweenTwoPointers = 0;

        while (distanceBetweenTwoPointers < (n-1)) {
            first = first.next;
            distanceBetweenTwoPointers++;
        } // we have first shifted to 2 pointer ahead from second.

        while (first.next != null) {
            first = first.next;
            second = second.next;  // now after this loop ,sec is 2 step away from last.
        }

        System.out.println("Printing the last "+n+" elements of the linked list :");
        while (second.next!= null) {
            System.out.println(" "+second.data);
            second = second.next;
        }
        System.out.println(" "+second.data);  // this prints last element 19 we need this stat here. bec, its node.next=null
    }
}
	
	
	
	
   //  same program using iteration...
   public void  insertSorted( Node h, int n ) {
        Node p = h.next;                   // p points to first real node in list                 
        Node q = h;                        // q trails p
        while( p != null ) {
           if(p.data >= n) {               // found insertion point, between p and q
                q.next = new Node(n, p);
                return;
           }
           q = p; 
           p = p.next;
        }
        q.next = new Node(n, null);        // Node must be added at end of list
   }
    
   
     public static Node deleteItem( int k, Node p ) {
       if( p == null )                     // if the list is ordered use:  ( p == null || p.data > k )
          return p; 
       else if ( p.data == k ) 
          return p.next;               // if you want to delete all instances, use:  return deleteItem( k, p.next );  
       else {
          p.next = deleteItem( k, p.next );
          return p; 
       }
    }
	
	
	 public Node deleteDuplicates(Node head) {
         
		 // i will return a new list , via this sentinel node....
         Node sentinel = new Node(0,null);
		 
         sentinel.next = head;
         Node current = head;
         Node previous = sentinel;
		 
         while(current.next!=null)
		 {
             boolean dup = false;
			 
             while(current.next!=null && (current.next.data == current.data))
			 {
                 current = current.next;
                 dup = true;
             }
			 
             // remove all duplicates
             if(dup)
			 {
                 previous.next = current.next;
             }
             // set the previous pointer
             else
			 {
                 previous = current;
             }
			 
         current = current.next;
         
		 }// ends while
		 
         return sentinel.next;
     }
	 
   
public static void main(String arg[])
{
LinkList1 list = new LinkList1();
LinkList1 list2 = new LinkList1();

int[] first = new int[] {2,5,9,10,33,20,55};

int[] second = new int[] {1,7,17,21,39,65,19};

for(int i : first)
{
	list.insert(i);
}

for(int i : second)
{
	list2.addLast(i);
}

System.out.print("Link List Traversal 1 : ");
list.print(list.head);
System.out.println();

System.out.print("Link List Traversal 2 : ");
list2.print(list2.head);

System.out.println();

System.out.println("First element : "+list2.getFirst());
System.out.println("Last element : "+list2.getLast());

list2.delete(21);
System.out.print("Link List Traversal 2 : ");
list2.print(list2.head);
System.out.println();

System.out.println("Last elements Link List Traversal 2 : ");

// print last n elements of the linked list
list2.displayLastNElements(list2.head, 3);
list2.print(list2.head);
System.out.println();


System.out.print("Link List reverse Traversal 2 : ");
list2.reverse(list2.head);

System.out.println();
list2.removeFirst();
list2.print(list2.head);
 
 
 
 
LinkList1 sort = new LinkList1();

int[] sorted = new int[] {1,3,5,11,15,19};

for(int i : sorted)
{
	sort.insert(i);
}
 
System.out.println();
System.out.println();

System.out.print("Link List Sorted Traversal : ");
sort.reverse(sort.head);
System.out.println();

  
 
 

System.out.print("Insert in  Sorted List : ");
 sort.insertInOrder(8,sort.head);
System.out.println(); 

System.out.print("Link List Sorted Traversal : ");
sort.reverse(sort.head);
System.out.println();

LinkList1 duplicate = new LinkList1();

int[] dup = new int[] {1,2,5,5,7,7,19};

for(int i : dup)
{
	duplicate.insert(i);
}

System.out.print(" Duplicate Link List Traversal : ");
duplicate.reverse(duplicate.head);
System.out.println();
 
duplicate.deleteDuplicates(duplicate.head);

System.out.print("After Removing Duplicate Link List  : ");
duplicate.reverse(duplicate.head);
System.out.println();
 
 
}


}

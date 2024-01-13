//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node insertionSort(Node head_ref)
    {
        //code here
        if (head_ref.next == null) return head_ref;
        Node headNew = head_ref, tempOuter = head_ref.next, lastInner = headNew, prevOuter = head_ref;
        while (tempOuter != null) {
            Node tempOuterCopy = tempOuter;
            tempOuter = tempOuter.next;
            if (lastInner.data > tempOuterCopy.data) {
                if (tempOuterCopy.data < headNew.data) {
                    if (headNew.next != null && headNew.next.equals(tempOuterCopy)) {
                        headNew.next = null;
                    }
                    tempOuterCopy.next = headNew;
                    headNew = tempOuterCopy;
                } else {
                    Node fromHead = headNew, prevInner = headNew;
                    while (fromHead != null) {
                        if (tempOuterCopy.data < fromHead.data) {
                            prevInner.next = tempOuterCopy;
                            tempOuterCopy.next = fromHead;
                            if (fromHead.next != null && fromHead.next.equals(tempOuterCopy)) fromHead.next = null;
                            break;
                        }
                        prevInner = fromHead;
                        fromHead = fromHead.next;
                    }
                }
            } else {
                tempOuterCopy.next = null;
                lastInner.next = tempOuterCopy;
                lastInner = lastInner.next;
            }
        }
        return headNew;
    }
}
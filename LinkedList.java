public class LinkedList{
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){ // O(1)
        //step1 =create new node
        Node newNode= new Node(data);
        size++;
        if (head==null){
            head=tail=newNode;
            return;
        }
        //step 2 - newNode next= head
        newNode.next=head; //link
        //step 3 head=newNode
        head = newNode;

    }

    public void addLast(int data){    //O(1)
       Node newNode= new Node(data);
       /*size++;
       if(head==null){
        head=tail=newNode;
        return;
       }
       tail.next=newNode;
       tail=newNode;*/
       size=0;
       if (head==null){
        head=newNode;
        size++;
        return;
       }
       Node temp=head;
       while(temp.next!=null){
        size++;
        temp=temp.next;
       }
       temp.next=newNode;
    }


    public void print(){   //printing a linkedlist
        Node temp=head;
        if(head==null){
            System.out.println("LL is empty");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data+" ->");
            temp=temp.next;
        } 
        System.out.println("null"); System.out.println(size);
        
    }
    
    public void add(int idx , int data){
        if(idx==0){
            addFirst(data);
            return;
        }
       Node newNode=new Node(data);
       size++;
       Node temp=head;
       int i=0;
       while(i<idx-1){
        temp=temp.next;
        i++;
       }
       //i=idx-1; temp->prev
       newNode.next=temp.next;
       temp.next=newNode;
    }

    public  int removeFirst(){
        if(size==0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
          System.out.println("ll is empty");
          return Integer.MIN_VALUE;
        }
        else if (size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        // prev =size-2;
        Node prev=head;
        for(int i=0;i<size-2;i++){
           prev =prev.next;
        }
        int val=prev.next.data; //tail data
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    public int itrSearch(int key){ //O(n)
        Node temp=head;
        int i=0;
        while (temp!=null){
            if(temp.data==key){
               return i;
            }
            temp=temp.next;
            i++;
        }
        //key not found
        return -1;
    }

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if(idx==-1){
            return -1;
        }
        return idx+1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }

    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev =curr;
            curr=next;
        }
        head =prev;
    }

    public void deleteNthFromEnd(int n){
        //calculate size
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next; //remove first
            return ;
        }
        //sz-n 
        int i=1;
        int iToFind=sz-n;
        Node prev =head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return ;
    } 
    // slow fast approach
   public static Node findMid(){
    Node slow=head;
    Node fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
   }

   public static boolean isPalindrome(){
    if(head==null||head.next==null){
        return true;
    }
    //find Mid
    Node midNode=findMid();
    //reverse half linkedlist
    Node prev=null;
    Node curr=midNode;
    Node next;
    while(curr!=null){
        next=curr.next;
        curr.next=prev;
        curr=next;
        next=prev;
    }
    Node right=prev;
    Node left=head;
    //check palindrome
    while(right!=null){
        if(right.data==left.data){
            return false;
        }
        right=right.next;left=left.next;
    }
    return true;

   }

    public static boolean isCycle(){ //floyds cycle finding algorithm
        Node slow =head;
        Node fast=head;
        while (fast!=null && fast.next!=null){
            slow =slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true; //cycle exist
            }
        }
        return false; //cycle doesnt exist
    } 

    public static void removeCycle(){
        //detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle==false){
            return;
        }
        //find meeting point
        slow=head;
        Node prev =null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        //remove cycle -> last.next=null
        prev.next=null;
    }

    //MERGE SORT ON LL
    private Node getMid(Node head){
        Node slow=head;
        Node fast =head.next;
        while(fast!=null&& fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
       if(head==null||head.next==null){
        return head;
       }
       //mid
       Node mid=getMid(head);
       //left and right head
       Node rightHead=mid.next;
       mid.next=null;
       Node newLeft=mergeSort(head);
       Node newRight=mergeSort(rightHead);
       //merge
       return merge(newLeft, newRight);
    }


    public void zigzag(){
        //get mid 
        Node slow=head;
        Node fast =head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid =slow;

        //reverse 2nd half
        Node curr=mid.next;
        mid.next=null;
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=next;
            curr=next;
        }
        Node left=head;
        Node right =prev;
        Node nextL,nextR;

        //alternate merge zigzag
        while(left!=null && right!=null){
           nextL=left.next;
           left.next=right;
           nextR=right.next;
           right.next=nextL;

           left=nextL;
           right=nextR;
        }
    }

    public static void main(String args[]){
       LinkedList ll=new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.print();
        ll.head=ll.mergeSort(ll.head);
        ll.print();
    }
}
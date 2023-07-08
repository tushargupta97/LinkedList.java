public class DoublyLL {
    public class Node{
        int data;
        Node prev;
        Node next;
        public Node (int data){
            this.data=data;
            this.next=next;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    public void InsertAtTail(int data){
        Node n=new Node(data);
        if(head==null){
            head=tail=n;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
        n.prev=temp;
        n.next=null;
    }

    public void InsertAtidx(int data,int idx){
        Node n=new Node(data);
        n.next=null;
        if(head==null){
            head=tail=n;
            return;
        }
        Node temp=head;
        for(int i=0;i<idx-2;i++){
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
        n.prev=temp;
    }
    //print
    public void print(){
      Node temp=head;
      while(temp!=null){
        System.out.print(temp.data+"<->");
        temp=temp.next;
      }
      System.out.println("null");
    }

    //removeFirst
    public int removeFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }

    public void deleteAtTail(){
        if(head==null){
            System.out.println("DLL is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
        }
        temp=temp.prev;
       
    }


    //reveerse the dll
    public void reverse(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public static void main(String args[]){
        DoublyLL dll= new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.InsertAtTail(4);
        //dll.InsertAtidx(5,2);
        dll.deleteAtTail();
        dll.print();
        //System.out.println(dll.size);
        //dll.removeFirst();
        //dll.reverse();
        //dll.print();
        //System.out.println(dll.size);
    }
}

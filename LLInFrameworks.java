import java.util.LinkedList;
public class LLInFrameworks {
    public static void main(String args[]){
        //create-objects int,float,boolean,char,etc->Integer,Float,Boolean,Character
        LinkedList<Integer>ll=new LinkedList<>();
        //ADD
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0); //0->1->2
        System.out.println(ll);
        //remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}

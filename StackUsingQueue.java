import java.util.*;
import java.util.Queue;
public class StackUsingQueue {
    static class Stack{
        static Queue<Integer> q1=new Queue<>();
        static Queue<Integer> q2 =new Queue<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()){
                q1.push(data);
            }
            else{
                q2.push(data);
            }
        }
        
        public static int pop(){
            if(q1.isEmpty()){
                return -1;
            }
            int top=-1;
            // case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top=q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }
            else{
                while(!q2.isEmpty()){
                    top=q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            int top=-1;
            // case 1
            if(!q.isEmpty()){
                while(!q1.isEmpty()){
                    top=q1.remove();
                    
                    q2.add(top);
                }
            }
            else{
                while(!q2.isEmpty()){
                    top=q2.remove();
                    
                    q1.add(top);
                }
            }
        }
    }

    public static void main(String args[]){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}

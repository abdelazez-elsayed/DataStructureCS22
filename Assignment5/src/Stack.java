import java.lang.IllegalArgumentException;
public class  Stack{
    public class Node{
        Object element;
        Node next;
        Node prev;
        Node() {
            element = null;
            next = null;
            prev = null;
        }
        Node(Object element,Node next,Node prev){
            this.element=element;
            this.next=next;
            this.prev=prev;
        }
    }
    Node top;
    int size;
    Stack(){
        size=0;
    }

   // @Override
    public void push(Object element) {
        Node node=new Node(element,null,null);
        if(size==0)top=node;
        else {
            top.next = node;
            node.prev=top;
            top = node;
        }
        size++;
    }

    //@Override
    public  Object peak() {
        if(size==0)throw new IllegalArgumentException();
        return top.element;
    }

   // @Override
    public Object pop() {
        if(size==0) throw new IllegalArgumentException();
        Object o=top.element;
        if(size==1){
            top=null;
            size--;
        }else {
        top=top.prev;
        top.next=null;
        size--;}
        return o;
    }

  //  @Override
    public boolean isEmpty() {
        return (size==0);
    }

   // @Override
    public int size() {
        return size;
    }

}

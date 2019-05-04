
package eg.edu.alexu.csd.datastructure.queue;
import java.util.*;

public class QueueL implements IQueue , ILinkedBased {
	class DNode {
        Object element;
        DNode Next;
        DNode Prev;

        DNode(Object Value, DNode next, DNode prev) {
            element = Value;
            Next = next;
            Prev = prev;
        }
    }
	DNode head;
    DNode tail;
    int size;

    QueueL() {
        head = null;
        tail = null;
        size = 0;
    }
    boolean isEmpty() {
    	return (size==0);
    }
    @Override
    public void enqueue(Object element){
    	DNode node= new DNode(element,null,null)
        head.Prev=node;
        node.Next=head;
        head=node;
        size++;
        if(tail==null)tail=node;
    }
    @Override
    public Object dequeue() {
    	Object e = new Object();
    	if(isEmpty()) {
    		throw new IllegalArgumentException("Queue is empty");
    	}
    	e=tail.element;
    	tail=tail.Prev;
    	tail.Next=null;
    	size--;
    	return e;
    	
    }
    @Override
    public int size() {
    	return size;
    }
    public Object front() {
    	if(isEmpty()) {
    		throw new IllegalArgumentException("Queue is Empty");
    		
    	}
    	return tail.element;
    }
	

}

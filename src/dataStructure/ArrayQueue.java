package dataStructure;


public class ArrayQueue {
	
	private static final int DEFAULT_SIZE = 10;
	private Object[] array;
	private int front;
	private int rear;
	private int count;
	
	public ArrayQueue(){
		array = new Object[DEFAULT_SIZE];
		front = rear = count = 0;
	}
	
	public void clear(){
		for (int i=0;i<array.length;i++)
			array[i] = null;
		front = rear = count = 0;
	}
	
	public void enqueue(Object val){
		if (count == array.length) expand();
		array[rear++] = val;
		if (rear == array.length) rear = 0;
		count++;
	}
	
	public Object dequeue(){
		if (count ==0)
			throw new IllegalStateException();
		Object val = array[front];
		array[front++] = null;
		if (front ==array.length) front =0;
		count--;
		return val;
		
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public int size(){return count;}
	
	public Object Peek(){
		if (count ==0){throw new IllegalStateException();}
		return array[front];
	}
	
	public String toString(){
		String buf = new String("[");
		for (int i=0;i<count;i++){
			if (i > 0) buf += ", ";
			buf += array[(front+i)%array.length].toString();
			
		}
		buf += " ]";
		return buf;
	}
	
	private void expand(){
		Object[] newarray = new Object[2*array.length];
		for (int i=0;i<array.length;i++)
			newarray[i] = array[(i+front)%array.length];
		front = 0;
		rear =array.length;
		array = newarray;
		
	}

}

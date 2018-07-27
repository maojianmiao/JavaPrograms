package dataStructure;

import java.nio.Buffer;

import javax.swing.tree.ExpandVetoException;

public class Stack {
	private static final int DSIZE = 10;
	private Object[] array;
	private int top;
	
	public Stack(){
		array = new Object[DSIZE];
		top = 0;
	}
	
	public void clear(){
		for (int i=0;i<top;i++)
			array[i] = null;
		top =0;
	}
	
	public void push(Object val){
		if (top == array.length)
			expand();
		array[top++] = val;
	}
	
	public Object pop(){
		if (top==0)
			throw new IllegalAccessError();
		Object val = array[--top];
		array[top] = null;
		return val;
	}
	
	public boolean isEmpty(){
		return top ==0;
	}
	
	public int size(){ return top;}
	
	public Object peek(){
		if (top == 0)
			throw new IllegalStateException();
		return array[top-1];
	}
	
	public String toString(){
		String buf = "[";
		for (int i=0;i<top;i++){
			if (i>0) buf +=", ";
		buf += array[i];
		}
		buf += "]";
		return buf;
	}
	
	
	public void expand(){
		Object[] newarrary = new Object[2*array.length];
		for (int i=0;i<array.length;i++)
			newarrary[i] = array[i];
		array=newarrary;
	}

}

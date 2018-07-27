package dataStructure;

public class SLLNode {
	
	Object data;
	SLLNode next;
	
	SLLNode() {
		// TODO Auto-generated constructor stub
	}
	SLLNode(Object obj) {data = obj;}
	SLLNode(Object obj,SLLNode link){
		data = obj;
		next = link;
	}
	
	void insert(Object val, SLLNode prior,SLLNode head){
		SLLNode ins = new SLLNode(val);
		if (prior == null){
			ins.next = head;
			 head = ins;
		}
		else{
			ins.next = prior.next;
			prior.next = ins;
		}
	}
	
	public String toString(){
		return data.toString();
	}
}

class DLLNode{
	Object data;
	DLLNode prenode;
	DLLNode nextnode;
	
	public DLLNode() {
		// TODO Auto-generated constructor stub
	}
	
	public DLLNode(Object obj){
		data = obj;
	}
	
	public DLLNode(DLLNode pre,Object obj,DLLNode next){
		prenode = pre;
		data = obj;
		nextnode = next;
	}
	
	public String toString(){
		return data.toString();
	}
}

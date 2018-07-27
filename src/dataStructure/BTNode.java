package dataStructure;

public class BTNode {
	Object data;
	BTNode left;
	BTNode right;
	
	public BTNode() {
		// TODO 自动生成的构造函数存根
	}
	
	public BTNode(Object obj){
		data = obj;
	}
	
	public BTNode(Object obj, BTNode leftChild,BTNode RightChild){
		data = obj;
		left = leftChild ;
		right = RightChild;
	}
	
	public String toString(){
		return data.toString();
	}

}
package dataStructure;

public class BTNode {
	Object data;
	BTNode left;
	BTNode right;
	
	public BTNode() {
		// TODO �Զ����ɵĹ��캯�����
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
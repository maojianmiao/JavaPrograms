package dataStructure;

///用二叉树实现的树
public class TreeNode {
	Object data;
	TreeNode leftChild;
	TreeNode rightSib;
	
	public TreeNode() {
		// TODO Auto-generated constructor stub
	}
	
	public TreeNode(Object obj){
		data = obj;
	}
	
	public TreeNode(Object obj, TreeNode left,TreeNode rights){
		data = obj;
		leftChild = left;
		rightSib = rights;
	}
	
	public String toString(){
		return data.toString();
	}
	
	static void insertFirst(TreeNode curr, Object val){
		curr.leftChild = new TreeNode(val, null, curr.leftChild);
	}
	
	static void insertNext(TreeNode curr,Object val){
		curr.rightSib = new TreeNode(val,null,curr.rightSib);
	}
	
	
	static Object removeFirst(TreeNode curr){
		if (curr.leftChild == null)
			return null;
		Object temp = curr.leftChild.data;
		curr.leftChild = curr.leftChild.rightSib;
		return temp;
	}
}

package dataStructure;

import javax.naming.directory.SearchControls;

public class BST{
	private static class BSTNode{
		Object data;
		BSTNode left;
		BSTNode right;
		
		BSTNode() {
			// TODO 自动生成的构造函数存根
		}
		
		BSTNode(Object val){
			data = val;
		}
		
		BSTNode(Object val,BSTNode leftv,BSTNode rightv){
			data = val;
			left = leftv;
			right = rightv;
		}
		
		public String toString(){
			return data.toString();
		}
	}
	
	private BSTNode root;
	private int count;
	
	public BST() {
		clear();
	}
	public final void clear(){
		root = null;
		count = 0;
	}
	
	public void insert(Object val){
		root = insert(root,val);
	}
	public void delete(Object val){
		root = delete(root,val);
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	public int size(){
		return count;
	}
	
	public boolean contains(Object val){
		return search(root,val) != null;
	}
	
	private BSTNode search(BSTNode ref,Object val){
		if (ref == null) return null;
		else {
			int comp = val.toString().compareTo(ref.data.toString());
			if (comp == 0) return ref;
			else if (comp < 0)
				return search(ref.left, val);
			else
				return search(ref.right, val);
		}
	}
	
	private BSTNode insert(BSTNode ref,Object val){
		if (ref == null){
			count ++;
			return new BSTNode(val);
		}
		else {
			int comp = val.toString().compareTo(ref.data.toString());
			if (comp <0)
				ref.left = insert(ref.left, val);
			else
				ref.right = insert(ref.right, val);
			return ref;
		}
	}
	
	private BSTNode delete(BSTNode ref,Object val){
		if (ref != null){
			int comp = val.toString().compareTo(ref.data.toString());
			if (comp == 0){
				count --;
				return deleteTopmost(ref);
			}
			else if (comp <0)
				ref.left = delete(ref.left, val);
			else
				ref.right = delete(ref.right, val);
		}
		return ref;
	}
	
	private BSTNode deleteTopmost(BSTNode ref){
		if (ref.left == null)
			return ref.right;
		else if (ref.right == null)
			return ref.right;
		else{
			ref.data  = getLeftmost(ref.right);
			ref.right = deleteLeftmost(ref.right);
			return ref;
		}
	}
	
	private Object getLeftmost(BSTNode ref){
		if (ref.left == null)
			return ref.data;
		else
			return getLeftmost(ref.left);
	}
	
	private BSTNode deleteLeftmost(BSTNode ref){
		if (ref.left == null)
			return ref.right;
		else{
			ref.left = deleteLeftmost(ref.left);
			return ref;
		}
	}
	
}
/**
 * 
 */
package dataStructures;

/**
 * @author djreinke
 *
 */
public class BinarySearchTree {
	
	private BinarySearchTreeNode root;
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public BinarySearchTree(BinarySearchTreeNode n){
		this.root = n;
	}

	public boolean isEmpty(){
		return this.root == null;
	}
	
	public void insert(BinarySearchTreeNode node){
		this.root = insert(this.root, node);
	}
	
	private BinarySearchTreeNode insert( BinarySearchTreeNode p, BinarySearchTreeNode current ){
		if (p.isEmpty())
			return new BinarySearchTreeNode(current.getData());
		if (current.getData() == p.getData())
			return p;
		if (current.getData() < p.getData())
			p.left = insert(p.getLeftNode(), current);
		else
			p.right = insert(p.getRightNode(), current);
		return p;
	}
	
	public void display(BinarySearchTreeNode root){
		if(root != null){
			display(root.getLeftNode());
			System.out.print(" " + root.getData());
			display(root.getRightNode());
		}
	}
	
	public static void main(String args[]){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(new BinarySearchTreeNode(10));
		bst.display(bst.root);
	}
}

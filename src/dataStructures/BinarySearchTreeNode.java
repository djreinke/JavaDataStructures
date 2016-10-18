/**
 * 
 */
package dataStructures;

/**
 * @author djreinke
 *
 */
public class BinarySearchTreeNode {
	
	BinarySearchTreeNode left, right;
	int nodeData;
	
	public BinarySearchTreeNode(){
		this.left = null;
		this.right = null;
		this.nodeData = -1;
	}
	
	public BinarySearchTreeNode(int nodeData){
		this.left = null; 
		this.right = null;
		this.nodeData = nodeData;
	}
	
	public void SetLeftNode(BinarySearchTreeNode n){
		this.left = n;
	}
	
	public void SetRightNode(BinarySearchTreeNode n){
		this.right = n;
	}
	
	public BinarySearchTreeNode getLeftNode(){
		return this.left;
	}
	
	public BinarySearchTreeNode getRightNode(){
		return this.right;
	}
	
	public void setData(int nodeData){
		this.nodeData = nodeData;
	}
	
	public int getData(){
		return this.nodeData;
	}
	
	public boolean isEmpty(){
		return this.nodeData == -1;
	}
}


public class TreeNode<T> {
	TreeNode<T> left;
	TreeNode<T> right; 
	T data;
	
	public TreeNode(T data) {
		this.data = data;
	}
	
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}
	
}

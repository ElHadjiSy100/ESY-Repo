import java.util.ArrayList;

/**
 * Class for Morse code tree (generic binary tree)
 * @author El Hadji Sy
 * 
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root; 
	private String[] morseArray = {".","-", "..",".-","-.","--","...","..-",".-.",".--","-..","-.-","--.","---","....","...-","..-.",".-..",".--.",".---","-...","-..-","-.-.","-.--","--..","--.-"};
	private String[] charArray = {"e","t","i","a","n","m","s","u","r","w","d","k","g","o","h","v","f","l","p","j","b","x","c","y","z","q"};
	
	/**
	 * Builds the Morse code tree for the entire alphabet.
	 */
	public MorseCodeTree() {
		buildTree();
	}

	/**
	 * 
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	
	/**
	 * Sets the root of the tree
	 */
	@Override
	public void setRoot(TreeNode<String> root) {
		this.root = root; 
	}
	
	/**
	 * 
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		TreeNode<String> newNode = new TreeNode<String>(letter);
		if(code.length() == 1) {
			if(code.charAt(0) == '.') {
				root.left = newNode;
			} else {
				root.right = newNode; 
			}
			return; 
		} else {
			TreeNode<String> curr = root; 
			if(code.charAt(0) == '.') {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
			if(code.length() != 1) {
				addNode(curr, code.substring(1), letter);
			}
			
			if(code.length() == 1) {
				if(curr.data == ".") {
					curr.left = newNode;
				} else {
					curr.right = newNode;
				}
				return;
			}
		}
	}
	
	/**
	 * 
	 */
	@Override
	public void insert(String code, String result) {
		addNode(root,code,result);
	}
	
	/**
	 * 
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root,code);
	}
	
	/**
	 * 
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if(root == null && code.length() > 4) {
			return null;
		}
		TreeNode<String> curr = root;
		for(int i = 0; i < code.length(); i++) {
			if(code.charAt(i) == '.') {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		return curr.data;
	}

	/**
	 * 
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This operation is not supported.");
	}
	
	/**
	 * 
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("This operation is not supported.");
	}
	
	/**
	 * 
	 */
	@Override
	public void buildTree() {
		setRoot(new TreeNode<String>(""));
		for(int i = 0; i < 26; i++) {
			addNode(root,morseArray[i],charArray[i]);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(root, list);
		return list;
	}
	
	/**
	 * 
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null) {
			if(root.left != null) {
				LNRoutputTraversal(root.left, list);
			}
			list.add(root.data);
			if(root.right != null) {
				LNRoutputTraversal(root.right,list);
			}
		}
		
	}
}

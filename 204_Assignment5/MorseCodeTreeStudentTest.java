import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class MorseCodeTreeStudentTest {
	
	private MorseCodeTree tree = new MorseCodeTree();
	
	@Test
	void testBuildTree() {
		assertEquals("e",tree.getRoot().left.data);
	}
	
	@Test
	void testGetRoot() {
		assertEquals("",tree.getRoot().data);
	}
	
	@Test
	void testSetRoot() {
		TreeNode<String> root = new TreeNode<String>("a");
		tree.setRoot(root);
		assertEquals("a",root.data);
	}
	
	@Test
	void testFetchNode() {
		String p = "p";
		assertEquals(p, tree.fetch(".--."));
	}
}

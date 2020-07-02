// Name: Keith Radford
// Student number: V00918086

public class WordFrequencyBST {
	private TreeNode root;
	private int numElements;
	
	public WordFrequencyBST() {
		root = null;
		numElements = 0;
	}
	
	/*
	 * Purpose: Update the BST by handling input word 
	 * Parameters: String word - The new word to handle
	 * Returns: Nothing
	 * Explanation: If there is no entry in the tree 
	 *   representing the word, then the a new entry 
	 *   should be created and placed into the correct 
	 *   location of the BST. Otherwise, the existing
	 *   entry for the word should have its frequency
	 *   value incremented. 
	 */	
	public void handleWord(String word) {
		// Check if in tree
		if(this.numElements > 0){
			TreeNode curr = this.root;
			while(curr != null){
				TreeNode left = curr.left;
				TreeNode right = curr.right;
				if(curr.compareTo(word) == 0){
					curr.addToFrequency();
					return;
				}
				else if(curr.compareTo(word) > 0){
					curr = left;
				}
				else if(curr.compareTo(word) < 0){
					curr = right;
				}
			}
		}
		// Else insert
		Entry entry = new Entry(word);
		if(this.numElements == 0){
			this.root = new TreeNode(entry);
		}
		else {
			insert(this.root, entry);
		}
		this.numElements++;
	}

	/*
	 * Purpose: Recursively insert a new entry to the BST. 
	 * Parameters: TreeNode root - the root node of the BST,
	 * Entry entry - the new entry to insert
	 */	
	public TreeNode insert(TreeNode root, Entry entry){
		if(root == null) 
			return new TreeNode(entry);
		else if(root.compareTo(entry.getWord()) > 0)
			root.left = insert(root.left, entry);
		else
			root.right = insert(root.right, entry);

		return root;
	}
	
	/*
	 * Purpose: Get the frequency value of the given word
	 * Parameters: String word - the word to find
	 * Returns: int - the word's associated frequency
	 */	
	public int getFrequency(String word) {
		TreeNode to_find = search(this.root, word);
		if(to_find != null){
			return to_find.getData().getFrequency();
		}

		return 0;
	}

	/*
	 * Purpose: Recursively search the BST for an Entry with the given word. 
	 * Parameters: TreeNode root - the root node of the BST,
	 * String word - the word to find
	 */	
	public TreeNode search(TreeNode root, String word){
		if(root == null || root.compareTo(word) == 0)
			return root;
		else if(root.compareTo(word) > 0)
			return search(root.left, word);
		
		return search(root.right, word);
	}

	/****************************************************
	* Helper functions for Insertion and Search testing *
	****************************************************/
	
	public String inOrder() {
		if (root == null) {
			return "empty";
		}
		return "{" + inOrderRecursive(root) + "}";
	}
	
	public String inOrderRecursive(TreeNode cur) {
		String result = "";
		if (cur.left != null) {
			result = inOrderRecursive(cur.left) + ",";
		} 
		result += cur.getData().getWord();
		if (cur.right != null) {
			result += "," + inOrderRecursive(cur.right);
		}
		return result;
	}
	
	public String preOrder() {
		if (root == null) {
			return "empty";
		}
		return "{" + preOrderRecursive(root) + "}";
	}
	
	public String preOrderRecursive(TreeNode cur) {
		String result = cur.getData().getWord();
		if (cur.left != null) {
			result += "," + preOrderRecursive(cur.left);
		} 
		if (cur.right != null) {
			result += "," + preOrderRecursive(cur.right);
		}
		return result;
	}
	
	/****************************************************
	* Helper functions to populate a Heap from this BST *
	****************************************************/
	
	public MaxFrequencyHeap createHeapFromTree() {
		MaxFrequencyHeap maxHeap = new MaxFrequencyHeap(numElements+1);
		addToHeap(maxHeap, root);
		return maxHeap;
	}
	
	public void addToHeap(MaxFrequencyHeap h, TreeNode n) {
		if (n != null) {
			addToHeap(h, n.left);
			h.insert(n.getData());
			addToHeap(h, n.right);
		}
	}		
}
/*
 * A Huffman Tree.
 * Huffman Trees are built with Huffman Nodes (HNodes)
 */
public class HuffmanTree {
	HNode root;
	
	public HuffmanTree(HNode root) {
		this.root = root;
	}
	
	/*
	 * Purpose: Decode the sequence of bits and return the associated string
	 * Parameters: BitQueue input - the input sequence of bits
	 * Returns: String - the decoded text
	 * Example:
	 *   For decoding an input, every time a 0-bit is read, 
	 *   the associated letter is found in the left subtree.
	 *   Every time a 1-bit is read, the associated letter
	 *   is found in the right subtree.
	 *
	 *   When a leaf node is detected, a letter can be added
	 *   to the output String. To decode the next sequence of 
	 *   bits, start traversing the tree from the root.
	 *
	 *   See the lecture exercise for more details.
	 */
	public String decode(BitQueue input) {
		try {
			return decodeRecursive(root, input);
		} catch (DecodeException e) {
			System.out.println(e);
		}
		return "Invalid coding";
	}
	
	public String decodeRecursive(HNode cur, BitQueue input) throws DecodeException {
		//If leaf node
		if(cur.left == null && cur.right == null){
			//If more to decode
			if(!input.isEmpty())
				return cur.letter + decodeRecursive(this.root, input);
			return cur.letter;
		}

		//Else if need to continue traversing to leaf node
		String next_bit = input.dequeue();
		if(next_bit.equals("0")){
			return decodeRecursive(cur.left, input);
		}
		else if(next_bit.equals("1")){
			return decodeRecursive(cur.right, input);
		}

		return "unknown"; //so it compiles
	}
}
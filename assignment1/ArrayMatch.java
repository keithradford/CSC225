/* 
 * CSC 225 - Assignment 3
 * Name: Keith Radford
 * Student number: V00918086
 */
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Arrays;

public class ArrayMatch {

	/*
	 * match
	 * Purpose: Determine if the two given arrays 'match'
	 * Parameters: int[] a, int[] b - the two arrays
	 * Returns: boolean - true if arrays 'match', false otherwise
	 * Preconditions: a and b have the same number of elements
	 */
	public static boolean match(int[] a, int[] b) {
		int len = a.length;
		Boolean equal = Arrays.equals(a, b);

		if ((a[0] != b[0]) && len == 1) return false;
		if(len % 2 != 0) return equal;
		if(equal) return equal;

		int[] a1 = new int[len/2];
		int[] a2 = new int[len/2];
		int[] b1 = new int[len/2];
		int[] b2 = new int[len/2];
		int k = 0;
		for (int i = 0; i < len; i++) {
			if(i < (int) len / 2) {
				a1[i] = a[i];
				b1[i] = b[i];
			}
			else{
				a2[k] = a[i];
				b2[k] = b[i];
				k++;
			}
		}

		Boolean condition_a = match(a1, b1) && match(a2, b2);
		Boolean condition_b = match(a1, b1) && match(a1, b2);
		Boolean condition_c = match(a2, b1) && match(a2, b2);

		return condition_a || condition_b || condition_c;
	}

	/*
	 * fillArray
	 * Purpose: Fills arrays with contents read from Scanner
	 * Parameters: int[] x, Scanner fileReader
	 * Returns: nothing
	 */
	public static void fillArray(int[] x, Scanner fileReader) throws NoSuchElementException {
		Scanner f = new Scanner(fileReader.nextLine());
		for (int i = 0; i < x.length; i++) {
			x[i] = f.nextInt();
		}
	}
		
	/*
	 * a3Setup
	 * Purpose: Initializes the input arrays for Assignment 3 match detection
	 *          by reading data from the text file named fname
	 * Parameters: String fname - name of the file containig input data
	 * Returns: nothing
	 */
	public static void a3Setup(String fname) {
		Scanner fileReader = null;
		int[] A = null;
		int[] B = null;
		
		try {
			fileReader = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			System.out.println("Error finding input file");
			e.printStackTrace();
			return;
		}
		
		try {
			int size = Integer.parseInt(fileReader.nextLine());
			A = new int[size];
			B = new int[size];
			fillArray(A, fileReader);
			fillArray(B, fileReader);
		} catch (NoSuchElementException e) {
			System.out.println("Error reading input file data");
			e.printStackTrace();
		}
		
		if (match(A,B)) {
			System.out.println("match found");
		} else {
			System.out.println("no matches");
		}
	}
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Incorrect usage, should be:");
			System.out.println("java MysteryArray filename.txt");
			return;
		}
		a3Setup(args[0]);
	}
}
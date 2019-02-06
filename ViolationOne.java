
public class ViolationOne {

	public static void main(String[] args) {
		/* Violation of Rule 02: EXP02-J  */
		// https://wiki.sei.cmu.edu/confluence/display/java/EXP02-J.+Do+not+use+the+Object.equals%28%29+method+to+compare+two+arrays
		int[] arr1 = new int[20];
		int[] arr2 = new int[20];
		
		int[] arr3 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] arr4 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		System.out.println(Arrays.equals(arr1, arr2));
		
		System.out.println(Arrays.equals(arr3, arr4));
	}
}

import java.math.BigInteger;

public class ViolationTwo {

	public static void main(String[] args) {
		/* Violation of Rule 04: STR03-J  */
		// https://wiki.sei.cmu.edu/confluence/display/java/STR03-J.+Do+not+encode+noncharacter+data+as+a+string
		BigInteger x = new BigInteger("530500452766");
		String s = x.toString();
		byte[] byteArray = s.getBytes();
		String ns = new String(byteArray);
		x = new BigInteger(ns);
		
		System.out.println("Original: " + x);
		System.out.println("Modified: " + y);
		System.out.println("Error of: " + x.subtract(y));
	}
}

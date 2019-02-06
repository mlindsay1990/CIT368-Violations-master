
public class ViolationThree {

	public static void main(String[] args) {
		MaliciousClass mc1 = new MaliciousClass("sensitiveFile.txt");
		MaliciousClass mc2 = mc1.clone(); // Attempting a clone that should not be permitted
		
		String s = mc1.get();
		System.out.println(s);
		
		mc2.replace();
		
		mc1.printFilename();
		mc2.printFilename();
	}
}

/* Violation of Rule 05: OBJ07-J */
//https://wiki.sei.cmu.edu/confluence/display/java/OBJ07-J.+Sensitive+classes+must+not+let+themselves+be+copied

// SensitiveClass contains sensitive data that should not allow it to be copied, but it can be with a Malicious class as shown.
final class SensitiveClass {
	// Sensitive data members
	private char[] filename;
	private Boolean shared = false;
	
	SensitiveClass(String filename){
		this.filename = filename.toCharArray();
	}
	
	// Replaces filename char array with all 'x'
	final void replace() {
		if(!shared) {
			for(int i = 0; i < filename.length; i++) {
				filename[i] = 'x';
			}
		}
	}
	
	final String get() {
		if(!shared) {
			shared = true;
			return String.valueOf(filename);
		} else {
			throw new IllegalStateException("Failed to get instance");
		}
	}
	
	final void printFilename() {
		System.out.println(String.valueOf(filename));
	}
}

// MaliciousClass that shows the Violation in action.
class MaliciousClass extends SensitiveClass implements Cloneable {
	protected MaliciousClass(String filename) {
		super(filename);
	}
	
	@Override public MaliciousClass clone() {
		MaliciousClass mal = null;
		try {
			mal = (MaliciousClass)super.clone();
		} catch(Exception e) {
			System.out.println("Not Cloneable");
		}
		return mal;
	}
}

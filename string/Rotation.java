package string;
//A Program to check if strings are rotations of each other or not
public class Rotation {

	public static void main(String[] args) {
		String s1="ASCFF";
		String s2="SCFFA";
		System.out.println(isRotation(s1,s2));
	}

	static boolean isRotation(String a,String b) {
		return (a.length() == b.length())&& ((a+a).indexOf(b) !=-1);
	}
}

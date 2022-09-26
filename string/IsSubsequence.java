package string;

public class IsSubsequence {

	public static void main(String[] args) {
		String s = "b";
		String t = "abc";
		System.out.println(isSubsequence(s,t));
	}
//Method 1
	 public static boolean isSubsequence(String s, String t) {
	        int i=0;
	        int j=0;
	        while(i<t.length() && j<s.length() ){
	            if(t.charAt(i)==s.charAt(j)){
	                j++;
	            }
	            i++;
	        }
	        if(j==s.length()){
	            return true;
	        }
	        return false;
	        
	    }
  //Method 2
  public boolean isSubsequence(String s, String t) {
        
           int index=0;
		
		for(int i=0; i<s.length(); i++){
			index = t.indexOf(s.charAt(i));
			if(index == -1) return false;
			t = t.substring(index+1);
		}
		return true;
    }
	
}

//https://leetcode.com/problems/reverse-string/
class Solution {
    public void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }
    
    public void helper( char[] s,int start,int end){
        if(start<end){
            char temp = s[start];
            s[start]=s[end];
            s[end]=temp;
            helper(s,++start,--end);
        }
    }
}

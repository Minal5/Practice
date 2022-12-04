package binaryTree;
import java.util.*;
import binaryTree.BinaryTreeYT.Node;


public class CountOfNodes {

	public static void main(String[] args) {
		
	}
	
	public static int getSizeRecursion(Node root)
	{
	    if(root == null){
	        return 0;
	    }
	    int left = getSizeRecursion(root.left);
	    int right = getSizeRecursion(root.right);
	    
	    return left+right+1;
        
    }
	
	public static int getSizeQueue(Node root)
	{
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       q.add(null);
       int count=0;
       while(!q.isEmpty()){
           Node curr = q.peek();
           q.poll();
           if(curr!=null){
               count++;
               if(curr.left!=null){
                   q.add(curr.left);
               }
               if(curr.right!=null){
                   q.add(curr.right);
               }
               if(curr==null && !q.isEmpty()){
                   q.add(null);
               }
           }
       }
       return count;
    }
	
	public static int getSizeStack(Node root){
      Stack<Node> st = new Stack<>();
      st.push(root);
      st.push(null);
      int count=0;
      while(!st.isEmpty()){
          Node curr = st.peek();
          st.pop();
          if(curr!=null){
              count++;
              if(curr.left!=null)
                 st.push(curr.left);
                 if(curr.right!=null)
                 st.push(curr.right);
                 
                 if(curr==null && !st.isEmpty())
                 st.push(null);
          }
      }
      return count;
    }

}

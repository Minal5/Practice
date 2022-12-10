package binaryTree;

import java.util.*;

public class ZigzagTraversal {

	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        queue.add(root);
        boolean flag=false;
        while(queue.size()>0)
        {
            int size = queue.size();
            LinkedList<Integer> subList = new LinkedList<>();
            for(int i =0; i<size;i++)
            {
                TreeNode node = queue.poll();
                if(node.left !=null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(flag) 
                {
                    subList.addFirst(node.val);//addFirst method adds the elements at the beginning of the list
                }
                else {
                    subList.addLast(node.val);//the addLast method adds the elements at the end
                }
                
            }  
            flag=!flag;
          ans.add(subList);
            
        }
        return ans;
    }

}

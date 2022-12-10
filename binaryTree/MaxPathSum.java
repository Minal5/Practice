package binaryTree;

public class MaxPathSum {

	public static void main(String[] args) {
		
	}
	//LeetCode
	//124. Binary Tree Maximum Path Sum
	public int maxPathSum(TreeNode root) {
		int[] maxval = new int[1];
		maxval[0] = Integer.MIN_VALUE;
		maxPathDown(root,maxval);
		return maxval[0];
	}
	
	private int maxPathDown(TreeNode node,int maxval[]) {
		if(node == null) return 0;
		int left = Math.max(0, maxPathDown(node.left,maxval));
		int right = Math.max(0, maxPathDown(node.right,maxval));
		maxval[0] = Math.max(maxval[0],left + right+node.val);
		return Math.max(left, right)+node.val;
	}
	
	//GFG
	//Maximum Path Sum between 2 Leaf Nodes
	int maxPathSum(Node root)
    { 
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        int res = helper(root,max);
        if(root.left == null || root.right==null) return Math.max(max[0],res);
        return max[0];
    } 
    public int helper(Node root,int[] max){
        if(root == null) return 0;
        if(root.left==null&&root.right==null){
            return root.data;
        }
         int l = Math.max(Integer.MIN_VALUE,helper(root.left,max));
       int r = Math.max(Integer.MIN_VALUE,helper(root.right,max));
       if(root.left == null){     
           return root.data + r;
       }
       if(root.right == null){   
           return root.data + l;
       }
        max[0] = Math.max(max[0] ,l+r+root.data);
        return Math.max(l,r)+root.data;
    }

}

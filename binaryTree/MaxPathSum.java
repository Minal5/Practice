package binaryTree;

public class MaxPathSum {

	public static void main(String[] args) {
		
	}
	
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

}

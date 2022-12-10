class MaxProdSplittedBT {
    long total = 0,max=0;
    public int maxProduct(TreeNode root) {
        total = sum(root);
        subtreesum(root);
        return (int)(max%((int)Math.pow(10,9)+7));
    }
    public long subtreesum(TreeNode root){
        if(root == null) return 0;
        long l =subtreesum(root.left);
        long r = subtreesum(root.right);
        long stsum = l+r+root.val;
        max = Math.max(max,(stsum)*(total -stsum));
        return stsum;
    }

    public long sum(TreeNode root){
        if(root == null) {
			return 0;
		}
		long leftSum = sum(root.left);
		long rightSum = sum(root.right);
		
		return leftSum + rightSum + root.val;
    }
}

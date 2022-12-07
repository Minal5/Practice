class LevelOrder{
  public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> a = new ArrayList<>();
        while(!q.isEmpty()){
            
            TreeNode cur = q.remove();
            if(cur==null){
                if(q.isEmpty() || q.peek()==null){
                    if(!a.isEmpty()) ans.add(a);
                    return ans;
                }
                q.add(null);
                ans.add(a);
                a=new ArrayList<>();
                continue;
            }
                a.add(cur.val);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
        }
        
        return ans;
    } 
  
}

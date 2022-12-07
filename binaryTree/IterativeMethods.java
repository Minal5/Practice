package binaryTree;

import java.util.*;

public class IterativeMethods {

	static class BinaryTree{
		static int idx = -1;
		public static TreeNode buildTree(int nodes[]) {
			idx++;
			if(nodes[idx] == -1) {
				return null;
			}
			
			TreeNode newNode = new TreeNode(nodes[idx]);
			newNode.left = buildTree(nodes);
			newNode.right = buildTree(nodes);
			
			return newNode;
		}
	}
	
	public static ArrayList<Integer> preorder(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null) return ans;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode cur = st.pop();
			ans.add(cur.val);
			if(cur.right != null) st.push(cur.right);
			if(cur.left != null) st.push(cur.left);
			
		}
		return ans;
	}
	
	public static ArrayList<Integer> inorder(TreeNode root){
		Stack<TreeNode> st = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode node = root;
		while(true) {
			if(node != null) {
				st.push(node);
				node = node.left;
			}else {
				if(st.isEmpty())
					break;
				node = st.pop();
				ans.add(node.val);
				node = node.right;
			}
		}
		return ans;
	}
	
	public static ArrayList<Integer> postorderUsing2Stack (TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();
		st1.push(root);
		while(!st1.isEmpty()) {
			TreeNode cur = st1.pop();
			st2.add(cur);
			if(cur.left != null) st1.push(cur.left);
			if(cur.right != null) st1.push(cur.right);
		}
		while(!st1.isEmpty()) {
			ans.add(st2.pop().val);
		}
		return ans;
	}
	
	public static ArrayList<Integer> postorderUsingSingleStack(TreeNode root){
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		TreeNode cur = root;
		while(cur != null || !st.isEmpty()) {
			if(cur != null) {
				st.push(cur);
				cur = cur.left;
			}else {
				TreeNode temp = st.peek().right;
				if(temp == null) {
					temp = st.pop();
					ans.add(temp.val);
					while(!st.isEmpty() && temp == st.peek().right) {
						temp = st.pop();
						ans.add(temp.val);
					}
				}
				else
					cur = temp;
			}
		}
		
		return ans;
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return ans;
		
		stack.push(root);
		while (!stack.isEmpty()){
			TreeNode cur = stack.pop();
			ans.addFirst(cur.val);
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			} 
		}
		return ans;
    }	
	
	public static void main(String[] args) {
		int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		BinaryTree tree = new BinaryTree();
		TreeNode root = tree.buildTree(nodes);
		ArrayList<Integer> ans = inorder(root);
		System.out.println(ans.toString());
		ArrayList<Integer> postorder = postorderUsingSingleStack(root);
		System.out.println(postorder.toString());
		
	}

}

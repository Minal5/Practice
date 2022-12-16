package binaryTree;

import java.util.*;

import binaryTree.BinaryTreeYT.Node;

public class BoundaryTraversal {

	public static void main(String[] args) {
		
	}

	private static boolean isLeaf(Node node)
    {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
	
	void addLeftBoundary(Node root,ArrayList<Integer> res) {
		Node cur = root.left;
		while(cur != null) {
			if(isLeaf(cur) == false)res.add(cur.data);
			if(cur.left != null) cur = cur.left;
			else cur = cur.right;
		}
	}
	
	void addRightBoundary(Node root, ArrayList<Integer> res) {
		Node cur = root.right;
		ArrayList<Integer> tmp = new ArrayList<>();
		while(cur != null) {
			if(isLeaf(cur) == false)tmp.add(cur.data);
			if(cur.right != null) cur = cur.right;
			else cur = cur.left;
		}
		for(int i = tmp.size()-1; i>=0; --i){
			res.add(tmp.get(i));
		}
				
	}
	
	private static void addLeaves(Node root, List<Integer> ans) {
        if (root.left != null)
            addLeaves(root.left, ans);         //LEFT
        if (isLeaf(root)) {
            ans.add(root.data);                    //ROOT
            return;
        }
        else if (root.right != null)
            addLeaves(root.right, ans);   //RIGHT
    }
	
	ArrayList <Integer> boundary(Node node)
	{
		ArrayList <Integer> ans = new ArrayList <Integer>();
		if(!isLeaf(node))ans.add(node.data);
		addLeftBoundary(node,ans);
		addLeaves(node,ans);
		addRightBoundary(node,ans);
		return ans;
	}
	
}

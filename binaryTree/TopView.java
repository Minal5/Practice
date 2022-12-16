package binaryTree;

import java.util.*;

import binaryTree.BinaryTreeYT.Node;

class Pair1{
	int hd;
	Node node;
	public Pair1(Node node,int hd) {
		this.node = node;
		this.hd = hd;
	}
}

public class TopView {

	public static void main(String[] args) {
		
	}
	
	static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair1> q=new LinkedList<Pair1>();
        q.add(new Pair1(root,0));
        while(!q.isEmpty()) {
        	Pair1 it = q.remove();
        	int hd = it.hd;
        	Node temp = it.node;
        	if(map.get(hd) ==null) map.put(hd, temp.data);
        	if(temp.left != null) q.add(new Pair1(temp.left,hd-1));
        	if(temp.right != null) q.add(new Pair1(temp.right,hd+1));
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	ans.add(entry.getValue());
        }
        return ans;
        
    }

}

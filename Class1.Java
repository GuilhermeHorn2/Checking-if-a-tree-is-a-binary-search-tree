package misc;

import java.util.ArrayList;

import misc.Graph_1.Node;

public class Binary_tree {

	   public static class Node{
	    	public int _id;
	    	public ArrayList<Node> adj;
	    	public int marked = 0;
	    	public int value;
	    	
	    	public Node(int id,int val) {
	    		_id = id;
	    		value = val;
	    		adj = new ArrayList<>();
	    		adj.add(null);
	    		adj.add(null);
	    	
	    	}
	    	
	    	public String toString() {
	    		String s = "";
	    		s += _id;
	    		return s;
	    	}
	    	
	    	public void set_value(int v) {
	    		value = v;
	    	}
	    	
		    public Node left() {
		    	if(this.adj.get(0) != null) {
		    		return this.adj.get(0);
		    	}
		    	return null;
		    }
		    public Node right() {
		    	if(this.adj.get(1) != null) {
		    		return this.adj.get(1);
		    	}
		    	return null;
		    }
		    
	    	
	    }
	    
	    public ArrayList<Node> nodes;
	    
	    public Binary_tree() {
	    	nodes = new ArrayList<>();
	    }
	    
	    public void add(int i,int val) {
	    	Node novo = new Node(i,val);
	    	nodes.add(novo);
	    }
	    
	    public void link_left(int id1,int id2){
	    	Node n = nodes.get(id1);
	    	n.adj.add(0, nodes.get(id2));
	    }
	    
	    public void link_right(int id1,int id2) {
	    	Node n = nodes.get(id1);
	    	n.adj.add(1,nodes.get(id2));
	    }
	    
	    /*public Node left(Node n) {
	    	if(n.adj.get(0) != null) {
	    		return n.adj.get(0);
	    	}
	    	return null;
	    }
	    public Node right(Node n) {
	    	if(n.adj.get(1) != null) {
	    		return n.adj.get(1);
	    	}
	    	return null;
	    }*/
	    
	    public Node get_node(int i) {
	    	return nodes.get(i);
	    }
	    
	    //Check if is a binary search tree
	    
	    /*
	     * To check if a tree is a binary search tree i just have to check for each node n if B:biggest from its left
	     * and S:smallest from its right always obeys: B <= n < S,n e [B,S[.
	     */
	    
	    public int biggest(Node n) {
	    	//given a node,find the biggest value on its subtree
	    	
	    	if(n.left() == null && n.right() == null) {
	    		return n.value;
	    	}
	    	
	    	int big = n.value;
	    	
	    	for(int i = 0;i < 2;i++){
	    		Node r = n.adj.get(i);
	    		if(r != null){ 
	    			int x = biggest(r);
	    			if(x > big) {
	    				big = x;
	    			}
	    		}
	    	}
	    	return big;		
	    }
	    
	    public int smallest(Node n) {
	    	//given a node,find the biggest value on its subtree
	    	
	    	if(n.left() == null && n.right() == null) {
	    		return n.value;
	    	}
	    	
	    	int sml = n.value;
	    	
	    	for(int i = 0;i < 2;i++){
	    		Node r = n.adj.get(i);
	    		if(r != null){
	    			int x = smallest(r);
	    			if(x <= sml) {
	    				sml = x;
	    			}
	    		}
	    	}
	    	return sml;		
	    }
	    
	    public boolean is_bsearch_tree(){
	    	
	    	for(int i = 0;i < nodes.size();i++){
	    		Node n = nodes.get(i);
	    		if(n.left() == null && n.right() == null){
	    			continue;
	    		}
	    	    if(n.left() == null) {
	    	    	//I only have to compare the right node
	    	    	int S = smallest(n.right());
	    	    	if(S <= n.value){
	    	    		//There is a value on the right that is equal or smaller than n
	    	    		return false;
	    	    	}
	    	    }    		
	    	    if(n.right() == null){
	    	    	//I only have to compare the left node
	    	    	int B = biggest(n.left());
	    	    	if(B > n.value){
	    	    		//There is a value that is bigger than n
	    	    		return false;
	    	    	}
	    	    }
	    	    else if(n.right() != null && n.left() != null){
	    	    	int B = biggest(n.left());
	    	    	int S = smallest(n.right());
	    	    	
	    	    	if(B > n.value || S <= n.value){
	    	    		return false;
	    	    	}
	    	    }
	    	}
	    	return true;
	    	
	    }
	
}

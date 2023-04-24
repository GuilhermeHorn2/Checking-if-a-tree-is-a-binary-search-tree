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
	    
	    
	    public Node get_node(int i) {
	    	return nodes.get(i);
	    }
	    
	    //Check if is a binary search tree
	    
	   /*
	    * Think about the checkBST function as a recursive function that ensures each node is
          within an allowable (min, max) range. At first, this range is infinite. When we traverse
          to the left, the min is negative infinity and the max is root. value. Can you implement
          this recursive function and properly adjust these ranges as you traverse the tree? 
	    */
	    
	    public boolean check_bst(Node n,int[] range){
	    		
	    	if(n.left() == null & n.right() == null){
		    	if((n.value > range[0] && n.value <= range[1])) {
		    		return true;
		    	}
		    	else if(n.value <= range[0] || n.value > range[1]) {
		    		return false;
		    	}
	    	  }
	    	if(n.value <= range[0] || n.value > range[1]) {
	    		return false;
	    	}
	    	
	    	    	
	    	for(int i = 0;i < 2;i++){
	    		if(n.left() == null && n.right() == null) {
	    			continue;
	    		}
	    		if(n.left() == null){
	    			//check on the right
	    			int [] v = new int[2];
	    			v[0] = n.value; 
	    			v[1] = range[1];
	    			if(check_bst(n.right(),v) == false) {
	    				return false;
	    			}
	    			
	    		}
	    		if(n.right() == null) {
	    			//check on the left
	    			int [] v = new int[2];
	    			v[0] = range[0];
	    			v[1] = n.value;
	    			if(check_bst(n.left(),v) == false) {
	    				return false;
	    			}
	    		}
	    		if(n.left() != null && n.left() != null) {
	    			//check both
	    			boolean cond1 = false;
	    			boolean cond2 = false;
	    			//right:
	    			int[] v = new int[2];
	    			v[0] = n.value;
	    			v[1] = range[1];
	    			if(check_bst(n.right(),v) == false) {
	    				return false;
	    			}
	    			//left:
	    			int[] w = new int[2];
	    			w[0] = range[0];
	    			w[1] = n.value;
	    			if(check_bst(n.left(),w) == false) {
	    				return false;
	    			}
	    		}
	    	}
	    	
	    	return true;
	    }
	
}

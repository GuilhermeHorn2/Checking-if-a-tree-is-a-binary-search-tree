package misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Date;

public class main_misc {
    
	
	public static void main(String[] args) {
	  
	
		
      Binary_tree b = new Binary_tree();
      b.add(0, 8);
      b.add(1, 4);
      b.add(2, 2);
      b.add(3, 60);
      b.add(4, 10);
      b.add(5, 20);
      
      b.link_left(0, 1);
      b.link_right(0, 4);
      
      b.link_left(1, 2);
      b.link_right(1, 3);
      
      b.link_right(4, 5);
      
      int[] range = {-999,999};
     System.out.println(b.check_bst(b.get_node(0),range));
      
	}
		
		
	}
	
	
		
	
		

	
  
	
    
	
		

	

	
		
		
	

	
	
	
	
	
	
	
	
	

	


	
	

	
		
	
	


	

	
	


	
	
	

	


	
	

	
		
	
	


	

	
	


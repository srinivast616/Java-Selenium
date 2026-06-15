package com.java.programs;

import java.util.*;

public class List_Check {

	public static void main(String args[])
	
	    {
	        
	        List<String> al = new ArrayList<>();	   
	      
	        al.add("xyz");
	        al.add("Geeks");
	        al.add("test");

	        System.out.println("Initial ArrayList " + al);
	  
	        al.set(2, "For");
	     
	        System.out.println("Updated ArrayList " + al);
	        
	        System.out.println(al.get(1));
	    }
	}



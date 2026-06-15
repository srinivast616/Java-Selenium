package com.java.programs;

import java.util.*;
import java.util.stream.*;

public class Lambda_PrintNums {
	
	    public static void main(String[] args) {

	        System.out.println("Using Traditional For Loop:");
	        for (int i = 1; i <= 10; i++) {
	            System.out.println(i);
	        }

	        System.out.println("\nUsing Lambda Expression:");
	        List<Integer> numbers = IntStream.rangeClosed(1, 10)
	                                         .boxed()
	                                         .collect(Collectors.toList());

	        numbers.forEach(n -> System.out.println(n));
	    }
	}




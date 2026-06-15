package com.sample.constructor2;

class Dog extends Animal {
	String breed;	
    Dog(String type, String breed) {        
    	super(type);
//    	this.breed = breed;
        System.out.println("Dog constructor called: Breed = " +breed);
    }
}


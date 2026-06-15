package com.sample.pagefactory.tests;
public class String_Object {
    public static void main(String[] args) {
        String str1 = "Java";                   // Using literal
        String str2 = new String("Java");       // Using new keyword

        System.out.println(str1 == str2);       // false (different references)
        System.out.println(str1.equals(str2));  // true  (same content)
    }
}
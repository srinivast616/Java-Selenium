package com.java.programs;

import java.util.Arrays;

import java.util.Scanner;

public class SortStringChars {

public static void main(String[] args) throws Exception {

Scanner in = new Scanner(System.in);

try{

System.out.println("Enter the string");

String s = in.nextLine();

char[] chars = s.toCharArray();

Arrays.sort(chars);

System.out.print("StringProgram_intw in sorted order:");

for(int i=0;i<=chars.length-1;i++)

{

System.out.print(chars[i]);

}

}

catch(Exception e){

System.out.println(e);

}

finally

{

in.close();

}

}

}



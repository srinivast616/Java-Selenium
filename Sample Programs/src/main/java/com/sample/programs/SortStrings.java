package com.sample.programs;

import java.util.Scanner;

public class SortStrings {

public static void main(String[] args) throws Exception {

int n;

String temp;

Scanner in = new Scanner(System.in);

System.out.println("Enter number of strings");

n = in.nextInt();

String names[]=new String[n];

//Scanner s1 = new Scanner(System.in);

try{

for(int i=0; i<n; i++)

{

names[i]=in.nextLine();

}

for(int i=1;i<=n-1;i++)

{

for(int j=i+1;j<n;j++)

{

if(names[i].compareTo(names[j])>0)



{

temp=names[i];

names[i]=names[j];

names[j]=temp;

}

}

}

System.out.print("Names in sorted order:");

for(int i=0;i<n-1;i++)

{

System.out.print(names[i]+",");

}

System.out.print(names[n-1]);

}

catch(Exception e){

System.out.println(e);

}

finally

{

//s1.close();

in.close();

}

}

}


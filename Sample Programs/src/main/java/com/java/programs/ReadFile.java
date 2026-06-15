package com.java.programs;

import java.io.FileInputStream;

import java.io.FileReader;

public class ReadFile

{

public static void main(String[] args)throws Exception

{

FileReader fr = new FileReader("D://usr.txt");

int i;

while((i=fr.read())!=-1)

{

System.out.print((char)i);

}

}

}

package com.java.programs;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile_FIS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("D:\\usr.txt");
		int i;
		while((i=fis.read())!=-1)
		{
			System.out.print((char)i);
		}
				

	}

}

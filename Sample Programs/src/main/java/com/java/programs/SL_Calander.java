package com.java.programs;

import java.util.*;
import java.text.*;
import java.util.Calendar;

public class SL_Calander {
	public static void main(String[] args)
	{
		Calendar calins = Calendar.getInstance();
		System.out.println("The current date = " + calins.getTime());
		calins.add(Calendar.DATE, -15);
		System.out.println("15 days ago:" +calins.getTime());
	}

}

package com.myfilm.service;

import java.util.Date;

public class Test {
	public static void main(String args[])
	{
		Date newdate=new Date();
		newdate.setYear(92);
		newdate.setMonth(1);
		newdate.setDate(1);
		System.out.println(newdate.toLocaleString());
	}

}

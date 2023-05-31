package com.jdbc.apps;
import java.io.FileReader;
import java.util.*;
public class TestApp {

	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.dir");  // this will give application location
		System.out.println(path);
		
		FileReader fr = new FileReader(path + "\\src\\demo.properties");
		
		Properties prop =new Properties();
		prop.load(fr);  // content will be converts into key-value format
		System.out.println("Student Name : " + prop.getProperty("sname"));
		System.out.println("Student Course : " + prop.getProperty("course"));
		System.out.println("Student Fees : " + prop.getProperty("fees"));
	
	}
}

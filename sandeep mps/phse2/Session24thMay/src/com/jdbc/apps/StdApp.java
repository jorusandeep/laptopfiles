package com.jdbc.apps;
import java.util.*;
import com.jdbc.service.*;
import com.jdbc.model.*;
public class StdApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentOperations so = new StudentOperations();
		Student std = null;
		while(true)
		{
			System.out.println("1. New Student\n2. Show All\n3. Search Student\n4. Update Student Name\n5. Delete Student\n6. Exit");
			System.out.println("Pick Ur Choice : ");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1: 
					std = new Student();
					System.out.println("Student Name : ");
					std.setStdname(sc.next());
					
					System.out.println("Student Course : ");
					std.setCourse(sc.next());
					
					System.out.println("Course Fees : ");
					std.setFees(sc.nextFloat());
					
					String res =  so.AddNewStudent(std);
					if(res.equals("Success"))
						System.out.println("New Student Added.....");
					break;
				case 2:
					List<Student>  stdall = so.ShowAll();
					for(Student s : stdall)
					{
						System.out.println(s.getRollno() + "\t" + s.getStdname() + "\t" + s.getCourse() + "\t" + s.getFees());
					}
					break;
				case 3:
					System.out.println("Enter Roll Number : ");
					int rno = sc.nextInt();
					Student s = so.SearchStudent(rno);
					if(s!=null)
						System.out.println(s.getRollno() + "\t" + s.getStdname() + "\t" + s.getCourse() + "\t" + s.getFees());
					else
						System.out.println("Student Not Found ...... ");
					break;
				case 4:
					System.out.println("Enter Roll Number to Update Student Name : ");
					rno = sc.nextInt();
				
					std = so.SearchStudent(rno);
					
					if(std!=null)
					{
						System.out.println("Present Name of the Student : " + std.getStdname());
						System.out.println("New Name of the Student : ");
						std.setStdname(sc.next());
						so.UpdateStudentName(std);
						System.out.println("Student Name is Updated....");
					}
					else
						System.out.println("Student Not Found.....");
					break;
				case 5:
					System.out.println("Enter Roll Number to Delete : ");
					rno = sc.nextInt();
				
					std = so.SearchStudent(rno);
					
					if(std!=null)
					{
						so.DeleteStudent(rno);
						System.out.println("Student Deleted....");
					}
					else
						System.out.println("Student Not Found.....");
					break;
				case 6:
					System.out.println("Thanks for Using App");
					System.exit(0);
			}
		}
	}
}

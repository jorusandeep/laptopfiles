package com.jdbc.service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.jdbc.connection.*;
import com.jdbc.model.*;

public class StudentOperations {

	private Connection conObj =null;
	
	public StudentOperations()
	{
		conObj = DbConnection.getConnection();
	}
	
	public String AddNewStudent(Student std)
	{
		String res = "Error";
		try
		{
			String inscmd = "Insert into Student(stdname, course, fees) values(?,?,?)";
			PreparedStatement ps = conObj.prepareStatement(inscmd);
			ps.setString(1, std.getStdname());
			ps.setString(2, std.getCourse());
			ps.setFloat(3, std.getFees());
			int r = ps.executeUpdate();
			if(r>=1)
				res = "Success";
			//conObj.close();
		}
		catch(Exception ex)
		{
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}
	
	public List<Student> ShowAll()
	{
		List<Student>  sall =  new ArrayList<Student>();
		Student std = null;
		try
		{
			PreparedStatement ps = conObj.prepareStatement("Select * from Student");
			ResultSet  rs = ps.executeQuery();
			
			while(rs.next())
			{
				std = new Student();
				std.setRollno(rs.getInt("rollno"));
				std.setStdname(rs.getString("stdname"));
				std.setCourse(rs.getString("course"));
				std.setFees(rs.getFloat("fees"));
				sall.add(std);
			}
			//conObj.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return sall;
	}
	
	public Student SearchStudent(int rollno)
	{
		Student std = null;
		try
		{
			PreparedStatement ps = conObj.prepareStatement("Select * from Student where rollno=?");
			ps.setInt(1, rollno);
			ResultSet  rs = ps.executeQuery();
			
			if(rs.next())
			{
				std = new Student();
				std.setRollno(rs.getInt("rollno"));
				std.setStdname(rs.getString("stdname"));
				std.setCourse(rs.getString("course"));
				std.setFees(rs.getFloat("fees"));
			}
			//conObj.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return std;
	}

	public String DeleteStudent(int rollno)
	{
		String res = "Error";
		try
		{
			//Delete from Student where rollno=1
			String delcmd = "Delete from Student where rollno=?";
			PreparedStatement ps = conObj.prepareStatement(delcmd);
			ps.setInt(1, rollno);
			int r = ps.executeUpdate();
			if(r>=1)
				res = "Success";
			//conObj.close();
		}
		catch(Exception ex)
		{
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}
	
	public String UpdateStudentName(Student std)
	{
		String res = "Error";
		try
		{
			//Update Student set stdname='nagesh' where rollno=2;
			String uptcmd = "Update Student set stdname=? where rollno=?";  
			
			PreparedStatement ps = conObj.prepareStatement(uptcmd);
			ps.setString(1, std.getStdname());
			ps.setInt(2, std.getRollno());
			
			int r = ps.executeUpdate();
			if(r>=1)
				res = "Success";
			//conObj.close();
		}
		catch(Exception ex)
		{
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}
}

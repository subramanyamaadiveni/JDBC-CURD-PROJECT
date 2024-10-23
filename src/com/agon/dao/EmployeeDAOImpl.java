package com.agon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.agon.connector.ConnectorFactory;
import com.agon.dto.Employee;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List getEmployees() {
		ArrayList<Employee> emplist=null;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query="select*from emp ";
			Statement stmt =con.createStatement();
			ResultSet res=stmt.executeQuery(query);
			
			emplist=emplist=new ArrayList<>();
			
			while(res.next()) {
				int id=res.getInt(1);
				String name=res.getString(2);
				String dsig = res.getString(3);
				int salary=res.getInt(4);
				
				Employee e1 = new Employee(id,name,dsig,salary);
				emplist.add(e1);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return emplist;
	}
	
	

	@Override
	public Employee getEmployee(int id) {
		
		PreparedStatement pstmt=null;
		Connection con=null;
		Employee e=null;
		try {
			con = ConnectorFactory.requestConnection();
			String query="select*from emp where id=? ";
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet res=pstmt.executeQuery();
			res.next();
			  e =new Employee(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4));
			
			
			
		} catch (Exception e2) {
			
			e2.printStackTrace();
		}
		
	
		
		
		return e;
	}

	@Override
	public boolean insertEmployee(int id, String name, String desigination, int salary) {
		
		Connection con;
		
		try {
			con = ConnectorFactory.requestConnection();
			String query="insert into emp values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, desigination);
			pstmt.setInt(4, salary);
			return pstmt.execute();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		int i=0;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query="update emp set salary =? where id=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, e.getSalary());
			pstmt.setInt(2, e.getId());
			i=pstmt.executeUpdate();
		}
		catch(Exception e2) {
			e2.printStackTrace();
		}
		if(i==1) return true;


		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		int i=0;
		try {
			Connection con = ConnectorFactory.requestConnection();
			String query="delete from emp where id=?";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1,id);
			i=pstmt.executeUpdate();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		if(i==1) return true;
		return false;
	}
	
	
	

}

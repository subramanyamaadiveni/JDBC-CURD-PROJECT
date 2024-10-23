package jdbc;
import com.agon.connector.*;
import java.util.List;
import java.util.Scanner;

import com.agon.dao.EmployeeDAOImpl;
import com.agon.dto.Employee;
public class DaoDriver {
	public static void main(String[]args) {
	
     	EmployeeDAOImpl emplDaoImpl=new EmployeeDAOImpl();
		List<Employee> employee=emplDaoImpl.getEmployees();
		for(Employee e:employee) {
			System.out.println(e);
		}
		
		ConnectorFactory c=new ConnectorFactory();
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter how many Number of rows you need to enter");
		int n=input.nextInt();
		
		while(n!=0) {
			
			System.out.println("enter details to insert into employee table");
			int id=input.nextInt();
			String name=input.next();
			String dsig=input.next();
			int salary=input.nextInt();
			emplDaoImpl.insertEmployee(id, name, dsig, salary);
			n--;
		}
		
		
		System.out.println("enter the employee id to update");
		int id=input.nextInt();
		Employee e=emplDaoImpl.getEmployee(id);
		System.out.println(e);
		
		System.out.println("enter salary to be updated");
		int newSalary=input.nextInt();
		e.setSalary(newSalary);
		boolean x=emplDaoImpl.updateEmployee(e);
		System.out.println(x);
		System.out.println("enter id to delete the data from database");
		int id1=input.nextInt();
		System.out.println(emplDaoImpl.deleteEmployee(id));
		
		
		
		
		List <Employee> emp=emplDaoImpl.getEmployees();
		for(Employee e1:emp) {
			System.out.println(e1);
		}
	}

}

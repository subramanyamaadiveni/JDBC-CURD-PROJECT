package com.agon.dao;

import java.util.*;
import com.agon.dto.Employee;



public interface EmployeeDAO {
	
	List getEmployees();
	
	Employee getEmployee(int id);
	
	boolean insertEmployee(int id, String name , String desigination, int salary);
	
	boolean updateEmployee(Employee e);
	
	boolean deleteEmployee(int id);
	
	
	
	
	

}

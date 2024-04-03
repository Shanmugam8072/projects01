package Project.repository;

import java.sql.SQLException;
import java.util.List;

import Project.Entity.Employee;

public interface EmpRepository {
	
	Employee Addemp(Employee employee)throws SQLException;
	Employee Update (Employee employee) throws SQLException;
	Employee GetById(Long Id)throws SQLException;
	List<Employee> GetAllEmp() throws SQLException;
	void DeleteById(Long Id) throws SQLException;
	

}

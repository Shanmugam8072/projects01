package Project.Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Project.Entity.Employee;
import Project.repository.EmpRepository;


@Repository
public class EmpImplement  implements EmpRepository{

	 @Autowired
	    private DataSource dataSource;

	 @Override
	 public Employee Addemp(Employee employee) throws SQLException {
	     String query = "INSERT INTO employee ( name, age, role) VALUES ( ?, ?, ?)";
	     try (Connection connection = dataSource.getConnection();
	          PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	    
	         preparedStatement.setString(1, employee.getName());
	         preparedStatement.setInt(2, employee.getAge());
	         preparedStatement.setString(3, employee.getRole());
	        
	         preparedStatement.executeUpdate();
	     }
	     return employee;
	 }


	    @Override
	    public Employee GetById(Long Id) throws SQLException {
	        String query = "SELECT * FROM employee WHERE id = ?";
	        try (Connection connection = dataSource.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setLong(1, Id);
	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    return sample(resultSet);
	                } else {
	                    throw new SQLException("Employee with ID " + Id + " not found");
	                }
	            }
	        }
	    }

	    @Override
	    public List<Employee> GetAllEmp() throws SQLException {
	        List<Employee> employees = new ArrayList<>();
	        String query = "SELECT * FROM employee";
	        try (Connection connection = dataSource.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                employees.add(sample(resultSet));
	            }
	        }
	        return employees;
	    }

	    @Override
	    public void DeleteById(Long id) throws SQLException {
	        String query = "DELETE FROM employee WHERE id = ?";
	        try (Connection connection = dataSource.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setLong(1, id);
	            preparedStatement.executeUpdate();
	        }
	    }

	    @Override
	    public Employee Update(Employee employee) throws SQLException {
	        String query = "UPDATE employee SET name=?, age=?, role=? WHERE id=?";
	        try (Connection connection = dataSource.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, employee.getName());
	            preparedStatement.setInt(2, employee.getAge());
	            preparedStatement.setString(3, employee.getRole());
	            
	            preparedStatement.setLong(4, employee.getId());
	            preparedStatement.executeUpdate();
	        }
	        return employee;
	    }


	    private Employee sample(ResultSet resultSet) throws SQLException {
	        Employee employee = new Employee();
	        employee.setId(resultSet.getLong("id"));
	        employee.setName(resultSet.getString("name"));
	        employee.setAge(resultSet.getInt("age"));
	        employee.setRole(resultSet.getString("role"));
	       
	        return employee;
	    }
	

}

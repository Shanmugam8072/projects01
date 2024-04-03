package Project.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Project.Entity.Employee;
import Project.repository.EmpRepository;


@RestController
@RequestMapping("/api/employee")
public class EmpContoller {
	
	@Autowired
	private EmpRepository empRep;
	
	@PostMapping("/add")
	private Employee AddEmployee(@RequestBody Employee emp ) throws SQLException {
		return empRep.Addemp(emp);
		
	}
	
	@GetMapping
    public List<Employee> getAllEmployees() throws SQLException {
        return empRep.GetAllEmp();
    }

	@GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) throws SQLException {
        return empRep.GetById(id);
    }
	
	 @PutMapping("/{id}")
	    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) throws SQLException {
	        emp.setId(id);
	        return empRep.Update(emp);
	    }
	 
	 @DeleteMapping("/{id}")
	    public void deleteEmployee(@PathVariable Long id) throws SQLException {
	    	empRep.DeleteById(id);
	    }

}

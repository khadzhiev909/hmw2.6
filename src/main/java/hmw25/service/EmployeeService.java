package hmw25.service;

import org.springframework.stereotype.Service;
import employee.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee find(String firtsName, String lastName);
    Employee add(String firtsName, String lastName);
    Employee remove(String firtsName, String lastName);
    Collection<Employee> findAll();
    //void findNewEmployee(Employee employee);

}

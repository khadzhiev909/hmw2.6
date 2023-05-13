package hmw25.service;

import hmw25.exeption.EmployeeAlreadyAddedException;
import hmw25.exeption.EmployeeNotFoundException;
import hmw25.exeption.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import employee.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    /* Создать сервис EmployeeService, который хранит внутри поле с коллекцией сотрудников и
      константу хранящее максимальное возможное количество сотрудников в фирме.*/
    final int maxEmpoyees = 12;

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Alex", "Volkanovskiy"),
            new Employee("John", "Vilyams")
    ));

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }



    /* метод для поиска*/
//    public void findNewEmployee(Employee employee) {
//        employees.(employee);
//    }


}

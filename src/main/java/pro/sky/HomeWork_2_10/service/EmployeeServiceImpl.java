package pro.sky.HomeWork_2_10.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.HomeWork_2_10.exeption.InvalidInputException;
import ru.pro.sky.Homework_29.exeption.EmployeeAlreadyAddedException;
import ru.pro.sky.Homework_29.exeption.EmployeeNotFoundException;
import ru.pro.sky.Homework_29.model.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final Map<String, Employee> employeeMap;


    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();

    }

    @Override
    public Employee add (String firstName, String lastName,  int salary, int department){

        if(validateInput(firstName,lastName)){
            throw new InvalidInputException();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        String s= firstName + lastName;
        if (employeeMap.containsKey(s)) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(s, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int department){
        if(validateInput(firstName,lastName)){
            throw new InvalidInputException();
        }
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employeeMap.containsValue(employee)) {
            String s= firstName + lastName;
            employeeMap.remove(s);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public Employee find (String firstName, String lastName, int salary, int department){

        if(validateInput(firstName,lastName)){
            throw new InvalidInputException();
        }

        Employee employee = new Employee(firstName, lastName, salary, department);
        String s= firstName + lastName;
        if (employeeMap.containsKey(s)) {
            return employee;
        }

        throw new EmployeeNotFoundException();
    }


    @Override
    public Collection<Employee> findAll () {
        return Collections.unmodifiableCollection(employeeMap.values());
    }

    @Override
    public Map<String, Employee> getMap(){
        return employeeMap;
    }

    private boolean validateInput( String firstName, String lastName){
        return isAlpha(firstName) && isAlpha(lastName);

    }




}

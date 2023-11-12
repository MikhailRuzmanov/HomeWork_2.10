package pro.sky.HomeWork_2_10.service;

import org.springframework.stereotype.Service;
import ru.pro.sky.Homework_29.exeption.EmployeeNotFoundException;
import ru.pro.sky.Homework_29.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public List<Employee>getAllByDepartment(int dep){
        return employeeServiceImpl.getMap().values()
                .stream()
                .filter(employee -> employee.getDepartment() == dep)
                .collect(Collectors.toList());
    }
    @Override
    public Employee getMin(int dep){
    return employeeServiceImpl.getMap().values()
            .stream()
            .filter(employee -> employee.getDepartment() == dep)
            .min(Comparator.comparingDouble(employeeServiceImpl-> employeeServiceImpl.getSalary()))
            .orElseThrow(EmployeeNotFoundException::new);

}

    public Employee getMax(int dep){
        return employeeServiceImpl.getMap().values()
                .stream()
                .filter(employee -> employee.getDepartment() == dep)
                .max(Comparator.comparingDouble(employeeServiceImpl-> employeeServiceImpl.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }


    @Override
    public Map<Integer, List<Employee>> getAll() {
        return employeeServiceImpl.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

}

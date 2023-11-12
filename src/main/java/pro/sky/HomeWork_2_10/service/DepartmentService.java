package pro.sky.HomeWork_2_10.service;

import ru.pro.sky.Homework_29.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    public List<Employee> getAllByDepartment(int dep);
    public Employee getMin(int dep);
    public Employee getMax(int dep);



    public Map<Integer, List<Employee>> getAll();
}

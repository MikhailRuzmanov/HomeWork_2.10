package pro.sky.HomeWork_2_10.model;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.capitalize;

public class Employee {

    private final String firstName;
    private final String lastName;
    private int salary;
    private int department;


    public Employee(String firstName, String lastName, int salary, int department ) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.department = department;

    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;

    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

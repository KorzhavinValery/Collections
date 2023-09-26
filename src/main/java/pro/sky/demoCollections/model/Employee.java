package pro.sky.demoCollections.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private int department;

    public Employee(String firstName, String lastName, String salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = new BigDecimal(String.valueOf(salary));
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return
                "ФИО сотрудника: " + firstName + " " + lastName;
    }
}
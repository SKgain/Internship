package question1;

import java.util.Objects;

public final class Employee {
    private final String id;
    private final String name;
    private final String department;
    private final String address;
    public Employee(String id, String name, String department, String address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }
}


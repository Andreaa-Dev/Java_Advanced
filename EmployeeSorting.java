import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

// class Employee
// Comparable: class's natural ordering
class Employee implements Comparable<Employee>{
        private int employeeId;
        private String employeeName;

        public Employee(int employeeId, String employeeName){
            this.employeeId=employeeId;
            this.employeeName=employeeName;
        }

        public int getEmployeeId(){
            return employeeId;
        }

        public String getEmployeeName(){
            return employeeName;
        }

        @Override
        public int compareTo(Employee other) {
        // Compare employees based on name
        return this.employeeName.compareTo(other.employeeName);
        }

        @Override
        public String toString() {
        return "Employee{id=" + employeeId + ", name='" + employeeName + '\'' + '}';
    }
    }

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "John Doe"));
        employees.add(new Employee(103, "Alice Smith"));
        employees.add(new Employee(102, "Bob Johnson"));

        // Sorting based on employee ID using Comparator
        sortByEmployeeId(employees);
        System.out.println("Sorted by Employee ID:");
        printEmployeeList(employees);

        // Sorting based on employee name using Comparable
        sortByEmployeeName(employees);
        System.out.println("\nSorted by Employee Name:");
        printEmployeeList(employees);


        private static void sortByEmployeeId(List<Employee> employees) {
        // Using Comparator to sort by employee ID
        Collections.sort(employees, Comparator.comparingInt(Employee::getId));
         }

    private static void sortByEmployeeName(List<Employee> employees) {
        // Using Comparable to sort by employee name
        Collections.sort(employees);
    }

    private static void printEmployeeList(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    }
}

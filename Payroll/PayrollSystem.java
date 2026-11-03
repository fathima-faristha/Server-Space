import java.util.ArrayList;
import java.util.Scanner;

// Abstract parent class
abstract class Employee {
    protected String name;
    protected int employeeID;

    public Employee(String name, int employeeID) {
        this.name = name;
        this.employeeID = employeeID;
    }

    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Salaried employee
class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(String name, int employeeID, double monthlySalary) {
        super(name, employeeID);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Hourly employee
class HourlyEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public HourlyEmployee(String name, int employeeID,
                          double hoursWorked, double hourlyRate) {
        super(name, employeeID);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Commission employee
class CommissionEmployee extends Employee {
    private double basicSalary;
    private double sales;
    private double commissionRate;

    public CommissionEmployee(String name, int employeeID,double basicSalary, double sales, double commissionRate) {
        super(name, employeeID);
        this.basicSalary = basicSalary;
        this.sales = sales;
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + (sales * commissionRate / 100);
    }
}

// Interface
interface EmployeeCreator {
    String getType();

    Employee createEmployee(Scanner input, String name, int id);
}

// Salaried employee creator
class SalariedCreator implements EmployeeCreator {
    public String getType() {
        return "Salaried Employee";
    }

    public Employee createEmployee(Scanner input, String name, int id) {
        System.out.print("Enter monthly salary: ");
        double salary = PayrollSystem.readDouble(input);
        return new SalariedEmployee(name, id, salary);
    }
}

// Hourly employee creator
class HourlyCreator implements EmployeeCreator {
    public String getType() {
        return "Hourly Employee";
    }

    public Employee createEmployee(Scanner input, String name, int id) {
        System.out.print("Enter hours worked: ");
        double hours = PayrollSystem.readDouble(input);

        System.out.print("Enter hourly rate: ");
        double rate = PayrollSystem.readDouble(input);

        return new HourlyEmployee(name, id, hours, rate);
    }
}

// Commission employee creator
class CommissionCreator implements EmployeeCreator {
    public String getType() {
        return "Commission Employee";
    }

    public Employee createEmployee(Scanner input, String name, int id) {
        System.out.print("Enter basic salary: ");
        double basic = PayrollSystem.readDouble(input);

        System.out.print("Enter sales amount: ");
        double sales = PayrollSystem.readDouble(input);

        System.out.print("Enter commission rate: ");
        double rate = PayrollSystem.readDouble(input);

        return new CommissionEmployee(name, id, basic, sales, rate);
    }
}

// Factory class
class EmployeeFactory {
    private ArrayList<EmployeeCreator> creators = new ArrayList<>();

    public void addCreator(EmployeeCreator creator) {
        creators.add(creator);
    }

    public int getNumberOfTypes() {
        return creators.size();
    }

    public void displayTypes() {
        for (int i = 0; i < creators.size(); i++) {
            System.out.println((i + 1) + ". " + creators.get(i).getType());
        }
    }

    public Employee createEmployee(int choice, Scanner input,String name, int id) {
        if (choice < 1 || choice > creators.size()) {
            throw new IllegalArgumentException("Invalid employee type.");
        }

        EmployeeCreator creator = creators.get(choice - 1);
        return creator.createEmployee(input, name, id);
    }
}

// Main payroll system
public class PayrollSystem {

    public static int readInt(Scanner input) {
        while (true) {
            try {
                int value = Integer.parseInt(input.nextLine());

                if (value <= 0) {
                    System.out.print("Enter a positive number: ");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a whole number: ");
            }
        }
    }

    public static double readDouble(Scanner input) {
        while (true) {
            try {
                double value = Double.parseDouble(input.nextLine());

                if (!Double.isFinite(value) || value < 0) {
                    System.out.print("Enter a valid non-negative number: ");
                    continue;
                }

                return value;

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        EmployeeFactory factory = new EmployeeFactory();

        // Register employee creators
        factory.addCreator(new SalariedCreator());
        factory.addCreator(new HourlyCreator());
        factory.addCreator(new CommissionCreator());

        System.out.println("PAYROLL MANAGEMENT SYSTEM");

        System.out.print("Enter number of employees: ");
        int numberOfEmployees = readInt(input);

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter employee name: ");
            String name = input.nextLine().trim();

            while (name.isEmpty()) {
                System.out.print("Name cannot be empty. Enter name: ");
                name = input.nextLine().trim();
            }

            System.out.print("Enter employee ID: ");
            int id = readInt(input);

            System.out.println("Select employee type:");
            factory.displayTypes();

            System.out.print("Enter your choice: ");
            int choice = readInt(input);

            while (choice > factory.getNumberOfTypes()) {
                System.out.print("Invalid choice. Enter again: ");
                choice = readInt(input);
            }

            try {
                Employee employee =
                    factory.createEmployee(choice, input, name, id);

                employees.add(employee);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Display payroll report
        System.out.println("\nPAYROLL REPORT");

        for (Employee emp : employees) {
            emp.displayDetails();
            System.out.println("-------------------");
        }

        // Find highest-paid employee
        Employee highestPaid = employees.get(0);

        for (Employee emp : employees) {
            if (emp.calculateSalary() > highestPaid.calculateSalary()) {
                highestPaid = emp;
            }
        }

        System.out.println("\nHIGHEST PAID EMPLOYEE");
        highestPaid.displayDetails();

        input.close();
    }
}

Payroll Management System

1. Project Description

This project is a simple Java payroll system for managing different types of employees. It supports salaried employees, hourly employees and commission-based employees.

The system calculates their salaries, displays a payroll report and finds the highest-paid employee.

2. Design Decisions

- Abstraction: I used an abstract class called "Employee" to hold common employee details and the salary calculation method.
- Inheritance: The three employee classes inherit from the Employee class.
- Polymorphism: Each employee type has its own way of calculating salary by overriding "calculateSalary()".
- Interface: I created an "EmployeeCreator" interface to define how employee objects are created.
- Factory: The "EmployeeFactory" helps select and create the required employee type.
- Open/Closed Principle: New employee types can be added by creating a new employee class and creator, then registering the creator with the factory.

3. Assumptions Made

- Employee names should not be empty.
- Employee IDs must be positive numbers.
- Salary-related values cannot be negative.
- Salaried employees receive a fixed monthly salary.
- Hourly employees are paid according to hours worked and their hourly rate.
- Commission employees receive a basic salary plus commission from sales.
- Employee details are stored in an ArrayList while the program is running. No database is used.

4. Requirements

- Java Development Kit (JDK) 17 or later.
- A computer with Command Prompt or a Java IDE.

5. How to Run the Program

Open Command Prompt in the folder containing the Java file.

Compile the program using:

javac PayrollSystem.java

Run the program using:

java PayrollSystem

Follow the instructions displayed to enter employee details and generate the payroll report.

6. Video Demonstration

The video below explains the code and demonstrates how the program works.

Video URL: https://youtu.be/e9c5wFhir3g
7. Conclusion

This project helped me practice Java object-oriented programming concepts. It also shows how different employee types can be managed using one payroll system.

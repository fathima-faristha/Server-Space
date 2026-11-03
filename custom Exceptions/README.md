Custom Exceptions in Java

1. Project Description

This project demonstrates how to create and use custom exceptions in Java. It contains two custom exceptions: "InvalidInputException" and "DatabaseConnectionException".

The program checks user input and handles errors using try-catch blocks.

2. Design Decisions

- InvalidInputException: Used when the user enters empty or invalid input.
- DatabaseConnectionException: Used when the database connection fails.
- Exception Handling: I used separate catch blocks to handle each exception.
- Inheritance: Both custom exception classes extend Java's built-in "Exception" class.
- Messages: Each exception displays a message explaining the problem.

3. Assumptions Made

- The user should not enter empty input.
- A database connection failure is simulated in the program.
- The program should display an error message instead of stopping unexpectedly.
- The database connection is only demonstrated and does not connect to a real database.

4. Files Used

- "InvalidInputException.java" – Handles invalid or empty input.
- "DatabaseConnectionException.java" – Handles database connection errors.
- "Main.java" – Contains the main method and input processing logic.

5. Requirements

- Java Development Kit (JDK).
- Command Prompt or a Java IDE.

6. How to Run the Program

Open Command Prompt in the folder containing the Java files.

Compile:

"javac *.java"

Run:

"java Main"

Enter an input when prompted and observe how the exceptions are handled.

7. Conclusion

This project helped me understand how custom exceptions work in Java and how different errors can be handled using try-catch blocks.

8. Video Demonstration

Video URL: https://youtu.be/zR8i0z0brXc
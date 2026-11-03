import java.util.Scanner;
class InvalidInputException extends Exception{
	public InvalidInputException(String message){
	super(message);
	}
}	

class DatabaseConnectionException extends Exception{
	public DatabaseConnectionException(String message){
	super(message);
	}
}

public class Main{
public static void processInput(String input) throws InvalidInputException, DatabaseConnectionException {
   if(input == null || input.trim().isEmpty()){
		throw new InvalidInputException("Invalid input!!");
   }
   else{
    System.out.println("Input is valid");
   }
  
	boolean connected =true;
	if (!connected){
		throw new DatabaseConnectionException("Database connection Failed");
	}
	else{
	 System.out.println("Database connection successfull");
	 }
	 }
	 
	 public static void main(String[] args){
	 Scanner s = new Scanner(System.in);
	 
	 boolean sucessful = false;
	 
	 while(!sucessful){
		  System.out.print("Enter Name:");
	 String input=s.nextLine();
	
	 
	 try{
		processInput(input);
		sucessful=true;
	 }
	 catch(InvalidInputException e)
	 {
		System.out.println(e.getMessage());
		System.out.println("Try again, Please");
	 }
	 catch(DatabaseConnectionException e)
	 {
		System.out.println(e.getMessage());
		System.out.println("Try Again, Please");
	 }
	 }
	 
	 s.close();
	 }
	 }
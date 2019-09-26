public class InvalidCommandException extends Exception{
  public InvalidCommandException(){
    String message = "Invalid command entered.";
    System.out.println(message);
  }
}

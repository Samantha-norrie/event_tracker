//Import
//Import
import java.util.Scanner;

public class UserInteraction{

  //Attribute
  private Accounts activate;

  //Constructor
  public UserInteraction(){
    activate = new Accounts();
  }

  //Method to start program
  public void start(){
    try{
      System.out.println("Would you like to Log In or Sign Up? (L/S)");
      Scanner s = new Scanner(System.in);
      String read = s.nextLine();
      if(read.equals("L") || read.equals("l")){
        logIn();
      }
      else if(read.equals("S") || read.equals("s")){
        signUp();
      }
      else{
        throw new InvalidCommandException();
      }
    }catch(InvalidCommandException e){
      start();
    }
  }

  //Method to sign up
  public void signUp(){

    //Get username
    System.out.println("Username wanted?");
    System.out.println("Username must be at least 7 characters long, and contain only letters (upper and/or lower) and numbers.");
    Scanner s = new Scanner(System.in);
    String username = s.nextLine();

    //Get password
    System.out.println("Password wanted?");
    System.out.println("Password must be at least 7 characters long, and contain at least one of '!', '$', '&', or '?'.");
    String password = s.nextLine();

    //Get sort setting
    System.out.println("Sort setting wanted? (name/location/date)");
    String sortSetting = s.nextLine();
    BSTNode newUser = new BSTNode(username, password, sortSetting);
    activate.insert(newUser);
    loggedInto(newUser);



  }

  //Method to log in
  public void logIn(){

    //Check if User exists
    System.out.println("Username:");
    Scanner s = new Scanner(System.in);
    String read = s.nextLine();
    System.out.println("Password:");
    Scanner s2 = new Scanner(System.in);
    String read2 = s.nextLine();
    BSTNode loggedInto = activate.find(read, read2);
    try{
      if(loggedInto != null){
        System.out.println("User: " + loggedInto.getData().getUsername());
        loggedInto(loggedInto);

      //Throw InvalidCommandException if User does not exist
      }else{
        throw new InvalidCommandException();
      }
    }catch(InvalidCommandException e){
      start();
    }
  }

  //Method for when User is logged in
  public void loggedInto(BSTNode user){
    while(true){

      //Get command from User
      System.out.println("What would you like to do? /n.See events (E) /n.Add events (A) /n.Change username and password /n.Log out (L)");
      Scanner s = new Scanner(System.in);
      String read = s.nextLine();
      try{

        //For if User want to see their Events
        if(read.equals("E") || read.equals("e")){
          try{
            System.out.println("In alphabetical or reverse alphabetical? (a/ra)");
            String order = s.nextLine();
            if(order.equals("a") || order.equals("A")){
              user.getData().getEvents().print("a");
            }else if(order.equals("ra") || order.equals("RA")){
              user.getData().getEvents().print("ra");
            }else{
              throw new InvalidCommandException();
            }
          }catch(InvalidCommandException e){
            LoggedInto(user);
          }
        }else if(read.equals("R") || read.equals("r")){
          System.out.println("What would you like to set your username as?");
          String newUsername = s.nextLine();
          System.out.println("What would you like to set your password as?");
          String newPassword = s.nextLine();
          user.getData().setUsername(newUsername);
          user.getData().setPassword(newPassword);
          System.out.println("New username: " + user.getData().getUsername());
          System.out.println("New password: " + user.getData().getPassword());


        //For if User wants to add an EventNode to their Events
        }else if(read.equals("A") || read.equals("a")){
          System.out.println("What is the name of the event?");
          Scanner s2 = new Scanner(System.in);
          String name = s2.nextLine();
          Scanner s3 = new Scanner(System.in);
          System.out.println("Event Location?");
          String location = s3.nextLine();
          Scanner s4 = new Scanner(System.in);
          System.out.println("Date? (00/00/00) (day/month/year)");
          String date = s4.nextLine();
          user.getData().getEvents().insert(name, location, date, user.getData().getSetting());

        //For if User wants to log out
        }else if(read.equals("L") || read.equals("l")){
          start();

        //For if invalid command entered
        }else{
          throw new InvalidCommandException();
        }
      }catch(InvalidCommandException e){
        loggedInto(user);
      }
    }
  }
}

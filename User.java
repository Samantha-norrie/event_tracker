public class User{
  //Attributes
  private String username;
  private String password;
  private Events userEvents;
  private String sortSetting;

  //Constructor
  public User(String username, String password, String sortSetting){
    this.sortSetting = sortSetting;
    userEvents = new Events(sortSetting);
    if(isValidUsername(username)){
      this.username = username;
      System.out.print("Username is: ");
    }

    //Generate random username if not valid
    else{
      System.out.print("Username invalid. Randomly generated username generated is: ");
      this.username = generateUsername();
    }
    System.out.println(this.username);
    if(isValidPassword(password)){
      this.password = password;
      System.out.print("Password is: ");
    }

    //Generate random password if not valid
    else{
      System.out.print("Password invalid. Randomly generated password is: ");
      this.password = generatePassword();
    }
    System.out.println(this.password);
  }

  //Method to check if username is valid

  /*Username must be at least 7 characters
  long, and contain only letters (upper and/or lower)
  and numbers.
  */
  private static boolean isValidUsername(String username){

    //Check length
    if(username.length() < 7){
      System.out.println("Username must be at least 7 characters.");
      return false;
    }

    //Check if all characters are valid
    for(int i = 0; i < username.length(); i++){
      if((username.charAt(i) > 32 && username.charAt(i) < 48) || (username.charAt(i) > 57 && username.charAt(i) < 65)){
        System.out.println("Illegal character(s) used.");
        return false;
      }
    }
    return true;
  }

  //Method to check if password is valid

  /*Password must be at least 7 characters
  long, and contain at least one of '!', '$',
  '&', or '?'.
  */

  private static boolean isValidPassword(String password){

    //Check length
    if(password.length() < 7){
      System.out.println("Password must be at least 7 characters.");
      return false;
    }

    //Check for one of '!', '$', '&', or '?'
    for(int i = 0; i < password.length(); i++){
      if(password.charAt(i) == 33 || password.charAt(i) == 36 || password.charAt(i) == 38 || password.charAt(i) == 63){
        return true;
      }
    }
    return false;
  }

  //Method to generate random username
  private static String generateUsername(){
    String toReturn = "";

    //Use loop to generate username
    for(int i = 0; i < 8; i++){
      int charType = (int)((Math.random())*3);
      if(charType == 0){
        int generator = (int)((Math.random())*(58-48)+48);
        toReturn = toReturn + (char)generator;
      }else if(charType == 1){
        int generator = (int)((Math.random())*(91-65)+65);
        toReturn = toReturn + (char)generator;
      }else{
        int generator = (int)((Math.random())*(123-97)+97);
        toReturn = toReturn + (char)generator;
      }
    }
    return toReturn;
  }

  //Method to generate random password
  private static String generatePassword(){
    String toReturn = "";

    //Decide where one of '!', '$', '&', '?' will go in password
    //There may be multiple in password due to randomization
    int placement = (int)((Math.random())*8);
    int character = (int)((Math.random())*4);
    char toAdd = '!';
    if(character == 1){
      toAdd = '$';
    }else if(character == 2){
      toAdd = '&';
    }else if(character == 3){
      toAdd = '?';
    }

    //Create for loop to create password
    for(int i = 0; i < 8; i++){
      int pwChar = (int)((Math.random()*((122-33)+1))+33);
      if(i == placement){
        toReturn = toReturn + toAdd;
      }else{
        toReturn = toReturn + ((char)pwChar);
      }
    }
    return toReturn;
  }

  //Get methods
  public String getUsername(){
    return username;
  }
  public String getPassword(){
    return password;
  }
  public boolean getStatus(){
    return adminStatus;
  }
  public Events getEvents(){
    return userEvents;
  }
  public String getSetting(){
    return sortSetting;
  }

  //Set methods
  public void setUsername(String username){
    if(isValidUsername(username)){
      this.username = username;
    }else{
      this.username = generateUsername();
    }
  }
  public void setPassword(String password){
    if(isValidPassword(password)){
      this.password = password;
    }else{
      this.password = generatePassword();
    }
  }
}

public class BSTNode{

  //Attributes
  private BSTNode left;
  private BSTNode right;
  private User data;

  //Constructors
  public BSTNode(boolean status, String username, String password, String sortSetting){
    User data = new User(status, username, password, sortSetting);
    this.data = data;
    left = null;
    right = null;
  }
  public BSTNode(String username, String password, String sortSetting){
    User data = new User(username, password, sortSetting);
    this.data = data;
    left = null;
    right = null;
  }

  //Get methods
  public BSTNode getLeft(){
    return left;
  }
  public BSTNode getRight(){
    return right;
  }
  public User getData(){
    return data;
  }

  //Set methods
  public void setLeft(BSTNode left){
    this.left = left;
  }
  public void setRight(BSTNode right){
    this.right = right;
  }

  //compareTo method
  public int compareTo(BSTNode n){
    String username1 = this.data.getUsername();
    String username2 = n.getData().getUsername();

    //Compare lengths of usernames to determine how many chars should be compared in loop (worst case)
    int one = username1.length();
    int two = username2.length();
    int use = one;
    if(one > two){
      use = two;
    }else if(one == two){
      if(username1.equals(username2)){
        return 0;
      }
    }
    for(int i = 0; i < use; i++){
      if(((int)(username1.charAt(i))) > ((int)(username2.charAt(i)))){
        return 1;
      }else if(((int)(username1.charAt(i))) < ((int)(username2.charAt(i)))){
        return -1;
      }
    }
    if(one > two){
      return 1;
    }
    return -1;
  }
}

public class Accounts{

  //Atribute
  BSTNode root;

  //Constructors
  public Accounts(){
    root = null;
  }
  public Accounts(BSTNode root){
    this.root = root;
  }

  //Insert method
  public void insert(BSTNode toInsert){

    //Make root if first BSTNode in Accounts
    if(root == null){
      root = toInsert;

    //If username already taken
    }else if(taken(toInsert)){
      System.out.println("Username already taken.");

    //Add BSTNode to Accounts BSTTree
    }else{
      BSTNode current = root;
      BSTNode parent = null;
      while(current != null){
        parent = current;
        if(current.compareTo(toInsert) < 0){
          current = current.getRight();
          if(current == null){
            parent.setRight(toInsert);
          }
        }else{
          current = current.getLeft();
          if(current == null){
            parent.setLeft(toInsert);
          }
        }
      }
    }
  }

  //Find method
  public BSTNode find(String username, String password){
    return find(username, password, root);
  }
  private BSTNode find(String username, String password, BSTNode at){
    if(at == null){
      return null;
    }else if(username.equals(at.getData().getUsername()) && password.equals(at.getData().getPassword())){
      return at;
    }else{
      if(username.compareTo(at.getData().getUsername()) > 0){
        return find(username, password, at.getRight());
      }else{
        return find(username, password, at.getLeft());
      }
    }
  }

  //In Order print method
  public void print(){
    print(root);
  }
  private void print(BSTNode t){
    if(t == null){
      return;
    }
    print(t.getLeft());
    System.out.println(t.getData().getUsername());
    print(t.getRight());
  }

  //Method to check if username is already taken
  private boolean taken(BSTNode toInsert){
    return taken(root, toInsert);
  }
  private boolean taken(BSTNode current, BSTNode toInsert){
    if(current == null){
      return false;
    }else if(current.compareTo(toInsert) == 0){
      return true;
    }else{
      if(current.compareTo(toInsert) > 0){
        taken(current.getLeft(), toInsert);
      }else{
        taken(current.getRight(), toInsert);
      }
    }
    return false;
  }
}

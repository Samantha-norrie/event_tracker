public class Events{

  //Attributes
  private String sortSetting;
  private EventNode head;
  private EventNode tail;

  //Constructors
  public Events(String sortSetting){
    this.sortSetting = sortSetting;
    head = null;
    tail = null;
  }
  public Events(String sortSetting, EventNode firstEvent){
    this.sortSetting = sortSetting;
    this.head = firstEvent;
    this.tail = firstEvent;
  }

  /*Events can be sorted by:
  .Name
  .Location
  .Date
  */

  //Get and set methods for sortSetting
  public String getSetting(){
    return sortSetting;
  }
  public void setSorting(String sortSetting){
    this.sortSetting = sortSetting;
  }

  //Insert method
  public void insert(String name, String location, String date, String sortSetting){
    EventNode toInsert = new EventNode(name, location, date);

    //For if no EventNode exist in User's Events
    if(head == null){
      head = toInsert;
      tail = toInsert;
      return;
    }else{
      //Find where EventNode should be inserted
      EventNode at = head;
      EventNode atPrev = null;
      while(at != null){
        if(toInsert.compareTo(at, sortSetting) <= 0){
          break;
        }
        atPrev = at;
        at = at.getNext();
      }

      //If smaller than current head (becomes head)
      if(at == head){
        at.setPrev(toInsert);
        toInsert.setNext(at);
        head = toInsert;
      }

      //if bigger than all current EventNode (becomes tail)
      else if(at == null){
        atPrev.setNext(toInsert);
        toInsert.setPrev(atPrev);
        tail = toInsert;
      }

      //If somewhere in the middle of all EventNode
      else{
        atPrev.setNext(toInsert);
        at.setPrev(toInsert);
        toInsert.setNext(at);
        toInsert.setPrev(atPrev);
      }
    }
  }

  //Method to print
  public void print(String order){

    //Starting at the beginning of the alphabet (head)
    if(order.equals("a")){
      EventNode at = head;
      while(at != null){
        System.out.println(at.toString());
        at = at.getNext();
      }
    }

    //Starting at the end of the alphabet (tail)
    else if(order.equals("ra")){
      EventNode at = tail;
      while(at != null){
        System.out.println(at.toString());
        at = at.getPrev();
      }
    }
  }
}

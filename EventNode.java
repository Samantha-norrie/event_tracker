public class EventNode{
  //Attributes
  private String name;
  private String location;
  private String date;
  private EventNode next;
  private EventNode prev;
  //private int day;
  //private int month;
  //private int year;

  //Constructors
  public EventNode(String name){
    this.name = name;
    location = "";
    date = "";
    next = null;
    prev = null;
    //day = 0;
    //month = 0;
    //year = 0;
  }
  public EventNode(String name, String location){
    this.name = name;
    this.location = location;
    date = "";
    next = null;
    prev = null;
  }
  public EventNode(String name, String location, String date){
    this.name = name;
    this.location = location;
    this.date = date;
    next = null;
    prev = null;
  }


  //Get methods
  public String getName(){
    return name;
  }
  public String getLocation(){
    return location;
  }
  public String getDate(){
    return date;
  }
  public EventNode getNext(){
    return next;
  }
  public EventNode getPrev(){
    return prev;
  }

  //Set methods
  public void setName(String name){
    this.name = name;
  }
  public void setLocation(String location){
    this.location = location;
  }
  public void setDate(String date){
    this.date = date;
  }
  public void setNext(EventNode next){
    this.next = next;
  }
  public void setPrev(EventNode prev){
    this.prev = prev;
  }

  //CompareTo method
  public int compareTo(EventNode e, String sortSetting){

    //If events are sorted by name
    if(sortSetting.equals("name")){
      String calledOn = this.name;
      String loaded = e.getName();
      int length = calledOn.length();
      if(loaded.length() < length){
        length = loaded.length();
      }
      for(int i = 0; i < length; i++){
        if(calledOn.charAt(i) > loaded.charAt(i)){
          return 1;
        }
        else if(calledOn.charAt(i) < loaded.charAt(i)){
          return -1;
        }

      }
      if(loaded.length() == calledOn.length()){
        return 0;
      }else if(calledOn.length() > loaded.length()){
        return 1;
      }
      return -1;

    }

    //If events are sorted by location
    else if(sortSetting.equals("location")){
      String calledOn = this.location;
      String loaded = e.getLocation();
      int length = calledOn.length();
      if(loaded.length() < length){
        length = loaded.length();
      }
      for(int i = 0; i < length; i++){
        if(calledOn.charAt(i) > loaded.charAt(i)){
          return 1;
        }
        else if(calledOn.charAt(i) < loaded.charAt(i)){
          return -1;
        }

      }
      if(loaded.length() == calledOn.length()){
        return 0;
      }else if(calledOn.length() > loaded.length()){
        return 1;
      }
      return -1;

    }

    //If events are sorted by date
    else if(sortSetting.equals("date")){
      String calledOn = this.date;
      String loaded = e.getDate();

      //Separate into year, month, and day

      //year
      String yearCalledOnString = "" + calledOn.charAt(6) + calledOn.charAt(7);
      int yearCalledOn = Integer.parseInt(yearCalledOnString);
      String yearLoadedString = "" + loaded.charAt(6) + loaded.charAt(7);
      int yearLoaded = Integer.parseInt(yearLoadedString);

      //month
      String monthCalledOnString = "" + calledOn.charAt(3) + calledOn.charAt(4);
      int monthCalledOn = Integer.parseInt(monthCalledOnString);
      String monthLoadedString = "" + loaded.charAt(3) + loaded.charAt(4);
      int monthLoaded = Integer.parseInt(monthLoadedString);

      //day
      String dayCalledOnString = "" + calledOn.charAt(0) + calledOn.charAt(1);
      int dayCalledOn = Integer.parseInt(dayCalledOnString);
      String dayLoadedString = "" + loaded.charAt(0) + loaded.charAt(1);
      int dayLoaded = Integer.parseInt(dayLoadedString);

      //A later date is considered to be greater
      if(yearCalledOn > yearLoaded){
        return 1;
      }else if(yearCalledOn < yearLoaded){
        return -1;
      }else{
        if(monthCalledOn > monthLoaded){
          return 1;
        }else if(monthCalledOn < monthLoaded){
          return -1;
        }else{
          if(dayCalledOn > dayLoaded){
            return 1;
          }else if(dayCalledOn < dayLoaded){
            return -1;
          }
        }
      }
      //return 0;
    }
    return 0;
  }

  public String toString(){
    String toReturn = "" + this.name + " at " + this.location + " during " + this.date;
    return toReturn;
  }

}

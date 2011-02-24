package info.martinussen.scwcd.hfsj.ch7.model;

import java.util.ArrayList;
import java.util.List;

/**
 * hfsj p 300
 * @author Henrik
 *
 */
public class HobbyArchive {
  
  static {
    System.out.println("HobbyArchive is loaded");
  }
  
  public HobbyArchive(){
    System.out.println("HobbyArchive is constructed");
  }
  
  public List<String> getNames(String hobby){
    System.out.println("HobbyArchive.getFriends() is called, parameter hobby was: " + hobby);
    List<String> friends = new ArrayList<String>();
    if (hobby.equals("extreme knitting")){
      friends.add("Fred");
      friends.add("Pradeep");
      friends.add("Philippe");
    } else {
      friends.add("Jack");
      friends.add("Anna");
    }
    System.out.println("HobbyArchive.getFriends() returns: " + friends);
    return friends;
  }

}

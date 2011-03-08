package info.martinussen.scwcd.hfsj.ch8.model;

import org.apache.log4j.Logger;

public class Dog {
  private static Logger log = Logger.getLogger(Dog.class);
  private String name;
  private String race;
  
  public Dog(){
    super();
    log.debug("Dog was constructed");
  }

  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
    log.debug("Dog.setRace was called, race parameter was " + race);
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    log.debug("Dog.setName was called, name parameter was " + name);
  }

  @Override
  public boolean equals(Object obj) {
    log.debug("Dog.equals() was called");
    boolean returnValue = false;
    if (obj == this){
      log.debug("obj and this was the same object");
      returnValue = true;
    } else{
      if (obj != null){
        log.debug("obj was not null");
        if (obj instanceof Dog){
          log.debug("obj was instance of Dog");
          Dog other = (Dog) obj;
          if (other.name != null){
            log.debug("other.name was not null");
            if (other.name.equalsIgnoreCase(this.name)){
              log.debug("other.name was equal to this.name (ignoring case)");
              if (other.race != null){
                log.debug("other.race was not null");
                if (other.race.equalsIgnoreCase(this.race)){
                  log.debug("other.race was equal to this.race (ignoring case)");
                  returnValue = true;
                }
              }
            }
          }
        }
      }
    }
    log.debug("Dog.equals ends, " + returnValue + " is returned");
    return returnValue;
  }

  @Override
  public int hashCode() {
    return 42; //usable but inefficient
  }

  
  

}

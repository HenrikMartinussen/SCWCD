package info.martinussen.scwcd.hfsj.ch14.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestListener implements ServletRequestAttributeListener {

  public void attributeAdded(ServletRequestAttributeEvent event) {
    System.out.println("attribute added");
    System.out.println("attribute name" + event.getName());
    System.out.println("attribute value: " + event.getValue());
  }

  public void attributeRemoved(ServletRequestAttributeEvent event) {
    System.out.println("attribute removed");
  }

  public void attributeReplaced(ServletRequestAttributeEvent event) {
    System.out.println("attribute replaced");

  }

}

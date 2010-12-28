package info.martinussen.scwcd.hfsj.ch9.model;

public class UserTypeModel {

  public UserTypeModel() {
    super();
    System.out.println("In UserTypeModel constructor");
  }
  
  public String findUserTypeFromName(String name){
    System.out.println("In UserTypeModel.findUserTypeFromName() - name parameter was: " + name);
    String userType = "non-member";
    if (name.equalsIgnoreCase("Henrik")){
      userType = "member";
    }
    
    System.out.println("In UserTypeModel.findUserTypeFromName() - about to return userType: " + userType);
    return userType;
  }
  

}

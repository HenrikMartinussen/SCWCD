package info.martinussen.scwcd.hfsj.ch6.model;

public class BeerExpert {

    public BeerExpert() {}

    public NextResponse getAdvice(String answer) {
      if (answer.equals("")){
        return new NextResponse(false, new String[] {"Dark", "Amber", "Pale"});
      } else {
        return new NextResponse(false, new String[] {"Cheap", "Regular", "Exclusive"});
      }
    }
    
    
}

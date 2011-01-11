package info.martinussen.scwcd.hfsj.ch10.tag;

public class Movie {
  private String name;
  private String genre;
  
  
  private Movie() {
  }

  public Movie (String name, String genre){
    this();
    this.name = name;
    this.genre = genre;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }
  
  

}

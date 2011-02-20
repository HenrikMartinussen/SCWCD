package info.martinussen.scwcd.hfsj.ch10.tag;

import java.util.ArrayList;
import java.util.List;

/**
 * HFSJ p393, 421
 * @author Henrik
 */
public class CreateMovieListFunction {
  public static List suggestMovie(){
    List movies = new ArrayList();
    movies.add(new Movie("Mama Mia", "Musical Drama"));
    movies.add(new Movie("Reservoir Dogs", "Action Thriller"));
    movies.add(new Movie("Matrix", "SciFi Action"));
    return movies;
  }
}

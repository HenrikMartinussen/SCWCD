package info.martinussen.beerexpert.restservice;

import info.martinussen.beerexpert.model.BeerExpert;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * curl -X GET http://localhost:8081/beerexpert-server/advice/light
 */

@Path("advice")
public class BeerExpertService
{

   @Path("/{color}")
   @GET
   @Produces("text/html")
   public String find(@PathParam("color") String color) {
      List<String> advice = new BeerExpert().getBrands(color);
      StringBuilder response = new StringBuilder();

      if (advice.size() > 0){
         response.append("<h2>Advice on Color ").append(color).append("</h2>\n");
         for (String s : advice){
            response.append("<p>Try: ").append(s).append("\n");
         }
         return response.toString();
      }

      throw new WebApplicationException(Response.Status.NOT_FOUND);
   }

}
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

   @Path("/{order}")
   @GET
   @Produces("text/html")
   public String find(@PathParam("order") String order) {
      List<String> advice = new BeerExpert().getBrands(order);
      StringBuilder response = new StringBuilder();

      if (advice.size() > 0){
         response.append("<h2>Advice on Color ").append(order).append("</h2>\n");
         for (String s : advice){
            response.append("<p>Try: ").append(s).append("\n");
         }
         return response.toString();
      }

      throw new WebApplicationException(Response.Status.NOT_FOUND);
   }

}
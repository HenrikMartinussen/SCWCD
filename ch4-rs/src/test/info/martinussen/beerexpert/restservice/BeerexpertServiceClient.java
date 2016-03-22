package info.martinussen.beerexpert.restservice;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.util.ArrayList;
import java.util.List;


public class BeerExpertServiceClient{

    private static final String SERVICE_URI = "http://localhost:8081/";

    public List<String> getAdvice(String color){
        List<String> returnValue = new ArrayList<String>();

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri(SERVICE_URI).build());
        // getting HTML data
        String response = service.path("beerexpert-server/").path("advice/").path(color).accept(MediaType.TEXT_HTML).get(String.class);
        System.out.println(response);

        String[] tokens = response.split("<p>Try: ");
        for (String token : tokens){
            returnValue.add(token);
            System.out.println(token);
        }

        return returnValue;
    }

    public static void main(String[] args){
        BeerExpertServiceClient client = new BeerExpertServiceClient();
        client.getAdvice("light");
        client.getAdvice("amber");
    }

}
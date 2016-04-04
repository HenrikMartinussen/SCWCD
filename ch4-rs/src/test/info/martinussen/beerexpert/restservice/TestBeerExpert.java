package info.martinussen.beerexpert.restservice;

import info.martinussen.beerexpert.model.BeerExpert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by edbafhmt.
 */
public class TestBeerExpert {

    private BeerExpert testExpert;

    @Before
    public void setUp(){
        testExpert = new BeerExpert();
    }

    @Test
    public void tsetLight(){
        List<String> expectedAdvice = Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"});
        List<String> advice = testExpert.getBrands("Light");
        fail("Not implemented yet");
    }

    @Test
    public void testLightXml(){
        String expectedAdvice = "<advice><brand>Jail Pale Ale</brand><brand>Gout Stout</brand></advice>";
        assertEquals(expectedAdvice, testExpert.getBrandsAsXml("light"));
    }

    @Test
    public void testDarkXml(){
        String expectedAdvice = "<advice><brand>Jail Pale Ale</brand><brand>Gout Stout</brand></advice>";
        assertEquals(expectedAdvice, testExpert.getBrandsAsXml("dark"));
    }

    @Test
    public void testBrownXml(){
        String expectedAdvice = "<advice><brand>Jail Pale Ale</brand><brand>Gout Stout</brand></advice>";
        assertEquals(expectedAdvice, testExpert.getBrandsAsXml("brown"));
    }

    @Test
    public void testAmberXml(){
        String expectedAdvice = "<advice><brand>Jack Amber</brand><brand>Red Moose</brand></advice>";
        assertEquals(expectedAdvice, testExpert.getBrandsAsXml("amber"));
    }

    @After
    public void tearDown(){
        testExpert = null;
    }


}

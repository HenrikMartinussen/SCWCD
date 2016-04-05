package info.martinussen.beerexpert.restservice;

import info.martinussen.beerexpert.model.BeerExpert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

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
    public void testLight(){
        List<String> expectedAdvice = Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"});
        Collections.sort(expectedAdvice);
        List<String> advice = testExpert.getBrands("light");
        Collections.sort(advice);
        assertEquals(expectedAdvice, advice);
    }

    @Test
    public void testDark(){
        List<String> expectedAdvice = Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"});
        Collections.sort(expectedAdvice);
        List<String> advice = testExpert.getBrands("dark");
        Collections.sort(advice);
        assertEquals(expectedAdvice, advice);
    }

    @Test
    public void testBrown(){
        List<String> expectedAdvice = Arrays.asList(new String[]{"Jail Pale Ale", "Gout Stout"});
        Collections.sort(expectedAdvice);
        List<String> advice = testExpert.getBrands("brown");
        Collections.sort(advice);
        assertEquals(expectedAdvice, advice);
    }

    @Test
    public void testAmber(){
        List<String> expectedAdvice = Arrays.asList(new String[]{"Jack Amber", "Red Moose"});
        Collections.sort(expectedAdvice);
        List<String> advice = testExpert.getBrands("amber");
        Collections.sort(advice);
        assertEquals(expectedAdvice, advice);
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

package info.martinussen.keyfile.model;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * "Junit in action" p 17 - "Running parameterized tests"
 */
@RunWith(value = Parameterized.class)
public class TestProductKey {
  private ProductKey testKey = null;
  
  private String  version;
  private String  customer;
  private int     clientCount;
  private int     automatCount;
  private boolean tiltEnabled;
  private boolean liftEnabled;
  private String  expectedFileName;

  
  @Parameters
  public static Collection<Object[]> getTestParameters(){
    return Arrays.asList(new Object[][]{
        {"Light",      "Carlsberg A/S",     1, 1, false, false, "expected1.xml"}, 
        {"Light",      "Tuborg A/S",        2, 4, true,  false, "expected2.xml"}, 
        {"Basic",      "Gourmetbryggeriet", 1, 1, false, false, "expected3.xml"},
        {"Basic",      "Svaneke Bryghus",   2, 4, true,  false, "expected4.xml"},
        {"Standard",   "Faxe",              1, 1, false, false, "expected5.xml"},
        {"Standard",   "Thor",              2, 4, true,  true,  "expected6.xml"},
        {"Enterprise", "Albani",            2, 2, true,  false, "expected7.xml"},
        {"Enterprise", "Skovlyst",          6, 4, true,  true,  "expected8.xml"}
    });
  }
  
  public TestProductKey(String testVersion, String customer, int clientCount, int automatCount, boolean tiltEnabled, boolean liftEnabled, String expectedFileName){
    this.version = testVersion;
    this.customer = customer;
    this.clientCount = clientCount;
    this.automatCount = automatCount;
    this.tiltEnabled = tiltEnabled;
    this.liftEnabled = liftEnabled;
    this.expectedFileName = expectedFileName;
  }
  
  @Before
  public void setUp() throws Exception {
    testKey = new ProductKey();
    testKey.setVersion(version);
    testKey.setCustomer(customer);
    testKey.setClientCount(clientCount);
    testKey.setAutomatCount(automatCount);
    testKey.setTiltEnabled(tiltEnabled);
    testKey.setLiftEnabled(liftEnabled);
  }

  @After
  public void tearDown() throws Exception {
    testKey = null;
  }

  /**
   * Runs once for each item in the testParameters collection
   * @throws IOException 
   */
  @Test
  public void testGetKeyAsXmlStringForTestParameters() throws IOException {
    String result = testKey.getKeyAsXmlString();
    InputStream expected = 
        getClass().getClassLoader().getResourceAsStream(expectedFileName);
    assertEquals( IOUtils.toString( expected ), result);
  }
}

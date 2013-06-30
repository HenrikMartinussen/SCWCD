package info.martinussen.keyfile.model;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * "Junit in action" p 17 - "Running parameterized tests"
 * @author HMS
 */
@RunWith(value = Parameterized.class)
public class TestProductKey {
  private ProductKey testKey = null;
  
  private String  version;
  private int     clientCount;
  private int     automatCount;
  private boolean tiltEnabled;
  private boolean liftEnabled;
  private String  expected;

  
  @Parameters
  public static Collection<Object[]> getTestParameters(){
    return Arrays.asList(new Object[][]{
        {"Light",      1, 1, false, false, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ProductKey><Version>Light</Version><ClientCount>1</ClientCount><AutomatCount>1</AutomatCount><TiltEnabled>false</TiltEnabled><LiftEnabled>false</LiftEnabled></ProductKey>"}, 
        {"Light",      2, 4, true,  false, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ProductKey><Version>Light</Version><ClientCount>2</ClientCount><AutomatCount>4</AutomatCount><TiltEnabled>true</TiltEnabled><LiftEnabled>false</LiftEnabled></ProductKey>"}, 
        {"Basic",      1, 1, false, false, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ProductKey><Version>Basic</Version><ClientCount>1</ClientCount><AutomatCount>1</AutomatCount><TiltEnabled>false</TiltEnabled><LiftEnabled>false</LiftEnabled></ProductKey>"},
        {"Basic",      2, 4, true,  false, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ProductKey><Version>Basic</Version><ClientCount>2</ClientCount><AutomatCount>4</AutomatCount><TiltEnabled>true</TiltEnabled><LiftEnabled>false</LiftEnabled></ProductKey>"},
        {"Standard",   1, 1, false, false, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ProductKey><Version>Standard</Version><ClientCount>1</ClientCount><AutomatCount>1</AutomatCount><TiltEnabled>false</TiltEnabled><LiftEnabled>false</LiftEnabled></ProductKey>"},
        {"Standard",   2, 4, true,  true,  "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ProductKey><Version>Standard</Version><ClientCount>2</ClientCount><AutomatCount>4</AutomatCount><TiltEnabled>true</TiltEnabled><LiftEnabled>true</LiftEnabled></ProductKey>"},
        {"Enterprise", 2, 2, true,  false, "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ProductKey><Version>Enterprise</Version><ClientCount>2</ClientCount><AutomatCount>2</AutomatCount><TiltEnabled>true</TiltEnabled><LiftEnabled>false</LiftEnabled></ProductKey>"},
        {"Enterprise", 6, 4, true,  true,  "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ProductKey><Version>Enterprise</Version><ClientCount>6</ClientCount><AutomatCount>4</AutomatCount><TiltEnabled>true</TiltEnabled><LiftEnabled>true</LiftEnabled></ProductKey>"}
    });
  }
  
  public TestProductKey(String testVersion, int clientCount, int automatCount, boolean tiltEnabled, boolean liftEnabled, String expected){
    this.version = testVersion;
    this.clientCount = clientCount;
    this.automatCount = automatCount;
    this.tiltEnabled = tiltEnabled;
    this.liftEnabled = liftEnabled;
    this.expected = expected;
  }
  
  @Before
  public void setUp() throws Exception {
    testKey = new ProductKey();
    testKey.setVersion(version);
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
   */
  @Test
  public void testGetKeyAsXmlStringForTestParameters() {
    String result = testKey.getKeyAsXmlString();
    assertTrue(result.contains(expected));
  }
}

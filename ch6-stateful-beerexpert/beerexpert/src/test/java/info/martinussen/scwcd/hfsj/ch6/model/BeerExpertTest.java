package info.martinussen.scwcd.hfsj.ch6.model;

import junit.framework.TestCase;

public class BeerExpertTest extends TestCase {

	BeerExpert testExpert = null;

	public BeerExpertTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		testExpert = new BeerExpert();
	}

	@Override
	protected void tearDown() throws Exception {
		testExpert = null;
		super.tearDown();
	}

	public void testConstructor() throws Exception {
		assertNotNull(testExpert);
	}

	public void testAdvice1() throws Exception {
		NextResponse advice =  testExpert.getAdvice("");
		assertNotNull(advice);
	}

	public void testAdvice2() throws Exception {
		String[] expectedMessages = new String[] {"Dark", "Amber", "Pale"};
		NextResponse advice =  testExpert.getAdvice("");
		assertEquals(3, advice.getMessages().length);
		assertFalse(advice.isFinalAdvice());
		for (int i = 0; i < advice.getMessages().length; i++){
			assertEquals(expectedMessages[i], advice.getMessages()[i]);
		}
	}

	public void testAdvice3() throws Exception {
		String[] expectedMessages = new String[] {"Cheap", "Regular", "Exclusive"};
		NextResponse advice =  testExpert.getAdvice("");
		advice = testExpert.getAdvice(advice.getMessages()[1]);
		assertEquals(3, advice.getMessages().length);
		assertFalse(advice.isFinalAdvice());
		for (int i = 0; i < advice.getMessages().length; i++){
			assertEquals(expectedMessages[i], advice.getMessages()[i]);
		}
	}

	public void testAdvice4() throws Exception {
	  String[] expectedMessages = new String[] {"outsourced bitter ale"};
	  NextResponse advice =  testExpert.getAdvice("");
	  advice = testExpert.getAdvice(advice.getMessages()[1]);//amber
	  advice = testExpert.getAdvice(advice.getMessages()[0]);//Cheap
	  assertTrue(advice.isFinalAdvice());
	  assertEquals(1, advice.getMessages().length);
    assertEquals(expectedMessages[0], advice.getMessages()[0]);
	}

	public void testAdvice5() throws Exception {
    String[] expectedMessages = new String[] {"leffe blonde"};
    NextResponse advice =  testExpert.getAdvice("");
    advice = testExpert.getAdvice(advice.getMessages()[1]);//amber
    advice = testExpert.getAdvice(advice.getMessages()[2]);//exclusive
    assertTrue(advice.isFinalAdvice());
    assertEquals(1, advice.getMessages().length);
    assertEquals(expectedMessages[0], advice.getMessages()[0]);
  }
	
	public void testAdvice6() throws Exception {
	  String[] expectedMessages = new String[] {"tuborg classic"};
	  NextResponse advice =  testExpert.getAdvice("");
	  advice = testExpert.getAdvice(advice.getMessages()[1]);//amber
	  advice = testExpert.getAdvice(advice.getMessages()[1]);//regular
	  assertTrue(advice.isFinalAdvice());
	  assertEquals(1, advice.getMessages().length);
	  assertEquals(expectedMessages[0], advice.getMessages()[0]);
	}

	public void testAdvice7() throws Exception {
	  String[] expectedMessages = new String[] {"gammel carlsberg porter"};
	  NextResponse advice =  testExpert.getAdvice("");
	  advice = testExpert.getAdvice(advice.getMessages()[0]);//dark
	  advice = testExpert.getAdvice(advice.getMessages()[0]);//cheap
	  assertTrue(advice.isFinalAdvice());
	  assertEquals(1, advice.getMessages().length);
	  assertEquals(expectedMessages[0], advice.getMessages()[0]);
	}

	public void testAdvice8() throws Exception {
	  String[] expectedMessages = new String[] {"carls dark abbey ale"};
	  NextResponse advice =  testExpert.getAdvice("");
	  advice = testExpert.getAdvice(advice.getMessages()[0]);//dark
	  advice = testExpert.getAdvice(advice.getMessages()[2]);//exclusive
	  assertTrue(advice.isFinalAdvice());
	  assertEquals(1, advice.getMessages().length);
	  assertEquals(expectedMessages[0], advice.getMessages()[0]);
	}
	
}

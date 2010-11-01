package info.martinussen.jsptut.user;

import junit.framework.TestCase;

public class TestUserData extends TestCase {
	private UserData testUserData;

	protected void setUp() throws Exception {
		testUserData = new UserData();
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Tests that noArg constructor indeed returns a UserData object
	 */
	public void testUserData() {
		assertNotNull(testUserData);
		assertTrue(testUserData instanceof UserData);
	}
	
	public void testSetUsername(){
		testUserData.setUsername("Hansemann Luchter");
		assertEquals("Hansemann Luchter", testUserData.getUsername());
	}

	public void testEquals() {
		testUserData.setEmail("hma@mail.dk");
		UserData otherTestUserData = new UserData();
		otherTestUserData.setEmail("hma@mail.dk");
		assertEquals(testUserData, otherTestUserData);
	}
	
	public void testEquals2(){
		testUserData.setEmail("hma@mail.dk");
		UserData otherTestUserData = new UserData();
		otherTestUserData.setEmail("hby@pfa.dk");
		assertFalse(testUserData.equals(otherTestUserData));
	}

	public TestUserData(String name) {
		super(name);
	}
}

package info.martinussen.jsptut.user;

import javax.print.attribute.standard.MediaSize.Other;

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

	public void testEquals() {
		testUserData.setEmail("hma@mail.dk");
		UserData otherTestUserData = new UserData();
		otherTestUserData.setEmail("hma@mail.dk");
		assertEquals(testUserData, otherTestUserData);
	}

	public TestUserData(String name) {
		super(name);
	}
}

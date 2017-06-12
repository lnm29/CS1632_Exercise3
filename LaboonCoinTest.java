import static org.junit.Assert.*;

import org.junit.*;

/*
*	JUST AS A NOTE:
*
*	Ideally, each test should test exactly one method.
*	Each method needs at least 3 tests
*	I accidently wrote one for mine(). Im just gonna leave it at this point.
*
*	Heres what we have so far:
*
*	Method				# of tests		Status
*	createBlock()		3 ?				In Progress
*	getBlockChain()		2 ?				In Progress	(Could use some help with this one.  Not sure what other corner cases to test)
*	hash()				3				Done
*	validHash			3				Done
*	
*	Total				11 ?
*	Needed				1	
*/
public class LaboonCoinTest {

	//	Creates an instance of LaboonCoin
	//	prior to each test
	LaboonCoin l = null;
	@Before
	public void init(){
		l = new LaboonCoin();		
	}
	
    //	Assert that creating a new LaboonCoin instance
    //	does not return a null reference
    @Test
    public void testLaboonCoinExists() {
		assertNotNull(l);	
	}
    
	//	Asserts that the blockchain has been initialized
	@Test
	public void testBlockChainExists(){
		assertNotNull(l.blockchain);
	}
	
	//	Test that the program is capable of
	//	outputting empty blockchain
	@Test
	public void testEmptyPrint(){
		assertEquals(l.getBlockChain(), "");
	}
	
	//	Tests the happy path of the hash function
	@Test
	public void testHappyHash(){
		assertEquals(l.hash("boo"), 1428150834);
		assertEquals(l.hash("quock"), 2034739681);
	}
	
	//	Tests corner case of empty hash
	//	to ensure initial hash value
	//	remains unchanged
	@Test
	public void testEmptyHash(){
		assertEquals(l.hash(""), 10000000);
	}
	
	//	Tests corner case of a very long hash
	@Test
	public void testLongHash(){
		assertEquals(l.hash("Did you ever hear the tragedy of Darth Plagueis the wise"), -1751869620);
	}
	
	//	Tests happy path of variables with the exact number
	//	of zeros in hex as difficulty
	@Test
	public void testEqualDifficulty(){
		assertTrue(l.validHash(3, 1038730));
		assertTrue(l.validHash(2, 16619695));
		assertTrue(l.validHash(6, 212));
	}
	
	//	Tests edge cases of hashes with less difficulty than
	//	necessary.
	@Test
	public void testLessDifficulty(){
		assertTrue(l.validHash(2, 1038730));
		assertTrue(l.validHash(1, 16619695));
		assertTrue(l.validHash(5, 212));
	}
	
	//	Tests edge cases of hashes with more difficulty than
	//	necessary.
	@Test
	public void testMoreDifficulty(){
		assertFalse(l.validHash(4, 1038730));
		assertFalse(l.validHash(3, 16619695));
		assertFalse(l.validHash(7, 212));
	}

	//	Extra test, written in error
	//	Tests for valid nonce cases based off
	//	expected deterministic nonce values.
	@Ignore("Extra")
	@Test
	public void testNonce(){
		assertEquals(l.mine("boo", 738238, 3), 1441);
		assertEquals(l.mine("quock", 1005884, 3), 553);
		assertEquals(l.mine("mars", 589727, 3), 1299);
	}
	
	//	Tests the happy path of a nonempty blockchain
	@Test
	public void testHappyBlockPrint(){
		l.blockchain.add("Johnny gave Ustes $50");
		l.blockchain.add("Krombopulos gave Michael $1000");
		l.blockchain.add("Jimmy gave Pitt $30000");
		assertEquals("Johnny gave Ustes $50" + '\n' + "Krombopulos gave Michael $1000" + '\n'  + "Jimmy gave Pitt $30000" + '\n', l.getBlockChain());
	}
	
	/*
	*	I have changed the following methods to @ignore so that i can start testing
	*	When you finish writing them please just change them back to @test
	*/
	
	//	Tests if hash has zero 0 in front, if so invalid
	@Ignore("In Progress")
	@Test
	public void testInvalidZero(){
		l.createBlock("Johnny gave Ustes $50", 0343243, 0212312, 0423432);
		l.getBlockChain();
		//assertEquals();
	}
	
	//	Tests if hash has 1 0 in front, if so invalid 
	@Ignore("In Progress")
	@Test
	public void testInvalidMultZeros(){
		l.createBlock("Johnny gave Ustes $50", 0043243, 0012312, 0023432);
		l.getBlockChain();
		//assertEquals();
	}
	
	//	Tests if hash has 3 or more in front, if so valid
	@Ignore("In Progress")
	@Test
	public void testValidZeros(){
		l.createBlock("Johnny gave Ustes $50", 0000043, 0000312, 0003432);
		l.getBlockChain();
		//assertEquals();
	}
}

import static org.junit.Assert.*;

import org.junit.*;


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

	//	Tests if hash has appropriate singular zero pad
	@Test
	public void testSingleZeroPad(){
		assertEquals("Johnny" + '|' + "0af53ccb" + '|' + "0bcf41ab" + '|' + "041a4f2b", l.createBlock("Johnny", 183844043, 198132139, 68833067));
	}
	
	//	Tests if hash has appropriate double zero pad
	@Test
	public void testDoubleZeroPad(){
		assertEquals("Johnny" + '|' + "0043243"  + '|' + "0012312" + '|' + "00423432", l.createBlock("Johnny", 43243, 12312, 23432));
	}
	
	//Tests if hash has 3 or more zero pads in the front
	@Test
	public void testMultZeroPad(){
		assertEquals("Johnny" + '|' + "00000043" + '|' + "00000312" + '|' + "00003432", l.createBlock("Johnny", 43, 312, 3432));
	}

}

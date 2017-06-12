import static org.junit.Assert.*;

import org.junit.*;

public class LaboonCoinTest {

	//	Creates an instance of LaboonCoin
	//	for testing
	@Before
	public void init(){
		LaboonCoin l = new LaboonCoin();		
	}
    	// Assert that creating a new LaboonCoin instance
    	// does not return a null reference
    	@Test
    	public void testLaboonCoinExists() {
		assertNotNull(l);	
	}
    
	//Assert that the program does not crash when
	//asked to print an empty blockchain
	@Test
	public void testNullPrint(){
		l.getBlockChain();		
	}
	
	//Tests the happy path of a nonempty blockchain
	@Test
	public void testHappyBlockPrint(){
		String expected = "Block 1 , Block 2 , Block 3.";
		l.blockchain.add("Block 1 , ");
		l.blockchain.add("Block 2 , ");
		l.blockchain.add("Block 3.");
		assertEquals(expected, l.getBlockChain());
	}
	
	//Tests the happy path of the hash function
	@Test
	public void testHash(){
		int hash1 = l.hash("boo");
		int hash2 = l.hash("quock");
		int hash3 = l.hash("loop");
		assertEquals(hash1, 1428150834);
		assertEquals(hash2, 2034739681);
		assertEquals(hash3, 3248649904);
	}
	
	@Test
	public void testEmptyHash(){
		assertEquals(l.hash(""), 10000000);
	}
	
	//	Tests happy path of variables with the exact number
	//	of zeros in hex as difficulty
	@Test
	public void testEqualDifficulty(){
		assertTrue(l.validHash(3, 1038730));
		assertTrue(l.validHash(2, 16619695));
		assertTrue(l.validHash(6, 212));
	}
	
	@Test
	public void testLessDifficulty(){
		assertTrue(l.validHash(2, 1038730));
		assertTrue(l.validHash(1, 16619695));
		assertTrue(l.validHash(5, 212));
	}
	
	@Test
	public void testMoreDifficulty(){
		assertFalse(l.validHash(4, 1038730));
		assertFalse(l.validHash(3, 16619695));
		assertFalse(l.validHash(7, 212));
	}
	
	@Test
	public void testNonce(){
		l.mine("hizzards");	
	}
    
	//Assert that the program does not crash when
	//asked to print an empty blockchain
	@Test
	public void testNullPrint(){
		LaboonCoin l = new LaboonCoin();
		l.getBlockChain();		
	}
	
	//Tests the happy path of a nonempty blockchain
	@Test
	public void testHappyBlockPrint(){
		LaboonCoin l = new LaboonCoin();
		l.createBlock("Johnny gave Ustes $50", 2343243, 1212312, 3423432);
		l.createBlock("Krombopulos gave Michael $1000", 2243324,34311888, 834849);
		l.getBlockChain();
		String Expected = "Johnny "
		assertEquals()
	}
	
	//Tests if hash has zero 0 in front, if so invalid
	@Test
	public void testInvalidZero{
		LaboonCoin l = new LaboonCoin();
		l.createBlock("Johnny gave Ustes $50", 0343243, 0212312, 0423432);
		l.getBlockChain();
		assertEquals();
	}
	
	//Tests if hash has 1 0 in front, if so invalid 
	@Test
	public void testInvalidMultZeros{
		LaboonCoin l = new LaboonCoin();
		l.createBlock("Johnny gave Ustes $50", 0043243, 0012312, 0023432);
		l.getBlockChain();
		assertEquals();
	}
	
	//Tests if hash has 3 or more in front, if so valid
	@Test
	public void testValidZeros{
		LaboonCoin l = new LaboonCoin();
		l.createBlock("Johnny gave Ustes $50", 0000043, 0000312, 0003432);
		l.getBlockChain();
		assertEquals();
	}
}

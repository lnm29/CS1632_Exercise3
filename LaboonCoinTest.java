import static org.junit.Assert.*;

import org.junit.*;

public class LaboonCoinTest {

    // Assert that creating a new LaboonCoin instance
    // does not return a null reference
    @Test
    public void testLaboonCoinExists() {
		LaboonCoin l = new LaboonCoin();
		assertNull(l);	
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

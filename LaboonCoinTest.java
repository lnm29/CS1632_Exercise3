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
}

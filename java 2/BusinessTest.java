import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BusinessTest.
 *
 * @author  Pritesh Bhole
 * @version 19 May 2015
 */
public class BusinessTest
{
    private Business business1;

    /**
     * Default constructor for test class BusinessTest
     */
    public BusinessTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        business1 = new Business("pritesh", "bhole", "gowland", "newcastle", "NE4 4NE", "inpanch");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testBusinessConstructor() 
    { 
        assertNotNull(business1);;
    }
    
    @Test
    public void testGetCompanyName() 
    {
        assertTrue(business1.getCompanyName() == "inpanch" );
    }
    
    @Test
    public void testBusinessClassToString() 
    {
       assertTrue(business1.equals(business1));
    }
    
}


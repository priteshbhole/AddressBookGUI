import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PersonalTest.
 *
 * @author  Pritesh Bhole
 * @version 19 May 2015
 */
public class PersonalTest
{
    private Personal personal1;

    /**
     * Default constructor for test class PersonalTest
     */
    public PersonalTest()
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
        personal1 = new Personal("pritesh", "bhole", "gowland", "newcastle", "NE4 4NE", "09/09/1992");
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
    public void testPersonalConstructor() 
    { 
        assertNotNull(personal1);;
    }
    
    @Test
    public void testGetDateOfBirth() 
    {
        assertTrue(personal1.getDateOfBirth() == "09/09/1992" );
    }
    
    @Test
    public void testGetFalseDateOfBirth() 
    {
        assertFalse(personal1.getDateOfBirth() == "0909" );
    }
    
    @Test
    public void testPersonalClassToString() 
    {
       assertTrue(personal1.equals(personal1));
    }
    
}

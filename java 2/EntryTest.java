import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EntryTest.
 *
 * @author  Pritesh Bhole
 * @version 19 May 2015
 */
public class EntryTest extends Exception
{
    private Entry entry1;

    /**
     * Default constructor for test class EntryTest
     */
    public EntryTest()
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
       entry1 = new Entry("pritesh", "bhole", "gowland", "newcastle", "NE4 4NE");
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
    public void testConstructor() 
    { 
        assertNotNull(entry1);;
    }
    
    @Test
    public void testGetFirstName() 
    {
        assertTrue(entry1.getFirstName() == "pritesh" );
    }
    
    @Test
    public void testGetLastName() 
    {
        assertTrue(entry1.getLastName() == "bhole" );
    }

    @Test
    public void testGetTown() 
    {
        assertTrue(entry1.getTown() == "newcastle" );
    }
    
    @Test
    public void testGetStreet() 
    {
        assertTrue(entry1.getStreet() == "gowland" );
    }
    
    @Test
    public void testGetPostCode() 
    {
        assertTrue(entry1.getPostCode() == "NE4 4NE" );
    }
    
    @Test
    public void testInvalidPostCode()
    {
        Entry entry2 = new Entry("","","","","");
        Entry entry3 =new Entry("pr","bh","gowland", "newcastle", "NE4NE");
        assertTrue(entry2.getPostCode() == "???" );
        assertTrue(entry3.getPostCode() == "???" );
    }
    
    @Test
    public void testToString() 
    {
        assertTrue(entry1.equals(entry1));
    }
    
    @Test 
    public void testEquals() 
    {
        Entry entry2 = new Entry("pritesh", "bhole", "gowland", "newcastle", "NE4 4NE");
        assertTrue( entry1.equals( entry2 ));
    }
    
    @Test 
    public void testNotEqual() 
    {
        Entry entry2 = new Entry("jo", "m", "gowland", "newcastle", "NE4 4NE");
        assertFalse( entry1.equals( entry2 ));
    }
    
}



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class ExtendedAddressBookTest.
 *
 * @author  Pritesh Bhole
 * @version 19 May 2015
 */
public class ExtendedAddressBookTest 
{
    /**
     * Default constructor for test class ExtendedAddressBookTest
     */
    public ExtendedAddressBookTest()
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
    public void testGetPersonalList()
    {
        Personal personal1 = new Personal("pritesh", "bhole", "gowland", "newcastle", "NE4 4NE", "09/09/1992");
        ExtendedAddressBook extended1= new ExtendedAddressBook();
        extended1.add(personal1);
        assertEquals("pritesh bhole, gowland, newcastle, NE4 4NE, 09/09/1992 \n",extended1.getPersonalList());
    }
    
    @Test
    public void testGetBusinessList()
    {
       Business business = new Business("pritesh", "bhole", "gowland", "newcastle", "NE4 4NE","inpanch");;      
       ExtendedAddressBook extended1= new ExtendedAddressBook();
       extended1.add(business);
       assertEquals("pritesh bhole, gowland, newcastle, NE4 4NE, inpanch \n",extended1.getBusinessList());
    }
}



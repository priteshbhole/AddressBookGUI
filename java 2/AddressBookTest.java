import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AddressBookTest.
 *
 * @author  Pritesh Bhole
 * @version 19 May 2015
 */
public class AddressBookTest
{
    private AddressBook addressB1;

    /**
     * Default constructor for test class AddressBookTest
     */
    public AddressBookTest()
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
        addressB1 = new AddressBook();
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
    public void testAddressBookCreated()
    {
         assertNotNull( addressB1 );
    }
    
    @Test
    public void testAddMethod()
    {
        assertEquals(0, addressB1.numberOfEntries());
       Entry entry = new Entry("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE");      
       addressB1.add(entry);
       Entry entry1 = new Entry("Max", "Payne", "gowland", "newcastle", "NE4 4NE");
       addressB1.add(entry1);
       assertEquals(2,addressB1.numberOfEntries());
    }

    @Test
    public void testPersonalAddMethod()
    {
       assertEquals(0, addressB1.numberOfEntries());
        Personal personal = new Personal("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE","09/09/1992");      
       addressB1.add(personal);
       assertEquals(1,addressB1.numberOfEntries());

    }

    @Test
    public void testBusinessAddMethod()
    {
       assertEquals(0, addressB1.numberOfEntries());
        Business business = new Business("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE","inpanch");      
       addressB1.add(business);
       assertEquals(1,addressB1.numberOfEntries());

    }
    
    @Test
    public void testIsAlreadyThere()
    {
        assertEquals(0, addressB1.numberOfEntries());
        AddressBook addressB2 = new AddressBook();
        Entry entry = new Entry("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE");
        Entry entry1 = new Entry("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE");
        addressB1.add(entry);
        addressB2.add(entry1);
        assertTrue( addressB1.isAlreadyThere(entry1));
    }
    
        @Test
    public void testIfNotAlreadyThere()
    {
        assertEquals(0, addressB1.numberOfEntries());
        AddressBook addressB2 = new AddressBook();
        Entry entry = new Entry("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE");
        Entry entry1 = new Entry("pr", "Bh", "gowland", "newcastle", "NE4 4NE");
        addressB1.add(entry);
        addressB2.add(entry1);
        assertFalse( addressB1.isAlreadyThere(entry1));
    }

    @Test
    public void testRemoveMethod()
    {
        assertEquals(0, addressB1.numberOfEntries());
        Entry entry = new Entry("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE");
        Entry entry1 = new Entry("Max", "Payne", "gowland", "newcastle", "NE4 4NE");
        Entry entry2= new Entry("sam", "smith", "gowland", "newcastle", "NE4 4NE");
        Entry entry3 = new Entry("Joe", "Halt", "gowland", "newcastle", "NE4 4NE");
        addressB1.add(entry);
        addressB1.add(entry1);
        addressB1.add(entry2);
        addressB1.add(entry3);
        addressB1.deleteEntry("pritesh Bhole");
        assertEquals(false,addressB1.isAlreadyThere(entry));
    }
    
    @Test
    public void testIfPersonNotRemoved()
    {
        assertEquals(0, addressB1.numberOfEntries());
        Entry entry = new Entry("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE");
        addressB1.add(entry);
        addressB1.deleteEntry("max payne");
        assertEquals(true,addressB1.isAlreadyThere(entry));
    }

    @Test
    public void testFindMethod()
    {
        assertEquals(0, addressB1.numberOfEntries());
        Entry entry = new Entry("pritesh", "bhole", "gowland", "newcastle", "NE4 4NE");
        addressB1.add(entry);
        assertEquals("1 match(es):\npritesh bhole, gowland, newcastle, NE4 4NE\n", addressB1.findEntry("pritesh bhole"));
    }

    @Test
    public void testIfPersonNotFound()
    {
        assertEquals(0, addressB1.numberOfEntries());
        Entry entry = new Entry("pritesh", "Bhole", "gowland", "newcastle", "NE4 4NE");
        addressB1.add(entry);
        assertEquals("'pr bh' does not occur in the book", addressB1.findEntry("pr bh"));
    }

    @Test
    public void testGetAllMethod()
    {
        assertEquals(0, addressB1.numberOfEntries());
        Entry entry = new Entry("pritesh", "bhole", "gowland", "newcastle", "NE4 4NE");
        addressB1.add(entry);
        assertEquals("1 entries:\npritesh bhole, gowland, newcastle, NE4 4NE\n", addressB1.getAll());
    }

}


















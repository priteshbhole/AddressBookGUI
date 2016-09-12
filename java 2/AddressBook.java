import java.util.ArrayList;

/**
 * Stores address book entries
 * @author Michael Brockway
 * @version 15 March 2013
 */
  public class AddressBook {
  private ArrayList<Entry> data;
    
  /**
   * Construct an empty address book
   */
  public AddressBook() {
    data = new ArrayList<Entry>();
  }

  /**
   * Determine whether an entry with same names as this one is already 
   * in the address book. Entry's equals method tests for a match.
   * @param entry to be matched
   * @return boolean indicates whether a match was found
   */
  public boolean isAlreadyThere(Entry entry) {
    if (entry == null)
      return false;
    for (Entry e: data) {
      if (e.equals(entry)) {
	      return true;
      }
    }
    return false; //we get here is there was no match
  }

  /**
   * Add an Entry to the address book
   * @param entry to be added
   * @return String indicating success or failure, including attempt
   *   to add a null Entry or a duplicate Entry
   */
  public String add(Entry entry) {
    if (entry == null)
      return "Error: null entry";
    if (isAlreadyThere(entry))
      return "Error: this name already in the book";

    boolean done = data.add(entry);    
    if (done)
      return " entry added";
    else
      return "entry could not be added"; 
  }

  /**
   * Delete Entry/s with full name matching given name
   * @param name - full name to be matched 
   * @return String indicating success or failure, including 
   *   nonexistence of any matching Entry
   */
  public String deleteEntry(String name) {
    ArrayList<Entry> deleteList = new ArrayList<Entry>();
    for (Entry e: data) {
      if (e.getName().equals(name))
        deleteList.add(e);
    }
    if (deleteList.isEmpty())
      return "'" + name + "' does not occur in the book";
  
    boolean done = data.removeAll(deleteList); 
    if (done)
      return "'" + name + "' removed";
    else
      return "'" + name + "' could not be removed";
  }

  /**
   * Find Entry/s with full name matching given name
   * @param name - full name to be matched 
   * @return String listing matched entries, or failure message 
   */
  public String findEntry(String name) {
    ArrayList<Entry> matchList = new ArrayList<Entry>();
    for (Entry e: data) {
      if (e.getName().equals(name))
        matchList.add(e);
    }
    if (matchList.isEmpty())
      return "'" + name + "' does not occur in the book";
    
    String result = "" + matchList.size() + " match(es):\n";
    for (Entry e: matchList)  
      result += e.toString() + "\n";
    return result;
  }

  /**
   * Return data structure storing Entries
   * @return the ArrayList of Entries
   */
  public ArrayList<Entry> getAddressBook() { return data; }

  /**
   * Provide a list of all Entries in the address book
   * @return String listing all entries, or failure message 
   */
  public String getAll() {
    if (data.isEmpty())
      return "No Entries Present In Book";
    
    String result = "" + data.size() + " entries:\n";
    for (Entry e: data)  
      result += e.toString() + "\n";
    return result;
  }

  /**
   * Provide a list of all full names of all Entries in the address book
   * @return String listing all names, or failure message 
   */
  public String getAllNames() {
    if (data.isEmpty())
      return "No Entries Present In Book";
    
    String result = "" + data.size() + " entries:\n";
    for (Entry e: data)  
      result += e.getName() + "\n";
    return result;
  }

  /**
   * Get number of entries in the address book
   * @return number of entries
   */
  public int numberOfEntries() {
    return data.size();
  }
}

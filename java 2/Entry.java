/**
 * Encapsulates an address book entry
 * @author Michael Brockway
 * @version 15 March 2013
 */
public class Entry {
  private String firstName;
  private String lastName;
  private String street;
  private String town;
  private String postCode;
    
  /**
   * Construct an Entry with empty fields
   */
  public Entry() {
    this("", "", "", "", "");
  }

  /**
   * Construct an Entry with fields given by parameters
   * @param fn - First name
   * @param ln - last name
   * @param st - street part of address
   * @param tn - Town
   * @param pc - Post code
   */
  public Entry(String fn, String ln, String st, String tn, String pc) {
    firstName = fn;
    lastName = ln;
    street = st;
    town = tn;
    if (pc.matches("[A-Z]{2}[0-9]{1,2} [0-9]{1,2}[A-Z]{2}"))
    { 
       postCode = pc;
    }else {
      System.err.printf("Bad postcode: '%s'\n", pc);
      postCode = "???";
    }
  }

  //Accessor methods  
  public String getFirstName() { return firstName; }
  public String getLastName()  { return lastName;  }
  /**
   * Return the full name
   * @return String containing first-name & last name separated by a space
   */
  public String getName()      { return firstName + " " + lastName; }
  public String getStreet()    { return street;    }
  public String getTown()      { return town;      }
  public String getPostCode()  { return postCode;  }

  //Modifier methods  
  /**
   * Set address parts of Entry per the given parameters
   * @param st - street part of address
   * @param tn - Town
   * @param pc - Post code
   */
  public void setAddress(String st, String tn, String pc) {
    street = st;
    town = tn;
    if (pc.matches("[A-Z]{2}[0-9]{1,2} [0-9]{1,2}[A-Z]{2}"))
    { postCode = pc;
    }else {
      System.err.printf("Bad postcode: '%s'\n", pc);
      postCode = "???";
    }
  }

  /**
   * Set name parts of address per the given parameters
   * @param fn - First name
   * @param ln - last name
   */
  public void setName(String fn, String ln) {
    firstName = fn;
    lastName = ln;
  }

  /**
   * Make a String representation of the address book entry
   * @return String representation of the entry
   */
  public String toString() {
    return getName() + ", " + street + ", " + town + ", " + postCode;
  }

  /**
   * Say whether this entry is the same as another. They are considered
   * the same if their first names agree and their last names agree.
   * @param e - another entry
   * @return true if this entry is the same as another; false otherwise
   */
  public boolean equals(Entry e) {
    return firstName.equals(e.firstName) && lastName.equals(e.lastName);
  }

} //end Entry class

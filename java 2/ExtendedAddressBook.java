import java.util.ArrayList;
/**
 * Inherits from Address Book class
 * @author Pritesh Bhole
 * @version 15 May 2015
 */
public class ExtendedAddressBook extends AddressBook
{
        
  /**
   * Empty constructor
   */
  public ExtendedAddressBook()
  {
  }
  
  /**
   *Return personal details list
   *@return String PersonalList
   */
  public String getPersonalList()
  {
      String personalList = "";
      ArrayList<Entry> data = getAddressBook();
      for ( Entry e: data )
      {
         if ( e instanceof Personal )
         {
           personalList =personalList + e.toString();
         }
      }
      return personalList;
  }
  
  /**
   *Return business details list
   *@return String BusinessList
   */  
  public String getBusinessList()
  {
      String BusinessList = "";
      ArrayList<Entry> data = getAddressBook();
      for ( Entry e: data )
      {
          if ( e instanceof Business )
          {
             BusinessList =BusinessList + e.toString();
          }
      }
      return BusinessList;
  }
    
}

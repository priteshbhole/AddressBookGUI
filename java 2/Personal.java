/**
 * Inherits from Entry class
 * @author Pritesh Bhole
 * @version 15 May 2015
 */
public class Personal extends Entry
{
    private String dateOfBirth;
   
   /**
    *Construct an Personal with fields inherited from Entry Class along with extra parameter 
    *@param dob = dateOfBirth
    */
    public Personal(String fn, String ln, String st, String tn, String pc, String dob)
   {
       super(fn, ln, st, tn, pc);
       dateOfBirth=dob;
   }
    
   /**
    *Return date of birth
    *@return String dateOfBirth
    */
    public String getDateOfBirth()
   {
       return dateOfBirth;
   }
   
   /**
    *Return first name, last name, town, street, postcode and date of birth
    *@return String PersonDetails
    */ 
   public String toString()
   {
       String toString = super.toString()+", "+dateOfBirth+" \n";
       return toString;
   }

}

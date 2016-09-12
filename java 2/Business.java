/**
 * Inherits from Entry class
 * @author Pritesh Bhole
 * @version 15 May 2015
 */
public class Business extends Entry
{
   private String companyName;
   
   /**
    *Construct an Personal with fields inherited from Entry Class along with extra parameter 
    *@param cn = companyName
    */
   public Business(String fn, String ln, String st, String tn, String pc, String cn)
   {
       super(fn, ln, st, tn, pc);
       companyName=cn;
   }
   
   /**
    *Return company name
    *@return String companyName 
    */
   public String getCompanyName()
   {
        return companyName;
   }
    
   /**
    *Return first name, last name, town, street, postcode and company name
    *@return String PersonDetails
    */ 
   public String toString()
   {
        String toString = super.toString()+", "+companyName+" \n";
        return toString;
   }
}

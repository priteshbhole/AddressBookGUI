import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Provides a Graphical User Interface for Address Book 
 * @author Pritesh Bhole
 * @version 15 May 2015
 */
public class AddressBookGUI extends JFrame implements ActionListener
{
private ExtendedAddressBook address;
private AddressBook addressBook;
private JPanel textOutput;
private JPanel panel2;
private JScrollPane scroller;

private JButton allButton = new JButton("List All");
private JButton personalButton = new JButton("List Personal");
private JButton businessButton = new JButton("List Business");
private JButton addPersonalButton = new JButton("Add Personal");
private JButton addBusinessButton = new JButton("Add Business");
private JButton findButton = new JButton("Find"); 
private JButton deleteButton = new JButton("Delete");
private JButton quitButton = new JButton("Quit");

private JLabel firstNameLabel = new JLabel("First Name",JLabel.RIGHT);
private JLabel lastNameLabel = new JLabel("Last Name",JLabel.RIGHT);
private JLabel streetLabel = new JLabel("Street",JLabel.RIGHT);
private JLabel townLabel = new JLabel("Town",JLabel.RIGHT);
private JLabel postCodeLabel = new JLabel("Post Code",JLabel.RIGHT);
private JLabel dobLabel = new JLabel("Date Of Birth",JLabel.RIGHT);
private JLabel companyNameLabel = new JLabel("Company Name",JLabel.RIGHT);

private JTextField firstNameJTextField = new JTextField(15);
private JTextField lastNameJTextField = new JTextField(15);
private JTextField streetJTextField = new JTextField(15);
private JTextField townJTextField = new JTextField(15);
private JTextField nameJTextField = new JTextField(15);
private JTextField postCodeJTextField = new JTextField(15);
private JTextField dobJTextField = new JTextField(15);
private JTextField companyNameJTextField = new JTextField(15);

private JButton enterButton = new JButton("Enter");
private String select="";
private JTextArea output = new JTextArea(30,30);

/**
  * Constructor for objects of class AddressBookGUI
  */
public AddressBookGUI()
{
    super("Address Book");
    address = new ExtendedAddressBook();
    makeFrame();
    showFrame();
}

/**
 * basic setup for the frame
 */    
private void showFrame()
{   
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
    setSize(1000,400);
    setVisible(true);
}

/**
 *  setup for the Buutons used in frame
 */     
public void buttons()
{
     JPanel buttonPanel= new JPanel();
     buttonPanel.setLayout(new GridLayout(1,1,1,1));
     buttonPanel.setBorder(BorderFactory.createEtchedBorder());
     buttonPanel.add(allButton);
     buttonPanel.add(personalButton);
     buttonPanel.add(businessButton);
     buttonPanel.add(addPersonalButton);
     buttonPanel.add(addBusinessButton);
     buttonPanel.add(deleteButton);
     buttonPanel.add(findButton);
     buttonPanel.add(quitButton);
     add(buttonPanel,BorderLayout.NORTH);
}

/**
 * setup for the buttons to perform action after getting click frame
 */ 

public void actionListner()
{
     allButton.addActionListener(this);
     personalButton.addActionListener(this);
     businessButton.addActionListener(this);
     addPersonalButton.addActionListener(this);
     addBusinessButton.addActionListener(this);
     findButton.addActionListener(this);
     deleteButton.addActionListener(this);
     quitButton.addActionListener(this);
     enterButton.addActionListener(this);
}

/**
 *  setup for the label and textfields used in frame
 */ 
public void labelAndTextFields()
{
     JPanel panel2 = new JPanel(); 
     panel2.setLayout ( new GridLayout(8,1,1,8));
     panel2.add(firstNameLabel);
     panel2.add(firstNameJTextField);
     panel2.add(lastNameLabel);
     panel2.add(lastNameJTextField);
     panel2.add(streetLabel);
     panel2.add(streetJTextField);
     panel2.add(townLabel);
     panel2.add(townJTextField);
     panel2.add(postCodeLabel);
     panel2.add(postCodeJTextField);
     panel2.add(dobLabel);
     panel2.add(dobJTextField);
     dobJTextField.setText("dd/mm/yyyy");
     panel2.add(companyNameLabel);
     panel2.add(companyNameJTextField);
     firstNameJTextField.setEditable(false);
     lastNameJTextField.setEditable(false);
     streetJTextField.setEditable(false);
     townJTextField.setEditable(false);
     postCodeJTextField.setEditable(false);
     dobJTextField.setEditable(false);
     companyNameJTextField.setEditable(false);
     enterButton.setEnabled(false);
     add(panel2,BorderLayout.WEST);
     panel2.add(enterButton);
}

/**
 * setup for the Scroll pane used in frame
 */ 
public void scrollPane()
{
     textOutput = new JPanel();
     textOutput.setLayout(new BorderLayout());
     textOutput.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
     output.setEditable(false);
     scroller = new JScrollPane(output);     
     textOutput.add(scroller);
     add(textOutput,BorderLayout.CENTER);
}

/**
 * setup to enable and disable textfield to add a personal entry 
 */     
public void addPersonal()
{
     dobJTextField.setText("");  
     companyNameJTextField.setText("");
     firstNameJTextField.setEditable(true);
     lastNameJTextField.setEditable(true);
     streetJTextField.setEditable(true);
     townJTextField.setEditable(true);
     postCodeJTextField.setEditable(true);
     dobJTextField.setEditable(true); 
     enterButton.setEnabled(true);
     dobLabel.setEnabled(true);
     companyNameLabel.setEnabled(false);
     companyNameJTextField.setEditable(false);
}

/**
 * setup to enable and disable textfield to add a business entry 
 */    
public void addBusiness()
{
     dobJTextField.setText(""); 
     firstNameJTextField.setEditable(true);
     lastNameJTextField.setEditable(true);
     streetJTextField.setEditable(true);
     townJTextField.setEditable(true);
     postCodeJTextField.setEditable(true);
     companyNameJTextField.setEditable(true);
     enterButton.setEnabled(true);
     companyNameLabel.setEnabled(true);
     dobLabel.setEnabled(false);
     dobJTextField.setEditable(false);
}

/**
 * setup to make frame 
 */    
public void makeFrame()
{
     buttons();
     labelAndTextFields();
     scrollPane();
     actionListner();
}

/**
* processes the legal click
* @param click the click pressed by the user on buttons
*/   
public void actionPerformed( ActionEvent ae)
{
      String click = ae.getActionCommand(); 
      if (click.equals("List All"))
      {
         output.setText(address.getAll());
      }
      else 
      if (click.equals("List Personal"))
      {
         output.setText(address.getPersonalList());
      }
      else 
      if (click.equals("List Business"))
      {
          output.setText(address.getBusinessList());
      }
      else
      if (click.equals("Add Personal"))
      {
          select="Add Personal";
          addPersonal();
      }
      else
      if (click.equals("Add Business"))
      {
          select="Add Business";
          addBusiness();
      }
      else
      if (click.equals("Find"))
      {
           String name = JOptionPane.showInputDialog(this,"Enter Person's Name",
                       "Person Search",JOptionPane.QUESTION_MESSAGE);   
           output.setText( address.findEntry(name));
      }
      else
      if (click.equals("Delete"))
      {
          String name = JOptionPane.showInputDialog ( this,
              "Enter Person's Name",
              "Delete a Person", 
                  JOptionPane.QUESTION_MESSAGE);
            output.setText( address.deleteEntry(name));
      }
      else
      if ( click.equals("Enter"))
      {
          output.setText( address.add(addPerson()));
          toClearTextField();
          resetButtons();
      }
      else
      if (click.equals("Quit"))
      {
          System.exit(0);
      }     
}

/**
* Return the person details
* @return entry if a perosn is added
*/
public Entry addPerson()
{
      Entry entry;
      if( select.equals("Add Personal"))
      {
         entry= createPersonal();
      }
      else
      {
         entry = createBusiness();
      }
      return entry;
}

/**
* Return the person's business details
* @return personal if a person's business is added
*/
public Personal createPersonal()
{
     String personFName=toCheckFirstNameFieldIsNotEmpty();
     String personLName =toCheckLastNameFieldIsNotEmpty();
     String streetName=toCheckStreetFieldIsNotEmpty();
     String townName=toCheckTownFieldIsNotEmpty();
     String postCode=toCheckPostCodeFieldIsNotEmptyAndValid(); 
     String dob = toCheckDateOfBirthFieldIsNotEmpty();
     if(personFName.equals("")){toCheckFirstNameFieldIsNotEmpty();}
     else
     if(personLName.equals("")){toCheckLastNameFieldIsNotEmpty();}
     else
     if(streetName.equals("")){toCheckStreetFieldIsNotEmpty();}
     else
     if(townName.equals("")){toCheckTownFieldIsNotEmpty();}
     else
     if(postCode.equals("")){toCheckPostCodeFieldIsNotEmptyAndValid();}
     else
     if(dob.equals("")){toCheckDateOfBirthFieldIsNotEmpty();}
     
     Personal personal= new Personal(personFName, personLName, streetName, townName ,postCode, dob);
     return personal;
}

/**
* Return the person's business details
* @return business if a person's business details is added
*/
public Business createBusiness()
{
     String personFName=toCheckFirstNameFieldIsNotEmpty();
     String personLName =toCheckLastNameFieldIsNotEmpty();
     String streetName=toCheckStreetFieldIsNotEmpty();
     String townName=toCheckTownFieldIsNotEmpty();
     String postCode=toCheckPostCodeFieldIsNotEmptyAndValid();  
     String companyName = toCheckCompanyNameFieldIsNotEmpty();
     if(personFName.equals("")){toCheckFirstNameFieldIsNotEmpty();}
     else
     if(personLName.equals("")){toCheckLastNameFieldIsNotEmpty();}
     else
     if(streetName.equals("")){toCheckStreetFieldIsNotEmpty();}
     else
     if(townName.equals("")){toCheckTownFieldIsNotEmpty();}
     else
     if(postCode.equals("")){toCheckPostCodeFieldIsNotEmptyAndValid();}
     else
     if(companyName.equals("")){toCheckCompanyNameFieldIsNotEmpty();}
     
     Business business= new Business(personFName, personLName, streetName, townName ,postCode, companyName);
     return business;
}
   
/**
* Return the First Name  of the person if valid.
* @return firstName if textfield is not empty
* @return null if textfield is empty
*/
public String toCheckFirstNameFieldIsNotEmpty()
{
    String firstName = firstNameJTextField.getText();
    if(firstName.equals("")||(!firstName.matches("^[\\p{L} .'-]+$")))
    {
       final JPanel panel = new JPanel();
       JOptionPane.showMessageDialog(panel, "Enter person's First Name", "Error",
       JOptionPane.ERROR_MESSAGE);
       return null;
    }
    else
    {
     return firstName;
    }
}
    
/**
* Return the Last Name  of the person if valid.
* @return lastName if textfield is not empty
* @return null if textfield is empty
*/
public String toCheckLastNameFieldIsNotEmpty()
{
    String lastName = lastNameJTextField.getText();
    if(lastName.equals("")||(!lastName.matches("^[\\p{L} .'-]+$")))
    {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, "Enter person's Last Name", "Error",
        JOptionPane.ERROR_MESSAGE);
        return null;
    }
     else
    {
     return lastName;
    }
}

/**
* Return the Street Name if valid.
* @return street if textfield is not empty
* @return null if textfield is empty
*/
public String toCheckStreetFieldIsNotEmpty()
{
    String street = streetJTextField.getText();
    if(street.equals(""))
    {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, "Enter Street Name", "Error",
        JOptionPane.ERROR_MESSAGE);
        return null;
    }
    else
    {
     return street;
    }
}

/**
* Return the Town Name if valid.
* @return town if textfield is not empty
* @return null if textfield is empty
*/
public String toCheckTownFieldIsNotEmpty()
{
    String town = townJTextField.getText();
    if(town.equals(""))
    {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, "Enter Town Name", "Error",
        JOptionPane.ERROR_MESSAGE);
        return null;
    }
    else
    {
     return town;
    }
}

/**
* Return the  Post Code if valid.
* @return postCode if textfield is not empty and post code is valid
* @return null if textfield is empty or post code is not valid
*/
public String toCheckPostCodeFieldIsNotEmptyAndValid()
{
   String postCode = postCodeJTextField.getText();
   if((postCode.equals(""))||(!postCode.matches("^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$")))
    {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, "Enter Post Code and in UK Format", "Error",
        JOptionPane.ERROR_MESSAGE);
        return null;
    }
    else
    {
     return postCode;
    }
}

/**
* Return the date of birth if valid.
* @return dob if textfield is not empty
* @return null if textfield is empty
*/
public String toCheckDateOfBirthFieldIsNotEmpty()
{
    String dob = dobJTextField.getText();
    if(dob.equals("")||(!dob.matches("[0-9]{1,2}[/\\\\]{1}[0-9]{1,2}[/\\\\][0-9]{4}")))
    {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, "Enter Date of Birth in dd/mm/yyyy format", "Error",
        JOptionPane.ERROR_MESSAGE);
        return null;
    }
    else
    {
     return dob;
    }
}

/**
* Return the company name if valid.
* @return companyName if textfield is not empty
* @return null if textfield is empty
*/
public String toCheckCompanyNameFieldIsNotEmpty()
{
    String companyName = companyNameJTextField.getText();
    if(companyName.equals(""))
    {
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, "Enter Company Name", "Error",
        JOptionPane.ERROR_MESSAGE);
        return null;
    }
    else
    {
     return companyName;
    }
}

/**
* To clear text fields
*/
public void toClearTextField()
{
     firstNameJTextField.setText("");
     lastNameJTextField.setText("");
     streetJTextField.setText("");
     townJTextField.setText("");
     postCodeJTextField.setText("");
     dobJTextField.setText(""); 
     companyNameJTextField.setText("");
     companyNameJTextField.setText("");
}

/**
* To Reset Buttons 
*/   
public void resetButtons()
{
     addPersonalButton.setEnabled(true);
     addBusinessButton.setEnabled(true);
     deleteButton.setEnabled(true);    
     findButton.setEnabled(true);
}
       
}


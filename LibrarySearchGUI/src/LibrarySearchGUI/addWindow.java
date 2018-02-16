/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearchGUI;
import LibrarySearch.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class that creates and manages user interactions for a GUI window corresponding to the add window for
 * the LibrarySearch Managing application
 * @author ccantwel
 */
public class addWindow extends JFrame implements ActionListener
{
/*INSTANCE VARIABLES*/
/*Width of the window in pixels*/
public static final int WIDTH = 800;
/*height of the window in pixels*/
public static final int HEIGHT = 600;
/*panel containing all of the text fields used for user input for the window, as well as error messages*/
private JPanel textInputPanel;
/*panel containing the reset and add buttons for the window*/
private JPanel buttonPanel;
/*button that, when clicked, resets the text boxes in the window so that the user can try again*/
private JButton resetButton;
/*button that, when clicked, attempts to add a reference to the system based on the information in the 
 * text fields*/
private JButton addButton;
/*Combo box for the type of reference(Book or Journal)*/
protected referenceBox type;
/*Text field for the call number of the reference*/
protected JTextField callNumber;
/*Text field for the authors of the reference (books only)*/
protected JTextField authors;
/*Text field for the title of the reference*/
protected JTextField title;
/*Text field for the publisher of the reference (books only)*/
protected JTextField publisher;
/*Text field for the publishing organization of the reference (journals only)*/
protected JTextField organization;
/*Text field for the publishing year of the reference*/
protected JTextField year;
/*labels for the authors, publisher, and organization text fields*/
protected JLabel authorsInst;
protected JLabel publisherInst;
protected JLabel organizationInst;
/*Text area that is responsible for displaying any error messages that may be 
 * generated during creating a reference and adding it to the list.
 */
public static JTextArea messageDisplay;

/*main method that can be used for testing purposes*/
public static void main(String[] args)
{
addWindow theAddWindow = new addWindow();
theAddWindow.setVisible(true);
}
/*General constructor that takes no arguments, but creates a window 800 pixels wide by 600 pixels long, 
 * and adds an add menu with close window option, an instruction label, as well as labeled
 * text fields for user to enter a reference's call number, title, and year, as well as authors and 
 * publisher (for books), or organization (for journals).  A combo box that allows the user to select 
 * book or journal, reset and add buttons, and a text area used to display error 
 * messages, are also added to the window.
 */
public addWindow()
{
super ("Library Search");
setSize(WIDTH, HEIGHT);
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
JMenu addMenu = new JMenu("Commands");
JMenuItem closeChoice = new JMenuItem("Close Window");
closeChoice.addActionListener(this);
addMenu.add(closeChoice);
JMenuBar bar = new JMenuBar( );
bar.add(addMenu);
setJMenuBar(bar);
JLabel addLabel = new JLabel("Adding a reference (please maximize window to use all features)");
add(addLabel, BorderLayout.NORTH);
textInputPanel = new JPanel();
textInputPanel.setLayout(new GridLayout(18, 1));
JLabel typeInst = new JLabel("Type Below (Book or Journal)");
textInputPanel.add(typeInst);
type = new referenceBox();
textInputPanel.add(type.getReferenceList());
JLabel callNumberInst = new JLabel("Call Number below");
textInputPanel.add(callNumberInst);
callNumber = new JTextField(100);
textInputPanel.add(callNumber);
authorsInst = new JLabel("Authors below");
textInputPanel.add(authorsInst);
authors = new JTextField(100);
textInputPanel.add(authors);
JLabel titleInst = new JLabel("Title Below");
textInputPanel.add(titleInst);
title = new JTextField(100);
textInputPanel.add(title);
publisherInst = new JLabel("Publisher Below");
textInputPanel.add(publisherInst);
publisher = new JTextField(100);
textInputPanel.add(publisher);
organizationInst = new JLabel("Organization Below");
textInputPanel.add(organizationInst);
organizationInst.setVisible(false);
organization = new JTextField(100);
textInputPanel.add(organization);
organization.setVisible(false);
JLabel yearInst = new JLabel("Year below (in range from 1000 to 9999)");
textInputPanel.add(yearInst);
year = new JTextField(100);
textInputPanel.add(year);
JLabel newLabel = new JLabel("Messages Below");
textInputPanel.add(newLabel);
messageDisplay = new JTextArea(40, 100);
messageDisplay.setBackground(Color.WHITE);
messageDisplay.setEditable(false);
messageDisplay.setLineWrap(true);
messageDisplay.setWrapStyleWord(true);
/*http://stackoverflow.com/questions/10274750/java-swing-setting-margins-on-textarea-with-line-border  Nov 26 2013 */
Border border = BorderFactory.createLineBorder(Color.BLACK);
messageDisplay.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
JScrollPane scrolledText = new JScrollPane(messageDisplay);
scrolledText.setHorizontalScrollBarPolicy(
JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
textInputPanel.add(scrolledText);
add(textInputPanel, BorderLayout.WEST);
buttonPanel = new JPanel();
buttonPanel.setLayout(new GridLayout(15, 1));
JLabel e1 = new JLabel("");
buttonPanel.add(e1);
JLabel e2 = new JLabel("");
buttonPanel.add(e2);
JLabel e3 = new JLabel("");
buttonPanel.add(e3);
JLabel e4 = new JLabel("");
buttonPanel.add(e4);
resetButton = new JButton("Reset");
AddResetListener buttonEar = new AddResetListener();
resetButton.addActionListener(buttonEar);
buttonPanel.add(resetButton);
AddListener attemptAdd = new AddListener();
addButton = new JButton("Add");
addButton.addActionListener(attemptAdd);
buttonPanel.add(addButton);
add(buttonPanel, BorderLayout.CENTER);
}

/*Method responsible for managing what happens when user clicks on something in the menu; 
 * just closes the window
 */
@Override
public void actionPerformed(ActionEvent e)
{
String buttonString = e.getActionCommand( );
if (buttonString.equals("Close Window")){
this.dispose();
}
else
System.out.println("Unexpected error.");
}
}
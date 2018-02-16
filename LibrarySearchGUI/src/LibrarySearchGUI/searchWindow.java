/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearchGUI;
import LibrarySearch.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class that creates and manages user interactions for a GUI window corresponding to the search window 
 * for the LibrarySearch application 
 * @author ccantwel
 */
public class searchWindow extends JFrame implements ActionListener
{
/*INSTANCE VARIABLES*/
/*Width of the window in pixels*/
public static final int WIDTH = 800;
/*height of the window in pixels*/
public static final int HEIGHT = 600;
/*panel containing all of the text fields used for user input for the window, as well as error messages*/
private JPanel textInputPanel;
/*panel containing the reset and search buttons for the window*/
private JPanel buttonPanel;
/*button that, when clicked, resets the text boxes in the window so that the user can try again*/
private JButton resetButton;
/*button that, when clicked, attempts to search for references to the system based on the information 
 * in the text fields, and display and found references on the screen*/
private JButton searchButton;
/*Text field for the type of reference(Book or Journal)*/
protected JTextField type;
/*Text field for the call number of the reference to search for*/
protected JTextField callNumber;
/*Text field for the title keywords of the reference(s) to search for*/
protected JTextField title;
/*Text fields for the publishing year (to search for) of the reference (start and end)*/
protected JTextField startYear;
protected JTextField endYear;

/*Text area that displays the references matching the user's specified information.  Also, 
 * searchResultDisplay is responsible for displaying any error messages that may be 
 * generated during searching for and displaying references.
 */
public static JTextArea searchResultDisplay;

/*main method that can be used for testing purposes*/
public static void main(String[] args)
{
searchWindow theSearchWindow = new searchWindow();
theSearchWindow.setVisible(true);
}
/*General constructor that takes no arguments, but creates a window 800 pixels wide by 600 pixels long, 
 * and adds a search menu with close window option, an instruction label, as well as labeled
 * text fields for user to enter a reference's call number, type, title keywords, and years to start 
 * and end their search in.  Reset and search buttons, and a text area used to display error 
 * messages and search results, are also added to the window.
 */
public searchWindow()
{
super ("Library Search");
setSize(WIDTH, HEIGHT);
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
JMenu searchMenu = new JMenu("Commands");
JMenuItem closeChoice = new JMenuItem("Close Window");
closeChoice.addActionListener(this);
searchMenu.add(closeChoice);
JMenuBar bar = new JMenuBar( );
bar.add(searchMenu);
setJMenuBar(bar);
JLabel searchLabel = new JLabel("Searching for references (please maximize window to use all features)");
add(searchLabel, BorderLayout.NORTH);
textInputPanel = new JPanel();
textInputPanel.setLayout(new GridLayout(16, 1));
JLabel typeInst = new JLabel("Type To Search For Below (Book or Journal)");
textInputPanel.add(typeInst);
type = new JTextField(100);
textInputPanel.add(type);
JLabel callNumberInst = new JLabel("Call Number To Search For below");
textInputPanel.add(callNumberInst);
callNumber = new JTextField(100);
textInputPanel.add(callNumber);
JLabel titleInst = new JLabel("Title Keywords To Search For Below");
textInputPanel.add(titleInst);
title = new JTextField(100);
textInputPanel.add(title);
JLabel startYearInst = new JLabel("Yeart To Start Searching In Below (in range from 1000 to 9999)");
textInputPanel.add(startYearInst);
startYear = new JTextField(100);
textInputPanel.add(startYear);
JLabel endYearInst = new JLabel("Yeart To End Searching In Below (in range from 1000 to 9999)");
textInputPanel.add(endYearInst);
endYear = new JTextField(100);
textInputPanel.add(endYear);
JLabel newLabel = new JLabel("Search Results Below");
textInputPanel.add(newLabel);
searchResultDisplay = new JTextArea(20, 100);
searchResultDisplay.setBackground(Color.WHITE);
searchResultDisplay.setEditable(false);
searchResultDisplay.setLineWrap(true);
searchResultDisplay.setWrapStyleWord(true);
JScrollPane scrolledText = new JScrollPane(searchResultDisplay);
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
SearchResetListener buttonEar = new SearchResetListener();
resetButton.addActionListener(buttonEar);
buttonPanel.add(resetButton);
searchButton = new JButton("Search");
SearchListener attemptSearch = new SearchListener();
searchButton.addActionListener(attemptSearch);
buttonPanel.add(searchButton);
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
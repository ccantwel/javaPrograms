/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
//import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class that creates and manages user interactions for a GUI window corresponding to the search window 
 * for the LibrarySearch application 
 * @author ccantwel
 */
public class userLoginWindow extends JFrame implements ActionListener
{
/*INSTANCE VARIABLES*/
/*Width of the window in pixels*/
public static final int WIDTH = 800;
/*height of the window in pixels*/
public static final int HEIGHT = 600;
/*panel containing all of the text fields used for user input for the window, as well as error 
 * messages.  Also contains the buttons for attempting to log in and resetting text boxes*/
private JPanel textInputPanel;
/*button that, when clicked, resets the text boxes in the window so that the user can try again*/
protected JButton resetButton;
/*button that, when clicked, attempts to allow the user to log in*/
protected JButton LoginButton;
/*button that, when clicked, closes the program after too many login attempts*/
protected JButton CloseButton;
/*button that, when clicked, attempts to allow the user to log in for user management*/
protected JButton ManageLoginButton;
/*Text field for the username of the user*/
protected JTextField username;
/*Text field for the submitted password of the user*/
protected JTextField submitPassword;


/*Text area that displays any error messages for the users
 */
public static JTextArea errorMessages;

/*main method that can be used for testing purposes*/
public static void main(String[] args)
{
userLoginWindow loginTest = new userLoginWindow();
loginTest.setVisible(true);
}
/*General constructor that takes no arguments, but creates a window 800 pixels wide by 600 pixels long, 
 * and adds a commands menu with close window option, an instruction label, as well as labeled
 * text fields for user to enter their username and password.  Reset and submit buttons, and a text area 
 * used to display error messages, are also added to the window.
 */
public userLoginWindow()
{
super ("AnonMsgBrod");
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
JLabel searchLabel = new JLabel("Screen for logging into system (please maximize window to use all features)");
add(searchLabel, BorderLayout.NORTH);
textInputPanel = new JPanel();
textInputPanel.setLayout(new GridLayout(16, 1));
JLabel nameInst = new JLabel("Type your Username in box below");
textInputPanel.add(nameInst);
username = new JTextField(100);
textInputPanel.add(username);
JLabel passwordInst = new JLabel("Type your password in box below");
textInputPanel.add(passwordInst);
submitPassword =new JTextField(140);
submitPassword.setForeground(Color.white);
textInputPanel.add(submitPassword);
JLabel messageDisplay = new JLabel("Error messages are displayed below");
textInputPanel.add(messageDisplay);
errorMessages = new JTextArea(20, 100);
errorMessages.setBackground(Color.WHITE);
errorMessages.setEditable(false);
errorMessages.setLineWrap(true);
errorMessages.setWrapStyleWord(true);
textInputPanel.add(errorMessages);

/*add buttons for closing program, as well as reset and login attempts, to interface*/
LoginButton = new JButton("Login");
LoginSubmitListener attemptLogin = new LoginSubmitListener();
LoginButton.addActionListener(attemptLogin);
textInputPanel.add(LoginButton);

ManageLoginButton = new JButton("Login-User Management");
ManageSubmitListener attemptManage = new ManageSubmitListener();
ManageLoginButton.addActionListener(attemptManage);
textInputPanel.add(ManageLoginButton);

resetButton = new JButton("Reset");
userLoginResetListener buttonEar = new userLoginResetListener();
resetButton.addActionListener(buttonEar);
textInputPanel.add(resetButton);

CloseButton = new JButton("Exit");
CloseListener exitProg = new CloseListener();
CloseButton.addActionListener(exitProg);
textInputPanel.add(CloseButton);
CloseButton.setVisible(false);

add(textInputPanel, BorderLayout.WEST);

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
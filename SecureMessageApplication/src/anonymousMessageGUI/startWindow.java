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
 * Class that creates and manages user interactions for a GUI window corresponding to the start window 
 * for the AnonMsgBrod application 
 * @author ccantwel
 */
public class startWindow extends JFrame implements ActionListener
{
/*INSTANCE VARIABLES*/
/*Width of the window in pixels*/
public static final int WIDTH = 800;
/*height of the window in pixels*/
public static final int HEIGHT = 600;
/*panel containing all of the text fields used for user input for the window, as well as error 
 * messages.  Also contains the buttons for submitting messages and resetting text boxes*/
private JPanel textInputPanel;
/*button that, when clicked, resets the text boxes in the window so that the user can try again
 (but does not reset the message display box*/
private JButton resetButton;
/*button that, when clicked, attempts to add the message to the list of messages and displays it with
 * all other messages (similar to a chat room)*/
private JButton submitButton;
/*Text field for displaying error messages*/
protected JTextField errorBox;
/*Text field for the username of the user submitting a message*/
protected JTextField username;
/*Text field for the submitted message of the user*/
protected JTextField submittedMessage;

/*Text area that displays all messages in the system in real time for the users
 */
public static JTextArea messageDisplayBox;

/*Second message display box that displays all messages in the system in real time for the users
 * (similar to the program running on a second computer)
 */
public static JTextArea messageDisplayBox2;

/*main method that can be used for testing purposes*/
public static void main(String[] args)
{
startWindow theStartWindow = new startWindow();
theStartWindow.setVisible(true);
}
/*General constructor that takes no arguments, but creates a window 800 pixels wide by 600 pixels long, 
 * and adds a commands menu with close window option, an instruction label, as well as labeled
 * text fields for user to enter a username and message.  Reset and submit buttons, and a text area used 
 * to display messages, are also added to the window.
 */
public startWindow()
{
/*Sets up window layout and places all text fields, labels and buttons in their appropriate locations*/    
super ("AnonMsgBrod");
setSize(WIDTH, HEIGHT);
setLayout(new BorderLayout());
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
JMenu startMenu = new JMenu("Commands");
JMenuItem removeMeChoice = new JMenuItem("Remove myself from system");
removeMeChoice.addActionListener(this);
startMenu.add(removeMeChoice);
JMenuItem closeChoice = new JMenuItem("Close Window");
closeChoice.addActionListener(this);
startMenu.add(closeChoice);
JMenuBar bar = new JMenuBar( );
bar.add(startMenu);
setJMenuBar(bar);
JLabel searchLabel = new JLabel("Screen for typing and viewing messages (please maximize window to use all features)");
add(searchLabel, BorderLayout.NORTH);
textInputPanel = new JPanel();
textInputPanel.setLayout(new GridLayout(16, 1));
JLabel nameInst = new JLabel("Type your Username in box below");
textInputPanel.add(nameInst);
username = new JTextField(100);
username.setEditable(false);
textInputPanel.add(username);
JLabel messageInst = new JLabel("Type your Message in box below");
textInputPanel.add(messageInst);
submittedMessage =new JTextField(140);
textInputPanel.add(submittedMessage);
JLabel errorLabel = new JLabel("Error messages are displayed below");
textInputPanel.add(errorLabel);
errorBox =new JTextField(100);
errorBox.setEditable(false);
textInputPanel.add(errorBox);
JLabel messageDisplay = new JLabel("Messages are displayed below");
textInputPanel.add(messageDisplay);
messageDisplayBox = new JTextArea(20, 100);
messageDisplayBox.setBackground(Color.WHITE);
messageDisplayBox.setEditable(false);
messageDisplayBox.setLineWrap(true);
messageDisplayBox.setWrapStyleWord(true);
messageDisplayBox.setText(new String(message.printList(ProgStart.messageList)));
JScrollPane scrolledText = new JScrollPane(messageDisplayBox);
scrolledText.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrolledText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
textInputPanel.add(scrolledText);
JLabel messageDisplay2 = new JLabel("Messages are also displayed below (second client)");
textInputPanel.add(messageDisplay2);
messageDisplayBox2 = new JTextArea(20, 100);
messageDisplayBox2.setBackground(Color.WHITE);
messageDisplayBox2.setEditable(false);
messageDisplayBox2.setLineWrap(true);
messageDisplayBox2.setWrapStyleWord(true);
messageDisplayBox2.setText(new String(message.printList(ProgStart.messageList)));
JScrollPane scrolledText2 = new JScrollPane(messageDisplayBox2);
scrolledText2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
scrolledText2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
textInputPanel.add(scrolledText2);

/*add buttons for reset and message submission to interface*/
submitButton = new JButton("Submit");
SubmitListener attemptSubmit = new SubmitListener();
submitButton.addActionListener(attemptSubmit);
textInputPanel.add(submitButton);

resetButton = new JButton("Reset");
startResetListener buttonEar = new startResetListener();
resetButton.addActionListener(buttonEar);
textInputPanel.add(resetButton);

add(textInputPanel, BorderLayout.WEST);

}

/*Method responsible for managing what happens when user clicks on something in the menu;
 * removes the logged in user from the system and closes window, or just closes the window
 */
@Override
public void actionPerformed(ActionEvent e)
{
String buttonString = e.getActionCommand( );
if (buttonString.equals("Remove myself from system")){
    String userID = new String(ProgStart.msgWindow.username.getText());
    /*attempts to remove user from the system and close window, error messages
     * resulting from exceptions are displayed in their own dedicated display box
     */
    try{
       ProgStart.userList = user.searchAndDelete(ProgStart.userList, userID);
       this.dispose();   
     }
    catch(MainUserException w) {
        ProgStart.msgWindow.errorBox.setText("ERROR: Cannot delete the main user account!");
    }    
    catch(InvalidUsernameException x){
         ProgStart.msgWindow.errorBox.setText("ERROR: Username cannot be blank!");
     }
     catch(emptyListException y){
         ProgStart.msgWindow.errorBox.setText("ERROR: No users in the system!");
     }
     catch(UserNotFoundException z){
         ProgStart.msgWindow.errorBox.setText("ERROR: Unable to find a user with that username!");
     }
     //this.dispose();    
}
else if (buttonString.equals("Close Window")){
    this.dispose();
}
else System.out.println("Unexpected error.");
}
}
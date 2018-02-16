/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.io.*;
/**
 * Class that creates and manages user interactions for a GUI window corresponding to the main window for
 * the anonymous message broadcast application (users will see this window first)
 * @author ccantwel
 */
public class ProgStart extends JFrame implements ActionListener {

 /*INSTANCE VARIABLES*/
/**
 * empty text field
 */
private JTextArea nothing;
/*arrayList containing all messages in the system*/
public static ArrayList<message> messageList = new ArrayList<message>();
/*arrayList containing all users in the system*/
public static ArrayList<user> userList = new ArrayList<user>();
/*main user account variable*/
private user mainUserAccount;
/*width of window in pixels */
public static final int WIDTH = 800;
/*height of window in pixels*/
public static final int HEIGHT = 600;
/*message counting variable*/
public static int messageCount = 0;

/*window used for typing and viewing messages*/
public static startWindow msgWindow;

/*window used for logging into system*/
public static userLoginWindow loginWindow;

/*window used for adding and deleting users*/
public static userManageWindow manageWindow;
/*main method that operates the main window for the application (users see this window first)*/
public static void main(String[] args)
{
        ProgStart gui = new ProgStart();
        gui.setVisible( true);
}

/*General constructor that takes no arguments, but creates a window 800 pixels wide by 600 pixels long, 
 * and adds a file menu with add, search, and quit options, as well as an instruction label.
 */
public ProgStart()
{
super ("AnonMsgBrod");
setSize(WIDTH, HEIGHT);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());
JMenu mainMenu = new JMenu("Commands");
JMenuItem loginChoice = new JMenuItem("Login");
loginChoice.addActionListener(this);
mainMenu.add(loginChoice);
JMenuItem quitChoice = new JMenuItem("Quit");
quitChoice.addActionListener(this);
mainMenu.add(quitChoice);
JMenuBar bar = new JMenuBar( );
bar.add(mainMenu);
setJMenuBar(bar);
nothing = new JTextArea(10, 20);
nothing.setEditable(false);
nothing.setBackground(Color.WHITE);
add(nothing, BorderLayout.NORTH);
JTextArea instructions = new JTextArea(60, 100);

Font font = new Font("Verdana", Font.BOLD, 24);
instructions.setFont(font);
instructions.setForeground(Color.BLACK);

instructions.setEditable(false);
instructions.setLineWrap(true);
instructions.setWrapStyleWord(true);
instructions.setText("                     Welcome to AnonMsgBrod!!\nThis program simulates anonymous message\nbroadcasting.\n" + 
        "Clicking the X in top corner simply exits the program\nwithout saving anything");
add(instructions, BorderLayout.CENTER);

/*set up message window but don't display it just yet*/
msgWindow = new startWindow();
msgWindow.setVisible(false);
/*set up login window but don't display it just yet*/
loginWindow = new userLoginWindow();
loginWindow.setVisible(false);
/*set up user management window but don't display it just yet*/
manageWindow = new userManageWindow();
manageWindow.setVisible(false);
/*set up the main user account*/
mainUserAccount = new user();
userList.add(mainUserAccount);
}

/*Method responsible for managing what happens when user clicks on something in the menu; creates 
 * required window, or just exits the program
 */
    @Override
public void actionPerformed(ActionEvent e)
{
String buttonString = e.getActionCommand( );
if(buttonString.equals("Login")){
    this.loginWindow = new userLoginWindow();
    this.loginWindow.setVisible(true);
}

else if (buttonString.equals("Quit")){
      System.exit(0);
}
else
System.out.println("Unexpected error.");
}
}

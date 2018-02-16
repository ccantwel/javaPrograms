/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearchGUI;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import LibrarySearch.*;
import java.io.*;
/**
 * Class that creates and manages user interactions for a GUI window corresponding to the main window for
 * the LibrarySearch application (users will see this window first)
 * @author ccantwel
 */
public class mainWindow extends JFrame implements ActionListener {

 /*INSTANCE VARIABLES*/
/**
 * empty text field
 */
private JTextArea nothing;
/*arrayList containing all references in the system*/
public static ArrayList<Reference> referenceList = new ArrayList<Reference>();
/*width of window in pixels */
public static final int WIDTH = 800;
/*height of window in pixels*/
public static final int HEIGHT = 600;
/*window used for adding references to the system*/
public static addWindow theAddWindow;
/*window used for searching for references in the system*/
public static searchWindow theSearchWindow;
/*hash map that contains lists of integer indexes that correspond to the references in the list
 * that contain each of the title keywords in the system*/
public static HashMap <String, ArrayList<Integer>> titleIndex;
/* object responsible for reading from and writing to files, as well as updating the titleIndex map*/
public static FileIO doStuffWithFile; 
/*input and output files*/
private String inFile;
private String outFile;

/*main method that operates the main window for the application (users see this window first)*/
public static void main(String[] args)
{
    /*user must specify two string arguments, representing the input and output files, on program launch
     * otherwise program will not run*/
    if(args.length < 2)
    {
        System.out.print("Error, no input or output files specified\n");
        System.exit(0);
    }
    else {
        mainWindow gui = new mainWindow();
        gui.inFile = new String(args[0]);
        gui.outFile = new String(args[1]);
        // Open the input file for reading, read in all data from file and set up list of references
        doStuffWithFile = new FileIO();
        referenceList = doStuffWithFile.readDataFromFile(gui.inFile);
        //set up hash map of title of indexes after reading in file, as well as after adding references
        titleIndex = doStuffWithFile.updateTitleIndex(referenceList);
        gui.setVisible( true);
    }
    }

/*General constructor that takes no arguments, but creates a window 800 pixels wide by 600 pixels long, 
 * and adds a file menu with add, search, and quit options, as well as an instruction label.
 */
public mainWindow()
{
super ("Library Search");
setSize(WIDTH, HEIGHT);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new BorderLayout());
JMenu mainMenu = new JMenu("Commands");
JMenuItem newChoice = new JMenuItem("Add");
newChoice.addActionListener(this);
mainMenu.add(newChoice);
JMenuItem searchChoice = new JMenuItem("Search");
searchChoice.addActionListener(this);
mainMenu.add(searchChoice);
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

/*http://www.javaprogrammingforums.com/java-swing-tutorials/39-how-change-jtextarea-font-font-size-color.html  
 * Nov 24 2013*/
Font font = new Font("Verdana", Font.BOLD, 24);
instructions.setFont(font);
instructions.setForeground(Color.BLACK);

instructions.setEditable(false);
instructions.setLineWrap(true);
instructions.setWrapStyleWord(true);
instructions.setText("                     Welcome to Library Search!!\nTo begin, please select a command from the commands menu." + 
        "  Commands include adding a reference, searching for references, and quitting the program with saving the reference data.\n"
        + "Clicking the X in top corner simply exits the program without saving anything");
add(instructions, BorderLayout.CENTER);
theAddWindow = new addWindow();
theAddWindow.setVisible(false);
theSearchWindow = new searchWindow();
theSearchWindow.setVisible(false);
}

/*Method responsible for managing what happens when user clicks on something in the menu; creates 
 * required window, or just exits the program
 */
public void actionPerformed(ActionEvent e)
{
String buttonString = e.getActionCommand( );

if (buttonString.equals("Add"))
{
    this.theAddWindow = new addWindow();
    this.theAddWindow.setVisible(true);
}
else if(buttonString.equals("Search")){
    this.theSearchWindow = new searchWindow();
    this.theSearchWindow.setVisible(true);
}

else if (buttonString.equals("Quit")){
    boolean successFileWrite = doStuffWithFile.writeDataToFile(referenceList, outFile);
    System.exit(0);
}
else
System.out.println("Unexpected error.");
}
}

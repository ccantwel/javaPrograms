NAME: CHANCE CANTWELL		   STUDENT ID #: 0792138
COURSE: CIS4110                ASSIGNMENT: 1 – ANONYMOUS MESSAGE BROADCAST
DATE: January 31, 2017
_________________________________________________________________________
COMPILING THE PROGRAM

In order to compile this program, navigate to the src directory and type the following:
javac anonymousMessage/*.java anonymousMessageGUI/*.java

RUNNING THE PROGRAM

To run the project from the command line, remain in the directory where the program was compiled and type the following:

java anonymousMessageGUI.ProgStart

ABOUT THE PROGRAM, OPERATING INSTRUCTIONS

This is a simulation programming for anonymous message broadcasting called AnonMsgBrod.  In this program, the user is allowed to log in, enter messages, and have them displayed in 2 message boxes, or 2 "clients," in real time, similar to a chat room that may be found on the Internet.  The user who is submitting a 
message has no idea who the other users are that have submitted messages before and after them, as the user name of each user is not displayed along without the message the user submitted; instead of user names, the program instead displays "Message x", where x is a integer.  For example, if a message is the first
one to be submitted, then the value of x would be 1.  The program also has a means for users to add and remove themselves from the system, as well as a means to
add and delete users through a User Management window by means of a main user account.  

In order to access the message functions of the program, users can click on Commands in the top left corner of the ProgStart window (window that appears when
the user first starts the program), and select Login.  From there, they can add themselves to the system by typing in a user name and password into the text
boxes on the loginWindow, afterwards clicking on the Login button.  Clicking on the Reset button resets the text boxes allowing the user to try again.  A message will appear to inform the user that they have been successfully added to the system, and inform them to click on the Login button a second time to 
continue.  If their user account already exists in the system with a matching password, the loginWindow will automatically close without displaying any messages.  In both cases, the user is directed to the StartWindow, where they can enter messages and click on the Submit button to view them in the display boxes provided.  Clicking on the Reset button resets the message text box so that they can try again.  If a user would like to remove themselves from the 
system, they can do so by clicking on Commands in the upper-left corner of the window, and selecting "Remove myself from the system" from the menu.  Doing so
will close the window while removing their user account from the system.

In order to access the User Management functions of the program, a user can follow the same procedure as they would to access the access functions, however, 
instead of clicking on the Login button on the loginWindow, they would click on a button that says "Login - User Management".  There is main user account that
has been given sole access to these features, and the user name and password for this account are shown below:

User name: root
Password: 4gt-+-8yXyJTBLZ6

Once logged into the User Management area, the main user can add or delete whichever user they would like.  By selecting Add or Delete in the operation select
box, the main user is able to have the required fields displayed for them (such as user name and password for add, or just user name for delete), where they can type in the user name and/or password that they wish.  Clicking on the Submit button completes the operation, or displays an error message should the 
operation fail.  Clicking on the Reset button resets all text boxes so that a second attempt can be made if required.

All user names and messages are saved together as message objects and placed in a single ArrayList that can grow in size as required.  In addition, all user names and passwords are grouped together in user objects and placed in their own ArrayList, that can shrink and grow as required.

For all windows of the program, clicking on an X in the top left or right corner of the window, or selecting Close Window on a Commands menu (upper-left
corner), causes the window to exit.  Clicking on one of the same items in the ProgStart window causes the entire program to shut down, deleting all user
accounts and submitted messages in the process (except for the main user account).

Important note about logging in: Users only have a maximum of 5 login attempts to the system.  A login attempt is when they type in a legitimate user name that
is in the system, but do not type in the correct password for that user.  After the fifth attempt, any subsequent login attempts result in the user being "locked out", meaning that they are forced to click on a button that closes the entire program.


LIMITATIONS AND SUGGESTIONS FOR IMPROVEMENT

There are a few limitations present in the current design of the program.  For example, any text box where it is required to enter a password has its text colour set to white; while this prohibits users from seeing the text they are typing in, they will be able to see the text if they highlight it in the event they need to remove or edit the text.  All user names and passwords are grouped together in individual objects, which are all saved in an ArrayList, limiting 
the security of the system as passwords can be retrieved and guessed relatively easily.  In addition, all user accounts (except for the main user account) and
all messages are removed from the system when the program exits.  In order to improve on the design of the program, a text masking procedure could be implemented on any text box requiring a password as input (e.g. replacing all typed characters with an asterisk (*).  The security of the program could be improved by saving all passwords to a location different from the user names, and applying an encryption or similar algorithm to that memory space.  The information for user accounts and messages could be saved to a file when the program terminates, and then read in when the program opens, in order to ensure the state of the program is able to remain the same during exiting and entering.  These improvements can be made as the user or creator develops their skills and has more experience using the Java programming language.

(C) CHANCE CANTWELL
JANUARY 31, 2017

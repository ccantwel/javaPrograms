/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessage;
import anonymousMessageGUI.*;

/**
 * Exception class that deals with finding the main user account in the userList (unable to delete it)
 * @author ccantwel
 */

public class MainUserException extends Exception {
public MainUserException()
{
super("ERROR: Cannot delete the main user account!");
}
}   


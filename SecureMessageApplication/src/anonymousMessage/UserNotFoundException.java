/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessage;
import anonymousMessageGUI.*;

/**
 * Exception class that deals with not being able to find username in system
 * @author ccantwel
 */

public class UserNotFoundException extends Exception {
public UserNotFoundException()
{
super("ERROR: Unable to find a user with that username!");
}
}   


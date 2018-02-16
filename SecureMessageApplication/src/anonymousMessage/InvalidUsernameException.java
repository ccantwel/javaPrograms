/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessage;
import anonymousMessageGUI.*;

/**
 * Exception class that deals with invalid usernames (usernames cannot be blank)
 * @author ccantwel
 */

public class InvalidUsernameException extends Exception {
public InvalidUsernameException()
{
super("ERROR: Username cannot be blank for submitted messages!");
}
}   


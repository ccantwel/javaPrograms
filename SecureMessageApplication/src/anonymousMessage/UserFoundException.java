/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessage;
import anonymousMessageGUI.*;

/**
 * Exception class that deals with being able to find username in system when
 * attempting to add a user
 * @author ccantwel
 */

public class UserFoundException extends Exception {
public UserFoundException()
{
super("ERROR: That user is already in the system!");
}
}   


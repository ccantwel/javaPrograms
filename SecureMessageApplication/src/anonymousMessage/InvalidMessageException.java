/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessage;
import anonymousMessageGUI.*;

/**
 * Exception class that deals with invalid messages (messages cannot be blank)
 * @author ccantwel
 */

public class InvalidMessageException extends Exception {
public InvalidMessageException()
{
super("ERROR: Users cannot submit blank messages!");
}
}   


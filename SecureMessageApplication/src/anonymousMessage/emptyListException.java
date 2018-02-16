/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessage;
import anonymousMessageGUI.*;

/**
 * Exception class that deals with empty user lists
 * @author ccantwel
 */

public class emptyListException extends Exception {
public emptyListException()
{
super("ERROR: No users in the system!");
}
}   


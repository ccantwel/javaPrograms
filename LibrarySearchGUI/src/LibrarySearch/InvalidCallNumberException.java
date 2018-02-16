/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;

/**
 * Exception class that deals with invalid call numbers (call numbers cannot be blank)
 * @author ccantwel
 */
public class InvalidCallNumberException extends Exception {
public InvalidCallNumberException()
{
super("ERROR: Call number must not be blank for a reference!");
}
}
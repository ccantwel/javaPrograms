/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;

/**
 *Exception class that deals with invalid speed (speed must be at least 0)
 * @author ccantwel
 */
public class InvalidTitleException extends Exception {
public InvalidTitleException()
{
super("ERROR: Title must not be blank for a reference!");
}
}
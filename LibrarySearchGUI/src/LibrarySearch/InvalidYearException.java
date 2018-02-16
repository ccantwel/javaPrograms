/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;

/**
 *Exception class that deals with invalid years (years can only be between 1000 and 9999
 * including 1000 and 9999)
 * @author ccantwel
 */
public class InvalidYearException extends Exception {
public InvalidYearException()
{
super("ERROR: Publishing year must be in range from 1000 to 9999 for a reference!");
}
}
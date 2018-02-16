/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearchGUI;
import LibrarySearch.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Reset listener responsible for resetting the text fields in the searchWindow so that user can 
 * try again
 * @author ccantwel
 */
public class SearchResetListener implements ActionListener{
     @Override
    public void actionPerformed(ActionEvent e)
    {
            mainWindow.theSearchWindow.type.setText("");
            mainWindow.theSearchWindow.callNumber.setText("");
            mainWindow.theSearchWindow.title.setText("");
            mainWindow.theSearchWindow.startYear.setText("");    
            mainWindow.theSearchWindow.endYear.setText("");
            mainWindow.theSearchWindow.searchResultDisplay.setText("");
        }
       
    
}

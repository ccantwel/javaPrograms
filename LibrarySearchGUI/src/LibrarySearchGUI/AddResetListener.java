/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearchGUI;
import LibrarySearch.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Reset listener responsible for resetting the text fields in the addWindow so that user can try again
 * @author ccantwel
 */
public class AddResetListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e)
    {
            mainWindow.theAddWindow.callNumber.setText("");
            mainWindow.theAddWindow.authors.setText("");
            mainWindow.theAddWindow.title.setText("");
            mainWindow.theAddWindow.publisher.setText("");
            mainWindow.theAddWindow.organization.setText("");
            mainWindow.theAddWindow.year.setText("");
            mainWindow.theAddWindow.messageDisplay.setText("");
   }
}


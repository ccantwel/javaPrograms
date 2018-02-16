/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearchGUI;
import LibrarySearch.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener responsible for attempting to search for references based on the information the user has 
 * typed into the text fields of the searchWindow, and display the results on the screen in the required
 * box
 * @author ccantwel
 */
public class SearchListener implements ActionListener{
     @Override
    public void actionPerformed(ActionEvent e)
    {
            String refType = mainWindow.theSearchWindow.type.getText();
            String tempCallNumber = mainWindow.theSearchWindow.callNumber.getText();
            String tempTitle = mainWindow.theSearchWindow.title.getText();
            int startYear = 0;
            if(!(mainWindow.theSearchWindow.startYear.getText().equals("")))
            {
            startYear = Integer.parseInt(mainWindow.theSearchWindow.startYear.getText());    
            }
            else startYear = 1000;
            int endYear = 0;
            if(!(mainWindow.theSearchWindow.endYear.getText().equals(""))) {
            endYear = Integer.parseInt(mainWindow.theSearchWindow.endYear.getText());
            }
            else endYear = 9999;
            String foundReferences = new String(Reference.searchReferences(mainWindow.referenceList, refType, tempCallNumber, tempTitle, startYear, endYear));
            mainWindow.theSearchWindow.searchResultDisplay.setText(foundReferences);
        }
}


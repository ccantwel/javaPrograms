/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearchGUI;
import LibrarySearch.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Listener responsible for attempting to create and add a reference to the system based on the 
 * information the user has typed into the text fields of the addWindow
 * @author ccantwel
 */
public class AddListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(mainWindow.theAddWindow.type.getType().equals("Book"))
        {
            String refType = new String("Book");
            String tempCallNumber = mainWindow.theAddWindow.callNumber.getText();
            String tempAuthors = mainWindow.theAddWindow.authors.getText();
            String tempTitle = mainWindow.theAddWindow.title.getText();
            String tempPublisher = mainWindow.theAddWindow.publisher.getText();
            String tempOrganization = new String("NONE");
            int tempYear = Integer.parseInt(mainWindow.theAddWindow.year.getText());
            mainWindow.referenceList = Reference.addReference(mainWindow.referenceList, refType, tempCallNumber, tempAuthors, tempTitle, tempPublisher, tempOrganization, tempYear);
        }
        else if(mainWindow.theAddWindow.type.getType().equals("Journal"))
        {
            String refType = new String("Journal");
            String tempCallNumber = mainWindow.theAddWindow.callNumber.getText();
            String tempAuthors = new String("NONE");
            String tempTitle = mainWindow.theAddWindow.title.getText();
            String tempPublisher = new String("NONE");
            String tempOrganization =  mainWindow.theAddWindow.organization.getText();
            int tempYear = Integer.parseInt(mainWindow.theAddWindow.year.getText());
            mainWindow.referenceList = Reference.addReference(mainWindow.referenceList, refType, tempCallNumber, tempAuthors, tempTitle, tempPublisher, tempOrganization, tempYear);
        }
    }
}

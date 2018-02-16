/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearchGUI;
import javax.swing.*;
import LibrarySearch.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class responsible for creating, and managing user interactions for, a combo box that allows user
 * to choose between book and journal as their reference type in the addWindow
 * @author ccantwel
 */
public class referenceBox implements ActionListener{
    /*INSTANCE VARIABLES*/
    /*type of reference obtained from the comboBox (book or journal)*/
    private String type;
    /*combo box to select between book or journal*/ 
    private JComboBox referenceList;
    /*Constructor*/
    public referenceBox(){
        String[] referenceStrings = {"Book", "Journal"};
        this.referenceList = new JComboBox(referenceStrings);
        referenceList.setSelectedIndex(0);
        this.type = new String("Book");
        referenceList.addActionListener(this);
        }
    /*Method that controls what happens when the user clicks on something in the ComboBox; disables the 
     * labels/text fields in the addWindow unique to journals, and enables the labels/text fields unique
     * to books, or does the reverse
     */
    public void actionPerformed(ActionEvent e) {
    JComboBox cb = (JComboBox)e.getSource();
    String referenceName = (String)cb.getSelectedItem();
    this.type = referenceName;
    if(this.getType().equals("Book")){
          mainWindow.theAddWindow.authorsInst.setVisible(true);
          mainWindow.theAddWindow.authors.setVisible(true);
          mainWindow.theAddWindow.publisher.setVisible(true);
          mainWindow.theAddWindow.publisherInst.setVisible(true);
          mainWindow.theAddWindow.organization.setVisible(false);
          mainWindow.theAddWindow.organizationInst.setVisible(false);
        }
        else if(this.getType().equals("Journal")){
         mainWindow.theAddWindow.authors.setVisible(false);
         mainWindow.theAddWindow.authorsInst.setVisible(false);
         mainWindow.theAddWindow.publisher.setVisible(false);
         mainWindow.theAddWindow.publisherInst.setVisible(false);
         mainWindow.theAddWindow.organization.setVisible(true);
         mainWindow.theAddWindow.organizationInst.setVisible(true);
        }
    }
    /*Retrieves the referenceList combo box for user selection between book and journal*/
    public JComboBox getReferenceList(){
        return this.referenceList;
    }
    /*Retrieves a string corresponding to book or journal, depending on what user selected in combo box*/
    public String getType(){
        return this.type;
    }
}

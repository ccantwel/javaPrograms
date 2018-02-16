/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * Class responsible for creating, and managing user interactions for, a combo box that allows user
 * to choose between add and delete for operations in the user management window
 * @author ccantwel
 */
public class operationSelect implements ActionListener{
    /*INSTANCE VARIABLES*/
    /*Oeperation obtained from the comboBox (add or delete)*/
    private String operation;
    /*combo box to select between add or delete*/ 
    private JComboBox operationList;
    /*Constructor*/
    public operationSelect(){
        String[] operationStrings = {"Please select option", "Add", "Delete"};
        this.operationList = new JComboBox(operationStrings);
        operationList.setSelectedIndex(0);
        this.operation = new String("Please select option");
        operationList.addActionListener(this);
        }
    /*Method that controls what happens when the user clicks on something in the ComboBox; disables the 
     * labels/text fields in the addWindow unique to deleting users, and enables the labels/text fields 
     * unique to adding users, or does the reverse
     */ 
    public void actionPerformed(ActionEvent e) {
    JComboBox cb = (JComboBox)e.getSource();
    String operationName = (String)cb.getSelectedItem();
    this.operation = operationName;
    if(this.getOperation().equals("Add")){
          ProgStart.manageWindow.passwordInst.setVisible(true);
          ProgStart.manageWindow.submitPassword.setVisible(true); 
          ProgStart.manageWindow.AddButton.setVisible(true);
          ProgStart.manageWindow.DeleteButton.setVisible(false);
        }
        else if(this.getOperation().equals("Delete")){
         ProgStart.manageWindow.passwordInst.setVisible(false);
         ProgStart.manageWindow.submitPassword.setVisible(false);  
         ProgStart.manageWindow.DeleteButton.setVisible(true);
         ProgStart.manageWindow.AddButton.setVisible(false);
        }
    }
    /*Retrieves the operationList from combo box for user selection between add and delete*/
    public JComboBox getOperationList(){
        return this.operationList;
    }
    /*Retrieves a string corresponding to add or delete, depending on what user selected in combo box*/
    public String getOperation(){
        return this.operation;
    }
}

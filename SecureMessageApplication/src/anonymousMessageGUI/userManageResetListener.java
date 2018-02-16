/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Reset listener responsible for resetting the text fields in the manageWindow so that user can 
 * try again
 * @author ccantwel
 */
public class userManageResetListener implements ActionListener{
     @Override
    public void actionPerformed(ActionEvent e)
    {
            ProgStart.manageWindow.username.setText("");
            ProgStart.manageWindow.submitPassword.setText("");
            ProgStart.manageWindow.errorMessages.setText("");
    }
       
    
}

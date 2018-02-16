/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Reset listener responsible for resetting the text fields in the loginWindow so that user can 
 * try again
 * @author ccantwel
 */
public class userLoginResetListener implements ActionListener{
     @Override
    public void actionPerformed(ActionEvent e)
    {
            ProgStart.loginWindow.username.setText("");
            ProgStart.loginWindow.submitPassword.setText("");
            ProgStart.loginWindow.errorMessages.setText("");
    }
       
    
}

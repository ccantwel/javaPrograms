/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Reset listener responsible for resetting the text fields in the searchWindow so that user can 
 * try again
 * @author ccantwel
 */
public class startResetListener implements ActionListener{
     @Override
    public void actionPerformed(ActionEvent e)
    {
            //ProgStart.msgWindow.errorBox.setText("");
            ProgStart.msgWindow.submittedMessage.setText("");
    }
}
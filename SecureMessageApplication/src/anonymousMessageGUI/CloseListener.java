/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener responsible for closing program after too many login attempts
 * @author ccantwel
 * */
public class CloseListener implements ActionListener{
   @Override   
    public void actionPerformed(ActionEvent e)
    {
        System.exit(1);
    }
}
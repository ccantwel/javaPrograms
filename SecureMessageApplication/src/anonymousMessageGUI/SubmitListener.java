/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener responsible for attempting to submit a message based on the information the user has 
 * typed into the text fields of the startWindow, and display all messages in real time (similar 
 * to a chat room)
 * @author ccantwel
 * */
public class SubmitListener implements ActionListener{
    /*variable and function that are used for error detection (when username or message box is blank
    when a user clicks Submit button */
    private String error = "You must type something in this box!";
    public String getError(){
        return this.error;
    }
    @Override   
    public void actionPerformed(ActionEvent e)
    {
            String userID;
            String tempMsg;
            if((((ProgStart.msgWindow.username.getText().equals("")))||(ProgStart.msgWindow.username.getText().equals(" "))||(ProgStart.msgWindow.username.getText().equals(this.getError())))||
                    ((ProgStart.msgWindow.submittedMessage.getText().equals(""))||(ProgStart.msgWindow.submittedMessage.getText().equals(" "))||(ProgStart.msgWindow.submittedMessage.getText().equals(this.getError()))))       
            {
                if((ProgStart.msgWindow.username.getText().equals(""))||(ProgStart.msgWindow.username.getText().equals(" "))){
                    ProgStart.msgWindow.username.setText(this.getError());
                }
                if((ProgStart.msgWindow.submittedMessage.getText().equals(""))||(ProgStart.msgWindow.submittedMessage.getText().equals(" ")))      
                {
                    ProgStart.msgWindow.submittedMessage.setText(this.getError());
                }
            }
            else{
                  userID = ProgStart.msgWindow.username.getText();
                  tempMsg = ProgStart.msgWindow.submittedMessage.getText();
                  ProgStart.messageList = message.addMessage(ProgStart.messageList, userID, tempMsg);
                  //ProgStart.msgWindow.username.setText("");
                  ProgStart.msgWindow.submittedMessage.setText("");
                  ProgStart.msgWindow.messageDisplayBox.setText("");
                  String messagesInSystem = new String(message.printList(ProgStart.messageList));
                  ProgStart.msgWindow.messageDisplayBox.setText(messagesInSystem);
                  ProgStart.msgWindow.messageDisplayBox2.setText(messagesInSystem);   
            }
    }
}



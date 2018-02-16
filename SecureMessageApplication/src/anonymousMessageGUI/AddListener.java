/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener responsible for attempting to add a user to the system from User Management window,
 * based on the information the user has typed into the text fields of the manageWindow, and display 
 * error messages to user
 * @author ccantwel
 * */
public class AddListener implements ActionListener{
    /*variable and function that are used for error detection (when username or password box is blank
    when a user clicks Submit button */
    private String error = "You must type something in this box!";
    public String getError(){
        return this.error;
    }
    @Override   
    public void actionPerformed(ActionEvent e)
    {
            String userID;
            String tempPassword;
            if((((ProgStart.manageWindow.username.getText().equals("")))||(ProgStart.manageWindow.username.getText().equals(" "))||(ProgStart.manageWindow.username.getText().equals(this.getError())))||
                    ((ProgStart.manageWindow.submitPassword.getText().equals(""))||(ProgStart.manageWindow.submitPassword.getText().equals(" "))||(ProgStart.manageWindow.submitPassword.getText().equals(this.getError()))))       
            {
                if((ProgStart.manageWindow.username.getText().equals(""))||(ProgStart.manageWindow.username.getText().equals(" "))){
                    ProgStart.manageWindow.username.setText(this.getError());
                }
                if((ProgStart.manageWindow.submitPassword.getText().equals(""))||(ProgStart.manageWindow.submitPassword.getText().equals(" ")))      
                {
                    ProgStart.manageWindow.submitPassword.setText(this.getError());
                }
            }
            else{
                  userID = ProgStart.manageWindow.username.getText();
                  tempPassword = ProgStart.manageWindow.submitPassword.getText();
                  try{
                  ProgStart.userList = user.searchAndAdd(ProgStart.userList, userID, tempPassword);
                  }
                  catch(InvalidUsernameException x){
                      ProgStart.manageWindow.errorMessages.setText("ERROR: Username cannot be blank!");
                  }
                 catch(InvalidPasswordException y){
                      ProgStart.manageWindow.errorMessages.setText("ERROR: Users cannot have a blank password!");
                 }
                 catch(UserFoundException z){
                      ProgStart.manageWindow.errorMessages.setText("ERROR: That user is already in the system!");
                 }
                 }
    }
}





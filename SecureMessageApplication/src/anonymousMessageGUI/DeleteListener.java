/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Listener responsible for attempting to delete a user to the system from User Management window,
 * based on the information the user has typed into the text fields of the manageWindow, and display 
 * error messages to user
 * @author ccantwel
 * */
public class DeleteListener implements ActionListener{
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
            if((((ProgStart.manageWindow.username.getText().equals("")))||(ProgStart.manageWindow.username.getText().equals(" "))||(ProgStart.manageWindow.username.getText().equals(this.getError())))){
                   ProgStart.manageWindow.username.setText(this.getError());
                }
                else{
                  userID = ProgStart.manageWindow.username.getText();
                  try{
                  ProgStart.userList = user.searchAndDelete(ProgStart.userList, userID);
                  }
                  catch(MainUserException w){
                      ProgStart.manageWindow.errorMessages.setText("ERROR: Cannot delete the main user account!");
                  }
                  catch(InvalidUsernameException x){
                      ProgStart.manageWindow.errorMessages.setText("ERROR: Username cannot be blank!");
                  }
                 catch(emptyListException y){
                      ProgStart.manageWindow.errorMessages.setText("ERROR: No users in the system!");
                 }
                 catch(UserNotFoundException z){
                      ProgStart.manageWindow.errorMessages.setText("ERROR: Unable to find a user with that username!");
                 }
                 }
    }
}





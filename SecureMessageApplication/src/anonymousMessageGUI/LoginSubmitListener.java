/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessageGUI;
import anonymousMessage.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener responsible for attempting to log a user into system based on the information the user has 
 * typed into the text fields of the loginWindow, and display error messages to user
 * @author ccantwel
 * */
public class LoginSubmitListener implements ActionListener{
    /*variable and function that are used for error detection (when username or password box is blank
    when a user clicks Submit button */
    private String error = "You must type something in this box!";
    public String getError(){
        return this.error;
    }
    /*boolean variable for successful login */
    boolean successfulLogin = false;
    /*boolean variable for found user in system*/
    boolean foundUserInSystem = false;
    int failedLogins = 0; //counter for failed login attempts
    @Override   
    public void actionPerformed(ActionEvent e)
    {
            String userID;
            String tempPassword;
            if((((ProgStart.loginWindow.username.getText().equals("")))||(ProgStart.loginWindow.username.getText().equals(" "))||(ProgStart.loginWindow.username.getText().equals(this.getError())))||
                    ((ProgStart.loginWindow.submitPassword.getText().equals(""))||(ProgStart.loginWindow.submitPassword.getText().equals(" "))||(ProgStart.loginWindow.submitPassword.getText().equals(this.getError()))))       
            {
                if((ProgStart.loginWindow.username.getText().equals(""))||(ProgStart.loginWindow.username.getText().equals(" "))){
                    ProgStart.loginWindow.username.setText(this.getError());
                }
                if((ProgStart.loginWindow.submitPassword.getText().equals(""))||(ProgStart.loginWindow.submitPassword.getText().equals(" ")))      
                {
                    ProgStart.loginWindow.submitPassword.setText(this.getError());
                }
            }
            else{
                  userID = ProgStart.loginWindow.username.getText();
                  tempPassword = ProgStart.loginWindow.submitPassword.getText();
                  foundUserInSystem = user.searchOnly(ProgStart.userList, userID);
                  if(foundUserInSystem == true){
                  successfulLogin = user.searchAndCheck(ProgStart.userList, userID, tempPassword);
                  if(successfulLogin == true){
                       ProgStart.msgWindow = new startWindow();
                       ProgStart.msgWindow.setVisible(true);
                       ProgStart.msgWindow.username.setText(userID); //set username to user logging in
                       //reset the text fields on login window before closing it
                       ProgStart.loginWindow.username.setText("");
                       ProgStart.loginWindow.submitPassword.setText("");
                       ProgStart.loginWindow.errorMessages.setText("");
                       ProgStart.loginWindow.setVisible(false);
                  }
                  else{
                      ProgStart.loginWindow.errorMessages.setText("ERROR: Bad password, please "
                              + "click Reset and try again!");
                      failedLogins = failedLogins + 1;
                  } 
                     if(failedLogins >= 5){
                     ProgStart.loginWindow.errorMessages.setText("ERROR: Too many login attempts!  Click on exit button to close program");
                     /*turn off all other buttons and turn on exit button, user has only option 
                     to close program after 5 or more failed login attempts*/
                     ProgStart.loginWindow.resetButton.setVisible(false);
                     ProgStart.loginWindow.LoginButton.setVisible(false);
                     ProgStart.loginWindow.ManageLoginButton.setVisible(false);
                     ProgStart.loginWindow.CloseButton.setVisible(true);
                  }
                  }
                  else{
                      try{
                      user createUser = new user(userID, tempPassword);
                      ProgStart.userList.add(createUser);
                      ProgStart.loginWindow.errorMessages.setText("You have now been added to the system, click on Login to continue");
                      }
                      catch(InvalidUsernameException x){
                          ProgStart.loginWindow.errorMessages.setText("ERROR: Username cannot be blank!");
                      }
                      catch(InvalidPasswordException x){
                          ProgStart.loginWindow.errorMessages.setText("ERROR: Password cannot be blank!");
                      }
               }
        }
    }
}





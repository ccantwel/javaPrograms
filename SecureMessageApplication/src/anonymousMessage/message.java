/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package anonymousMessage;
import anonymousMessageGUI.*;
import java.util.*;
/**
 *
 * @author ccantwel
 */
public class message {
    /*
     * -------------------------
     * INSTANCE/MEMBER VARIABLES
     * -------------------------
     */
     /**
     * <p>Username that submitted the message</p>
     */
    private String username;
    
    /**
     * <p>Submitted message </p>
     */
    private String submittedMessage;
    
    /*
     * ------------
     * CONSTRUCTORS
     * ------------
     */
    
    /**
     * <p>Standard constructor creates a message object according to the specified username and message 
     * passed in
     * @param username Username that is submitting the message
     * @param submittedMessage Message that is being submitted
     */
     public message (String username, String message) throws InvalidUsernameException,
            InvalidMessageException {
        /*username and submitted message cannot be blank; throw exception if either 
         username or message is blank */
        if(!(username.equals("")) || !(username.equals(" "))) {
        this.username = username; 
        }
        else throw new InvalidUsernameException();
        if(!(message.equals("")) || !(message.equals(" "))) {
        this.submittedMessage = message;
        }
        else throw new InvalidMessageException();
        }
     /*
     * --------
     * MUTATORS
     * --------
     */
    
    
    /**
     * <p>Sets the username for the message object</p>
     * 
     * @param username Data for the message object's username
     * @return <code>true</code> if the new data was assigned; throws exception if the assignment failed
     */
   public boolean setUsername(String username) throws InvalidUsernameException
   {
       if((username.equals("")) || (username.equals(" ")))           
       {
       throw new InvalidUsernameException();
       }
       else{       
           this.username = username;
           System.out.print("Username written successfully\n");
           return true;
       }
   }
           /**
     * <p>Sets the message for the message object</p>
     * 
     * @param message Data for the message object's submitted message
     * @return <code>true</code> if the new data was assigned; throws exception if the assignment failed
     */
      public boolean setMessage(String message) throws InvalidMessageException
       {
           if((message.equals("")) || (message.equals(" ")))           
           {
             throw new InvalidMessageException();
           }
           else{       
             this.submittedMessage = message;
             System.out.print("Message written successfully\n");
             return true;
           }
       }
      
      /*
     * ---------
     * ACCESSORS
     * ---------
     */
    
    /**
     * <p>Retrieves the username of the message object</p>
     * @return Username of message object
     */
    public String getUsername () {
        return this.username;
    }
    /**
     * <p>Retrieves the submitted message of the message object</p>
     * @return submitted message within object
     */
    public String getMessage () {
        return this.submittedMessage;
    }
    /*
     * -------------
     * OTHER METHODS
     * -------------
     */

    
    /**
     * <p>Prints the list of objects to the messageDisplay on the startWindow</p>
     */
    public static String printList(ArrayList<message> messageList)
    {
        String Messages = new String();
        int messageListSize = messageList.size();
        int x = 0;
        ProgStart.messageCount = 0;
        for(x = 0; x<messageListSize; x++)
        {
            message temp = messageList.get(x);
            ProgStart.messageCount = ProgStart.messageCount + 1;
            Messages = Messages + "Message " + ProgStart.messageCount + " - " + temp.getMessage() + "\n";
        }
        return Messages; 
    }
        
     
     /**
     * <p>Creates a message object with username and submitted message.  Attempts to add the message
     * to the messageList</p>
     * @return arrayList the newly created message, as well as all the other messages in the system
     */  
    public static ArrayList<message> addMessage(ArrayList<message> messageList, String userID, String tempMsg)
    {
            message temp = null;
            int messageListSize = messageList.size();
            try{ 
              temp = new message(userID, tempMsg);
            }
            catch(InvalidUsernameException x) {
                ProgStart.msgWindow.messageDisplayBox.setText("Username is blank; can't add\n");
            }
            catch(InvalidMessageException x){
                ProgStart.msgWindow.messageDisplayBox.setText("Message is blank; can't add\n");
                }
            //attempts to add message to list
            messageList.add(temp);
            //ProgStart.msgWindow.messageDisplayBox.setText("Add successful");
            return messageList;
    }
}
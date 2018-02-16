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
public class user {
    /*
     * -------------------------
     * INSTANCE/MEMBER VARIABLES
     * -------------------------
     */
     /**
     * <p>Name of user in the system</p>
     */
    private String username;
    
    /**
     * <p>Password of user in the system </p>
     */
    private String password;
    
    /**
     * <p>Main username and password </p>
     */
     private String mainUsername = "root";
     private String mainPass = "4gt-+-8yXyJTBLZ6";
    /*
     * ------------
     * CONSTRUCTORS
     * ------------
     */
    
    /**
     * <p>Standard constructor creates the main user account</p> 
     */
     public user (){
        this.username = this.mainUsername; 
        this.password = this.mainPass;          
     }
        
     /*
     
     /**
     * <p>Standard constructor creates a user object according to the specified username and password 
     * passed in
     * @param username Name of user being created
     * @param tempPasswd Password of created user
     */
     public user (String username, String tempPasswd) throws InvalidUsernameException,
            InvalidPasswordException {
        /*username and submitted message cannot be blank; throw exception if either 
         username or message is blank */
        if(!(username.equals("")) || !(username.equals(" "))) {
        this.username = username; 
        }
        else throw new InvalidUsernameException();
        if(!(tempPasswd.equals("")) || !(tempPasswd.equals(" "))) {
        this.password = tempPasswd;
        }
        else throw new InvalidPasswordException();
        }
     /*
     * --------
     * MUTATORS
     * --------
     */
    
    
    /**
     * <p>Sets the username for the user object</p>
     * 
     * @param username Data for the user object's username
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
     * <p>Sets the password for the message object</p>
     * 
     * @param tempPasswd Data for the user object's password
     * @return <code>true</code> if the new data was assigned; throws exception if the assignment failed
     */
      public boolean setPassword(String tempPasswd) throws InvalidPasswordException
       {
           if((tempPasswd.equals("")) || (tempPasswd.equals(" ")))           
           {
             throw new InvalidPasswordException();
           }
           else{       
             this.password = tempPasswd;
             System.out.print("Password written successfully\n");
             return true;
           }
       }
      
      /*
     * ---------
     * ACCESSORS
     * ---------
     */
    
    /**
     * <p>Retrieves the username of the user object</p>
     * @return Username of user object
     */
    public String getUsername () {
        return this.username;
    }
    /**
     * <p>Retrieves the password of the user object</p>
     * @return password of user object
     */
    public String getPassword () {
        return this.password;
    }
    /**
     * <p>Retrieves the main username</p>
     * @return Username of main user
     */
    private String getMainUsername () {
        return this.mainUsername;
    }
    /**
     * <p>Retrieves the password of the main user </p>
     * @return password of main user
     */
    private String getMainPassword () {
        return this.mainPass;
    }
    /*
     * -------------
     * OTHER METHODS
     * -------------
     */
    
    /**
     * <p>Searches for a user in the system and deletes it if it is found</p>
     * @return newly modified list if user is found and deleted, throws exception otherwise
     */    
    public static ArrayList<user> searchAndDelete (ArrayList<user> userList, String userToSearch) throws InvalidUsernameException, 
            emptyListException, UserNotFoundException, MainUserException{         
        int userListSize = userList.size();
        if(userList.isEmpty() == false) //only search for users if arrayList is not empty
                   {                   
                   if((userToSearch.equalsIgnoreCase(""))||(userToSearch.equalsIgnoreCase(" ")))
                           {
                               throw new InvalidUsernameException();
                           }
                  /*search sequentially to find the username in system (if username is not blank), delete
                    * user if found, throw exception otherwise
                    */
                   else{
                       int x = 0; //loop index for searching            
                       for(x = 0; x<userListSize; x++){                       
                          user newUser = userList.get(x);
                          String test = newUser.getUsername();
                          if(userToSearch.equals(test)){
                              if(userToSearch.equals(newUser.getMainUsername())){
                                  throw new MainUserException();
                              }
                              else {
                                  userList.remove(x);                              
                                  break;
                              }
                          }
                       }
                       if(x >= userListSize){
                         throw new UserNotFoundException();
                        } 
                   }
        }             
                   else{
                      throw new emptyListException(); 
                   }
        return userList;
    }               
    /**
     * <p>Searches for a user in the system and adds it if it is not found</p>
     * @return newly modified list if user is not found and added, throws exception otherwise
     */    
    public static ArrayList<user> searchAndAdd (ArrayList<user> userList, String userToSearch, String newPass) throws InvalidUsernameException, 
            InvalidPasswordException, UserFoundException{
          if((userToSearch.equalsIgnoreCase(""))||(userToSearch.equalsIgnoreCase(" ")))
                           {
                               throw new InvalidUsernameException();
                           }
           if((newPass.equalsIgnoreCase(""))||(newPass.equalsIgnoreCase(" ")))
                           {
                               throw new InvalidPasswordException();
                           }
        int userListSize = userList.size();
        if(userList.isEmpty() == false) //only search for users if arrayList is not empty
                   {                      
                  /*search sequentially to find the username in system (if username is not blank),
                    * throw exception if user is found
                    */
                       boolean foundUser = false;  //test variable for user discovery
                       int x = 0; //loop index for searching            
                       for(x = 0; x<userListSize; x++){                       
                          user newUser = userList.get(x);
                          String test = newUser.getUsername();
                          if(userToSearch.equals(test)){
                              foundUser = true; //found the username in system
                              break;
                          }
                       }
                       if(foundUser == true){
                         throw new UserFoundException();
                        }           
        }
       //user has not been found, create and add to system
        user addUser = new user(userToSearch, newPass);
        userList.add(addUser);
        return userList;
    }    
    /**
     * <p>Searches for a user and check its password to verify if it matches</p>
     * @return true if user is found and password matches, false otherwise
     */    
    public static boolean searchAndCheck (ArrayList<user> userList, String userToSearch, String passwordToSearch){
        int userListSize = userList.size();
        if(userList.isEmpty() == false) //only search for users if arrayList is not empty
                   {                   
                   
                  /*search sequentially to find the username in system (if username is not blank), checks
                    * password if found
                    */
                       int x = 0; //loop index for searching            
                       for(x = 0; x<userListSize; x++){                       
                          user newUser = userList.get(x);
                          String test = newUser.getUsername();
                          if(userToSearch.equals(test)){
                              String test2 = newUser.getPassword();
                              if(passwordToSearch.equals(test2)){
                                  return true;
                              }
                          }
                       }
        }
    return false;
    }
/**
     * <p>Only searches for a user in the system based on a submitted username</p>
     * @return true if user is found, false otherwise
     */    
    public static boolean searchOnly (ArrayList<user> userList, String userToSearch){
        int userListSize = userList.size();
        if(userList.isEmpty() == false) //only search for users if arrayList is not empty
                   {                   
                   
                  /*search sequentially to find the username in system (if username is not blank), checks
                    * password if found
                    */
                       int x = 0; //loop index for searching            
                       for(x = 0; x<userListSize; x++){                       
                          user newUser = userList.get(x);
                          String test = newUser.getUsername();
                          if(userToSearch.equals(test)){
                              return true;
                          }
                          }
                    }
    return false;
    }
    /**
     * <p>Searches for main user and check its password to verify if it matches</p>
     * @return true if user is found and password matches, false otherwise
     */    
    public static boolean searchForMain (ArrayList<user> userList, String userToSearch, String passwordToSearch){
        int userListSize = userList.size();
        if(userList.isEmpty() == false) //only search for users if arrayList is not empty
                   {                   
                   
                  /*search sequentially to find the username in system (if username is not blank), checks
                    * password if found
                    */
                       int x = 0; //loop index for searching            
                       for(x = 0; x<userListSize; x++){                       
                          user newUser = userList.get(x);
                          String test = newUser.getUsername();
                          if((userToSearch.equals(test))&&(userToSearch.equals(newUser.getMainUsername()))){
                              String test2 = newUser.getPassword();
                              if((passwordToSearch.equals(test2))&&(passwordToSearch.equals(newUser.getMainPassword()))) {
                                  return true;
                              }
                          }
                       }
        }
    return false;
    }
                     
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;

/**
 *
 * @author ccantwel
 */
public class Journal extends Reference {
      /*
     * -------------------------
     * INSTANCE/MEMBER VARIABLES
     * -------------------------
     */
        /**
     * <p>Name of organization who published the journal.</p>
     */
    private String organization;
     /*
     * ------------
     * CONSTRUCTORS
     * ------------
     */
    
    /**
     * <p>Standard constructor creates a journal according to the specified call number, title,
     * publishing organization, and publishing year
     * @param type Type of reference (journal in this case)
     * @param callNum Journal's call number
     * @param title Journal's title
     * @param organize Journal's publishing organization
     * @param year Journal's publishing year
     */
     public Journal (String type, String callNum, String title, String organize, int year) 
     throws InvalidCallNumberException, InvalidYearException, InvalidTitleException{
         super(type, callNum, title, year);
         this.organization = organize;
     }
     /*
     * --------
     * MUTATORS
     * --------
     */
     
     /**
     * <p>Sets the publishing organization for the journal</p>
     * 
     * @param organize for the journal's publishing organization(s)
     * @return <code>true</code> if the new data was assigned; <code>false</code> if the assignment failed
     */
       public boolean setOrganization(String organize)
       {
           this.organization = organize;
           System.out.print("Publishing organization information written successfully\n");
           return true;
       }
         
        /*
     * ---------
     * ACCESSORS
     * ---------
     */
        
    /**
     * <p>Retrieves the publisher organization for the journal.</p>
     * @return Organization of journal
     */
    public String getOrganization ()
    {
        return this.organization;
    }
    
   /*
     * -------------
     * OTHER METHODS
     * -------------
     */
    
   /**
     * <p>Compares the  publishing organization of a journal user is adding 
    *  with the same information of a journal already in the arrayList</p>
     * @return true if publisher of the journal user is adding 
    *  are identical, false otherwise
    **/
   public boolean areOrganizationsEqual(Journal otherJournal)
   {
       if(((this.organization).equalsIgnoreCase(otherJournal.organization)))
       {
           return true;
       }
       else return false;
   }
   
}

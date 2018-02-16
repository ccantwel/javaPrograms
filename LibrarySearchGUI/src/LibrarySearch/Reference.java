/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;
import LibrarySearchGUI.*;
import java.util.*;
/**
 *
 * @author ccantwel
 */
public class Reference {
    /*
     * -------------------------
     * INSTANCE/MEMBER VARIABLES
     * -------------------------
     */
     /**
     * <p>Type of reference (book or journal)</p>
     */
    private String type;
    
    /**
     * <p>Call number of the reference </p>
     */
    private String callNumber;
    
    /**
     * <p>Title of the reference.</p>
     */
    private String title;
    
    /**
     * <p>Publishing year of the reference.</p>
     */
    private int year;
    /*
     * ------------
     * CONSTRUCTORS
     * ------------
     */
    
    /**
     * <p>Standard constructor creates a referenc according to the specified type, call number, title,
     * and publishing year
     * @param type Reference's type (book or journal)
     * @param callNum Reference's call number
     * @param title Reference's title
     * @param year Book's publishing year
     */
     public Reference (String type, String callNum, String title, int year) throws InvalidCallNumberException,
            InvalidYearException, InvalidTitleException {
        this.type = type;
        //call number and title cannot be blank; throw exception if either call number or title is blank
        if(!(callNum.equals("")) || !(callNum.equals(" "))) {
        this.callNumber = callNum; 
        }
        else throw new InvalidCallNumberException();
        if(!(title.equals("")) || !(title.equals(" "))) {
        this.title = title;
        }
        else throw new InvalidTitleException();
        /*publishing year must be in range from 1000 to 9999 (including 1000 and 9999); throw exception 
         * if it is not*/
        if((year < 1000) || (year > 9999)){
            throw new InvalidYearException();
        }
        else this.year = year;
     }
     /*
     * --------
     * MUTATORS
     * --------
     */
    
    
    /**
     * <p>Sets the call number for the reference</p>
     * 
     * @param callNum Data for the Reference's call Number
     * @return <code>true</code> if the new data was assigned; throws exception if the assignment failed
     */
   public boolean setCallNumber(String callNum) throws InvalidCallNumberException
   {
       if((callNum.equals("")) || (callNum.equals(" ")))           
       {
       throw new InvalidCallNumberException();
       }
       else{       
           this.callNumber = callNum;
           System.out.print("Call number written successfully\n");
           return true;
       }
   }
           /**
     * <p>Sets the type of the reference</p>
     * 
     * @param type Data for the Reference's type
     * @return <code>true</code> if the new data was assigned; <code>false</code> if the assignment failed
     */
      public boolean setType(String type)
       {
           this.type = type;
           System.out.print("Type of reference written successfully\n");
           return true;
       }
       /**
     * <p>Sets the title for the book</p>
     * 
     * @param title Data for the Reference's title
     * @return <code>true</code> if the new data was assigned; throws exception if assignment failed
     */
   public boolean setTitle(String title) throws InvalidTitleException
   {
       if((title.equals("")) || (title.equals(" ")))
       {
       throw new InvalidTitleException();
       }
       else{
       this.title = title;
       System.out.print("Title of reference written successfully\n");
       return true;
       }
   }      
     /**
     * <p>Sets the publishing year for the reference</p>
     * 
     * @param year Value for the Reference's publishing year
     * @return <code>true</code> if the new value was assigned; throws exception if assignment failed
     */
       public boolean setYear(int year) throws InvalidYearException
       {
           if((year < 1000) || (year > 9999))
           {
               throw new InvalidYearException();
           }
           else {
           this.year = year;
           System.out.print("Publishing year written successfully\n");
           return true;
           }       
       }
      /*
     * ---------
     * ACCESSORS
     * ---------
     */
    
    /**
     * <p>Retrieves the call number of the Reference.</p>
     * @return Call Number of reference
     */
    public String getCallNumber () {
        return this.callNumber;
    }
    /**
     * <p>Retrieves the type of the Reference.</p>
     * @return Type of reference
     */
    public String getType () {
        return this.type;
    }
    
    /**
     * <p>Retrieves the title of the reference.</p>
     * @return Title of reference
     */
    public String getTitle ()
    {
        return this.title;
    }
    
    /**
     * <p>Retrieves the publishing year for the reference.</p>
     * @return Year of reference
     */
   public int getYear ()
    {
        return this.year;
    }
     /*
     * -------------
     * OTHER METHODS
     * -------------
     */
    /**
     * <p>Compares the call number, title, year, and either authors and publisher (for books), or organization
    * (for journals) of a reference user is adding are identical with the same information of a reference 
    * already in the arrayList</p>
     * @return true if the call number, title, year, and either authors and publisher (for books), or organization
    * (for journals) of the reference user is adding are identical, false otherwise
    **/
   public boolean equals(Reference otherReference)
   {
       if((this instanceof Book) && (otherReference instanceof Book)){
        Book thisBook = (Book)this;
        Book otherBook = (Book)otherReference;
        return(((thisBook.getCallNumber())).equalsIgnoreCase(otherBook.getCallNumber()))&&((thisBook.getAuthors()).equalsIgnoreCase(otherBook.getAuthors()))
               &&((thisBook.getTitle()).equalsIgnoreCase(otherBook.getTitle()))&&((thisBook.getPublisher()).equalsIgnoreCase(otherBook.getPublisher()))&&((thisBook.getYear()) == (otherBook.getYear()));
            }
       else if((this instanceof Journal)&&(otherReference instanceof Journal))
       {
        Journal thisJournal = (Journal)this;
        Journal otherJournal = (Journal)otherReference;
        return(((thisJournal.getCallNumber())).equalsIgnoreCase(otherJournal.getCallNumber())) &&((thisJournal.getTitle()).equalsIgnoreCase(otherJournal.getTitle()))&&((thisJournal.getOrganization()).equalsIgnoreCase(otherJournal.getOrganization()))&& ((thisJournal.getYear()) == (otherJournal.getYear()));
       }
       else return(((this.getCallNumber())).equalsIgnoreCase(otherReference.getCallNumber()))&&((this.getTitle()).equalsIgnoreCase(otherReference.getTitle()))&&((this.getYear()) == (otherReference.getYear()));
      }
   /**
     * <p>Compares the call number of a reference user is adding 
    *  with the same information of a reference in the arrayList</p>
     * @return true if the call number of the reference user is adding 
    *  is identical, false otherwise
    **/
   public boolean areCallNumbersEqual(Reference otherReference)
   {
       if(((this.callNumber).equalsIgnoreCase(otherReference.callNumber)))
       {
           return true;
       }
       else return false;
   }
   
   /**
     * <p>Compares the title of a reference user is adding 
    *  with the same information of a reference already in the arrayList</p>
     * @return true if the title of the reference user is adding 
    *  is identical, false otherwise
    **/
   public boolean areTitlesEqual(Reference otherReference)
   {
       if(((this.title).equalsIgnoreCase(otherReference.title)))
       {
           return true;
       }
       else return false;
   }
   /**
     * <p>Compares the year of a reference user is adding 
    *  with the same information of a reference already in the arrayList</p>
     * @return true if the year of the reference user is adding 
    *  is identical, false otherwise
    **/
   public boolean areYearsEqual(Reference otherReference)
   {
       if(((this.getYear()) == (otherReference.getYear())))
       {
           return true;
       }
       else return false;
   }
    @Override
    /**
     * <p>Converts the different components of the reference into a string the user can read/understand</p>
     * @return String containing the reference's call number, author(s), title, publisher name(s) and 
     * publishing year
     */
    public String toString()
    {
        if(this instanceof Book){
        Book thisBook = (Book)this;
        return ("Type: " + thisBook.getType() + "\nCall Number: "+ thisBook.getCallNumber() + "\nAuthors: " + thisBook.getAuthors() + "\nTitle: " + 
                thisBook.getTitle() + "\nPublisher: "+ thisBook.getPublisher() + "\nYear: " + thisBook.getYear() + "\n");
        }
                else if(this instanceof Journal){
                    Journal thisJournal = (Journal)this;
            return ("Type: " + thisJournal.getType() + "\nCall Number: "+ thisJournal.getCallNumber() + "\nTitle: " + thisJournal.getTitle() + "\nOrganization: " + thisJournal.getOrganization() + "\nYear: " + thisJournal.getYear() + "\n");
        }
        else return ("Call Number: "+ this.getCallNumber() + "\nTitle: " + this.getTitle() + "\nYear: " + this.getYear() + "\n");
}
     /**
     * <p>Converts the different components of the reference into a string to be stored in a file</p>
     * @return String containing the reference's call number, author(s), title, publisher name(s) and 
     * publishing year
     */
    public String toFileString()
    {
        if(this instanceof Book){
        Book thisBook = (Book)this;
        return ("type = \"book\"\ncallnumber = \"" + thisBook.getCallNumber() + "\"\nauthors = \"" + thisBook.getAuthors() + "\"\ntitle = \"" + 
                thisBook.getTitle() + "\"\npublisher = \""+ thisBook.getPublisher() + "\"\nyear = \"" + thisBook.getYear() + "\"\n");
        }
                else if(this instanceof Journal){
                    Journal thisJournal = (Journal)this;
            return ("type = \"journal\"\ncallnumber = \"" + thisJournal.getCallNumber() + "\"\ntitle = \"" + thisJournal.getTitle() + "\"\norganization = \""
                                   + thisJournal.getOrganization() + "\"\nyear = \"" + thisJournal.getYear() + "\"\n");
        }
        else return ("type = \"other\"\ncallnumber = \"" + this.getCallNumber() + "\"\ntitle = \"" + 
                this.getTitle() +  "\"\nyear: \"" + this.getYear() + "\"\n");
    }
       /**
     * <p>Creates a reference with user's specified call number, title, and year, as well as authors 
     * and publisher (for books) or organization (for journals).  Attempts to add the reference to the
     * referenceList if it is not found there already</p>
     * @return arrayList containing the newly created reference, as well as all the other references in the system
     */  
    public static ArrayList<Reference> addReference(ArrayList<Reference> referenceList, String refType, String tempCallNumber, String tempAuthors, String tempTitle, String tempPublisher, String tempOrganization, int tempYear)
    {
        Reference temp = null;
        int referenceListSize = referenceList.size();
        if(refType.equalsIgnoreCase("book"))
        {
            temp = null;
            try{ 
            temp = new Book(refType, tempCallNumber, tempAuthors, tempTitle, tempPublisher, tempYear); 
            }
            catch(InvalidCallNumberException x) {
                mainWindow.theAddWindow.messageDisplay.setText("Call number is blank; can't add\n");
            }
            catch(InvalidTitleException x){
                mainWindow.theAddWindow.messageDisplay.setText("Title is blank; can't add\n");
                }
            catch(InvalidYearException x) {
            mainWindow.theAddWindow.messageDisplay.setText("Year is outside range from 1000 to 9999; cant add\n");    
            }
         }
        if(refType.equalsIgnoreCase("journal"))
        {
            try{
            temp = new Journal(refType, tempCallNumber, tempTitle, tempOrganization, tempYear);
            }
             catch(InvalidCallNumberException x) {
                mainWindow.theAddWindow.messageDisplay.setText("Call number is blank; can't add\n");
            }
            catch(InvalidTitleException x){
                mainWindow.theAddWindow.messageDisplay.setText("Title is blank; can't add\n");
                }
            catch(InvalidYearException x) {
            mainWindow.theAddWindow.messageDisplay.setText("Year is outside range from 1000 to 9999; cant add\n");    
            }
        }
        //attempts to add reference to list
                         //directly adds reference to list if empty
                         if((referenceList.isEmpty()) == true)
                         {
                            referenceList.add(temp);
                            mainWindow.theAddWindow.messageDisplay.setText("Add successful");
                            mainWindow.titleIndex = mainWindow.doStuffWithFile.updateTitleIndex(referenceList);
                         }
                        //list is not empty
                         else 
                            {
                        //i is for loop index variable, as is c and userQuery
                        int i = 0;
                        /*check arrayList to find out if a reference containing the same call number and year as the book
                        being added is already in the list*/
                        for(i = 0; i<referenceListSize; i++)
                                {
                        Reference newReference = referenceList.get(i);
                        if(((temp.areCallNumbersEqual(newReference)) == true) &&((temp.areYearsEqual(newReference)) == true))
                                    {
                                    mainWindow.theAddWindow.messageDisplay.setText("You already have that reference in the system!\nPlease try agaim");
                                    break;
                                    }
                                }
                            //no identical references in list, can add created reference
                            if(i >= referenceListSize){
                               referenceList.add(temp);
                               mainWindow.theAddWindow.messageDisplay.setText("Add successful");
                               mainWindow.titleIndex = mainWindow.doStuffWithFile.updateTitleIndex(referenceList);
                            }
                            }
               return referenceList;
    }
      /**
     * <p>Searches for references based on the user's specified type, title keywords, start year, 
     * and/or end year</p>
     * @return String containing the references that match the users search query
     */    
    public static String searchReferences (ArrayList<Reference> referenceList, String refType, String tempCallNumber, String tempTitle, int startYear, int endYear)
    {
        String foundReferences = new String();
        String userDelims = "[\"\", =!?:;\n]+";
        int noMatch = 0; int referenceListSize = referenceList.size();
        if(referenceList.isEmpty() == false)//only search for references if arrayList is not empty
                   {
                   int userMatches = 0; 
                   String searchTitle[] = null;
                   if(!(tempTitle.equalsIgnoreCase("")))
                           {
                   searchTitle = tempTitle.split(userDelims); //array containing user's tokenized title keywords
                           }
                   if(startYear < 1000)
                   {
                       startYear = 1000;
                   }
                   else if(startYear > 9999)
                   {
                       startYear = 9999;
                   }
               boolean matchType = false;
               boolean matchCallNum = false; 
               boolean matchTitle = false;
               boolean matchYear = false;
               int i = 0;
               //use the titleIndex hashMap to search for records if title keywords are provided
               
               if((searchTitle != null)&&(searchTitle.length > 0))
               {
                   foundReferences = useHashMapToSearch(refType, tempCallNumber, startYear, endYear, searchTitle, referenceList, mainWindow.titleIndex);  
               }
               //does the sequential search if nothing can be found for title keywords
               else if((searchTitle == null)||(searchTitle.length <= 0)) {
               for(i = 0; i<referenceListSize; i++)
               {
               Reference newReference = referenceList.get(i);
               String test[] = newReference.getTitle().split(userDelims);
               
               if((refType.equalsIgnoreCase(newReference.getType())) || refType.equalsIgnoreCase("") || refType.equalsIgnoreCase(" "))
               {
                   matchType = true;
               }
               else matchType = false;
               if((tempCallNumber.equalsIgnoreCase(newReference.getCallNumber())) || tempCallNumber.equalsIgnoreCase("") || tempCallNumber.equalsIgnoreCase(" "))
               {
                   matchCallNum = true;
               }
               matchTitle = true;
               if((newReference.getYear() >= startYear) && (newReference.getYear() <= endYear))
                  {
                  matchYear = true;
                  }
                   /*displays reference results on screen if title and call number match, and year falls within
                   specified range*/
                   if((matchType == true)&&(matchCallNum == true)&&(matchTitle == true)&&(matchYear == true))
                   {
                       if(newReference instanceof Book)
                       {
                           Book newBook = (Book)newReference;
                           String output = newBook.toString();
                           foundReferences = foundReferences + output + "\n";
                       }
                       else if(newReference instanceof Journal)
                               {
                               Journal newJournal = (Journal)newReference;
                               String output = newJournal.toString();
                               foundReferences = foundReferences + output + "\n";
                               }
                   }
                   else noMatch = noMatch + 1;
               }
                    if(noMatch >= referenceListSize){
                     foundReferences = "Sorry, there are no matches for your search query.";
                   } 
                   }
        } else foundReferences = "Sorry, no references to search for in the system!";
                   return foundReferences;
    }
/**
 * <p>Method that performs the search for references using the titleIndex hash map instead of sequentially.
 * Once references are found, they are printed out, just like in the sequential search procedures contained
 * within the main method.</p>
 * 
 * @author ccantwel
 */
public static String useHashMapToSearch(String searchType, String tempCallNum, int startYear, int endYear, String[] tempTitle, ArrayList<Reference> referenceList, HashMap<String, ArrayList<Integer>> titleIndex)
    {
                  if(titleIndex == null)
                  { System.out.print("Equals null!\n"); }
                  String searchResults = new String();
                  int noMatch = 0;
                  boolean matchType = false;
                  boolean matchCallNum = false; 
                  boolean matchTitle = false;
                  boolean matchYear = false;
                  ArrayList<Reference> referencesToCheck = null;
                  ArrayList<Integer> foundReferences = null;
                  ArrayList<Integer> referencesInCommon = null;
                  ArrayList<ArrayList<Integer>> theFoundReferences = new ArrayList<ArrayList<Integer>>();
                  String foundKeyword = new String();
                  for(int titleIndexes = 0; titleIndexes<tempTitle.length; titleIndexes++)
                  {
                  //obtain the keyset for the titleIndex hashmap and put it in an array
                  String toTest = tempTitle[titleIndexes].toLowerCase();
                  Object [] titleKeys = titleIndex.keySet().toArray();
                  String []newKeys = new String[titleKeys.length];
                  for(int r = 0; r<titleKeys.length; r++)
                  {
                      newKeys[r] = titleKeys[r].toString();
                     
                  }
                  //check the title keyword against the keys of the hash map
                  int u = 0;
                  for(u = 0; u<newKeys.length; u++)
                  {
                      if(toTest.equals(newKeys[u]))
                      {
                          foundKeyword = toTest;
                          break;
                      }
                  }
                  //add the list of indexes corresponding to the found keywords to the list of found references
                  foundReferences = titleIndex.get(foundKeyword);
                  theFoundReferences.add(foundReferences);
                  }
                  /*if found reference list is not null, create a list of references to check the call numbers
                  and years of, and actually performs the checking and printing of references*/
                  if(theFoundReferences != null)
                  {
                      referencesToCheck = new ArrayList<Reference>();
                      if(theFoundReferences.size() == 1)
                      {
                    //add the corresponding references to a list of references to check
                    for(int p = 0; p<(theFoundReferences.get(0)).size(); p++)    
                      {
                          int theIndex = (theFoundReferences.get(0)).get(p);
                          referencesToCheck.add(referenceList.get(theIndex));
                      }
                      }
                      //take the indexes that each of the lists in foundReferences have in common, and makes
                      //a new list containing only those indexes
                      else if(theFoundReferences.size() > 1)
                      {
                         for(int h = 0; h<theFoundReferences.size(); h++)
                          {
                              ArrayList<Integer> newIndexes = theFoundReferences.get(h);
                              for(int j = (h+1); j<theFoundReferences.size(); j++)
                              {
                              ArrayList<Integer> otherIndexes = theFoundReferences.get(j);
                              int n = 0;
                              for(int m = 0; m < newIndexes.size(); m++)
                              {
                                  if(n>=otherIndexes.size())
                                  {
                                      break;
                                  }
                                  else if((newIndexes.get(m)) == (otherIndexes.get(n)))
                                  {
                                      Reference newReferenceToAdd = referenceList.get(otherIndexes.get(n));
                                      int thereIsMatch = 0;
                                      for(int s = 0; s<referencesToCheck.size(); s++)
                                      {
                                          if(newReferenceToAdd.equals(referencesToCheck.get(s)))
                                          {
                                              thereIsMatch = 1;
                                              break;
                                          }
                                       }
                                     if(thereIsMatch > 0){
                                         break;
                                     }
                                     else referencesToCheck.add(newReferenceToAdd);
                                     
                                  n = n + 1;            
                                  }
                              }
                              }
                          }
                      }
                    /*goes through the obtained references to check if their call numbers, types, and years
                      match the user's input before displaying them on the screen*/
                      for(int f = 0; f<referencesToCheck.size(); f++)
                      {
                        Reference referenceToCheck = referencesToCheck.get(f);  
                        if((searchType.equalsIgnoreCase(referenceToCheck.getType())) || searchType.equalsIgnoreCase("") || searchType.equalsIgnoreCase(" "))
                    {
                   matchType = true;
                    }
               else matchType = false;
               if((tempCallNum.equalsIgnoreCase(referenceToCheck.getCallNumber())) || tempCallNum.equalsIgnoreCase("") || tempCallNum.equalsIgnoreCase(" "))
               {
                   matchCallNum = true; 
               }
               matchTitle = true;  
               if((referenceToCheck.getYear() >= startYear) && (referenceToCheck.getYear() <= endYear))
                  {
                  matchYear = true; 
                  }
                   /*displays reference results on screen if title and call number match, and year falls within
                   specified range*/
                   if((matchType == true)&&(matchCallNum == true)&&(matchTitle == true)&&(matchYear == true))
                   {
                       if(referenceToCheck instanceof Book)
                       {
                           Book newBook = (Book)referenceToCheck;
                           String output = newBook.toString();
                           searchResults = searchResults + output + "\n";
                       }
                       else if(referenceToCheck instanceof Journal)
                               {
                               Journal newJournal = (Journal)referenceToCheck;
                               String output = newJournal .toString();
                               searchResults = searchResults + output + "\n";
                               }
                   }
                   else noMatch = noMatch + 1;
                      }
                   if(noMatch > theFoundReferences.size())
                      {
                          searchResults = "Sorry, no matches found";
                      }
                  }else searchResults = "Can't find any references!!";
                  return searchResults; 
                  }
}

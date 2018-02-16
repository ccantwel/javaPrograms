/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrarySearch;

/**
 *
 * @author ccantwel
 */
public class Book extends Reference{
    /*
     * -------------------------
     * INSTANCE/MEMBER VARIABLES
     * -------------------------
     */

     /**
     * <p>Author(s) of the book</p>
     */
    private String authors;
    
    /**
     * <p>Name of publisher(s) for the book.</p>
     */
    private String publisher;
    
    /*
     * ------------
     * CONSTRUCTORS
     * ------------
     */
    
    /**
     * <p>Standard constructor creates a book according to the specified call number, author(s), title,
     * publisher, and publishing year
     * 
     * @param type Type of reference (book in this case)
     * @param callNum Book's call number
     * @param authors Book's author(s)
     * @param title Book's title
     * @param publish Book's publisher name
     * @param year Book's publishing year
     */
     public Book (String type, String callNum, String authors, String title, String publish, int year) throws InvalidCallNumberException, InvalidYearException, InvalidTitleException {
        super(type, callNum, title, year);
        this.authors = authors;
        this.publisher = publish;
        }
     /*
     * --------
     * MUTATORS
     * --------
     */
        
        /**
     * <p>Sets the author(s) for the book</p>
     * 
     * @param authors Data for the book's author(s)
     * @return <code>true</code> if the new data was assigned; <code>false</code> if the assignment failed
     */
       public boolean setAuthors(String authors)
       {
           this.authors = authors;
           System.out.print("Author name(s) written successfully\n");
           return true;
       }
       
       /**
     * <p>Sets the publisher for the book</p>
     * 
     * @param publish Data for the book's publisher(s)
     * @return <code>true</code> if the new data was assigned; <code>false</code> if the assignment failed
     */
       public boolean setPublisher(String publish)
       {
           this.publisher = publisher;
           System.out.print("Publisher information written successfully\n");
           return true;
       }
       
      /*
     * ---------
     * ACCESSORS
     * ---------
     */
    
    /**
     * <p>Retrieves the author(s) of the book.</p>
     * @return Author(s) of book
     */
    public String getAuthors () {
        return this.authors;
    }
    
    /**
     * <p>Retrieves the publisher name(s) for the book.</p>
     * @return Publisher of book
     */
    public String getPublisher ()
    {
        return this.publisher;
    }
    
     /*
     * -------------
     * OTHER METHODS
     * -------------
     */
   
   /**
     * <p>Compares the authors of a book user is adding 
    *  with the same information of a book already in the arrayList</p>
     * @return true if the authors of the book user is adding 
    *  are identical, false otherwise
    **/
   public boolean areAuthorsEqual(Book otherBook)
   {
       if(((this.authors).equalsIgnoreCase(otherBook.authors)))
       {
           return true;
       }
       else return false;
   }
   
   /**
     * <p>Compares the  publisher of a book user is adding 
    *  with the same information of a book already in the arrayList</p>
     * @return true if publisher of the book user is adding 
    *  are identical, false otherwise
    **/
   public boolean arePublishersEqual(Book otherBook)
   {
       if(((this.publisher).equalsIgnoreCase(otherBook.publisher)))
       {
           return true;
       }
       else return false;
   }
   
}

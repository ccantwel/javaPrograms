package LibrarySearch;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 * <p>This class is responsible for the reading in of information from files, and creating references from
 * the data.  Also, it is responsible for taking a list of references and writing each reference to a file.
 * November 11 2013</p> 
 * 
 * @author ccantwel
 */

public class FileIO {
    
    /**
     * Used for reading from the input file
     */
    private Scanner inputStream;
    /**
     * Used for writing to the input file using PrintWriter
     */
    private PrintWriter outputStream;  
    
                    
    /**
     * Default constructor: sets the default input and output stream buffers 
     * to the keyboard and the screen, respectively.
     */
    public FileIO () {
        inputStream = new Scanner(System.in);
        outputStream= new PrintWriter(new PrintWriter(System.out));
    }    
       
    /**
     * Open the input file for reading and read all lines.
     * @return Array List of References, representing all References in the file
     */
    public ArrayList <Reference> readDataFromFile(String inFile)
        {
        ArrayList <Reference> references = new ArrayList <Reference>();
        // Open the input file for reading; if failed to do so, display error message and exit program
        inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(inFile));
        }
        catch (FileNotFoundException exception) {
            System.err.println("(FileIO): " + exception.toString());
            System.err.println("(FileIO): Error opening file " + inFile);
            System.exit(0);
        }                
        //Read each line of the file
        String next = null;
        String userDelims = "[\"\", =!?:;\n]+";
        /*while loop that reads lines in from file, tokenizes the lines, creates references containing specified type,
         * call number, title, and year, and either organization (for journals), or authors and publisher (for books), 
         * and add the created references to the referenceList
         
         */
            while(inputStream.hasNextLine()) {
            next = inputStream.nextLine();
            String nextLine[] = next.split(userDelims);
            String fileCallNum = null; String fileTitle = null; int fileYear = 0;
            String fileType = new String(nextLine[1]);
            if(fileType.equalsIgnoreCase("book"))
            {
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            fileCallNum = nextLine[1];
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            String fileAuthors = nextLine[1];
            if(nextLine.length >= 3)
            {
            for(int x = 2; x<nextLine.length; x++){
                fileAuthors = fileAuthors + " " + nextLine[x];
            }
            }
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            fileTitle = new String(nextLine[1]);
            if(nextLine.length >= 3)
            {
            for(int x = 2; x<nextLine.length; x++){
                fileTitle = fileTitle + " " + nextLine[x];
            }
            }
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            String filePublisher = new String(nextLine[1]);
            if(nextLine.length >= 3)
            {
            for(int x = 2; x<nextLine.length; x++){
                filePublisher = filePublisher + " " + nextLine[x];
            }
            }
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            fileYear = Integer.parseInt(nextLine[1]);
            Book newBook = null;
            try{ 
            newBook = new Book(fileType, fileCallNum, fileAuthors, fileTitle, filePublisher, fileYear); 
            references.add(newBook);
            }
            catch(InvalidCallNumberException x) {
                System.out.print("Call number is blank; can't add\n");
            }
            catch(InvalidTitleException x){
                System.out.print("Title is blank; can't add\n");
                }
            catch(InvalidYearException x) {
            System.out.print("Year is outside range from 1000 to 9999; cant add\n");    
            }
         }
            else if(fileType.equalsIgnoreCase("journal"))
            {
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            fileCallNum = nextLine[1];
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            fileTitle = new String(nextLine[1]);
            if(nextLine.length >= 3)
            {
            for(int x = 2; x<nextLine.length; x++){
                fileTitle = fileTitle + " " + nextLine[x];
            }
            }
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            String fileOrganization = new String(nextLine[1]);
            if(nextLine.length >= 3)
            {
            for(int x = 2; x<nextLine.length; x++){
                fileOrganization = fileOrganization + " " + nextLine[x];
            }
            }
            next = inputStream.nextLine();
            nextLine = next.split(userDelims);
            fileYear = Integer.parseInt(nextLine[1]);
            Journal newJournal = null;
              try{ 
           newJournal = new Journal(fileType, fileCallNum, fileTitle, fileOrganization, fileYear);
           references.add(newJournal);
            }
            catch(InvalidCallNumberException x) {
                System.out.print("Call number is blank; can't add\n");
            }
            catch(InvalidTitleException x){
                System.out.print("Title is blank; can't add\n");
                }
            catch(InvalidYearException x) {
            System.out.print("Year is outside range from 1000 to 9999; cant add\n");    
            }
            }
            inputStream.nextLine();
            }
            inputStream.close();
        return references;
    }
    
    /**
     * Open the output file for writing and write to it a list of references.
     * @param referenceList List of references in system
     * @param outFile File where the list of references will be written
     */
    public boolean writeDataToFile (ArrayList <Reference> referenceList, String outFile) {
        int listSize = referenceList.size();
        // Open the output file for writing; if failed to do so, display error message and exit program
        outputStream = null;
        try {
        outputStream = new PrintWriter(new FileOutputStream(outFile));
        }
        catch (FileNotFoundException exception) {
            System.err.println("(FileIO): " + exception.toString());
            System.err.println("(FileIO): Error opening file " + outFile);
            System.exit(0);
        }                       
        //actually write a list of references to data file    
        for(int x = 0; x < listSize; x++)
            {
                if((referenceList.get(x)) instanceof Book)
                {
                    Book newBook = (Book)referenceList.get(x);
                    outputStream.print(newBook.toFileString());
                }
                else if((referenceList.get(x)) instanceof Journal)
                {
                    Journal newJournal = (Journal)referenceList.get(x);
                    outputStream.print(newJournal.toFileString());
                }
                outputStream.print("\n");
            }
                
            //finally, close file before exiting the program
            outputStream.close();
            return true;
    }
    /**
     * Creates a Hash Map containing all of the title keywords in the system and all the indexes 
     * from the arrayList containing that specific keyword
     * @param referenceList List of references in the system
     */
    public HashMap<String, ArrayList<Integer>> updateTitleIndex(ArrayList<Reference> referenceList)
    {
        HashMap <String, ArrayList<Integer>> titleIndex  = new HashMap <String, ArrayList<Integer>>(100);
        String userDelims = "[\"\", =!?:;\n]+";
        ArrayList<String> titleWords = new ArrayList<String>();
        for(int w = 0; w < referenceList.size(); w++)
        {
           String [] titleKeywords = referenceList.get(w).getTitle().split(userDelims);
            for(int v = 0; v<titleKeywords.length; v++)
            {
                int matches = 0;
                if(v>0){
                    /*checks the arrayList of title keywords to see if keyword is already there before
                    adding*/
                    for(int x = 0; x<titleWords.size(); x++)
                    {
                        if(titleWords.get(x).equalsIgnoreCase(titleKeywords[v]))
                        {
                            matches = matches + 1;
                        }
                    }
                    //adds title keyword to arrayList if no duplicates are found
                if(!(matches > 0))
                {
                    titleWords.add(titleKeywords[v]);
                }
                }  
                else titleWords.add(titleKeywords[v]);
            }
            /*take the arrayList of title keywords and obain arrayLists containing the indexes of
            references containing those title keywords' arrayList and corresponding keywords are
            added to hash map*/
            for(int q = 0; q<titleWords.size(); q++)
            {
                ArrayList<Integer> indexes = new ArrayList<Integer>();
                for(int y = 0; y < referenceList.size(); y++)
                {
                String test[] = referenceList.get(y).getTitle().split(userDelims);
                for(int l = 0; l<test.length; l++)
                {
                    if(test[l].equalsIgnoreCase(titleWords.get(q)))
                    {
                        indexes.add(y);
                    }
                  }
                }
                String wordToAdd = titleWords.get(q).toLowerCase();
                titleIndex.put(wordToAdd, indexes);
            }
        }
        return titleIndex;
    }
}


 
NAME: CHANCE CANTWELL		   STUDENT ID #: 0792138
COURSE: CIS2430                 ASSIGNMENT: 4 – LIBRARY SEARCH
DATE: November 28 2013
_________________________________________________________________________
COMPILING THE PROGRAM

In order to compile this program, navigate to the src directory and type the following:
javac LibrarySearch/*.java LibrarySearchGUI/*.java

RUNNING THE PROGRAM

To run the project from the command line, remain in the directory where the program was compiled and type the following:

java LibrarySearchGUI.mainWindow refin.txt refout.txt

where refin.txt and refout.txt represent the names of your input and output files, respectively

ABOUT THE PROGRAM, OPERATING INSTRUCTIONS

This is an improvement on the simple Library Search program made in Assignment 1, and further developed in Assignments 2 and 3.  In this program, the user is allowed to enter books or journals as general references into the same arrayList that is able to dynamically grow in size as required.  The main difference between this program and the ones produced in previous assignments is that this program has been created using a GUI interface for the main menu, add and search functions.  Selecting add from the commands menu (in main window), will allow the user to add a reference into the program.  If the user is adding a book, they can select book in the combo box for type of reference;; if the user is adding a journal, they can do the exact same thing, except selecting journal instead of book.  After specifying what the user wants to enter, they are then permitted to enter the call number, title, year, and either authors and publisher (for books), or publishing organization (for journals), in the corresponding text fields, and click the add button to complete the operation.  User can click reset button to delete all the contents of the text fields so that they can try again if they choose.  Selecting search from the commands menu (in main window) will allow the user to search for references in the systems.  In the corresponding text fields, the user is allowed to specify the type of reference they are searching for, call number, title keywords (separated by spaces and/or semicolons), start year, and/or end year, and click on search button to 
have the program search for references and have the results displayed in the searchResultsDisplay.  User can click reset button to delete all the contents of the text fields so that they can try again if they choose.  
If title keywords are provided, the program uses an arrayList of indexes corresponding to each of their keywords (as stored in a hash map) to greatly narrow down the references to search for matching call number, type, and/or publishing year (if provided).  The search is performed sequentially through all references in the system otherwise.  In both the add and search windows, clicking the X in the top right hand corner, or ‘Close Window’ in the menu, simply closes the window.  Selecting ‘Quit’ from the commands menu(in main window) will allow the user to save the reference data to the specified output file before exiting the program;  clicking the X at the top right hand corner of the window simply exits the program without saving anything.

HOW IT WAS ENSURED THAT THE PROGRAM RUNS CORRECTLY

In order to ensure that the program runs correctly, testing was performed on the creator’s own Toshiba laptop computer running Microsoft Windows 8.  Any compatibility issues addressed during testing were rectified.  The following is a list of the tests performed:
A) add command:
i. Validity check: tested to ensure that a call number and title are both entered for books and journals, as well as a publishing year that falls within the range of 1000 to 9999 (including 1000 and 9999).  If any or none of these conditions are met, the user is simply notified that the record they were trying to enter could not be added into the system, and is prompted to try again.
ii. Duplicate check: tested to ensure that if a specific call and number and year combination is already in the list of references, the program rejects the new book or journal prompt the user that it already exists, and prompt the user to try again.  
iii. Capacity Check: No test required; reference list was implemented as an arrayList that can dynamically grow as more books or journals are added.
C) Search Command
i. Test for no inputs for call number, authors, title, publisher, and starting and ending years (for book), or call number, title, organization, and starting and ending years to ensure that program comes back with all elements in book or journal list as results
ii. Tested for single and multiple words as search requests for call numbers and titles
iii. (In call numbers and titles) Tested for words with different combinations of upper and lower-case letters, such as “dummies”, “Dummies”, and “DUMMIES”.
iv. Tested for starting and ending years falling both inside and outside the range of 1000 to 9999 (including 1000 and 9999) as search requests; if starting and ending years fall outside the range, values are simply set to 1000 and 9999.
v. Tested for matching of call number and titles at the word level.  For example, “Steve” and “Steven” are not a match from a word-level perspective.
vi. Tested the use of the hash map of title indexes for searching when title keywords were provided, to ensure that this search method was functioning.  For example, if the user specifies the keywords ‘java’ and ‘programming’ as title keywords in the search command, the program is supposed to take the intersection of the two lists of indexes corresponding to the keywords, and only print out those references corresponding to those indexes on the arrayList, if they match the search criteria for call number, type, and/or year if it was provided.  In this example, if the keyword ‘java’ corresponds to a list containing the indexes 0, 3, 8, 9, and 20, and the keyword ‘programming’ corresponds to a list containing the indexes 0, 2, 4, 6, 8, and 20, then the program will take the intersection of the two lists (0, 8, and 20), and only search those references as found in the list of references to check if they match the call number, type, and/or year that may have been provided by the user.

SUGGESTIONS FOR IMPROVEMENT

In order to improve on the design of this program, it could be implemented using a graphical user interface (GUI) that is more aesthetically pleasing than the current interface. As well, functionality could be implemented that would allow user to enter publisher, publishing organization, and/or author names as criteria in their searches.  These improvements can be made as the user or creator develops their skills and has more experience using the Java programming language.

(C) CHANCE CANTWELL
NOVEMBER 28 2013

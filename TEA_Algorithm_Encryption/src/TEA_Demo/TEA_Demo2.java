/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TEA_Demo;

import java.util.Scanner;

/**
 *
 * @author ccantwel
 */
public class TEA_Demo2 {
    //input string from user

    private static String input;
    //input converted to individual values
    private static String[] numbers;
    //key values used for encryption and decryption
    private static int[] key;// = {53687429, 84248344, 123123, 123123};
    /* variable that stores individual values at each stage of cryption process
     * (e.g. before encryption, after encryption, after decryption)
     */
    private static int[] value;
    //copy of original values before encryption
    private static int[] originalNumbers;
    //temporary integer storage variable
    private static int[] tempStore;
    //boolean that is set to true if decryption is successful, false otherwise
    private static boolean decryptTest;
    //boolean that is set to true if encryption is successful, false otherwise
    private static boolean encryptTest;
    //boolean that is set to true if something has been decrypted, false otherwise
    private static boolean decryptedSomething;
    //boolean that is set to true if something has been encrypted, false otherwise
    private static boolean encryptedSomething;
    //boolean that is set to true if there is a failed cryption attempt, false otherwise
    private static boolean failedAttempt;
    /* boolean that is set when numbers have been encrypted (used to initiate random number generation
    for decryption keys */
    private static boolean setRandom;
    //random number generator for keys
    private static testRNG randomKeys;
    //counter for number of attempts to decrypt a value series
    private static long numAttempts;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //variables
        int x; //loop counter
        boolean done = false;  //sets to true when user selects exit option
        decryptedSomething = false;
        encryptedSomething = false;
        failedAttempt = false;
        setRandom = false;
        randomKeys = new testRNG();
        numAttempts = 0;
        int option = 0; //variable that stores user's option selection
        while (done == false) {
            /* boolean that is set to true when right number of input amounts is
             * given (number divisible by 2 for values, number divisible by 4 for
             * keys), false otherwise */
            boolean rightInputAmounts = false;
            if (setRandom == false) {
                /*Introductory menu and instructions*/
                System.out.println("Welcome to the TEA_Demo application.");
                System.out.println("Please select an option from the list below:");
                System.out.println("1. Encrypt new");
                System.out.println("2. Encrypt existing");
                System.out.println("3. Decrypt new");
                System.out.println("4. Decrypt existing");
                System.out.println("5. Exit");
                System.out.print("Enter number of choice here: ");
                /*get input from user and throw away newline character*/
                Scanner getOption = new Scanner(System.in);
                option = getOption.nextInt();
                getOption.nextLine();  //throw away newline character from previous input
            } else {
                option = 4;
            }
            if (option == 1) {
                while (rightInputAmounts == false) {
                    /* Retrieve input from user, and check whether it is equal to two
                     * values, and equal to 4 for keys.  If not, let user know and have 
                     * them try again.
                     */
                    value = getInput();
                    key = getKey();
                    if ((value.length != 2) || (key.length != 4)) {
                        rightInputAmounts = false;
                        System.out.println("Must have two inputs for values and four inputs for keys!");
                    } else {
                        rightInputAmounts = true;
                    }
                }
                /* make copies of data before the encryption process starts (in case it is needed later) */
                originalNumbers = new int[value.length];
                originalNumbers = makeCopy(value);
                tempStore = new int[value.length];
                tempStore = makeCopy(value);
                /* Perform encryption procedure, printing the results 
                 * to screen after each step.
                 */
                /* Consulted "timing - How do I time a method's execution in Java - Stack Overflow" on
                 * March 9, 2017 to learn how to determine a method's execution time
                 * URL: http://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java
                 */
                long encryptStart = System.nanoTime();
                value = encryption(value, key);
                long encryptEnd = System.nanoTime();
                long execution = (encryptEnd - encryptStart);///1000000;
                System.out.println("Encryption took " + execution + " nanoseconds");//milliseconds");

                System.out.println("Here are your encrypted values");
                for (x = 0; x < value.length; x++) {
                    System.out.println(value[x]);
                }

                decryptedSomething = false;
                encryptedSomething = true;
                setRandom = true;
            } else if (option == 2) {
                /* If there is no existing decrypted values, have user input 
                 * 2 values to encrypt.  Only proceed when right number of inputs
                 * has been entered */
                if (value == null) {
                    System.out.println("No values to encrypt.  You must specify "
                            + "values to encrypt!");
                    while (rightInputAmounts == false) {
                        value = getInput();
                        if (value.length == 2) {
                            rightInputAmounts = true;
                        }
                    }
                    decryptedSomething = false;
                }
                /* Make copy of value variable for reset if decryption fails
                 */
                tempStore = new int[value.length];
                tempStore = makeCopy(value);

                /* Print out encrypted values in system for user */
                System.out.println("Here are decrypted values in systems");
                for (x = 0; x < value.length; x++) {
                    System.out.println(value[x]);
                }
                rightInputAmounts = false;
                /*Obtain input from user for keys and only proceed with 4 inputs */
                while (rightInputAmounts == false) {
                    key = getKey();
                    if ((value.length != 2) || (key.length != 4)) {
                        rightInputAmounts = false;
                        System.out.println("Must have a number of inputs equal to 2 for values, "
                                + "or equal to four for keys!");
                    } else {
                        rightInputAmounts = true;
                    }
                }
                /* Perform encryption procedure and print out the results after each step */
                value = encryption(value, key);
                System.out.println("Here are your encrypted values");
                for (x = 0; x < value.length; x++) {
                    System.out.println(value[x]);
                }

                /* Test whether the encryption process was successful and let the user
                 * know with printed out message. */
                if (decryptedSomething == true) {
                    encryptTest = testEncrypt(value, originalNumbers);
                    if (encryptTest == true) {
                        System.out.println("Encryption successful!");
                        decryptedSomething = false;
                        failedAttempt = false;
                    } else {
                        System.out.println("Encryption failed!");
                        /* reset the values to what they were before failed 
                         * encryption process started
                         */
                        failedAttempt = true;
                        for (x = 0; x < value.length; x++) {
                            if ((originalNumbers != null) && (tempStore != null)) {
                                value[x] = tempStore[x];
                            }
                        }
                    }
                }

                encryptedSomething = true;
                setRandom = true;
            } else if (option == 3) {
                while (rightInputAmounts == false) {
                    /* Retrieve input from user, and check whether it is equal to two for 
                     * values, and equal to 4 for keys.  If not, let user know and have 
                     * them try again.
                     */
                    value = getInput();
                    key = getKey();
                    if ((value.length != 2) || (key.length != 4)) {
                        rightInputAmounts = false;
                        System.out.println("Must have two inputs for values and four inputs for keys!");
                    } else {
                        rightInputAmounts = true;
                    }
                }
                /* Create and store copy of integer values before starting the decryption 
                 * process. */
                originalNumbers = new int[value.length];
                originalNumbers = makeCopy(value);
                tempStore = new int[value.length];
                tempStore = makeCopy(value);
                /* Perform decryption procedure, printing the results 
                 * to screen after each step.
                 */
                value = decryption(value, key);
                System.out.println("Here are your decrypted values");
                for (x = 0; x < value.length; x++) {
                    System.out.println(value[x]);
                }
                decryptedSomething = true;
                encryptedSomething = false;
            } else if (option == 4) {
                /* If there is no existing encrypted values, have user input 
                 * 2 values to decrypt.  Only proceed when right number of inputs
                 * has been entered */
                if (value == null) {
                    System.out.println("No values to decrypt.  You must specify "
                            + "values to decrypt!");
                    value = getInput();
                    encryptedSomething = false;
                }

                /* Make copy of value variable for reset if decryption fails
                 */
                tempStore = new int[value.length];
                tempStore = makeCopy(value);

                /* Print out encrypted values in system for user */
                if (setRandom == false) {
                    System.out.println("Here are encrypted values in systems");
                    for (x = 0; x < value.length; x++) {
                        System.out.println(value[x]);
                    }
                }
                /*Obtain input from user for keys and only proceed with 4 inputs */
                if (setRandom == false) {
                    rightInputAmounts = false;
                    while (rightInputAmounts == false) {
                        key = getKey();
                        if ((value.length % 2 != 0) || (key.length % 4 != 0)) {
                            rightInputAmounts = false;
                            System.out.println("Must have a number of inputs divisible by two for values, "
                                    + "or divisible by four for keys!");
                        } else {
                            rightInputAmounts = true;
                        }
                    }
                } else {
                    key = getRandomKey();
                }

                //Perform decryption procedure and print out the results after each step 
                long decryptStart = System.nanoTime();
                value = decryption(value, key);
                long decryptEnd = System.nanoTime();
                long execution = (decryptEnd - decryptStart);///1000000;
                System.out.println("Decryption took " + execution + " nanoseconds");//milliseconds");
                if (setRandom == true) {
                    numAttempts = numAttempts + 1;
                }
                if (setRandom == false) {
                    System.out.println("Here are your decrypted values");
                    for (x = 0; x < value.length; x++) {
                        System.out.println(value[x]);
                    }
                }

                //Test whether the decryption process was successful and let the user
                //know with printed out message. 
                if (encryptedSomething == true) {
                    decryptTest = testDecrypt(value, originalNumbers);
                    if (decryptTest == true) {
                        System.out.println("Decryption successful!");
                        if (setRandom == true) {
                            System.out.println("Amount of attempts needed: " + numAttempts);
                            System.out.println("Decryption key values used:");
                            for (x = 0; x < key.length; x++) {
                                System.out.println(key[x]);
                            }
                            setRandom = false;
                        }
                        encryptedSomething = false;
                        failedAttempt = false;
                    } else {
                        if (setRandom == false) {
                            System.out.println("Decryption failed!");
                        }
                        //reset the values to what they were before failed 
                        //decryption process started

                        failedAttempt = true;
                        //System.out.println("Attempt " + numAttempts);
                        for (x = 0; x < value.length; x++) {
                            if (tempStore != null) {
                                value[x] = tempStore[x];
                            }
                        }
                    }
                }
                decryptedSomething = true;

            } else if (option == 5) {
                done = true;
            } else {
                System.out.println("Input is incorrect, please try again!");
            }
        }
    }


    /* Instrucs user and gets series of integers as input for encryption or decryption.  
     * Returns the series of integers */
    public static int[] getInput() {
        //variables
        int y;  //loop counter
        Scanner getInput = new Scanner(System.in);

        System.out.println("Enter a series of 2 integers separated by spaces.");
        input = getInput.nextLine();
        numbers = input.split("\\ ");
        int z = numbers.length;  //number of integers inputted by user
        value = new int[z];
        for (y = 0; y < numbers.length; y++) {
            value[y] = Integer.parseInt(numbers[y]);
        }
        return value;
    }
    /* Instrucs user and gets series of integers as key values for encryption and/
     * or decryption.  Returns the series of integers */

    public static int[] getKey() {
        //variables
        int y;  //loop counter
        Scanner getInput = new Scanner(System.in);

        System.out.println("Enter a series of 4 integers for key values separated by spaces.");
        input = getInput.nextLine();
        numbers = input.split("\\ ");
        int z = numbers.length;  //number of integers inputted by user
        key = new int[z];
        for (y = 0; y < numbers.length; y++) {
            key[y] = Integer.parseInt(numbers[y]);
        }
        return key;
    }
    /* Creates set of 4 random values to use for decryption keys */

    public static int[] getRandomKey() {
        //variables
        int y;  //loop counter
        key = new int[4];
        for (y = 0; y < 4; y++) {
            key[y] = randomKeys.getRNG().nextInt(randomKeys.getMaxRange()) + 1;
        }
        return key;
    }
    /*Encryption and decryption functions ported to Java from C code
     * found at https://en.wikipedia.org/wiki/Tiny_Encryption_Algorithm
     * on March 4, 2017
     */
    //encryption algorithm

    public static int[] encryption(int[] value, int[] key) {
        //set up the variables
        int valueZero = value[0];
        int valueOne = value[1];
        int sum = 0;
        int x = 0; //loop counter
        int keyConstant = 0x9E3779B9; //Magic key constant
        //set up cache key
        int keyZero = key[0], keyOne = key[1], keyTwo = key[2];
        int keyThree = key[3];
        //start the encrypting cycle
        for (x = 0; x < 32; x++) {
            sum += keyConstant;
            valueZero += ((valueOne << 4) + keyZero) ^ (valueOne + sum) ^ ((valueOne >>> 5) + keyOne);
            valueOne += ((valueZero << 4) + keyTwo) ^ (valueZero + sum) ^ ((valueZero >>> 5) + keyThree);
        }//end encrypting cycle here
        value[0] = valueZero;
        value[1] = valueOne;
        //System.out.println("Entering encryption method...");
        return value;
    }
    //decryption algorithm

    public static int[] decryption(int[] value, int[] key) {
        //set up the variables
        int valueZero = value[0];
        int valueOne = value[1];
        int sum = 0xC6EF3720; //from literature
        int x = 0;
        int keyConstant = 0x9E3779B9; //Magic key constant
        //set up cache key
        int keyZero = key[0], keyOne = key[1], keyTwo = key[2];
        int keyThree = key[3];
        //start the decrypting cycle
        for (x = 0; x < 32; x++) {
            valueOne -= ((valueZero << 4) + keyTwo) ^ (valueZero + sum) ^ ((valueZero >>> 5) + keyThree);
            valueZero -= ((valueOne << 4) + keyZero) ^ (valueOne + sum) ^ ((valueOne >>> 5) + keyOne);
            sum -= keyConstant;
        }//end decrypting cycle here
        value[0] = valueZero;
        value[1] = valueOne;
        //System.out.print("Entering decryption method...");
        return value;
    }

    /**
     * Creates a copy of the user's inputted integers before the encryption process
     * starts
     * @param userNumbers Series of integers inputted by user
     * @return originalNumbers (exact copy of userNumbers
     */
    public static int[] makeCopy(int[] userNumbers) {
        int[] original = new int[userNumbers.length];
        int x; //loop counter
        for (x = 0; x < userNumbers.length; x++) {
            original[x] = userNumbers[x];
        }
        return original;
    }

    /**
     * Test to determine whether the decryption process was successful (output
     * matches what user inputted at start)      
     * @param decryptedValues Series of integers obtained after decryption 
     * procedure
     * @param originalNums Series of integers obtained from user at start
     * @return <code>true</code> if the decryption was successful, 
     * <code>false</code> otherwise
     */
    public static boolean testDecrypt(int[] decryptedValues, int[] originalNums) {
        boolean testDecrypt = false;
        int x; //loop counter
        for (x = 0; x < originalNums.length; x++) {
            //System.out.println("Decrypted: " + decryptedValues[x]);
            //System.out.println("Original: " + originalNums[x]);
            if (originalNums[x] == decryptedValues[x]) {
                testDecrypt = true;
            } else {
                testDecrypt = false;
                //break;
            }
        }
        return testDecrypt;
    }

    /**
     * Test to determine whether the encryption process was successful (output
     * matches what user inputted at start)     * 
     * @param encryptedValues Series of integers obtained after encryption 
     * procedure
     * @param originalNums Series of integers obtained from user at start
     * @return <code>true</code> if the encryption was successful, 
     * <code>false</code> otherwise
     */
    public static boolean testEncrypt(int[] encryptedValues, int[] originalNums) {
        boolean testEncrypt = false;
        int x; //loop counter
        for (x = 0; x < originalNums.length; x++) {
            if (originalNums[x] == encryptedValues[x]) {
                testEncrypt = true;
            } else {
                testEncrypt = false;
            }
        }
        return testEncrypt;
    }
}
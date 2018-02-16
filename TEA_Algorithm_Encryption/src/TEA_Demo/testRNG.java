/**
 * <p>Representation of a random number generator to use with the TEA_Demo application.</p>
 * Consulted "Getting random numbers in Java - Stack Overflow" on March 8, 2017, for informatiom
 * to assist with implementing this class.
 * URL: http://stackoverflow.com/questions/5887709/gettingrandomnumbersinjava
 * 
 * @author ccantwel
 */
package TEA_Demo;

import java.util.Random;

public class testRNG {

    /*
     * -------------------------
     * INSTANCE/MEMBER VARIABLES
     * -------------------------
     */
    /**
     * <p>Maximum range for the random number generation./p>
     */
    private final int maxRange = (Integer.MAX_VALUE) - 1;
    /**
     * <p>Minimum range for the random number generation./p>
     */
    private final int minRange = 1;
    /**
     * <p>Random number generator</p>
     */
    private Random RNG;

    /*
     * ------------
     * CONSTRUCTORS
     * ------------
     */
    /**
     * <p>Creates RNG object</p>
     */
    public testRNG() {
        this.RNG = new Random();
    }

    /*
     * --------
     * MUTATORS
     * --------
     */
    //INSERT METHODS HERE
    /*
     * ---------
     * ACCESSORS
     * ---------
     */    
    /**
     * <p>Retrieves the maximum range of the random number generator</p>
     * @return maximum range of random number generator
     */
    public int getMaxRange() {
        return this.maxRange;
    }

    /**
     * <p>Retrieves the minimum range of the random number generator</p>
     * @return minimum range of random number generator
     */
    public int getMinRange() {
        return this.minRange;
    }

    /**
     * <p>Retrieves the random number generation object</p>
     * @return random number generation object (RNG)
     */
    public Random getRNG() {
        return this.RNG;
    }
    /*
     * -------------
     * OTHER METHODS
     * -------------
     */
    //INSERT METHODS HERE
}
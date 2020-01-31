/**
 * A utility class for the fox hound program.
 * 
 * It contains helper functions to check the state of the game
 * board and validate board coordinates and figure positions.
 */

import java.util.Arrays;

public class FoxHoundUtils {

    // ATTENTION: Changing the following given constants can 
    // negatively affect the outcome of the auto grading!

    /** Default dimension of the game board in case none is specified. */
    public static final int DEFAULT_DIM = 8;
    /** Minimum possible dimension of the game board. */
    public static final int MIN_DIM = 4;
    /** Maximum possible dimension of the game board. */
    public static final int MAX_DIM = 26;

    /** Symbol to represent a hound figure. */
    public static final char HOUND_FIELD = 'H';
    /** Symbol to represent the fox figure. */
    public static final char FOX_FIELD = 'F';

    // HINT Write your own constants here to improve code readability ...



    public static String[] initialisePositions(int dimension) {
        // TODO implement me

        int foxletter = -1; //the column of the fox
        int lengthofhoundarray;
        int [] odds = {5,9,13,17,21,25};//explained later
        int [] evens = {4,8,12,16,20,24};//explained later

        if (  (dimension%2) == 0  ) { // if dimension is even

            lengthofhoundarray = dimension/2;
            //foxletter = (dimension+1)/2 + 1;

            // for foxletter, need another for loop because there will be 2 cases for fox's column location, depending on whether the middle is white or black.
            // for dimensions 4,8,12,16,20,24 middle is on closer to the right >- foxletter = (dimension+1)/2 + 1;
            // for dimensions 6,10,14,18,22,26 middle is on closer to the left -> foxletter = dimension+1)/2;


            for (int i = 0; i<evens.length;i++) { // if dimension is in evens {4,8,12,16,20,24}

                if (evens[i] == dimension) {
                    foxletter = (dimension)/2 + 1; //closer to the right
                   // System.out.println("True");
                    //System.out.println("foxletter1: " + foxletter );
                }


                if (foxletter == -1) {
                    foxletter = (dimension)/2;
                }

            }
            //foxletter is correct for 6,10,14...

          //  System.out.println("foxletter2: " + foxletter );

            //foxletter = dimension/2 + 1;


        }


        else { // if dimension is odd

            lengthofhoundarray = (dimension-1)/2;// round down!!! not up!! mistake in the instructions!!
           // foxletter = (dimension+1)/2 + 1; //remove later
            //foxletter = (dimension+1)/2;

            // need another for loop because there will be 2 cases for fox's column location, depending on whether the middle is white or black.
            // if middle is white, for dimensions 5,9,13...25 then -> foxletter = (dimension+1)/2 + 1;
            // if middle is black, for dimensions 7,11,15...23 then -> foxletter = (dimension+1)/2;
            // if the value of the dimension is an element in the array odds, then the middle is white.
            // else the middle is black.

            for (int i = 0; i<odds.length;i++) { // if dimension in {5,9,13,17,21,25};

                if (odds[i] == dimension) {
                    foxletter = (dimension+1)/2 + 1; //middle is white
                }


                if (foxletter == -1) {
                    foxletter =  (dimension+1)/2;//middle is black
                }


            }
           // System.out.println("foxletter: " + foxletter );

        }


        String foxposition = Character.toString('A' + (foxletter - 1)) + Integer.toString(dimension);

        //String houndposition = Character.toString(something) + Integer.toString(1);
        //char something;



        String[] houndarray = new String[lengthofhoundarray]; // creating an array of strings for hound positions.
// [B1, D1, F1...]
        //System.out.println(houndarray.length);

        for (int i=0;i<houndarray.length;i++) {
            houndarray[i] = (Character.toString('B'+2*i)) + "1"; // "2*i" because every other letter[B1, D1, F1...] for hounds
            // "1" because hounds are always on the top row.
        }

        String[] finalarray = new String[houndarray.length+1]; //hounds + 1 fox

        for (int i=0;i<finalarray.length-1;i++) { //adding houndpositions to finalarray
            finalarray[i] = houndarray[i];
        }

        finalarray[finalarray.length-1] = foxposition; //last elemnt of finalarray is fox position


                //houndarray + foxposition ; //adding a string to a string of arrays. yikes.


        // loop through letters until i < dimension.


        // hounds position (j,k) <- j = every other letter (starting from B), k = 1


        // fox position (a,b) <- b = dimension
        //      if dim is even then
        //             a = dimension/2 + 1
        //      else
        //             a = (dimension+1)/2
        //

        System.out.println(Arrays.toString(finalarray));
        return finalarray;



    }

}

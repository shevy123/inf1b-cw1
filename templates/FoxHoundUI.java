import java.util.Scanner;
import java.util.Objects;
import java.util.Arrays;

/**
 * A utility class for the fox hound program.
 * 
 * It contains helper functions for all user interface related
 * functionality such as printing menus and displaying the game board.
 */
public class FoxHoundUI {

    /** Number of main menu entries. */
    private static final int MENU_ENTRIES = 2;
    /** Main menu display string. */
    private static final String MAIN_MENU =
        "\n1. Move\n2. Exit\n\nEnter 1 - 2:";

    /** Menu entry to select a move action. */
    public static final int MENU_MOVE = 1;
    /** Menu entry to terminate the program. */
    public static final int MENU_EXIT = 2;

    public static void displayBoard(String[] players, int dimension) {
        // TODO implement me
        // worry about 01 vs 1 later

        //GOAL:
// create every coordinate eg. a1, b1... e8.
        // replace those coordinates with H or F where neccessary.






// printing the letters
        for (int i = 0; i<dimension; i++) {
            System.out.print(Character.toString('A'+ i)) ;
        }

        System.out.println() ;


 // printing out all coordinates
// need to record coordinates

        // [B1, D1, F1, H1, F9]

String[] coordinates = new String[dimension*dimension];

        int k = 0;
        for (int i = 1; i<=dimension; i++) {
            System.out.print(i + " ");
            for (int j = 0; j<dimension; j++) {
                System.out.print(Character.toString('A'+ j) + i + " ") ;
                coordinates[k] = (Character.toString('A'+ j) + Integer.toString(i)) ;
                k++;
            }

            System.out.print(i);
            System.out.println();
        }




// printing the letters AGAIN
        System.out.print("   ");
        for (int i = 0; i<dimension; i++) {
            System.out.print(Character.toString('A'+ i) + " ") ;
        }

        System.out.println() ;



// [B1, D1, F1, H1, F9]


// replacing coordinates with . and H and F

        //this is for the hounds only.
        for (int i = 0; i<players.length-1; i++) {
            for (int j = 0; j<coordinates.length; j++) {
                if (coordinates[j].equals(players[i])) {
                    coordinates[j] = "H"; //adds the corresponding H's for the hounds
                }
            }
        }

        //this is for the fox.
        int l = players.length-1;
        for (int j = 0; j<coordinates.length; j++) {
            if (coordinates[j].equals(players[l])) {
                coordinates[j] = "F"; //adds the corresponding 'F' for the fox
            }
        }

        //this is for the dots.
        for (int j = 0; j<coordinates.length; j++) {
            if (coordinates[j].equals("H") || coordinates[j].equals("F")) {
            }
            else {
                coordinates[j] = ".";
            }

        }


// for printing the map of the game using the array coordinates.

        for (int i = 0; i<dimension; i++) {
            if (dimension <=9 ) {
                System.out.print((i + 1) + " ");
            }
            else {
                if ((i + 1) <= 9) {
                    System.out.print("0" + (i + 1) + " ");
                }
                else {
                    System.out.print( (i + 1) + " ");
                }

            }


            for (int j = 0; j<dimension; j++) {
                System.out.print(coordinates[j+i*dimension] + " ");
            }




            if (dimension <=9 ) {
                System.out.print((i + 1) + " ");
            }
            else {
                if ((i + 1) <= 9) {
                    System.out.print("0" + (i + 1) + " ");
                }
                else {
                    System.out.print( (i + 1) + " ");
                }

            }


            System.out.println();
        }




        System.out.print("   ");
        for (int i = 0; i<dimension; i++) {
            System.out.print(Character.toString('A'+ i) + " ") ;
        }

        System.out.println() ;



        /*
        if (dimension <=9 ) {
                System.out.print((i + 1) + " ");
            }
            else {
                if (i + 1) <= 9) {
                    System.out.print((i + 1) + " ");
                }
                else {
                    System.out.print("0" + (i + 1) + " ");
                }

            }

         */

        //1-8,9-16



/*


        for (int i = 1; i<=dimension; i++) {
            System.out.print(i + " ");
            for (int j = 0; j<dimension; j++) {
                System.out.print(Character.toString('A'+ j) + i + " ") ;
            }

            System.out.print(i);
            System.out.println();
        }

 */



       // System.out.println(Arrays.toString(coordinates));








    }

    /**
     * Print the main menu and query the user for an entry selection.
     * 
     * @param figureToMove the figure type that has the next move
     * @param stdin a Scanner object to read user input from
     * @return a number representing the menu entry selected by the user
     * @throws IllegalArgumentException if the given figure type is invalid
     * @throws NullPointerException if the given Scanner is null
     */
    public static int mainMenuQuery(char figureToMove, Scanner stdin) {
        Objects.requireNonNull(stdin, "Given Scanner must not be null");
        if (figureToMove != FoxHoundUtils.FOX_FIELD 
         && figureToMove != FoxHoundUtils.HOUND_FIELD) {
            throw new IllegalArgumentException("Given figure field invalid: " + figureToMove);
        }

        String nextFigure = 
            figureToMove == FoxHoundUtils.FOX_FIELD ? "Fox" : "Hounds";

        int input = -1;
        while (input == -1) {
            System.out.println(nextFigure + " to move");
            System.out.println(MAIN_MENU);

            boolean validInput = false;
            if (stdin.hasNextInt()) {
                input = stdin.nextInt();
                validInput = input > 0 && input <= MENU_ENTRIES;
            }

            if (!validInput) {
                System.out.println("Please enter valid number.");
                input = -1; // reset input variable
            }

            stdin.nextLine(); // throw away the rest of the line
        }

        return input;
    }
}








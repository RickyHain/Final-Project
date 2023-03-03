import java.util.*;

public class HangMan {
    public static void main(String args[]){
        //creates a new display and gets the word to guess based on user input
        Display board = new Display();
        char[] wordArray = setWord();

        startGame(wordArray, board);
    }

    public static void startGame(char[] wordArray, Display board){
        Scanner in = new Scanner(System.in);
        char[] guessArray = new char[wordArray.length];
        blankArray(guessArray, wordArray); 
        Set<Character> guessedLetters = new TreeSet<Character>();
        boolean win = false;

        //keeps looping as long as the player hasn't won or lost yet
        while(board.getStage()<6 && !win){
            //Shows display in the terminal
            System.out.println("Guesses: " + guessedLetters);
            printArray(guessArray);
            System.out.println(board);
            System.out.print("guess: ");
            char guess = in.next().toLowerCase().charAt(0); //gets char input from user and converts it to lower case
            
            //Checks if the guessed char is in the word and if it hasn't already been guessed yet
            if(!checkGuess(wordArray, guessArray, guess)&&!inSet(guess, guessedLetters)){
                board.nextStage();
            }
            //adds the guessed letter to the guessedLetter set (accounts for duplicates because it is a set)
            guessedLetters.add(guess);

            if(Arrays.equals(guessArray, wordArray)){
                win = true;
            }
            clearScreen();
        }

        //Shows the final display in terminal and then prints whether the player won or lost
        System.out.println("Guesses: " + guessedLetters);
        printArray(wordArray);
        System.out.println(board);
        if(win){
            System.out.println("You Won!");
        }else{
            System.out.println("You Lost!");
        }

    }

    public static boolean checkGuess(char[] wordArr, char[] guessArr, char x){
        int i = 0;
        boolean inWord = false;

        //checks each element in the guessing word
        for(char elem : wordArr)
        {
            // Updates the guessing array to account for any instance of the character in the word
            if(elem == x){
                inWord = true;
                guessArr[i]=x;
            }
            i++;
        }
        System.out.println();
        //returns whether or not the guessed letter is in the word
        return inWord;
    }

    //Checks if a character is in a Set of Characters. Used to find duplicate guesses
    public static boolean inSet(char test, Set<Character> testSet){
        for (Character elem : testSet) {
            if (elem.equals(test)) {
                return true;
            }
        }
        return false;
    }

    //prints out elements in array with spaces in between
    public static void printArray(char[] arr){
        for(Character elem : arr)
        {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    //clears the terminal (taken from user satish on the forum https://stackoverflow.com/a/32295974)
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    //Creates the array that displays "_"'s when guessing
    public static void blankArray(char[] guessArray, char[] wordArray){
        for(int i = 0; i<guessArray.length; i++)
        {
            //checks to see if the character in the word is a lower case character
            if(wordArray[i]>=97 && wordArray[i]<=122){
                guessArray[i] = '_'; //changes index to "_" if so
            }else{
                //if it's not a letter, the guess array will just change the index to what it is in the word
                guessArray[i] = wordArray[i];
            }
        }
    }

    //Used to get a user inputted word that will be guessed later on
    public static char[] setWord(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the word to guess: ");
        String guess = (in.nextLine()).toLowerCase();
        char[] wordArray = new char[guess.length()];
        
        //converts the word into an array of characters
        for(int i = 0; i<wordArray.length; i++){
            wordArray[i] = guess.charAt(i);
        }

        clearScreen();
        return wordArray;
    }
}


import java.io.File;
import java.io.FileNotFoundException;// or IOException
import java.io.PrintStream;
import java.util.Scanner;


public class FileProcessingExample {
        
    													
    public static void main(String[] args) throws FileNotFoundException
    {
        //fileInput();
        //userInput();
        //fileOutput();
    }
    
    /**									This is needed anytime
     *									we are handling file
     *									processing.
     *
     *											 ||
     *											\  /
     *											 \/			
     *								__________________________
     *							   |						  |
     *							   | Make sure you import it! |	
     *							   |						  |	*/
    public static void fileInput() throws FileNotFoundException
    {
    	// We need to specify which file we want to read from:
    	File fileObjectName = new File("sample_file.txt");
    	
    	/*The file needs to be in the folder as the Java file*/
    	
    		
    	// We use a Scanner object to actually read from the file
    	// by specifying which file OBJECT we are referring to.
    	Scanner sc = new Scanner( fileObjectName );
    	
    	/** Common Scanner Methods:
    	 *
    	 * .next()			->	Reads and returns the next sequence of adjacent characters (a.k.a. tokens) as a String.
    	 *							** Tip: any whitespace will be used to separate each "String"
    	 *							** Example Use: To grab the next word
    	 * .nextDouble()	->	Reads and returns the next double value.
    	 * .nextInt()		->	Reads and returns the next int value.
    	 * .nextLine()		->	Reads and returns the nextline of input from the source as a String.
    	 *
    	 * .hasNext()		->	Returns true if there is at least 1 more data/token to read and false otherwise.
    	 * .hasNextDouble()	->	Returns true if there is at least 1 double value left to read and false otherwise.
    	 * .hasNextInt()	->	Returns true if there is at least 1 int value left to read and false otherwise.
    	 * .hasNextLine()	->	Returns true if there is at least 1 line left to read and false otherwise.
    	**/
    	
    	
    	/***************************************************************************************** 
    	 *		How the Scanner works: Imagine your Scanner object as a cursor in the file.
    	 *		As the Scanner object is reading parts of the file, it is keeping track
    	 *		of where it ended in the file after each operation. The cursor can ONLY
    	 *		move forward. Once we have read a part of our source, we cannot move backwards.
    	 *
    	 *****************************************************************************************/
    	
    	// The provided sample_file.txt does not tell us how many lines of text are in the file.
    	// We can use the .hasNextLine() boolean method determine when to stop our loop that will
    	// process the data in the file.
    	
    	while( sc.hasNextLine() )
    	{
    		System.out.println(sc.nextLine());
    	}
    
    	sc = new Scanner(fileObjectName);//This will reset the scanner object
    	
    	
    	/* Try using some of the scanner methods below and print the results! */
    	
    }
    
//------
    
    public static void userInput()
    {
    	/***********************************************************************
    	 * To gather input from the user, we initialize the Scanner object with
    	 * System.in as our argument. Everytime we use a Scanner command that
    	 * reads information, it will wait for the user to type in a value and
    	 * press the Enter key.
    	 ***********************************************************************/
    	
    						// By using System.in, we can get user
    						// input from the keyboard.
    	Scanner sc = new Scanner( System.in );
    	
    	System.out.print("What is your name? ");
    	
    	//This line will save whatever the user typed using the keyboard
    	//		 to a variable.
    	String name = sc.nextLine();
    	
    	System.out.println("\nHi "+name+". Hope you are having a good day :D");
    	System.out.print("How many pets do you have? ");
    	
    	int numOfPets = sc.nextInt();
    	
    	System.out.print("You have "+numOfPets+", I have none! ;D ");
    }
    
//--------

    public static void fileOutput() throws FileNotFoundException
    {
    	/***********************************************************************
    	 * To output information to a file, we are going to utilize the
    	 * PrintStream class. This will allow us to print information to a file
    	 * in a similar fashion to us printing to the console.
    	 *
    	 * Creating a PrintStream object is similar to that of creating a Scanner.
    	 * We specify the name of our object and the file that we want to output
    	 * to. Instead of creating a File object and then a Scanner object, we
    	 * can actually do both at once as seen below.
    	 ***********************************************************************/
    	PrintStream output = new PrintStream(new File("outputTest.txt"));
    	
    	// To add content to the file, we just print to our PrintStream object!
    	output.print("I am printing this to a new file in the same folder "+ 
    		"if the file doesn't already exist. ");
    	
    	// We can even use println() if we want the next thing printed to be on a 
    	// 		separate line in the output file.
    	output.println("Whoops, I am printing on the same line as before...");
    	output.println("...\nThat is better!!!");
    	
    	/***********************************************************************
    	 * If the file already exist, running this code will overwrite the
    	 * information that is in the output file. Try "updating" the text file
    	 * by running it once and then changing/add some print statements!
    	 ***********************************************************************/
    	 
    }
}

//Filename: “Test.java”

//import the header files

import java.io.File;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

//definition of "Test" class

public class Test
{

    //definition of main method

    public static void main(String[] args)

    {

        //open a file name hello.txt

        try (Scanner in = new Scanner(new File("hello.txt")))

        {

            //read message in string variable

            String message = in.nextLine();

            //display the message

            System.out.println(message);

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw an exception

            e.printStackTrace();

        }
        //file auto close at the end by try and catch block

        //try block

        try (PrintWriter out = new PrintWriter("hello.txt"))

        {

            //store the message Hello, World! in the file

            out.println("Hello, World!");

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw an exception

            e.printStackTrace();

        }

    }

}
//expected output:: hello world


#########2


        Filename: “BlankLinesRemover.java”
        //import the header files
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.util.Scanner;
        import java.util.ArrayList;
//definition of "BlankLinesRemover" class
public class BlankLinesRemover
{
    //objective 1 remove definition of "removeLines" class
    public static void removeLines(String fileName)
    {
        //create an object for "ArrayList" class
        ArrayList<String> lines = new ArrayList<>();
        //get the filename in try block
        try (Scanner in = new Scanner(new File(fileName)))
        {
            //check the condition
            while (in.hasNextLine())
            {
                //get the input
                String line = in.nextLine();
                //check the "line" is empty
                if (!line.trim().isEmpty())
                {
                    //add the values
                    lines.add(line);
                }
            }
        }
        //catch block
        catch (FileNotFoundException e)
        {
            //throw an error message
            e.printStackTrace();
        }
        //objective 2 write non blank in the same file again get the filename in try block
        try (PrintWriter out = new PrintWriter(fileName))
        {
            //check the condition
            for (String line: lines)
            {
                //print the output
                out.println(line);
            }
        }
        //catch block
        catch (FileNotFoundException e)
        {
            //throw an error message
            e.printStackTrace();
        }
    }
}
Filename: “Test.java”
        //import the header files
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.io.PrintWriter;
        import java.util.Scanner;
//definition of "Test" class
public class Test
{
    //definition of main method
    public static void main(String[] args)
    {
        //objective 1 remove :call the method with a filename
        BlankLinesRemover.removeLines("lines.txt");
        //declare the variable
        int count = 0;
        //get the file name in try block
        try (Scanner in = new Scanner(new File("lines.txt")))
        {
            //check the condition
            while (in.hasNextLine())
            {
                //get the input
                in.nextLine();
                //increment the value
                count++;
            }
        }
        //catch block
        catch (FileNotFoundException e)
        {
            //throw exception
            e.printStackTrace();
        }
        //display the outputs
        System.out.println("Number of non-blank lines: " + count);
        System.out.println("Expected: 10");
    }
}
    Sample Output
Output:
        Input file: “lines.txt”


        ################ 3


        Filename: “FileTrimmer.java”

        //import the header files

        import java.io.File;

        import java.io.FileNotFoundException;

        import java.io.PrintWriter;

        import java.util.Scanner;

        import java.util.ArrayList;

        import java.util.ListIterator;

//definition of "FileTrimmer" class

public class FileTrimmer

{

    //definition of "trimBlankLines" class

    public static void trimBlankLines(String fileName)

    {

        //create an object for "ArrayList" class

        ArrayList<String> lines = new ArrayList<>();

        boolean nonBlankFound = false;

        //get the filename in try block

        try (Scanner in = new Scanner(new File(fileName)))

        {

            //check the condition

            while (in.hasNextLine())

            {

                //get the input

                String line = in.nextLine();

                /*Skip lines until non blank found*/

                if (!line.trim().isEmpty() || nonBlankFound)

                {

                    //set the value

                    nonBlankFound = true;

                    //add the values

                    lines.add(line);

                }

            }

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw an error message

            e.printStackTrace();

        }

        //create an object for "ListIterator" class

        ListIterator<String> it = lines.listIterator(lines.size());

        //check the condition

        while (it.hasPrevious() && it.previous().trim().isEmpty())

        {

            /*objective 1 :: remove blank lines at the end of the file*/

            it.remove();

        }

        //objective 1 :: write the remaining line back to the same file get the filename in try block

        try (PrintWriter out = new PrintWriter(fileName))

        {

            //check the condition

            for (String line: lines)

            {

                //print the output

                out.println(line);

            }

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw an error message

            e.printStackTrace();

        }

    }

}

Filename: “Test.java”

        //import the header files

        import java.io.File;

        import java.io.FileNotFoundException;

        import java.io.PrintWriter;

        import java.util.Scanner;

//definition of "Test" class

public class Test

{

    //definition of main method

    public static void main(String[] args)

    {

        //call the method with a filename

        FileTrimmer.trimBlankLines("lines.txt");

        //declare the variable

        int count = 0;

        //get the file name in try block

        try (Scanner in = new Scanner(new File("lines.txt")))

        {

            //check the condition

            while (in.hasNextLine())

            {

                //get the input

                in.nextLine();

                //increment the value

                count++;

            }

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //throw exception

            e.printStackTrace();

        }

        //display the outputs

        System.out.println("Number of non-blank lines: " + count);

        System.out.println("Expected: 12");

    }

}


    Number of non-blank lines: 10
        Expected: 10


        ############# 4


        Filename: “LineNumbers.java”
        //import the header files
        import java.io.*;
        import java.util.Scanner;
//definition of "LineNumbers" class
public class LineNumbers
{
    //definition of main method
    public static void main(String[] args)
    {
        //create an object for "Scanner" class
        Scanner in = new Scanner(System.in);
        //get the input file name
        System.out.print("Please enter the file name for input: ");
        String filename1 = in.next();
        //get the output file name
        System.out.print("Please enter the file name for output: ");
        String filename2 = in.next();
        //objective 1 :: read text file and send it to out file and also line number try block
        try (Scanner inFile = new Scanner(new File(filename1)); PrintWriter out = new PrintWriter(filename2))
        {
            //declare the variable and set the value
            int count = 1;
            //check the condition
            while (inFile.hasNext())
            {
                //add the "/* */" to the line
                out.println("/* " + count + " */ " + inFile.nextLine());
                //increment the value
                count++;
            }
        }
        //catch block
        catch (FileNotFoundException e)
        {
            //display an error message
            System.out.println("File not found!");
        }
    }
}
    Sample Output
Output:
        Please enter the file name for input: input.txt
        Please enter the file name for output: output.txt
        Input file: “input.txt”


        Input file: “output.txt”



        ########## 5


        Filename: “Test.java”

        //import the header files

        import java.io.*;

        import java.util.Scanner;

//definition of "LineNumbers" class

public class LineNumbers

{

    //definition of main method

    public static void main(String[] args)

    {

        //create an object for "Scanner" class

        Scanner in = new Scanner(System.in);

        //objective 1 if user specify fileneme in command line declare the variable and set the value

        String filename1 = null;

        //check "args" length is 1

        if (args.length == 1)

        {

            //set the value

            filename1 = args[0];

        }

        //objective 2 otherwise prompt the user for name

        else

        {

            //get the input file name from the user

            System.out.print("Please enter the file name for input: ");

            filename1 = in.next();

        }

        //get the output file name

        System.out.print("Please enter the file name for output: ");

        String filename2 = in.next();

        //try block

        try (Scanner inFile = new Scanner(new File(filename1)); PrintWriter out = new PrintWriter(filename2))

        {

            //declare the variable and set the value

            int count = 1;

            //check the condition

            while (inFile.hasNext())

            {

                //add the "/* */" to the line

                out.println("/* " + count + " */ " + inFile.nextLine());

                //increment the value

                count++;

            }

        }

        //catch block

        catch (FileNotFoundException e)

        {

            //display an error message

            System.out.println("File not found!");

        }

    }

}


############# 6


        Filename: “AverageColumns.java”
        //import the header files
        import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.Scanner;
//definition of "AverageColumns" class
public class AverageColumns
{
    //definition of main method
    public static void main(String[] args)
    {
        // create an object for "Scanner" class
        Scanner in = new Scanner(System.in);
        //objective ask user for file name get the input file name
        System.out.print("Please enter the file name: ");
        String filename = in.next();
        //objective read file having 2 columns try block
        try (Scanner inFile = new Scanner(new File(filename)))
        {
            /*declare the variables and set the values*/
            double sum1 = 0.0;
            double sum2 = 0.0;
            int count = 0;
            //check the condition
            while (inFile.hasNextDouble())
            {
                //calculate the "sum1" and "sum2"
                sum1 += inFile.nextDouble();
                sum2 += inFile.nextDouble();
                //increment the value
                count++;
            }
            //objective 3 print average of each columns display the outputs
            System.out.println("Average of column 1: " + sum1 / count);
            System.out.println("Average of column 2: " + sum2 / count);
        }
        //catch block
        catch (FileNotFoundException e)
        {
            //display an error message
            System.out.println("File not found!");
        }
    }
}
Step 4 > Sample Output
        Output:
        Please enter the file name: input.txt
        Average of column 1: 4.787999999999999
        Average of column 2: 5.247999999999999
        Input file: “input.txt”

        ################# 7


        import java.io.FileReader;
        import java.io.FileWriter;
        import java.io.IOException;
// Class
class GFG
{ // Fundamental driver technique
    public static void main(String[] args) //
    {
        attempt
        {
            FileReader fr = new FileReader("gfgInput.txt");
            // Creating a FileWriter object
            FileWriter fw = new FileWriter("gfgOutput.txt");
            String str = "";
            int i;
            while ((i = fr.read()) != -1)
            {     // Storing every character in the string
                str += (char)i;
            }
            // Print and show the string that    // contains record information
            System.out.println(str);    // Writing above string data to    // FileWriter object
            fw.write(str); // Shutting the record utilizing close() strategy
            fr.close();
            fw.close();    // Display message
            System.out.println(  "File reading and writing both done");
        }
        // Catch block to handle the exception
    catch (IOException e)
        {    // If there is no file in specified path
            System.out.println(     "There are some IOException");
        }

    }
}




####### programming projects

        ######## 1

//include the required header files
        import java.io.File;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.Scanner;
//definition of "BabyNames" class
public class BabyNames
{
    //definition of "processName" method
    public static String processName(Scanner in)
    {
        //get the inputs
        String name = in.next();
        int count = in.nextInt();
        double percent = in.nextDouble();
        //return the names
        return name;
    }
    //definition of main method
    public static void main(String[] args)
    {
        //objective 1 read baynames.txt try block
        try (Scanner in = new Scanner(new File("babynames.txt"));
             PrintWriter boyOut = new PrintWriter("boynames.txt");
             PrintWriter girlOut = new PrintWriter("girlnames.txt"))
        {
            //check the condition
            while (in.hasNextInt())
            {
                //get the input
                int rank = in.nextInt();
                //objective 2create 2 sepearate boy nad girl names.txt try block
                /*call the "processName" method and write the boy names */
                boyOut.println(processName(in));
                /*call the "processName" method and write the girl names */
                girlOut.println(processName(in));
            }
            //display the message
            System.out.println("The program runs successfully");
        }
        //catch block
        catch (IOException e)
        {
            //exception
            e.printStackTrace();
        }
    }
}
    Sample Output
    Input filename: “babynames.txt”

        Output:
        The program runs successfully
        Output filename: “boynames.txt”

        Output filename: “girlnames.txt”


        ####### 2

//include the required header files

        import java.io.File;

        import java.io.IOException;

        import java.util.ArrayList;

        import java.util.Scanner;

//definition of "DualGenderNames" class

public class DualGenderNames

{

    //definition of "processName" method

    public static String processName(Scanner in)

    {

        //get the inputs

        String name = in.next();

        int count = in.nextInt();

        double percent = in.nextDouble();

        return name;

    }

    //definition of "printSameNames" method

    public static void printSameNames(ArrayList<String> boyNames, ArrayList<String> girlNames)

    {

        //iterate for boy names

        for (String name : boyNames)

        {

            //iterate for girl names

            if (girlNames.contains(name))

            {

                //display the names

                System.out.println(name);

            }

        }

    }

    //definition of main method

    public static void main(String[] args)

    {

        //try block

        try (Scanner in = new Scanner(new File("babynames.txt")))

        {

            //create the objects for boy and girl names

            ArrayList<String> boyNames = new ArrayList<String>();

            ArrayList<String> girlNames = new ArrayList<String>();

            //check the condition

            while (in.hasNextInt())

            {

                //get the input

                int rank = in.nextInt();

                /*call the "processName" method and write the boy names */

                boyNames.add(processName(in));

                /*call the "processName" method and write the girl names */

                girlNames.add(processName(in));

            }

            ////objective 1 print  names that are both boy and girls name call the method

            printSameNames(boyNames, girlNames);

        }

        //catch block

        catch (IOException e)

        {

            //exception

            e.printStackTrace();

        }

    }

}
package finalprogramexamv2;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class FinalProgramExamV2
{
    //Make a array instance
    public static dessert[] myDessert = new dessert[10];
    public static void main(String[] args) throws FileNotFoundException
    {
        //Make all methods
        createArrayOfDesserts();
        printArrayOfDesserts(); 
        computeAndPrintStats();
    }
    public static void createArrayOfDesserts() throws FileNotFoundException
    {
        //Call file
        File aFile = new File("desserts.txt");
        //call Scanner to save infor
        Scanner myFile = new Scanner(aFile);
        
        //Make variables to save infor
        int calories;
        String dessertName;
        dessert theseDessert;
        int i = 0;
        //Make while loop to access file
        while(myFile.hasNext() && i < myDessert.length)
        {
            //Call variable and save into myFile
            calories = myFile.nextInt();
            dessertName = myFile.nextLine();
            //Make a new dessert instance 
            theseDessert = new dessert(calories, dessertName);
            //Save infor into array
            myDessert[i] = theseDessert;
            i++;
        }
        //Close files
        myFile.close();
    }
    public static void printArrayOfDesserts()
    {
        //Make adv for loop and display the whole text
        for(dessert dessertList : myDessert)
        {
            System.out.println(dessertList);
        }
    }
    public static void computeAndPrintStats()
    {
        //Make all variables and reset arrray to 0 and get calories
        double avg;
        double sum = myDessert[0].getCalories();
        double highD = myDessert[0].getCalories();
        double lowD = myDessert[0].getCalories();
        
        int lowInd = 0;
        int highInd = 0;
        //Make a for loop and get dessert length
        for(int i = 1; i < myDessert.length; i++)
        {
            //Make if statments and get calories and save all infor into index
            if(highD < myDessert[i].getCalories())
            {
                highD = myDessert[i].getCalories();
                highInd = i;
            }
            if(lowD > myDessert[i].getCalories())
            {
                lowD = myDessert[i].getCalories();
                lowInd = i;
            }
            //Make sum equal and add all infor from get calories
            sum += myDessert[i].getCalories();
        }
        //Get avgrage of all sum and get dessert length
        avg = sum/myDessert.length;
        //Make a Decimal format class
        DecimalFormat df = new DecimalFormat("##0.00");
        //Display all information in sout
        System.out.println("Average calories is " + df.format(avg));
        System.out.println("The sum of all the calories is " + sum);
        System.out.println("The Lowest calorie dessert is " + myDessert[lowInd]);
        System.out.println("The Highest calorie dessert is " + myDessert[highInd]);
    }
}

/*********************************************************************
Author     : Dayron Hernanez
Course     : COP 2250 09/01/2012
Professor  : Michael Robinson
Program #  : the purpose of this program was to learn how to use:
*            print, printf, println and for loops. 
Due Date   : 09/05/2012
Certification:
I hereby certify that this work is my own and none of it is the work of any
* other person.
 ..........{ Dayron Hernandez }..........
*********************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hernandezdpgm1;

/**
 *
 * @author dayron14
 */
public class HernandezDpgm1 {

  
    /**
     * @param args the command line arguments
     */
    
    // method for my information
    public static void myInfo(String myName, int creditsTaken,int totalCredits,
            double GPA,String major,String className)
    {
        System.out.printf("Hi my name is %s "
                + "\nmy major is %s "
                + "\nI have completed %d credits "
                + "\nI am taking %d credits "
                + "\nThis class's name is %s \n\n"
                ,myName, major, totalCredits, creditsTaken, className);
    }
    
    //this method adds numbers
    public static void addNumbers(int maxValue)
    {
    System.out.print(maxValue + "+1="+(maxValue+1)+"\n");
    System.out.print(maxValue + "+2="+(maxValue + 2)+"\n");
    System.out.print(maxValue + "+3="+(maxValue + 3)+"\n");
    System.out.print(maxValue + "+4="+(maxValue + 4)+"\n");
    System.out.print(maxValue + "+5="+(maxValue + 5)+"\n");
    }
    
    //this simple method subtracs numbers
    public static void substractNumbers(int maxValue)
    {System.out.print(maxValue + "-1="+(maxValue - 1)+"\t");
     System.out.print(maxValue + "-2="+(maxValue - 2)+"\t");
     System.out.print(maxValue + "-3="+(maxValue - 3)+"\t");
     System.out.print(maxValue + "-4="+(maxValue - 4)+"\t");
     System.out.print(maxValue + "-5="+(maxValue - 5)+"\t");}
    
    
    //this method shows multiplication
    public static void multiplyNumbers(int maxValue)
    {
     System.out.println(maxValue + "*1="+maxValue * 1); 
     System.out.println(maxValue + "*2="+maxValue * 2); 
     System.out.println(maxValue + "*3="+maxValue * 3); 
     System.out.println(maxValue + "*4="+maxValue * 4);
     System.out.println(maxValue + "*5="+maxValue * 5);}
    
    //this method shows division
    public static void divideNumbers(int maxValue)
    {System.out.printf(maxValue + "/1="+"%d",(maxValue / 1));
     System.out.printf(maxValue + "/2="+"%d",(maxValue / 2));
     System.out.printf(maxValue + "/3="+"%d",(maxValue / 3));
     System.out.printf(maxValue + "/4="+"%d",(maxValue / 4));
     System.out.printf(maxValue + "/5="+"%d",(maxValue / 5));
     System.out.print("\n");    

    }
    
    //this method shows how mod is used 
    public static void modNumbers(int maxValue) 
    {System.out.print(maxValue + "%1= "+maxValue % 1+"  "); 
     System.out.print(maxValue + "%2= "+maxValue % 2+"  ");
     System.out.print(maxValue + "%3= "+maxValue % 3+"  ");
     System.out.print(maxValue + "%4= "+maxValue % 4+"  ");
     System.out.print(maxValue + "%5= "+maxValue % 5+"\n");
     
    }
    
    //a simple method that shows addition once again
    public static void sumOfDigits(int N) 
    {
    	N=100;
    	int sumofdigs;
    	sumofdigs=((1+N)*(N/2));
    	System.out.println("The sum of digits 1-100 is "+ sumofdigs + "\n");
    }
    
    //simple method displaying how for loops are used.
    public static void forLoop()
    {
     int total = 0;
        for (int x = 1; x <= 100; x++)
        {
            total = total + x;
        }
            
        System.out.printf("The sum of digits 1-100 is +%d",total);
        System.out.print("\n");    

        
    
    
    }
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        String myName = "Dayron Hernandez";
        int creditsTaken = 12;
        int totalCredits= 18;
        double GPA = 3.5 ;
        String major= "Information Technology";
        String className= "Java Programming";
        
        int maxValue=100;
        
        myInfo(myName,creditsTaken,totalCredits,GPA,major,className);
        addNumbers(maxValue);
        substractNumbers(maxValue);
        multiplyNumbers(maxValue);
        divideNumbers(maxValue);
        modNumbers(maxValue);
        sumOfDigits(100);
        forLoop();
        
        
        
        
        
    }
    
    
}

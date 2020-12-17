
package number2;
import java.text.DecimalFormat;

public class Number2 {

   
    public static void main(String[] args) {
        double minimum = 0.0;           //Lower limit for detemining the range
        double maximum = 1000.0;        //Upper limit for determining the range
        
        int t = 0;                  //counter for the random numbers
        int m = 1;                  //numbers from 1 - 30
                
        //Print out the table format
        System.out.print("S/No. \t");               
        System.out.print("Decimal Number \t");
        System.out.print("Binary number \t \t");
        System.out.print("Remark \n");
        
        do                      //loop that lists the number, random number and the binary equivalent
        {
            int position = 0;       //determines array index for the binary array
            int pos = 0;           //determines array index for the whole part of binary number
            int binaryPart [] = new int [10];       //array to store integer binary equivalent
            int wholeNumber [] = new int [6];         //array to store fraction part binary equivalent
            
            System.out.print(m);
            m++;                            //increments the numbering (1-30)
            
            System.out.print("\t");
            
            double random = minimum + Math.random() * (maximum - minimum);          //generates random number within the range 
            DecimalFormat numberFormat = new DecimalFormat("#.000");    //restricts the number of decimal places for the random number to 3
            System.out.print(numberFormat.format(random)+ "\t");        //prints the random number

            int intPart = (int) random;                                 //TypeCast the integer part to a number
            String Decimal = numberFormat.format(random - intPart);     //Separates integer part from the fraction part
                  
            
            System.out.print("\t");
            t++;                                                        
            
            do                                                          //converts integer part to binary
            {
                if(intPart %2 == 0)                                     //checks for divisiblity by 2
                {
                    intPart = intPart/2;                             
                    binaryPart[position] = 0;                               
                }
                else
                {
                    intPart = intPart/2;
                    binaryPart[position] = 1;
                }
                position++;                                             //increments the array index
            }while(intPart > 0);                                        //process continues until integer is less than or equal to 0
            
            double i = Double.parseDouble(Decimal);                     //TypeCasts Decimal part of number from String to double
            //System.out.println(i);
            int count = 0;                                              //counter for the number of iterations for a recurring number (with a maximum of 5 decimal places)
            
            do
            {
                if(i > 0.999)                                            
                {
                    i = (Double.parseDouble(numberFormat.format( i - (int) i)) * 2);        //takes only the fraction part of the number and multiplies by 2
                    //System.out.println(i);
                    wholeNumber[pos] = (int) i;                                                  //stores the 1(one) in an array
                    pos++;                                                                 //increments array index 
                    count++;                                                                //increments the counter for the ,ax decimal places
                }
                else if (i<=0.999)
                {
                    i = i * 2;                                                                //multiplies fraction by 2
                    //System.out.println(i);
                    wholeNumber[pos] = (int) i;                                                  //stores the 0(zero) in an array
                    pos++;
                    count++;
                }
            }while(count < 6);                                                              //process continues until a max of 5 decimal places
            
            
            for (int y = binaryPart.length - 1; y >= 0; y--)                                    //prints decimal intger's binary array backwards
            {
                System.out.print(binaryPart[y]);
            }
            System.out.print(".");
            for (int x = 0; x <wholeNumber.length - 1 ; x++)                                      //prints the decimal fraction's binary equivalent array backwards
            {
                System.out.print(wholeNumber[x]);
            }
            System.out.print("\t \t");
            
            //System.out.print(count);
                if(count >= 5)                                                              //if count >= 5, it means the array for the fraction part is full, thus the remarks apply
                {
                    System.out.print("Approximate");
                }
                else
                {
                    System.out.print("Exact");
                }

            System.out.print("\n");
            
            System.out.print("\n");
        }while(t<30);                                                                      //Continues until 30 random numbers are generated
    }
}   



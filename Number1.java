
package number1;


public class Number1 {
    //Part A assignment 2
   public static void main(String[] args) {
        //Output for the table format
        System.out.print("Decimal (base 10) \t");
        System.out.print("Binary (base 2) \t");
        System.out.println("Hexadecimal (base 16)");    
        
        int numbers = 0;        //Counts up to 256
        char hexa [] = new char [10]; //array to store generated hexadecimal values
        char hexchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; // array of all hexadecimal values
        int binary [] = new int [9]; // array to store generated binary
        
        do                      //loop to print the numbers all the way to 256
        {
            System.out.print("\t");
            System.out.print(numbers); //prints the number
            System.out.print("\t \t");
            
            int t = numbers;    // reference to the current number, for computing binary
            int d = numbers;    // reference to the current number, for computing hexadecimal
            int rem;            // calculate reminder for hexadecimal
            int pos = 0;   //determines position of the array index for binary conversion
            int hexPos = 0;        //determines position of the array index for hexadecimal conversion
            
            //Converting to binary
            do
            {
                if (t %2 == 0)
                {
                    t = t/2;
                    binary[pos] = 0;
                }
                else
                {
                    t = t/2;
                    binary[pos] = 1;
                }
                pos++;   //increment array index position            
            }while(t>0);
            
            for (int y = binary.length - 1; y >= 0; y--) //prints binary array backwards
            {
                System.out.print(binary[y]);
            }
            
            System.out.print("\t \t ");
            
            //Converting to hexadecimal
            do
            {
                rem = d % 16;   //determine the reminder            
                hexa[hexPos] = hexchars[rem];   //store the associated hexadecimal values in an array
                d = d/16;
                hexPos++;          // increment array index for hexadecimal
            }while(d>0);
            
            for (int y = hexa.length - 1; y >= 0; y--) //prints hexadecimal array backwards
            {
                System.out.print(hexa[y]);
            }
            
                System.out.print("\n");     
                
        numbers++;              // goes to the next number
        }while(numbers<=256);
    
    }
    
}

import java.util.*;
import java.math.*;

class powerOfBigNum {
    // function definition
    public static BigInteger powerFind(BigInteger a, int b){
        BigInteger result, finalResult;
        // base case condition
        if(b == 1){
            return a;
        }

        // recursive function call
        result = powerFind(a, b/2);
        finalResult = result.multiply(result);
        if(b % 2 == 0){
            return finalResult;
        }
        else{
            return a.multiply(finalResult);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of a and b");

        BigInteger a = sc.nextBigInteger();
        int b = sc.nextInt();

        // function calling
        BigInteger result = powerFind(a, b);
        System.out.println("The power of a^b is: "+result);

        
    }
}

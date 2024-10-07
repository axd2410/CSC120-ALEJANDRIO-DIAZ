import java.util.Scanner;

public class NumberSequence {

    //---------------------------------------------------------------------------------------------
    private final static Scanner keyboard = new Scanner(System.in);
    private static final int NUM_INPUTS = 10;

    //---------------------------------------------------------------------------------------------

    /**
     * call methods and proof if they are fibonacci or prime
     * @param args
     */

    public static void main(String[] args) {

        int[] usersNumbers = new int [NUM_INPUTS];
        int totalNumbers = inputMethod(usersNumbers);
        int i = 0;

        for(i=0; i < totalNumbers; i++){
            if(isPrime(usersNumbers[i]) && isFibonacci(usersNumbers[i])){
                System.out.println(usersNumbers[i] + " is Fibonacci and is Prime");

            }
            else if(isPrime(usersNumbers[i]) && !isFibonacci(usersNumbers[i])) {
                System.out.println(usersNumbers[i] + " is not Fibonacci and is Prime");
            }
            else if(!isPrime(usersNumbers[i]) && isFibonacci(usersNumbers[i])) {
                System.out.println(usersNumbers[i] + " is Fibonacci and is not Prime");
            }
            else if(!isPrime(usersNumbers[i]) && !isFibonacci(usersNumbers[i])) {
                System.out.println(usersNumbers[i] + " is not Fibonacci and is not Prime");
            }
        }



    }//---END OF MAIN METHOD

    //---- ENTER INPUT METHOD

    /**
     * user enters a list of numbers, and method organize them into an array
     * @param userNumbers is the array of users input
     * @return position of the number
     */
    private static int inputMethod(int[] userNumbers) {

        int numbersInput;
        int i = 0;

        System.out.println("Please enter numbers (0 stops) : ");
        do {
            numbersInput = keyboard.nextInt();
            if (numbersInput != 0 && i < NUM_INPUTS) {
                userNumbers[i] = numbersInput;
                i++;
            }
        } while (numbersInput != 0 && i < NUM_INPUTS);
        return i;
    }//---- END OF INPUT METHOD

    //---- PRIME NUMBER METHOD

    /**
     *
     * @param candidate number of the array that we are testing if prime
     * @return true if it is prime
     */
    private static boolean isPrime(int candidate) {

        int divisor = 2;

        while (divisor <= Math.sqrt(candidate)) {
            if (candidate % divisor == 0) {

                return (false);
            }
            divisor++;
        }
        return (true);
    }//---- END OF isPrime METHOD

    //---- FIBONACCI NUMBER METHOD

    /**
     *
     * @param number number in the array that we are testing if fibonacci
     * @return true if it is fibonacci
     */
    private static boolean isFibonacci(int number) {
        int previous = 1;
        int current = 0;
        int next;

        while (number > current) {
            next = current + previous;
            previous = current;
            current = next;

            if (current == number) {
                return true;
            }
        }
        return false;
    }

}//--- END OF THE CLASS










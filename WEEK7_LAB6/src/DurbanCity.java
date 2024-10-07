import java.util.Scanner;

public class DurbanCity {
    //---------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
//---------------------------------------------------------------------------------------------

    // MAIN METHOD CALLING INPUT METHOD AND CALCULATION METHOD
    public static void main(String[] args) {

        int numberHouses;
        System.out.println("How many houses are on the street?  :");
        numberHouses = keyboard.nextInt();
        int [][] houseAges = inputMethod(numberHouses);

        calculationMethod(houseAges);

    }//END OF MAIN METHOD

    /**
     * The input method collects the data of each house, the number of people that live there
     * and the age of every single one
     * @param numberHouses The number of houses that are in that street
     * @return A 2D Dimensional array that includes the strEet number of each house and the age of all
     * people that live in each house
     */
    private static int[][] inputMethod (int numberHouses){
        int peopleInHouse = 0;
        int [] houseNumbers = new int [numberHouses];
        int [][] houseAges = new int[numberHouses][];


        for(int i=0; i < houseNumbers.length; i++) {
            System.out.println("What is the next house number?  :");
            houseNumbers[i] = keyboard.nextInt();
        }

        for(int n = 0; n < numberHouses; n++){
            System.out.println("How many people live in house " + houseNumbers[n] + ":  ");
            peopleInHouse = keyboard.nextInt();
            houseAges [n] = new int[peopleInHouse];


            for(int j=0; j < peopleInHouse; j++){
                System.out.println("What is the age of person " + (j + 1) + ":    ");
                houseAges [n] [j] = keyboard.nextInt();


            }
        }return houseAges;
    }// END OF INPUT METHOD

    /**
     * The Calculation method iterates in every row (persons in each house) age and adds them together
     * per house and then as total of all the street combined
     * @param houseAges is te array that includes the ages of every member of each house in the street
     *
     */
    private static void calculationMethod (int [][] houseAges){
        int houseTotalAge = 0;
        int streetTotalAge = 0;

        for(int i = 0; i < houseAges.length; i++){
            for(int j = 0; j < houseAges[i].length; j++){
                houseTotalAge += houseAges [i][j];

            }
            System.out.println("House [" + (i + 1) + "] + has a total age of [" + houseTotalAge + "] ");

            streetTotalAge += houseTotalAge;
            houseTotalAge = 0;

        }
        System.out.println("The street has a total age of [" + streetTotalAge + "] ");
    }
    //END OF CALCULATION METHOD




}//END OF CLASS

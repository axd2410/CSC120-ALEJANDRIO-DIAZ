import java.util.Scanner;

public class KangaroosKills {
    //---------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //---------------------------------------------------------------------------------------------
    private static final double ROAD_KILL_CONSTANT = 1.47;
    private static final int ROAD_WIDTH = 10;

    //---------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        //---- Declare Variables
        double sideSquare;
        double roadsRunning;
        double numberKangaroos;
        double kangaroosPerSqKm;
        double roadSurfaceArea;
        double expectedKills;

        //---- Entering Values
        System.out.println("Enter side of square in km: ");
        sideSquare = keyboard.nextDouble();
        System.out.println("Enter roads lenght in km: ");
        roadsRunning = keyboard.nextDouble();
        System.out.println("Enter number or kangaroos: ");
        numberKangaroos = keyboard.nextDouble();

        //---- Executing Calculations Phase 1 (Number of kangaroos per sq km)
        kangaroosPerSqKm = numberKangaroos / (sideSquare * sideSquare);

        //---- Executing Calculations Phase 2 (Road Surface Area)
        roadSurfaceArea = roadsRunning * ((double) ROAD_WIDTH / 1000);

        //---- Final Calculations
        expectedKills = (roadSurfaceArea * kangaroosPerSqKm * ROAD_KILL_CONSTANT);

        //---- Displaying Results
        System.out.println("Expected number of kills is: " + (int) (expectedKills));

        if (expectedKills % 1 != 0) {
            System.out.print("Expected number of injuries : 1");
        } else {
            System.out.print("Expected number of injuries : 0");
        }


    }// END OF THE MAIN METHOD

}//---- END OF THE CLASS






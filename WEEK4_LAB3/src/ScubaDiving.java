import java.util.Scanner;

public class ScubaDiving {
    //---------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //---------------------------------------------------------------------------------------------
    private static final double FEET_PER_ATMOSPHERE_CONSTANT = 33.0;

    //---------------------------------------------------------------------------------------------

    public static void main(String[] args) {

        //---- Declare Variables
        int depth;
        int percentageO2;
        double ambientPressure;
        double partialPressureO2;
        char o2Group;
        boolean exceedsMaximal;
        boolean exceedsContingency;


        //---- Get Depth and O2 Percentage
        System.out.println("Enter depth and percentage O2    : ");
        depth = keyboard.nextInt();
        percentageO2 = keyboard.nextInt();

        //---- Perform Computation
        ambientPressure = ((double) depth / FEET_PER_ATMOSPHERE_CONSTANT) + 1;
        partialPressureO2 = ((double) percentageO2 / 100.0) * ambientPressure;

        o2Group = computeO2Groups(partialPressureO2);
        exceedsMaximal = exceedsMaximalO2Group(o2Group);
        exceedsContingency = exceedsContingencyO2Group(o2Group);


        // ---- Display Results
        System.out.println("Ambient pressure\t: " + ambientPressure);
        System.out.println("O2 pressure\t:" + partialPressureO2);
        System.out.println("O2 group\t:" + o2Group);
        System.out.println("Exceeds maximal O2 pressure :" + exceedsMaximal);
        System.out.println("Exceeds contingency O2 pressure : " + exceedsContingency);

    }


    //---- METHOD TO CREATE INTERVALS
    private static char computeO2Groups(double partialPressureO2) {
        char group = 'A';

        //---- 'For' loop with step starting from 0.0 and using a 0.1 step

        for (double start = 0.0; start < 2.6; start += 0.1) {
            double end = (start + 0.1);
            if (partialPressureO2 >= start && partialPressureO2 < end) {
                group = getGroup(start);
                break;
            }
        }
        return group;
    }


    //---- Method to select group

    private static char getGroup(double start) {

        if (start >= 0 && start < 0.1) return 'A';
        if (start >= 0.1 && start < 0.2) return 'B';
        if (start >= 0.2 && start < 0.3) return 'C';
        if (start >= 0.3 && start < 0.4) return 'D';
        if (start >= 0.4 && start < 0.5) return 'E';
        if (start >= 0.5 && start < 0.6) return 'F';
        if (start >= 0.6 && start < 0.7) return 'G';
        if (start >= 0.7 && start < 0.8) return 'H';
        if (start >= 0.8 && start < 0.9) return 'I';
        if (start >= 0.9 && start < 1.0) return 'J';
        if (start >= 1.0 && start < 1.1) return 'K';
        if (start >= 1.1 && start < 1.2) return 'L';
        if (start >= 1.2 && start < 1.3) return 'M';
        if (start >= 1.3 && start < 1.4) return 'N';
        if (start >= 1.4 && start < 1.5) return 'O';
        if (start >= 1.5 && start < 1.6) return 'P';
        if (start >= 1.6 && start < 1.7) return 'Q';
        if (start >= 1.7 && start < 1.8) return 'R';
        if (start >= 1.8 && start < 1.9) return 'S';
        if (start >= 1.9 && start < 2.0) return 'T';
        if (start >= 2.0 && start < 2.1) return 'U';
        if (start >= 2.1 && start < 2.2) return 'V';
        if (start >= 2.2 && start < 2.3) return 'W';
        if (start >= 2.3 && start < 2.4) return 'X';
        if (start >= 2.4 && start < 2.5) return 'Y';
        if (start >= 2.5 && start < 2.6) return 'Z';
        return 0;
    }
//---- Compare if group is more than 'N', which is the maximal O2 pressure recommended

    private static boolean exceedsMaximalO2Group(char group) {
        return group > 'N';

    }

    //---- Compare if group is m
    private static boolean exceedsContingencyO2Group(char group) {
        return group >= 'P';
    }

}// END OF ScubaDiving



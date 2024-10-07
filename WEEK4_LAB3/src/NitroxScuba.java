import java.util.Scanner;

public class NitroxScuba {

    //---------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //---------------------------------------------------------------------------------------------
    private static final double FEET_PER_ATMOSPHERE_CONSTANT = 33.0;
    private static final double MAXIMAL_O2_PRESSURE = 1.4;
    private static final double MAXIMAL_CONTINGENCY = 1.6;

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

        //---- Get pressure oxygen group

        o2Group = computeO2Group(partialPressureO2);

        exceedsMaximal = computeMaximalO2(o2Group);

        exceedsContingency = computeContingency(o2Group);

        // ---- Display Results
        System.out.println("Ambient pressure\t: " + ambientPressure);
        System.out.println("O2 pressure\t:" + partialPressureO2);
        System.out.println("O2 group\t:" + o2Group);
        System.out.println("Exceeds maximal O2 pressure :" + exceedsMaximal);
        System.out.println("Exceeds contingency O2 pressure : " + exceedsContingency);
    }

    //---- Compute O2 Group Method
    private static char computeO2Group(double partialPressureO2) {
        char o2Group;
        o2Group = (char) ((int) (partialPressureO2 * 10) + (int) ('A'));
        return (o2Group);

    }

    //---- Compute Maximal O2
    private static boolean computeMaximalO2(double o2Group) {

        return o2Group > 'N';
    }


    //---- Compute Contingency O2
    private static boolean computeContingency(double o2Group) {

        return o2Group > 'P';
    }


}




















// ---- End of the main method


import java.util.Scanner;
public class FinalProject1 {

    //-------------------------------------------------------------------------------------------------
    private final static Scanner keyboard = new Scanner(System.in);
    private final static int MAX_FAMILY_MEMBERS = 6;
    private final static int MAX_UPPER_TEETH = 8;
    private final static int MAX_LOWER_TEETH = 8;

    /**
     * Declaress arrays and creates following methods with the previous ones returns.
     * @param args
     */
//Main method that calls other methods
    public static void main(String[] args) {
        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("---------------------------------------");

        String[] familyNames;
        char[][][] teethTypePerFamilyMember;

        familyNames = new String[MAX_FAMILY_MEMBERS];
        teethTypePerFamilyMember = new char[MAX_FAMILY_MEMBERS][2][MAX_UPPER_TEETH];

        int numFamilyMembers = getNamesAndTeeth(familyNames, teethTypePerFamilyMember);
        menu(familyNames, teethTypePerFamilyMember, numFamilyMembers);
    }

    /**
     * Fills the three dimensional array that contains each family member, name, upper and lower teeth type
     * @param familyNames Fills out the family names array with the family names thar user provides
     * @param teethTypes Fills out the three dimensional array witch each family member,
     *                   name, upper and lower tooth type
     * @return the number of family members
     */
//Collect names and teeth from each family member
    private static int getNamesAndTeeth(String[] familyNames, char[][][] teethTypes) {
        int numFamilyMembers;
        String upperTeeth;
        String lowerTeeth;

        do {
            System.out.println("Please enter number of people in the family:");
            numFamilyMembers = keyboard.nextInt();
            keyboard.nextLine();
            if (numFamilyMembers <= 0 || numFamilyMembers > MAX_FAMILY_MEMBERS) {
                System.out.println("Invalid number of people, please try again.");
            }
        } while (numFamilyMembers <= 0 || numFamilyMembers > MAX_FAMILY_MEMBERS);

        for (int i = 0; i < numFamilyMembers; i++) {
            System.out.println("Enter name of family member number " + (i + 1) + ":");
            familyNames[i] = keyboard.nextLine();


            do {
                System.out.println("Please enter uppers for " + familyNames[i] + ":");
                upperTeeth = keyboard.nextLine().toUpperCase();
                if (upperTeeth.length() > MAX_UPPER_TEETH || !validTeeth(upperTeeth)) {
                    System.out.println("Invalid teeth type or too many teeth, please try again.");
                }
            } while (upperTeeth.length() > MAX_UPPER_TEETH || !validTeeth(upperTeeth));

            for (int j = 0; j < upperTeeth.length(); j++) {
                teethTypes[i][0][j] = upperTeeth.charAt(j);
            }


            do {
                System.out.println("Please enter lowers for " + familyNames[i] + ":");
                lowerTeeth = keyboard.nextLine().toUpperCase();
                if (lowerTeeth.length() > MAX_LOWER_TEETH || !validTeeth(lowerTeeth)) {
                    System.out.println("Invalid teeth type or too many teeth, please try again.");
                }
            } while (lowerTeeth.length() > MAX_LOWER_TEETH || !validTeeth(lowerTeeth));

            for (int z = 0; z < lowerTeeth.length(); z++) {
                teethTypes[i][1][z] = lowerTeeth.charAt(z);
            }
        }
        return numFamilyMembers;
    }
// Make sure that the letters entered are only I,B,M
    private static boolean validTeeth(String teeth) {
        for (int i = 0; i < teeth.length(); i++) {
            char tooth = Character.toUpperCase(teeth.charAt(i));
            if (tooth != 'I' && tooth != 'B' && tooth != 'M') {
                return false;
            }
        }
        return true;
    }

    /**
     * Makes a switch based menu to call each menu method option that user wants
     * @param familyNames Brings into scope to send it to corresponding method that needs it
     * @param teethTypePerFamilyMember Brings into scope to send it to corresponding method that needs it
     * @param numFamilyMembers Brings into scope to send it to corresponding method that needs it
     */
//Menu method, based in switch function to been directed to corresponding option
    private static void menu(String[] familyNames, char[][][] teethTypePerFamilyMember, int numFamilyMembers) {
        char option;
        do {
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it: ");
            option = keyboard.next().toUpperCase().charAt(0);
            keyboard.nextLine();
            switch (option) {
                case 'P':
                    menuPrint(familyNames, teethTypePerFamilyMember, numFamilyMembers);
                    break;
                case 'E':
                    menuExtract(familyNames, teethTypePerFamilyMember, numFamilyMembers);
                    break;
                case 'R':
                    menuRoots(teethTypePerFamilyMember, numFamilyMembers);
                    break;
                case 'X':
                    System.out.println("Exiting the Floridian Tooth Records :-)");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 'X');
    }
// Print option in menu, to print each member's teeth
    private static void menuPrint(String[] familyNames, char[][][] teethTypePerFamily, int numFamilyMembers) {
        for (int i = 0; i < numFamilyMembers; i++) {
            System.out.println(familyNames[i]);
            System.out.print(" Uppers ");
            for (int j = 0; j < MAX_UPPER_TEETH; j++) {
                System.out.print(" " + (j + 1) + ":" + (teethTypePerFamily[i][0][j]));
            }
            System.out.println();
            System.out.print(" Lowers ");
            for (int j = 0; j < MAX_LOWER_TEETH; j++) {
                System.out.println(" " + (j + 1) + ":" + (teethTypePerFamily[i][1][j]));
            }
            System.out.println();
        }
    }

    /**
     * Checks if tooth is missing or not and if it's not it extracts it, and replace the
     * tooth with a 'M' of missing tooth in the array
     * @param familyNames Brings into scope this array to enter their personal teeth array
     * @param teethTypePerFamily Brings array into scope to indetify of each family member its teeth set,
     *                           and verify if it's not missing already, and change it if not
     * @param numFamilyMembers Brings family members number into scope to create for loops with it being the top limit
     */
//Extract option to find if a tooth is not already missing and extract it, remove it from array and replace with 'M'
    private static void menuExtract(String[] familyNames, char[][][] teethTypePerFamily, int numFamilyMembers) {
        int layerIndex;
        String familyMember;
        char toothLayer;
        int toothNumber;
        int memberIndex = -1;

        do {
            System.out.println("Which family member: ");
            familyMember = keyboard.nextLine();
            for (int i = 0; i < numFamilyMembers; i++) {
                if (familyNames[i].equalsIgnoreCase(familyMember)) {
                    memberIndex = i;
                    break;
                }
            }
            if (memberIndex == -1) {
                System.out.println("Invalid family member, please try again.");
            }
        } while (memberIndex == -1);

        do {
            System.out.println("Which tooth layer (U)pper or (L)ower: ");
            toothLayer = keyboard.next().toUpperCase().charAt(0);
            if (toothLayer != 'U' && toothLayer != 'L') {
                System.out.println("Invalid layer, please try again.");
            }
        } while (toothLayer != 'U' && toothLayer != 'L');

        do {
            System.out.println("Which tooth number: ");
            toothNumber = keyboard.nextInt();
            keyboard.nextLine();
            if (toothNumber < 1 || toothNumber > MAX_UPPER_TEETH) {
                System.out.println("Invalid tooth number, please try again.");
            } else {
                layerIndex = (toothLayer == 'U') ? 0 : 1;
                if (teethTypePerFamily[memberIndex][layerIndex][toothNumber - 1] == 'M') {
                    System.out.println("This tooth is already missing, please select another.");
                } else {
                    // If it is not missing, extract tooth
                    teethTypePerFamily[memberIndex][layerIndex][toothNumber - 1] = 'M';
                    System.out.println("Tooth extracted successfully.");
                    break; // Exit loop if tooth has successfully been extracted
                }
            }
        } while (true); // Repeats until valid teeth is given
    }

    /**
     * Counts number of I tooth, M tooth and B tooth to create a quadratic formula based on the whole family count
     * @param teethTypePerFamily brings in the array of teeth of family so we can count them in a for loop
     * @param numFamilyMembers brings variable to scope to make the for loop and it being the top limit.
     */
//Roots option to print roots of family based in umber of I,B,M teeth
    private static void menuRoots(char[][][] teethTypePerFamily, int numFamilyMembers) {
        int numI = 0;
        int numB = 0;
        int numM = 0;
        int member;
        int row;
        int i;
        char tooth;
        double rootOne;
        double rootTwo;
        double discriminant;

        // Count type of teeth in family
        for (member = 0; member < numFamilyMembers; member++) {
            for (row = 0; row < 2; row++) {
                for (i = 0; i < MAX_UPPER_TEETH; i++) {
                    tooth = teethTypePerFamily[member][row][i];
                    if (tooth == 'I') numI++;    // Count I tooth
                    else if (tooth == 'B') numB++;   // Count B tooth
                    else if (tooth == 'M') numM++;   // Count M tooth
                }
            }
        }

        // Calculate discriminant and roots
        if (numI > 0) { // Avoid dividing by zero
            discriminant = (numB * numB) - (4 * numI * numM);

            if (discriminant >= 0) {
                // Calculate roots
                rootOne = (-numB + Math.sqrt(discriminant)) / (2 * numI);
                rootTwo = (-numB - Math.sqrt(discriminant)) / (2 * numI);

                System.out.println("One root canal at: " + rootOne);
                System.out.println("Another root canal at: " + rootTwo);
            } else {
                System.out.println("No real roots can be calculated.");
            }
        } else {
            System.out.println("Cannot compute roots because there are no incisors (I).");
        }
    }
}
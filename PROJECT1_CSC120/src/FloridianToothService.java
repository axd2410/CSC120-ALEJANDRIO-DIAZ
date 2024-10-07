import java.util.Scanner;

public class FloridianToothService {
//-------------------------------------------------------------------------------------------------
    private final static Scanner keyboard  = new Scanner(System.in);
    private final static int MAX_FAMILY_MEMBERS = 6;
    private final static int MAX_UPPER_TEETH = 8;
    private final static int MAX_LOWER_TEETH = 8;

    public static void main (String [] args){
        String[] familyNames = getNames();
        char[][][]teethTypePerFamilyMember = getTeethInfo(familyNames);




    }// end of main method

// JAVA DOCS
    private static String [] getNames() {
        int numFamilyMembers = 0;
        String[] names = new String[0];
        int index = 0;

        System.out.println("Please enter number of people in the family    :");
        numFamilyMembers = keyboard.nextInt();
        keyboard.nextLine();
        if ((numFamilyMembers > 0) && (numFamilyMembers < MAX_FAMILY_MEMBERS)) {
            names = new String[numFamilyMembers];
            for (index = 0; index < numFamilyMembers; index++) {
                System.out.println("Enter name of family member number " + (index + 1) + ":");
                names[index] = (keyboard.nextLine());
            }

        }
        else{
            System.out.println("Invalid number of people, please try again");
        }
        return names;
    }// end of getNames method

// JAVA DOCS
    private static char [][][] getTeethInfo(String [] names) {
        char[][][] teethTypes = new char[names.length][2][MAX_UPPER_TEETH];
        int i = 0;
        int j = 0;
        int z = 0;
        String upperTeeth;
        String lowerTeeth;
        for (i = 0; i < names.length; i++) {
            do {
                System.out.println("Please enter uppers for " + names[i] + ":");
                upperTeeth = keyboard.nextLine();
                if (upperTeeth.length() > MAX_UPPER_TEETH) {
                    System.out.println("Invalid teeth type, please try again");
                }

            } while (upperTeeth.length() > MAX_UPPER_TEETH);
            for (j = 0; j < upperTeeth.length(); j++) {
                teethTypes[i][0][j] = upperTeeth.charAt(j);
            }
            do {
                System.out.println("Please enter lowers for " + names[i] + ":");
                lowerTeeth = keyboard.nextLine();
                if (lowerTeeth.length() > MAX_LOWER_TEETH) {
                    System.out.println("Invalid teeth type, please try again");
                }
            } while (lowerTeeth.length() > MAX_LOWER_TEETH);
            for (z = 0; z < lowerTeeth.length(); z++) {
                teethTypes[i][1][z] = lowerTeeth.charAt(z);
            }

        }
        return teethTypes;
    }// end of getTeeth method

// JAVA DOCS
    private static void menu (String[] familyNames, char [][][] teethTypePerFamilyMember){
        char option;
        do{
            System.out.print("(P)rint, (E)xtract, (R)oot, e(X)it");
            option = keyboard.next().toUpperCase().charAt(0);
            switch (option){
                case 'P':
                    menuPrint(familyNames, teethTypePerFamilyMember);
                    break;
                case 'E':
                    menuExtract(familyNames, teethTypePerFamilyMember);
                    break;
                case 'R':
                    menuRoots(teethTypePerFamilyMember);
                    break;
                case 'X':
                    System.out.println("Exciting the Floridian Tooth Records :-)");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");




            }
        }while(option != 'X');

    }// end of menu method

//JAVA DOCS
    private static void menuPrint (String[] familyNames, char [][][] teethTypePerFamily) {
        int i;
        int j;
        for(i = 0; i < familyNames.length; i++){
            System.out.println(familyNames[i]);
            System.out.print(" Uppers ");
            for(j = 0; j < MAX_UPPER_TEETH; j++){
                System.out.print(" " + (j+1) + ":" + (teethTypePerFamily[i][0][j]));
            }
            System.out.println();
            System.out.print(" Lowers ");
            for(j = 0; j < MAX_LOWER_TEETH; j++){
                System.out.println(" " + (j + 1) + ":" + (teethTypePerFamily[i][1][j]));
            }
            System.out.println();

        }
    }// end of menuPrint method

//JAVA DOCS
    private static void menuExtract (String[] name, char [][][] teethTypePerFamily){
        int i;
// MISSING METHOD**********************************************************************************

    }// end of menuExtract method

//JAVA DOCS
    private static void menuRoots (char [][][] teethTypePerFamily){
        int member;
        int row;
        int i;
        int numI = 0;
        int numB = 0;
        int numM = 0;
        double rootOne = 0;
        double rootTwo = 0;
        double discriminant;
        for(member = 0; member < teethTypePerFamily.length; member++){
            for(row = 0; row < 2; row++){
                for(i = 0; i < MAX_UPPER_TEETH; i++){
                    if(teethTypePerFamily[member][row][i] == 'I'){
                        ++numI;
                    }
                    if(teethTypePerFamily[member][row][i] == 'B') {
                        ++numB;
                    }
                    if(teethTypePerFamily[member][row][i] == 'M') {
                        ++numM;
                    }
                }
            }
        }
    if(numI != 0) {
        discriminant = Math.pow(numB, 2) - 4 * numI * numM;
        rootOne = (-numB - Math.sqrt(discriminant)) / (2 * numI);
        rootTwo = (numB - Math.sqrt(discriminant)) / (2 * numI);
        System.out.println("One root canal at   " + rootOne);
        System.out.println("Another root canal at   " + rootTwo);
    }
    else{
        System.out.println("Cannot compute roots because there are 0 Incisors teeth in the family");
    }









}// end of class

















import java.util.Scanner;

public class PROJECT_TEST {

    private final static Scanner keyboard = new Scanner(System.in);
    private final static int MAX_FAMILY_MEMBERS = 6;
    private final static int MAX_UPPER_TEETH = 8;

    public static void main(String[] args) {
        int numFamilyMembers = 0;
        String[] names;
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
    }
}
private static char [][] getTeeth(){



}// end of getTeeth method

private static void printMenu (){



}// end of printMenu method
for(i = 0; i < names.length; i++){
        System.out.println("Please enter the upper for" + names[i] + ":");
upperTeeth = keyboard.nextLine();
            if(upperTeeth.length() <= MAX_UPPER_TEETH){
        for(j = 0; j < upperTeeth.length(); j++){
teethTypes [i][0][j] = upperTeeth.charAt(j);
                }
                        System.out.println("Please enter the lower for" + names [i] + ":");
lowerTeeth = keyboard.nextLine();
                if(lowerTeeth.length() <= MAX_LOWER_TEETH){
        for(z = 0; z < lowerTeeth.length(); z++){
teethTypes [i][1][z] = lowerTeeth.charAt(z);
                    }
                            }
                            else{
                            System.out.println("Invalid teeth type, try again");
                }
                        }
                        else{
                        System.out.println("Invalid teeth type, try again");
            }
                    }
                    return teethTypes;

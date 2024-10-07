import java.util.Scanner;

public class GeoffsIrs {

    private final static Scanner keyboard = new Scanner(System.in);
    //---------------------------------------------------------------------------------------------
    public static void main(String [] args){

    //---- Declare Variables
    double amount = 1;
    double income = 0;
    double deduction = 0;
    double taxableIncome = 0;
    char taxGroup =  'P';
    double taxOwed = 0;

    //---- Input income and deduction
        while(amount != 0){
            System.out.println("Enter next amount: ");
            amount = keyboard.nextDouble();
            if(amount > 0){
                income += amount;
            }
            else{
                deduction += Math.abs(amount);
            }

        }

       taxableIncome =  computeTaxableIncome(income,deduction);

       taxGroup = (char)computeTaxGroup(taxableIncome);

       taxOwed = computeTaxOwed(taxGroup, taxableIncome);

    //---- Display Results
        System.out.println("Income: " + income);
        System.out.println("Deduction: " + deduction);
        System.out.println("Taxable income: " + taxableIncome);
        System.out.println("Tax group: " + taxGroup);
        System.out.println("Tax owed: " + taxOwed);



    }//---- End of the main method
    //---------------------------------------------------------------------------------------------
    private static double computeTaxableIncome(double income,double deduction){
        double taxable = 0;
        if(income >= deduction){
            taxable = income - deduction;
        }
        else{
            double taxableIncome = 0.0;
        }
        return taxable;

    }
    //---------------------------------------------------------------------------------------------
    private static double computeTaxGroup(double taxableIncome){
        char taxGroup;
        if(taxableIncome >= 500000){
             taxGroup = 'S';
        }
        else if(taxableIncome >= 200000){
             taxGroup = 'Q';
        }
        else if(taxableIncome >= 100000){
             taxGroup = 'M';
        }
        else if(taxableIncome >= 50000){
             taxGroup = 'A';
        }
        else if(taxableIncome >= 20000){
             taxGroup = 'R';
        }
        else{
             taxGroup = 'P';
        }
        return taxGroup;

    }
    //---------------------------------------------------------------------------------------------
    private static double computeTaxOwed(char taxGroup, double taxableIncome){
        double tax = 0.0;

        switch (taxGroup){
            case 'S':
            case 'Q':
                tax = taxableIncome * 0.25;
                break;
            case 'M':
                tax = taxableIncome * .10;
                break;
            case 'A':
            case 'R':
                tax = taxableIncome *.03;
                break;
            case 'P':
                tax = 0.0;
                break;
            default:
                System.out.println("Wrong Group");
                tax = 0.0;
        }
    return tax;
    }


}//---- End of the class

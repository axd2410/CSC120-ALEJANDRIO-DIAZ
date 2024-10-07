/*import java.util.Scanner;

public class TaxIrs {

    private static final Scanner keyboard  = new Scanner(System.in);

    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_RICH = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double POOR = 20000;


    public static void main(String[] args) {

    //---- Input income and deduction
        double amount = 1.0;

        while(amount != 0){
            System.out.println("Enter next amount: ");
            amount = keyboard.nextDouble();






    }// end mof main method

    private static double computeTaxableIncome(double income, double deduction){
        double taxable;
        if(income >= deduction){
            return income - deduction;
        }else{
            return 0.0;
        }
    }//---end method

    private double chooseTaxGroup(double income){
        char taxGroup;
        if(income >= 500000){
            taxGroup = 'S';
        }
        else if(income >= 200000){
            taxGroup = 'Q';
        }
        else if(income >= 100000){
            taxGroup = 'M';
        }
        else if(income >= 50000){
            taxGroup = 'A';
        }
        else if(income >= 20000){
            taxGroup = 'R';
        }
        else{
            taxGroup = 'P';
        }
        return taxGroup;
    }//--- end of method

    private double computeTax(char taxGroup, double taxable){
        double tax = 0.0;

        switch (taxGroup){
            case 'S':
            case 'Q':
                tax = taxable * 0.25;
                break;
            case 'M':
                tax = taxable * .10;
                break;
            case 'A':
            case 'R':
                tax = taxable *.03;
                break;
            case 'P':
                tax = 0.0;
                break;
        }
        return tax;
    }

    private void displayResults(double taxable, char taxGroup, double income, double deduction, double tax){
        System.out.println("Income: " + income);
        System.out.println("Deduction: " + deduction);
        System.out.println("Taxable Income: " + taxable);
        System.out.println("Tax Group: " + taxGroup);
        System.out.println("Tax Group: " + tax);

    }

    }//-- end of class*/






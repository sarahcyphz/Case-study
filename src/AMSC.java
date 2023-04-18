import java.util.Scanner;
import java.text.DecimalFormat;


public class AMSC {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.printf("Enter loan amount: ");
        double loanAmount = input.nextDouble();

        System.out.print("Enter length of loan: ");
        int loanLength = input.nextInt();
        int periods = loanLength * 12;

        System.out.print("Enter interest rate: ");
        double interestRate = input.nextDouble();
        double monthlyRate = (interestRate / 12) / 100;

        input.close();

        
        double monthlyPayment = loanAmount * monthlyRate / (1 - 1 / Math.pow(1 + monthlyRate, periods)); 

        double interestPaid = loanAmount * monthlyRate;

        double principleAmount = monthlyPayment - interestPaid;
        double interest;

        // format output
        System.out.println("Month\t\tLoan Amount\t\tInterest\t\tPrinciple\t\tMonthly Payment");
        System.out.println("");

        for (int i = 1; i <= periods; i++) {
            interest = loanAmount * monthlyRate;
            principleAmount = monthlyPayment - interest;
            formatPrint(i, loanAmount, interest, principleAmount, monthlyPayment);
            loanAmount = loanAmount - principleAmount;
        }

    }
 
    private static void formatPrint(int i, double loanAmount, double interest, double principleAmount, double monthlyPayment) {
       
        DecimalFormat df = new DecimalFormat("$#,###.00");

        // format month
       if (i>9) {
            System.out.print(i + " ");
        }
        else {
            System.out.print(i);
        }
        System.out.print("\t\t");

        // format loan amount
       if (loanAmount < 1000) {
            System.out.print(df.format(loanAmount) + "  ");
            if (loanAmount < 100) {
                System.out.print(" ");
            }
        }
        else {
            System.out.print(df.format(loanAmount));
        }
        System.out.println("\t\t");




                                        
    }
}
    


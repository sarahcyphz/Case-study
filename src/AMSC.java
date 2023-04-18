import java.util.Scanner;
import java.text.DecimalFormat;


public class AMSC {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.printf("Enter loan amount: ");
        double loanAmount = input.nextDouble();

        System.out.print("Enter length of loan in months: ");
        int loanLength = input.nextInt();

        System.out.print("Enter interest rate: ");
        double interestRate = input.nextDouble();
        double monthlyRate = (interestRate / 12) / 100;

        input.close();

        
        double monthlyPayment = loanAmount * monthlyRate / (1 - 1 / Math.pow(1 + monthlyRate, loanLength)); 

        double interestPaid = loanAmount * monthlyRate;

        double principleAmount = monthlyPayment - interestPaid;
        double interest;
        double balance = loanAmount;

        // format output
        System.out.println("Month\t\tLoan Amount\t\tInterest\t\tPrinciple\t\tPayment\t\tBalance");
        System.out.println("");

        for (int i = 1; i <= loanLength; i++) {
            interest = loanAmount * monthlyRate;
            principleAmount = monthlyPayment - interest;
            balance = loanAmount - principleAmount;
            formatPrint(i, loanAmount, interest, principleAmount, monthlyPayment, balance);
            loanAmount = loanAmount - principleAmount;
        }

    }
 
    private static void formatPrint(int i, double loanAmount, double interest, double principleAmount, double monthlyPayment, double balance) {
       
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
        System.out.print("\t\t");

        //format interest
       if (interest < 10) {
            System.out.print(df.format(interest) + " ");
            System.out.print("\t\t\t");
        }
        else if (interest > 999) {
            System.out.print(df.format(interest));
            System.out.print("\t\t");
        }
        else {
            System.out.print(df.format(interest));
            System.out.print("\t\t\t");
        }

        // format principle
       if (principleAmount < 1000) {
            if (principleAmount <10) {
                System.out.print(df.format(principleAmount) + "    ");
            }
            else {
                System.out.print(df.format(principleAmount) + "  ");
            }
        }
        else {
            System.out.print(df.format(principleAmount));
        }
        System.out.print("\t\t");

        // format monthly payment
        if (monthlyPayment > 999) {
            System.out.print(df.format(monthlyPayment));
            System.out.print("\t");
        }
        else {
            System.out.print(df.format(monthlyPayment));
            System.out.print("\t\t");
        }

        // format balance
        System.out.println(df.format(balance));
        
                              
    }
}
    


import java.util.Scanner;
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

        double interest = loanAmount * monthlyRate;
        double principleAmount = monthlyPayment - interest;
        double balance = loanAmount;

        System.out.println();
        System.out.println("Month        Loan Amount        Interest        Principle        Payment        Balance");
        System.out.println("-----        -----------        --------        ---------        -------        -------");

        for (int i = 1; i <= loanLength; i++) {
            interest = loanAmount * monthlyRate;
            principleAmount = monthlyPayment - interest;
            balance = loanAmount - principleAmount;
            formatPrint(i, loanAmount, interest, principleAmount, monthlyPayment, balance);     // format output
            loanAmount = loanAmount - principleAmount;
        }

    }

    private static void formatPrint(int i, double loanAmount, double interest, double principleAmount, double monthlyPayment, double balance){

        String str1 = String.format("%-13d", i);
        String str2 = String.format("$%-,18.2f", loanAmount);
        String str3 = String.format("$%-,15.2f", interest);
        String str4 = String.format("$%-,16.2f", principleAmount);
        String str5 = String.format("$%-,14.2f", monthlyPayment);
        String str6 = String.format("$%-,18.2f", balance);
  
        System.out.println(str1 + str2 + str3 + str4 + str5 + str6);
        
    }
 
}
    


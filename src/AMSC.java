import java.util.Scanner;


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


    }
    
}

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

  // Constant for the number of months in a year
  private static final int MONTHS_IN_A_YEAR = 12;
  
  public static void main(String[] args) {
    
    // Create a Scanner object for reading input
    Scanner scanner = new Scanner(System.in);
    
    // Prompt the user to enter the principal amount and read it
    System.out.println("Enter the principal amount:");
    double principal = scanner.nextDouble();
    
    // Prompt the user to enter the annual interest rate and read it
    System.out.println("Enter the annual interest rate:");
    float annualInterestRate = scanner.nextFloat();
    
    // Prompt the user to enter the term in years and read it
    System.out.println("Enter the term in years:");
    int termInYears = scanner.nextInt();
    
    // Close the scanner as we no longer need to read any input
    scanner.close();
    
    // Calculate the monthly interest rate
    float monthlyInterestRate = annualInterestRate / MONTHS_IN_A_YEAR;
    
    // Calculate the total number of payments over the term of the loan
    int numberOfPayments = termInYears * MONTHS_IN_A_YEAR;
    
    // Calculate the monthly payment using the formula for an annuity payment
    double monthlyPayment = principal * (
          (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, numberOfPayments))) /
          ((Math.pow(1 + monthlyInterestRate, numberOfPayments)) - 1)
        );
    
    // Print out the monthly payment, formatted as currency
    System.out.println("Monthly payment: " + NumberFormat.getCurrencyInstance().format(monthlyPayment));
    
    // Calculate and print out the total payback amount, formatted as currency
    System.out.println("Total payback amount: " + NumberFormat.getCurrencyInstance().format(monthlyPayment * numberOfPayments));
    
  }
}

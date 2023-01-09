import java.text.NumberFormat;
import java.util.Scanner;

/*
Principal : 100,000
Annual Interest Rate : 3.92
Period (Years) : 10

Formular

var a = r*(1 + r) raised to power n
var b = (1+r) raised to power n
var c = b - 1
var d = a/c
var e = P * d
*/

public class Main {
    public static void main(String[] args) {

        //Declare constants
        final byte months_in_year = 12;
        final byte percent = 100;

        // Initiate scanner
        Scanner scanner = new Scanner(System.in);

        // Get principal from input
        System.out.print("Enter Principal : ");
        int principal = scanner.nextInt();

        // Get annual interest rate from input
        System.out.print("Annual Interest Rate : ");
        double annualInterest = scanner.nextDouble();
        double monthlyInterest = annualInterest / percent / months_in_year;

        // Get number of years from input
        System.out.print("Period (Years) : ");
        byte period = scanner.nextByte();
        int numberOfPayments = period * months_in_year;

        // Calculate Mortgage
        double a = monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments);
        double b = Math.pow(1 + monthlyInterest, numberOfPayments) - 1;
        double c = a / b;

        double mortgage = principal * c;

        // Format mortgage into currency form
        NumberFormat mortgageFormat = NumberFormat.getCurrencyInstance();

        // Display result
        System.out.println("Your Monthly Payment : " + mortgageFormat.format(mortgage));

    }
}
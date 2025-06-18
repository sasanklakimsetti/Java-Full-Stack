package abstractclasses;

import java.sql.Date;
import java.util.*;

class Account{
    String firstName, lastName;
    long accNo;
    static long nextAccNo=1100001;
    double balance;
    int custId;
    static int nextCustId=1001;
    java.sql.Date openingDate;

    public Account(String firstName, String lastName, double balance){
        super();
        this.firstName=firstName;
        this.lastName=lastName;
        this.balance=balance;
        accNo=nextAccNo++;
        custId=nextCustId++;
        openingDate=new Date(System.currentTimeMillis());
        System.out.println("Account number is: "+accNo);
        System.out.println("Name: "+firstName+" "+lastName);
        System.out.println("Customer Id is: "+custId);
        System.out.println("Opening Date: "+openingDate);
    }
    // Anonymous constructor
    // this constructor is part of every constructor
    // this will be executed automatically before every constructor
//    {
//
//    }
    public Account(){
        super();
        balance=0;
        accNo=nextAccNo++;
        custId=nextCustId++;
        openingDate=new Date(System.currentTimeMillis());
        System.out.println("Account number is: "+accNo);
        System.out.println("Customer Id is: "+custId);
        System.out.println("Opening Date: "+openingDate);
    }
    public void deposit(double amount){
        balance+=amount;
        System.out.println("₹"+amount+" deposited successfully");
    }
    public void withdraw(double amount){
        if(balance-amount<0){
            System.out.println("Withdrawal amount exceeds current balance");
            return;
        }
        else {
            balance -= amount;
            System.out.println("₹"+amount + " withdrawn successfully");
        }
    }
    public void showBalance(){
        System.out.println("Account Balance: ₹"+balance);
    }
}
class LoanAccount extends Account{
    double loanAmount, interestRate, emiAmount;
    String typeOfLoan;
    int durationInMonths;
    List<String> loansAvailable = new ArrayList<>(Arrays.asList("Home", "Car", "Personal","Gold"));
    List<Double> standardInterestRates = new ArrayList<>(Arrays.asList(6.0,7.5,9.0,7.0));
    List<Integer> standardDurations=new ArrayList<>(Arrays.asList(180,60,24,36));
    List<Double> compoundInterestRates=new ArrayList<>(Arrays.asList(1.0,1.5,3.0,2.0));
    public LoanAccount(String firstName, String lastName,  double loanAmount, String typeOfLoan, int durationInMonths){
        super(firstName, lastName,0);
        this.loanAmount=loanAmount;
        balance=-loanAmount;
        this.typeOfLoan=typeOfLoan;
        this.durationInMonths=durationInMonths;
        int index=loansAvailable.indexOf(typeOfLoan);
        if(index==-1) System.out.println("Sorry, the loan doesn't exist");
        else{
            interestRate=getInterestRate(index);
            emiAmount=getEMIAmount(loanAmount,interestRate,durationInMonths);
            System.out.println("Type of Loan: "+typeOfLoan);
            System.out.println("Loan Tenure: "+durationInMonths+" months");
            System.out.println("Interest Rate: "+interestRate+"%");
            System.out.println("Monthly EMI to be paid: "+emiAmount);
        }
    }
    public double getInterestRate(int index){
        if(durationInMonths<= standardDurations.get(index)) return standardInterestRates.get(index);
        int differenceInMonths=durationInMonths-standardDurations.get(index);
        double extraInterest=Math.pow(compoundInterestRates.get(index),differenceInMonths)/differenceInMonths;
        return interestRate=standardInterestRates.get(index)+extraInterest;
    }
    public double getEMIAmount(double loanAmount, double interestRate, int durationInMonths){
        double monthlyInterestAmount=interestRate / (12 * 100);
        double numerator = loanAmount * monthlyInterestAmount * Math.pow(1 + monthlyInterestAmount, durationInMonths);
        double denominator = Math.pow(1 + monthlyInterestAmount, durationInMonths) - 1;
        if (denominator == 0) return 0;
        emiAmount = numerator / denominator;
        return emiAmount;
    }
}
class SavingsAccount extends Account{
    String debitCardNumber;
    char debitCardType;  // A: Visa, B: MasterCard, C: RuPay
    int minimumBalanceRequirement;
    public SavingsAccount(){
        super();
    }
    public SavingsAccount(String firstName, String lastName, String debitCardNumber, int minimumBalanceRequirement){
        super(firstName, lastName,0);
        this.debitCardNumber=debitCardNumber;
        this.minimumBalanceRequirement=minimumBalanceRequirement;
        if(minimumBalanceRequirement<=1000) debitCardType='C';
        else if(minimumBalanceRequirement<=5000) debitCardType='B';
        else debitCardType='A';
        System.out.println("Debit Card Number is: "+debitCardNumber);
        System.out.print("Card type: ");
        if(debitCardType=='A') System.out.println("Visa");
        else if(debitCardType=='B') System.out.println("MasterCard");
        else System.out.println("Rupay");
        if(minimumBalanceRequirement>0)System.out.println("You should maintain ₹"+minimumBalanceRequirement+" monthly. Otherwise, there will be a penalty of ₹"+minimumBalancePenalty());
    }
    public int minimumBalancePenalty() {
        if(minimumBalanceRequirement<=1000) return 100;
        else if(minimumBalanceRequirement<=2000) return 250;
        return 500;
    }
}
class JandhanAccount extends SavingsAccount{
    public JandhanAccount(String firstName, String lastName, String debitCardNumber){
        super(firstName, lastName,debitCardNumber,0);
        debitCardType='C';
        System.out.println("There is no minimum balance requirement and penalty over insufficient minimum balance.");
        System.out.println("Total Savings within an year shouldn't exceed ₹1,00,000");
    }
    public int minimumBalancePenalty(){return 0;}
    public void deposit(double amount){
        if(balance+amount>100000){
            System.out.println("Total balance can't exceed ₹1,00,000 in an year");
            return;
        }
        // use the deposit method of Parent class if the condition is not met
        else super.deposit(amount);
    }
}
public class BankingSystem {
    public static void main(String[] args){
        SavingsAccount s1=new SavingsAccount("Sasank","Lakimsetti","12345",1000);
        s1.deposit(1000);
        s1.deposit(1000);
        s1.showBalance();
        System.out.println();
        System.out.println();
        SavingsAccount s2=new SavingsAccount("Sasank","Lakimsetti","12345",1000);
        s2.deposit(1000);
        s2.deposit(1000);
        s2.showBalance();
        System.out.println();
        System.out.println();
        JandhanAccount j1=new JandhanAccount("Sai","Sasank","12346");
        j1.deposit(10000);
        j1.showBalance();
        System.out.println();
        System.out.println();
        LoanAccount l1=new LoanAccount("Yuvaraj","Poduri",2000000,"Home",180);
        l1.deposit(10000);
        l1.showBalance();

    }
}

package fa.training.entities;

/**
 *
 * @author NghiêmNam
 */
public class SavingsAccount {
    private double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount() {
        this.savingsBalance = 0.0;
    }

    public SavingsAccount(double intRate, double savBal) {
        this.annualInterestRate = intRate;
        this.savingsBalance = savBal;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    // Method to calculate monthly interest
    public void calculateMonthlyInterest() {
        double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += monthlyInterest;
    }
}

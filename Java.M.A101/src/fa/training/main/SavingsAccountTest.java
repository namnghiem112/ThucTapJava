package fa.training.main;

import fa.training.entities.SavingsAccount;

/**
 *
 * @author NghiêmNam
 */
public class SavingsAccountTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();

        saver1.setSavingsBalance(2000.00);
        saver2.setSavingsBalance(3000.00);
        saver1.setAnnualInterestRate(0.04);
        saver2.setAnnualInterestRate(0.04);
        
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Saver 1 new balance: " + saver1.getSavingsBalance());
        System.out.println("Saver 2 new balance: " + saver2.getSavingsBalance());

        saver1.setAnnualInterestRate(0.05);
        saver2.setAnnualInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("Saver 1 new balance after 5% interest: " + saver1.getSavingsBalance());
        System.out.println("Saver 2 new balance after 5% interest: " + saver2.getSavingsBalance());
    }
    
}

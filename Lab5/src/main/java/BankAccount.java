import java.util.Random;

/**
 * Class implementing a bank account.
 * <p>
 * Complete and document this class as part of Lab 8.
 *
 * @see <a href="https://cs125.cs.illinois.edu/lab/8/">Lab 8 Description</a>
 */
public class BankAccount {

    /**
     * distinguishes between types.
     */
    public enum BankAccountType {
        /**
         * write checks.
         */
        CHECKINGS,
        /**
         * save money.
         */
        SAVINGS,
        /**
         * broke ass kind.
         */
        STUDENT,
        /**
         * biz.
         */
        WORKPLACE
    }

    /**
     * account number.
     */
    private int accountNumber;
    /**
     * account type.
     */
    private BankAccountType accountType;
    /**
     * account balance.
     */
    private double accountBalance;
    /**
     * owner name.
     */
    private String ownerName;
    /**
     * interest rate.
     */
    private double interestRate;
    /**
     * interest earned.
     */
    private double interestEarned;

    /**
     * constructor.
     * @param name owner name
     * @param accountCategory account type
     */
    public BankAccount(final String name, final BankAccountType accountCategory) {
        ownerName = name;
        accountType = accountCategory;
        Bank.add();
    }

    /**
     * returns account number.
     * @return accountNumber
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * sets account number.
     * @param newNumber sets account to this number
     */
    public void setAccountNumber(final int newNumber) {
        accountNumber = newNumber;
    }

    /**
     * returns bank account type.
     * @return accountType
     */
    public BankAccountType getAccountType() {
        return accountType;
    }

    /**
     * sets account type.
     * @param newType sets account to this type
     */
    public void setAccountType(final BankAccountType newType) {
        accountType = newType;
    }

    /**
     * returns account balance.
     * @return accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * sets account balance.
     * @param newBalance sets account to this balance
     */
    public void setAccountBalance(final double newBalance) {
        accountBalance = newBalance;
    }

    /**
     * return account owner's name.
     * @return ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * sets owner name.
     * @param newName sets owner to this name
     */
    public void setOwnerName(final String newName) {
        ownerName = newName;
    }

    /**
     * returns interest rate.
     * @return interestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * sets interest rate.
     * @param newRate sets interest to this rate
     */
    public void setInterestRate(final int newRate) {
        interestRate = newRate;
    }

    /**
     * returns interest earned.
     * @return interest earned
     */
    public double getInterestEarned() {
        return interestEarned;
    }

    /**
     * sets interest earned.
     * @param newInterest sets earned interest to this amount
     */
    public void setInterestEarned(final double newInterest) {
        interestEarned = newInterest;
    }

}
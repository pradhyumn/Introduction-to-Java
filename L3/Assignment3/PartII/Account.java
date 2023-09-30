 
public class Account {

    private static int account_count = 1;
    private double balance;
    private int id;

    Account() {}

    Account(double startingBalance) {
        this.balance = startingBalance;
        this.id = account_count;
        account_count++;
    }

    public boolean withdraw(double amount) {
        if(amount <= this.balance) {
            this.balance -= amount;
            return true;
        }
        else return false;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return this.id;
    }
}

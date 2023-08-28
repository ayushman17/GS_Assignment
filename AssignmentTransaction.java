import java.util.Date;
class Account {
    private int accno;
    private String accholdername;
    private Date openedDate;
    private String status;
    private double balance;

    public Account(int accno, String accholdername, Date openedDate, String status, double balance) {
        this.accno = accno;
        this.accholdername = accholdername;
        this.openedDate = openedDate;
        this.status = status;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account Object {" +
                "accno= " + accno +
                ", accholdername= " + accholdername + ' ' +
                ", openedDate= " + openedDate +
                ", status= " + status + ' ' +
                ", balance= " + balance +
                '}';
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
        //System.out.println(message;
    }
}

class Transaction {
    public void deposit(Account a, double amount) {
        double newBalance = a.getBalance() + amount;
        a.setBalance(newBalance);
        System.out.println("Deposited: ₹" + amount);
    }
    public void withdraw(Account a, double amount) throws InsufficientBalanceException {
        if (a.getBalance() >= amount) {
            double newBalance = a.getBalance() - amount;
            a.setBalance(newBalance);
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            throw new InsufficientBalanceException("Insufficient balance to withdraw ₹" + amount);
        }
    }
}

public class AssignmentTransaction {
    public static void main(String[] args) {
        Account account = new Account(12345, "Spider-Man", new Date(2003, 1, 17), "Active", 10000.0);
        Account account2 = new Account(54321, "ShaktiMaan", new Date(2010, 12, 19), "Active", 20000.0);
        Transaction transaction = new Transaction();
        //Transaction transaction2 = new Transaction();
        try {
            transaction.deposit(account, 5000.0);
            transaction.deposit(account, 50.0);
            transaction.withdraw(account, 100.0);
            transaction.withdraw(account, 3000.0);
            //transaction.withdraw(account, 15000.0);

            transaction.deposit(account2, 1000.0);
            transaction.deposit(account2, 500.0);
            transaction.withdraw(account2, 800.0);
            transaction.withdraw(account2, 2000.0);
            transaction.withdraw(account2, 19000.0);;
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Current Balance (Account): ₹" + account.getBalance());
        System.out.println(account);
        System.out.println("Current Balance (Account2): ₹" + account2.getBalance());
        System.out.println(account2);
    }
}

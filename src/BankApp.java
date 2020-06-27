import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        BankAccount obj1 = new BankAccount("User", "BA001");
        obj1.showMenu();
    }
}

class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid)
    {
        customerName = cname;
        customerId = cid;
    }

    // To make a deposit
    void deposit(int amount)
    {
        if (amount != 0)
        {
            balance += amount;
            previousTransaction = amount;
        }
    }

    // To make withdraw
    void withdraw(int amount)
    {
        if (amount != 0)
        {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    // to see previous transaction
    void getPreviousTransaction()
    {
        // check if its deposited
        if (previousTransaction > 0)
        {
            System.out.println("Deposited: " + previousTransaction);
        }
        // check if its withdraw
        else if (previousTransaction < 0)
        {
            // turn the value into positive
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        }
        // If there's no transaction before
        else
        {
            // Output no transaction
            System.out.println("No transaction occurred");
        }
    }

    void showMenu()
    {
        char option = '\0';  // initialize the value as zero in string
        Scanner scanner = new Scanner(System.in);

        // This is the interface that the user will see
        System.out.println("Welcome " + customerName + "!!");
        System.out.println("Your ID is " + customerId);
        System.out.print("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
        System.out.println("H. Help\n");

        do {
            // This is the input interface
            System.out.println("============================================================");
            System.out.println("Enter an Option (H for help and E to Exit)");
            System.out.println("============================================================");
            option = scanner.next().charAt(0);
            System.out.print("\n");

            // This switch statement will iterate as user use different commands
            switch (option)
            {
                // To see their balance
                case 'A':
                    System.out.println("----------------------------------");
                    System.out.println("Balance = $" + balance);
                    System.out.println("----------------------------------");
                    System.out.print("\n");
                    break;

                // To make a deposit
                case 'B':
                    System.out.println("----------------------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("----------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("You have deposit $" + amount + " into your account");
                    System.out.print("\n");
                    break;

                // To make a withdraw
                case 'C':
                    System.out.println("----------------------------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("----------------------------------");
                    int amount2 = scanner.nextInt();
                    deposit(amount2);
                    System.out.println("You have withdraw $" + amount2 + " from your account");
                    System.out.print("\n");
                    break;

                // To see their previous transaction
                case 'D':
                    System.out.println("----------------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------------");
                    System.out.print("\n");
                    break;

                // To seek help after forgetting commands
                case 'H':
                    System.out.println("----------------------------------");
                    System.out.println("A. Check Balance");
                    System.out.println("B. Deposit");
                    System.out.println("C. Withdraw");
                    System.out.println("D. Previous Transaction");
                    System.out.println("E. Exit");
                    System.out.println("H. Help");
                    System.out.println("----------------------------------");
                    System.out.print("\n");
                    break;

                // To exit the app
                case 'E':
                    System.out.println("**********************************");
                    break;

                // message for inputing invalid commands
                default:
                    System.out.println("Invalid Option!! Please enter again");
                    break;

            }

        } while (option != 'E');

        // Leaving message
        System.out.println("Thank you for using our services, and have a nice day");

    }

}
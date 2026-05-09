import java.util.*;


public class Main {
    public static void main(String[] args){
        // Student student1 = new Student("ali", 25, 3.8);
        // student1.printReport();
        // Scanner Obj = new Scanner(System.in);
        // System.out.println("Enter number");
        // int number = Obj.nextInt();
        // if(number % 2 == 0){
        //     System.out.println("Even");
        // }else{
        //     System.out.println("odd");
        // }
        // Obj.close(); 
        // int x=0;
        // while(++x<=3){
        //     System.out.println(x);
        // }


        // Map<String, Integer> map = new HashMap<>();

        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the Bank!");
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter National ID (NID): ");
        String nid = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        int initialBalance = scanner.nextInt();


        bankAccount myAccount = new bankAccount(name, nid, initialBalance);

        System.out.println("\nAccount successfully created for " + myAccount.getHolderName() + "!");


        boolean exit = false;

        while (!exit) {
            System.out.println("\n==============================");
            System.out.println("       BANKING MENU");
            System.out.println("==============================");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Check Remaining Daily Limit");
            System.out.println("5. Statement");
            System.out.println("6. Exit");
            System.out.println("==============================");
            System.out.print("Please choose an operation (1-6): ");

            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    myAccount.Deposite(depositAmount);
                    System.out.println("Current Balance: " + myAccount.getBalance());
                    // map.put("Deposit", depositAmount);


                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    myAccount.Withdraw(withdrawAmount);
                    System.out.println("Current Balance: " + myAccount.getBalance());
                    // transactions.add("withdraw "+ String.valueOf(withdrawAmount));
                    break;

                case 3:
                    System.out.println("Current Balance: " + myAccount.getBalance());
                    break;

                case 4:
                    int remainingLimit = myAccount.getWithdrawLimit() - myAccount.getWithdraw_Limit_consumed();
                    System.out.println("Remaining Daily Withdrawal Limit: " + remainingLimit);
                    break;


                case 5:
                    // this.Transactions = new ArrayList<>();
                    // for (String item : transactions) {
                    //     System.out.println(item);}
                    myAccount.printTransactions();
                    break;

                case 6:
                    System.out.println("Thank you for using our banking services. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
            }
        }

        scanner.close();

    }
}
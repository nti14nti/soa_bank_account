import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bankAccount {
    private String holderName;
    private String NID;
    private int balance;
    private final int WithdrawLimit = 500;
    private int Withdraw_Limit_consumed = 0;
    


    Map<String, List<Integer>> transactions;

    public bankAccount() {
        transactions = new HashMap<>();
        transactions.put("Deposit", new ArrayList<>());
        transactions.put("Withdraw", new ArrayList<>());
    }

    public bankAccount(String holderName, String NID, int balance) {
        this();
        this.holderName = holderName;
        this.NID = NID;
        this.balance = balance;
    }

    public String getHolderName() {
        return this.holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getNID() {
        return this.NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getWithdrawLimit() {
        return this.WithdrawLimit;
    }

    public int getWithdraw_Limit_consumed() {
        return this.Withdraw_Limit_consumed;
    }

    public void setWithdraw_Limit_consumed(int Withdraw_Limit_consumed) {
        this.Withdraw_Limit_consumed = Withdraw_Limit_consumed;
    }

    public void Deposite(int DepositeValue) {
        if (HelperCheckLogic(DepositeValue)) {
            balance += DepositeValue;
        } else {
            System.out.println("Enter a Valid Value");
        }
        transactions.get("Deposit").add(DepositeValue);
    }

    /*
     * public void Withdraw(int WithdrawValue) {
     * if (HelperCheckLogic(WithdrawValue) && (WithdrawValue <= balance)
     * && (Withdraw_Limit_consumed < WithdrawLimit) && (WithdrawValue <=
     * WithdrawLimit)) {
     * balance -= WithdrawValue;
     * Withdraw_Limit_consumed += WithdrawValue;
     * 
     * } else {
     * if (Withdraw_Limit_consumed > WithdrawLimit) {
     * System.out.println("Maximum withdraw value reached for the day");
     * } else {
     * System.out.println("Enter a Valid Value");
     * }
     * 
     * }
     * 
     * }
     */
    public void Withdraw(int WithdrawValue) {
        if (HelperCheckLogic(WithdrawValue)) {
            if (Withdraw_Limit_consumed + WithdrawValue <= WithdrawLimit) {
                if (WithdrawValue <= balance) {
                    balance -= WithdrawValue;
                    Withdraw_Limit_consumed += WithdrawValue;
                    System.out.println("Transaction Successful.");
                    transactions.get("Withdraw").add(WithdrawValue);
                } else {
                    System.out.println("Insufficient Amount.");
                }
            } else {
                System.out.println("Maximum withdraw limit reached for the day.");
            }
        } else {
            System.out.println("Enter a Valid Value (Must be a positive number).");
        }
    }
    public void printTransactions() {
    for (Map.Entry<String, List<Integer>> entry : transactions.entrySet()) {
        System.out.println(entry.getKey() + ":");

        for (int amount : entry.getValue()) {
            System.out.println("  " + amount);
        }
    }
}

    private boolean HelperCheckLogic(int value) {
        boolean Res = false;
        if (value > 0) {
            Res = true;
        }
        return Res;
    }

}
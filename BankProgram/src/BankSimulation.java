import java.util.Arrays;
import java.util.Random;

public class BankSimulation {
    private NormalAccount[] normalAccounts;
    private LimitedAccount[] limitedAccounts;
    private OverdraftAccount[] overdraftAccounts;
    private int count;

    public static Random r = new Random();

    public BankSimulation(int count) {
        this.count = count;
        normalAccounts = new NormalAccount[count];
        limitedAccounts = new LimitedAccount[count];
        overdraftAccounts = new OverdraftAccount[count];

        for (int i = 0; i < count; i++) {
            normalAccounts[i] = new NormalAccount(100);
            limitedAccounts[i] = new LimitedAccount(100, 1000);
            overdraftAccounts[i] = new OverdraftAccount(100, -1000);
        }

        addARandomCash(normalAccounts);
        addARandomCash(limitedAccounts);
        addARandomCash(overdraftAccounts);
    }

    public void addARandomCash(Account[] accounts) {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].deposit(r.nextInt(10000, 50000));
        }
    }

    public void simulate() {
        boolean res = true;
        boolean res2 = true;
        boolean res3 = true;

        for (int i = 0; i < normalAccounts.length; i++) {
            if ((i + 1) % 2 == 0) {
                normalAccounts[i].deposit(r.nextInt(100, 1000));
                limitedAccounts[i].deposit(r.nextInt(100, 1000));
                overdraftAccounts[i].deposit(r.nextInt(100, 1000));
            } else {
                res = normalAccounts[i].withdraw(r.nextInt(100, 1000));
                res2 = limitedAccounts[i].withdraw(r.nextInt(100, 1000));
                res3 = overdraftAccounts[i].withdraw(r.nextInt(100, 1000));
            }

            if (!res) {
                normalAccounts[i].printTransactions();
                break;
            } else if (!res2) {
                limitedAccounts[i].printTransactions();
                break;
            } else if (!res3) {
                overdraftAccounts[i].printTransactions();
                break;
            }
        }
    }

    private int moneyInTheBank(){
        int totalMoney = 0;
        for (int i = 0; i < normalAccounts.length; i++) {
            totalMoney += normalAccounts[i].getMoneyInTheAccount()
            +overdraftAccounts[i].getMoneyInTheAccount() + limitedAccounts[i].getMoneyInTheAccount();
        }
        return totalMoney;
    }
    private int howManyAccountInTheBank(){
        return limitedAccounts.length + normalAccounts.length + overdraftAccounts.length;
    }
    public void theHighestAndLowestBalance(){
        int highestBalance = normalAccounts[0].getMoneyInTheAccount();
        int lowerBalance = normalAccounts[0].getMoneyInTheAccount();
        for (int i = 0; i < normalAccounts.length; i++) {
            if (normalAccounts[i].getMoneyInTheAccount() < lowerBalance){
                lowerBalance = normalAccounts[i].getMoneyInTheAccount();
            }
            if (normalAccounts[i].getMoneyInTheAccount() > highestBalance){
                highestBalance = normalAccounts[i].getMoneyInTheAccount();
            }
            if (limitedAccounts[i].getMoneyInTheAccount() < lowerBalance){
                lowerBalance = limitedAccounts[i].getMoneyInTheAccount();
            }
            if (limitedAccounts[i].getMoneyInTheAccount() > highestBalance){
                highestBalance = limitedAccounts[i].getMoneyInTheAccount();
            }
            if (overdraftAccounts[i].getMoneyInTheAccount() < lowerBalance){
                lowerBalance = overdraftAccounts[i].getMoneyInTheAccount();
            }
            if (overdraftAccounts[i].getMoneyInTheAccount() > highestBalance){
                highestBalance = overdraftAccounts[i].getMoneyInTheAccount();
            }
        }
        System.out.println("The lower balance is ---> " + lowerBalance);
        System.out.println("The highest balance is ---> " + highestBalance);
    }

    public String toString() {
       int howManyAccountInTheBank = howManyAccountInTheBank();
       int moneyInTheBank = moneyInTheBank();

        String s = "Account in the bank ---> " + howManyAccountInTheBank + "\n" +
                "Money in the bank ---> " + moneyInTheBank + "\n";
        theHighestAndLowestBalance();
        return s;

    }
}

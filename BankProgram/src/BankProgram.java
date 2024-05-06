public class BankProgram {
    public static void main(String[] args) {


    }
    public static void CheckProgram(){
        System.out.println("|Regular Account|");
        NormalAccount normalAccount = new NormalAccount(1000);
        System.out.println(normalAccount);
        normalAccount.deposit(400);
        System.out.println(normalAccount);
        System.out.println(normalAccount.withdraw(1000));
        System.out.println(normalAccount);
        System.out.println(normalAccount.withdraw(500));
        normalAccount.printTransactions();

        System.out.println();
        System.out.println();

        System.out.println("|Limited Account|");
        LimitedAccount limitedAccount = new LimitedAccount(2000,1000);
        System.out.println(limitedAccount);
        System.out.println(limitedAccount.withdraw(500));
        System.out.println(limitedAccount);
        System.out.println(limitedAccount.withdraw(1100));
        System.out.println(limitedAccount);
        System.out.println(limitedAccount.withdraw(1000));
        System.out.println(limitedAccount);
        limitedAccount.printTransactions();

        System.out.println();
        System.out.println();

        System.out.println("|Overdraft Account|");
        OverdraftAccount overdraftAccount = new OverdraftAccount(4000,-5000);
        System.out.println(overdraftAccount);
        System.out.println(overdraftAccount.withdraw(4000));
        System.out.println(overdraftAccount);
        overdraftAccount.deposit(500);
        System.out.println(overdraftAccount);
        System.out.println(overdraftAccount.withdraw(5000));
        System.out.println(overdraftAccount);
        overdraftAccount.printTransactions();
    }
}

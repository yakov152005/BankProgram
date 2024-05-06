public class LimitedAccount extends Account{
    private int limit;

    public LimitedAccount(int initialBalance, int limit) {
        super(initialBalance);
        this.limit = limit;
    }

    public String toString(){
        return super.toString();
    }

    @Override
    public void deposit(int sum) {
        super.deposit(sum);
    }

    public int getLimit() {
        return limit;
    }

    public boolean withdraw (int sum){
        boolean success = false;
        int before = this.getMoneyInTheAccount();
        if (this.checkEnoughBalance(sum) && sum <= this.limit) {
            this.setMoneyInTheAccount(getMoneyInTheAccount() - sum);
            success = true;
        }else {
            System.out.println("The limit is ---> " + this.limit);
            System.out.println("The withdrawal was not successful because it is higher than the limit.");

        }
        int after = this.getMoneyInTheAccount();
        Transaction transaction = new Transaction(getHistory() +1, Transaction.TYPE_WITHDRAW, success, before, after);
        addHistory(transaction);
        return success;
    }

    @Override
    public void printTransactions() {
        super.printTransactions();
    }
}

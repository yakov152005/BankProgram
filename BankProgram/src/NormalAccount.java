public class NormalAccount extends Account{

    public NormalAccount(int initialBalance) {
        super(initialBalance);
    }
    @Override
    public void deposit(int sum) {
        super.deposit(sum);
    }

    public boolean withdraw (int sum){
        boolean success = false;
        int before = this.getMoneyInTheAccount();
        if (this.checkEnoughBalance(sum)) {
            this.setMoneyInTheAccount(getMoneyInTheAccount() - sum);
            success = true;
        }
        int after = this.getMoneyInTheAccount();
        Transaction transaction = new Transaction(getHistory(), Transaction.TYPE_WITHDRAW, success, before, after);
        addHistory(transaction);
        return success;
    }
    @Override
    public void printTransactions() {
        super.printTransactions();
    }
    public String toString () {
        return super.toString();
    }
}

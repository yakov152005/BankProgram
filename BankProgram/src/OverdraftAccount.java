public class OverdraftAccount extends Account{
    public int frame;

    public OverdraftAccount(int initialBalance, int frame) {
        super(initialBalance);
        this.frame = frame;
    }

    @Override
    public void deposit(int sum) {
        super.deposit(sum);
    }

    @Override
    public boolean withdraw(int sum) {
      boolean success = false;
      int before = this.getMoneyInTheAccount();
      if (this.getMoneyInTheAccount() - sum >= this.frame){
          this.setMoneyInTheAccount(this.getMoneyInTheAccount() - sum);
          success = true;
      }else {
          System.out.println("Your frame ---> " + this.frame);
          System.out.println("The withdrawal was not successful, because you exceeded the frame");
      }
      int after = this.getMoneyInTheAccount();
      Transaction transaction = new Transaction(getHistory()+1,Transaction.TYPE_WITHDRAW,success,before,after);
      addHistory(transaction);
      return success;
    }

    @Override
    public void printTransactions() {
        super.printTransactions();
    }
    public String toString() {
        return super.toString();
    }
}

public abstract class Account  {
    private  Transaction[] history;
    private int moneyInTheAccount;

    public Account(int initialBalance){
        this.moneyInTheAccount = initialBalance;
        this.history = new Transaction[0];
    }

    public void deposit ( int sum){
        int before = moneyInTheAccount;
        this.moneyInTheAccount += sum;
        int after = moneyInTheAccount;
        Transaction transaction =
                new Transaction(this.history.length + 1,Transaction.TYPE_DEPOSIT,true,before,after);
        System.out.println("|Deposit Success|");
        addHistory(transaction);
    }

    public void setMoneyInTheAccount(int moneyInTheAccount) {
        this.moneyInTheAccount = moneyInTheAccount;
    }

    public int getHistory(){
        return this.history.length;
    }

    public int getMoneyInTheAccount() {
        return moneyInTheAccount;
    }
    public boolean checkEnoughBalance(int sum){
        return sum <= this.moneyInTheAccount;
    }

    public void addHistory(Transaction transaction){
        Transaction[] temp = new Transaction[history.length + 1];
        for (int i = 0; i < history.length; i++) {
            temp[i] = history[i];
        }
        temp[temp.length -1] = transaction;
        history = temp;
    }

    public abstract boolean withdraw ( int sum);

    public void printTransactions () {
        for (int i = 0; i < this.history.length; i++) {
            System.out.println("-----------");
            System.out.println("-----------");
            System.out.println(this.history[i] +" ");
        }
    }
    public String toString () {
        return "Your balance: " + this.moneyInTheAccount +"$";
    }
}

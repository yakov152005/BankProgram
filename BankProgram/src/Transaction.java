public class Transaction {
    private int count;
    private int type;
    private boolean success;
    private int before;
    private int after;

    public static final int TYPE_DEPOSIT = 1;
    public static final int TYPE_WITHDRAW = 2;
    public Transaction(int count,int type,boolean success,int before,int after){
        this.count = count;
        this.type = type;
        this.success = success;
        this.before = before;
        this.after = after;
    }
    public String toString(){
        return "Transaction # " + this.count + ":\n" +
        "Type: " + (this.type == TYPE_DEPOSIT  ? "Deposit"  : "Withdrawal") + "\n" +
                "Success: " +(this.success ? "Yes" : "No") + "\n" +
                "Balance Before: " + this.before +"\n" +
                "Balance After: " + this.after;
    }
}

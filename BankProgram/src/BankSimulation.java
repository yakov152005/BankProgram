public class BankSimulation {
    private NormalAccount[] normalAccounts;
    private LimitedAccount[] limitedAccounts;
    private OverdraftAccount[] overdraftAccounts;
    private int count;

    public BankSimulation(int count) {
        normalAccounts = new NormalAccount[count];
        limitedAccounts = new LimitedAccount[count];
        overdraftAccounts = new OverdraftAccount[count];
    }
    public void simulate(){
        
    }

}
package vendingmachine;

import Inventory.Inventory;
import Inventory.Product;
import States.CoinInsertedState;
import States.DispenceState;
import States.NoCoinInsertedState;
import States.State;

public class VendingMachine {
    private NoCoinInsertedState noCoinInsertedState;
    private CoinInsertedState coinInsertedState;
    private DispenceState dispenceState;
    private State currentVendingMachineState;
    private Inventory inventory;
    private double amount;
    private static final int AISLE_COUNT=2;

    public VendingMachine(){
        noCoinInsertedState=new NoCoinInsertedState(this);
        coinInsertedState=new CoinInsertedState(this);
        dispenceState=new DispenceState(this);
        currentVendingMachineState=noCoinInsertedState;
        amount=0;
        inventory=new Inventory(AISLE_COUNT);

    }
    public boolean hasSufficientAmount(double expectedAmount){
        return expectedAmount<=this.amount;
    }
    public NoCoinInsertedState getNoCoinInsertedState(){
        return noCoinInsertedState;
    }
    public void setNoCoinInsertedState(NoCoinInsertedState noCoinInsertedState){
        this.noCoinInsertedState=noCoinInsertedState;
    }
    public CoinInsertedState getCoinInsertedState(){
        return coinInsertedState;
    }
    public void setCoinInsertedState(CoinInsertedState coinInsertedState){
        this.coinInsertedState=coinInsertedState;
    }
    public DispenceState getDispenceState() {
        return dispenceState;
    }
    public void setDispenceState(DispenceState dispenceState){
        this.dispenceState=dispenceState;
    }
    public State getCurrentVendingMachineState(){
        return currentVendingMachineState;
    }
    public void setCurrentVendingMachineState(State currentVendingMachineState){
        this.currentVendingMachineState=currentVendingMachineState;
    }
    public Inventory getInventory(){
        return this.inventory;
    }
    public void setInventory(Inventory inventory){
        this.inventory=inventory;
    }
    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void insertCoin(double amount){
        this.currentVendingMachineState.insertCoin(amount);
        System.out.println(amount+ " coin is inserted");
    }
    public void pressButton(int aisleNumber){
        this.currentVendingMachineState.pressButton(aisleNumber);
        this.currentVendingMachineState.dispense(aisleNumber);
    }
    public void addProduct(Product product){
        try{
            this.getInventory().addProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

















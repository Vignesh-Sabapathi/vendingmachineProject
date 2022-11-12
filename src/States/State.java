package States;
//Three different states
//No coin Inserted state -->Coin Inserted State-->Dispense State -->No coin Inserted State
public interface State {
    public void insertCoin(double amount);
    public void pressButton(int aisleNumber);
    public void dispense(int aisleNumber);
}

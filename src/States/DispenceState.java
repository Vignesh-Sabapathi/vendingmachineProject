package States;

import Inventory.Inventory;
import Inventory.Product;
import vendingmachine.VendingMachine;

public class DispenceState implements State{
    VendingMachine vendingMachine;

    public DispenceState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(double amount) {
        throw new IllegalStateException("Product getting dispensed");
    }

    @Override
    public void pressButton(int aisleNumber) {
        throw new IllegalStateException("Product getting dispensed");
    }

    @Override
    public void dispense(int aisleNumber) {
        Inventory inventory=vendingMachine.getInventory();
        Product product=inventory.getProductAt(aisleNumber);

        inventory.deductProductCount(aisleNumber);
        double change =vendingMachine.getAmount()- product.getPrice();
        vendingMachine.setAmount(0);
        vendingMachine.setCurrentVendingMachineState(vendingMachine.getNoCoinInsertedState());

        System.out.println("Product with id " +product.getId() +" is dispensed please collect the change "+change);
    }
}

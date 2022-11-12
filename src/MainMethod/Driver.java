package MainMethod;

import Inventory.Product;
import vendingmachine.VendingMachine;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine=new VendingMachine();
        Product cola=new Product("cola",1,5.0);
        for(int i=1;i<=3;i++){
            vendingMachine.addProduct(cola);
        }
        Product pepsi=new Product("pepsi",2,2.0);
        for (int i=1;i<=3;i++){
            vendingMachine.addProduct(pepsi);
        }
        vendingMachine.insertCoin(5.0);
        vendingMachine.insertCoin(3.0);
        vendingMachine.pressButton(1);

        vendingMachine.insertCoin(5.0);
        vendingMachine.pressButton(1);

        vendingMachine.insertCoin(7.0);
        vendingMachine.pressButton(2);
    }
}

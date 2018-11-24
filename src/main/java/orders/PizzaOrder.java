package orders;

import orders.Order;

public class PizzaOrder implements Order {
    private int amount;

    public PizzaOrder(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return amount;
    }
}

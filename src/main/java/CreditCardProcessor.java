public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException;
    int getAmountOfOnlyCharge();
    CreditCard getCardOfOnlyCharge();
}

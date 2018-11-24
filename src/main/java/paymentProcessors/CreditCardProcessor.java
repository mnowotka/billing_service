package paymentProcessors;

import creditCard.CreditCard;
import exceptions.UnreachableException;
import paymentArtifacts.ChargeResult;

public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException;
    int getAmountOfOnlyCharge();
    CreditCard getCardOfOnlyCharge();
}

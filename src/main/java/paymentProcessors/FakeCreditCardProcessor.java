package paymentProcessors;

import creditCard.CreditCard;
import exceptions.UnreachableException;
import paymentArtifacts.ChargeResult;
import paymentProcessors.CreditCardProcessor;

public class FakeCreditCardProcessor implements CreditCardProcessor {
    private CreditCard lastCreditCard;
    private int lastAmount;

    public ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException {
        lastCreditCard = creditCard;
        lastAmount = amount;
        return new ChargeResult(amount);
    }
    public int getAmountOfOnlyCharge(){
        return lastAmount;
    }

    public CreditCard getCardOfOnlyCharge(){
        return lastCreditCard;
    }
}

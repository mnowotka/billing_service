package billingService.paymentProcessors;

import billingService.creditCard.CreditCard;
import billingService.exceptions.UnreachableException;
import billingService.paymentArtifacts.ChargeResult;

public class PaypalCreditCardProcessor implements CreditCardProcessor {
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

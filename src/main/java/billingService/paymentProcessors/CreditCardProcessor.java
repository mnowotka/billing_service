package billingService.paymentProcessors;

import billingService.creditCard.CreditCard;
import billingService.exceptions.UnreachableException;
import billingService.paymentArtifacts.ChargeResult;

public interface CreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, int amount) throws UnreachableException;
    int getAmountOfOnlyCharge();
    CreditCard getCardOfOnlyCharge();
}

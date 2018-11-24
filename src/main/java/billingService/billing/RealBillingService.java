package billingService.billing;

import com.google.inject.Inject;
import billingService.creditCard.CreditCard;
import billingService.exceptions.UnreachableException;
import billingService.orders.PizzaOrder;
import billingService.paymentArtifacts.ChargeResult;
import billingService.paymentArtifacts.Receipt;
import billingService.paymentProcessors.CreditCardProcessor;
import billingService.transactionLogs.TransactionLog;

public class RealBillingService implements BillingService {
    private final CreditCardProcessor processor;
    private final TransactionLog transactionLog;

    @Inject
    public RealBillingService(CreditCardProcessor processor,
                              TransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            return result.wasSuccessful()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclinedCharge(result.getDeclineMessage());
        } catch (UnreachableException e) {
            transactionLog.logConnectException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }
}
package billingService.billing;

import billingService.paymentProcessors.PaypalCreditCardProcessor;
import billingService.transactionLogs.DatabaseTransactionLog;
import billingService.creditCard.CreditCard;
import billingService.exceptions.UnreachableException;
import billingService.orders.PizzaOrder;
import billingService.paymentArtifacts.ChargeResult;
import billingService.paymentArtifacts.Receipt;

public class RealBillingService implements BillingService {
    private final PaypalCreditCardProcessor processor = new PaypalCreditCardProcessor();
    private final DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();

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
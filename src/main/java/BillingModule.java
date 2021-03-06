import billingService.billing.BillingService;
import billingService.billing.RealBillingService;
import com.google.inject.AbstractModule;
import billingService.paymentProcessors.CreditCardProcessor;
import billingService.paymentProcessors.PaypalCreditCardProcessor;
import billingService.transactionLogs.DatabaseTransactionLog;
import billingService.transactionLogs.TransactionLog;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingService.class);
    }
}
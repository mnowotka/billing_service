package billing;

import com.google.inject.AbstractModule;
import paymentProcessors.CreditCardProcessor;
import paymentProcessors.PaypalCreditCardProcessor;
import transactionLogs.DatabaseTransactionLog;
import transactionLogs.TransactionLog;

public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
        bind(BillingService.class).to(RealBillingService.class);
    }
}
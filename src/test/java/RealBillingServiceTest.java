import billingService.billing.RealBillingService;
import billingService.creditCard.CreditCard;
import billingService.orders.PizzaOrder;
import org.junit.Test;
import billingService.paymentArtifacts.Receipt;
import billingService.paymentProcessors.FakeCreditCardProcessor;
import billingService.transactionLogs.InMemoryTransactionLog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RealBillingServiceTest {

    private final PizzaOrder order = new PizzaOrder(100);
    private final CreditCard creditCard = new CreditCard("1234", 11, 2010);

    private final InMemoryTransactionLog transactionLog = new InMemoryTransactionLog();
    private final FakeCreditCardProcessor processor = new FakeCreditCardProcessor();

    @Test
    public void testSuccessfulCharge() {
        RealBillingService billingService
                = new RealBillingService(processor, transactionLog);
        Receipt receipt = billingService.chargeOrder(order, creditCard);

        assertTrue(receipt.hasSuccessfulCharge());
        assertEquals(100, receipt.getAmountOfCharge());
        assertEquals(creditCard, processor.getCardOfOnlyCharge());
        assertEquals(100, processor.getAmountOfOnlyCharge());
        assertTrue(transactionLog.wasSuccessLogged());
    }
}
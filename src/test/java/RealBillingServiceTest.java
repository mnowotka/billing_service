import billingService.billing.RealBillingService;
import billingService.creditCard.CreditCard;
import billingService.exceptions.UnreachableException;
import billingService.orders.PizzaOrder;
import billingService.paymentArtifacts.ChargeResult;
import org.junit.Test;
import billingService.paymentArtifacts.Receipt;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RealBillingServiceTest {

    private final PizzaOrder order = new PizzaOrder(100);
    private final CreditCard creditCard = new CreditCard("1234", 11, 2010);

    @Mock
    private TransactionLog transactionLog;

    @Mock
    private CreditCardProcessor processor;

    @InjectMocks
    private RealBillingService billingService;

    @Test
    public void testSuccessfulCharge() throws UnreachableException

    {
        when(processor.getCardOfOnlyCharge()).thenReturn(creditCard);
        when(processor.getAmountOfOnlyCharge()).thenReturn(100);
        when(processor.charge(any(CreditCard.class), anyInt())).thenReturn(new ChargeResult(100));
        when(transactionLog.wasSuccessLogged()).thenReturn(true);

        Receipt receipt = billingService.chargeOrder(order, creditCard);

        assertTrue(receipt.hasSuccessfulCharge());
        assertEquals(100, receipt.getAmountOfCharge());
        assertEquals(creditCard, processor.getCardOfOnlyCharge());
        assertEquals(100, processor.getAmountOfOnlyCharge());
        assertTrue(transactionLog.wasSuccessLogged());
    }
}
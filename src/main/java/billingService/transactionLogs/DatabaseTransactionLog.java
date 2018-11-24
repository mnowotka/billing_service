package billingService.transactionLogs;

import billingService.paymentArtifacts.ChargeResult;

public class DatabaseTransactionLog {
    public void logChargeResult(ChargeResult result){
        return;
    }
    public void logConnectException(Exception e){
        return;
    }
    public boolean wasSuccessLogged(){
        return true;
    }
}

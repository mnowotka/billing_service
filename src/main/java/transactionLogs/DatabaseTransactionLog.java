package transactionLogs;

import paymentArtifacts.ChargeResult;
import transactionLogs.TransactionLog;

public class DatabaseTransactionLog implements TransactionLog {
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

public interface TransactionLog {
    public void logChargeResult(ChargeResult result);
    public void logConnectException(Exception e);
    public boolean wasSuccessLogged();
}

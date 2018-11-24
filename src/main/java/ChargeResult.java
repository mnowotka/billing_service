public class ChargeResult {
    private int amount = 0;
    private boolean successful = false;
    private String declinedMessage;

    public ChargeResult(int amount){
        this.amount = amount;
        this.successful = true;
    }

    public ChargeResult(String declinedMessage){
        this.declinedMessage = declinedMessage;
    }

    public boolean wasSuccessful(){
        return successful;
    }

    public String getDeclineMessage(){
        return declinedMessage;
    }
}

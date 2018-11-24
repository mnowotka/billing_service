package billingService.paymentArtifacts;

public class Receipt {
    private int amount = 0;
    private boolean succesfullyCharged = false;

    public Receipt(int amount){
        this.amount = amount;
        this.succesfullyCharged = true;
    }

    public Receipt(){
    }

    public static Receipt forSuccessfulCharge(int amount){
        return new Receipt(amount);
    }

    public static Receipt forDeclinedCharge(String declineMessage){
        return new Receipt();
    }

    public static Receipt forSystemFailure(String errorMessage){
        return new Receipt();
    }

    public int getAmountOfCharge(){
        return amount;
    }

    public boolean hasSuccessfulCharge(){
        return succesfullyCharged;
    }
}

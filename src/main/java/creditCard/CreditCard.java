package creditCard;

public class CreditCard {
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;

    public CreditCard(String cardNumber, int expiryMonth, int expiryYear){
        this.cardNumber = cardNumber;
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
    }
}

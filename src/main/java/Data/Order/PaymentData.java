package Data.Order;

public enum PaymentData {

    PAYMENT_DATA("Test Visa Card", "4111 1111 1111 1111", "123");

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    private String cardName;
    private String cardNumber;
    private String securityCode;

    PaymentData(String cardName,String cardNumber, String securityCode){
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
    }
}

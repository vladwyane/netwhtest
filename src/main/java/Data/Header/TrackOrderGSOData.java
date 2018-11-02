package Data.Header;

public enum  TrackOrderGSOData {
    VALID_ORDER_DATA("R064939614" , "AllowCodeInmate4");

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getInmateID() {
        return inmateID;
    }

    private String orderNumber;
    private String inmateID;

    TrackOrderGSOData(String orderNumber, String inmateID) {
        this.orderNumber = orderNumber;
        this.inmateID = inmateID;
    }
}

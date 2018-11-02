package Data.Header;

public enum TrackOrderUPSData {
    VALID_ORDER_DATA("R621497233" , "AllowCodeInmate4");

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getInmateID() {
        return inmateID;
    }

    private String orderNumber;
    private String inmateID;

    TrackOrderUPSData(String orderNumber, String inmateID) {
        this.orderNumber = orderNumber;
        this.inmateID = inmateID;

    }
}

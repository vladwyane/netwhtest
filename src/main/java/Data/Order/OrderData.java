package Data.Order;

public enum OrderData {
    VALID_ORDER_DATA("FirstName" + Math.random() * 5, "LastName+" + Math.random() * 5, "1111111111", "Phoenix", "Phoenix Street Address" + Math.random() * 5, "85001");

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalZip() {
        return postalZip;
    }

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String streetAddress;
    private String postalZip;

    OrderData(String firstName, String lastName, String phoneNumber, String city, String streetAddress, String postalZip) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.streetAddress = streetAddress;
        this.postalZip = postalZip;
    }
}
package Data.Header;

public enum FundInmateUnregistered {
    VALID_ORDER_DATA("FirstName" + Math.random() * 5, "LastName+" + Math.random() * 5, "stanislav.leontjev"+Math.random() * 5+"@bigdropinc.com", "1111111111", "Phoenix", "Phoenix Street Address" + Math.random() * 5, "85001","987654321","987654321");

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail(){return email;}

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

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String streetAddress;
    private String postalZip;
    private String password;
    private String confirmPassword;

    FundInmateUnregistered(String firstName, String lastName, String email, String phoneNumber, String city, String streetAddress, String postalZip, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.streetAddress = streetAddress;
        this.postalZip = postalZip;
        this.password = password;
        this.confirmPassword = password;
    }
}

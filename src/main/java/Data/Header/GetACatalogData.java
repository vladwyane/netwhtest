package Data.Header;

public enum GetACatalogData {

    VALIDDATA("Leon Test", "Address 111", "Phoenix", "85001", "stanislav.leontjev@bigdropinc.com", "0000000000");

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getPostalZipCode() {
        return postalZipCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String fullName;
    private String address;
    private String city;
    private String postalZipCode;
    private String email;
    private String phoneNumber;

    GetACatalogData(String fullName, String address, String city, String postalZipCode, String email, String phoneNumber) {
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.postalZipCode = postalZipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
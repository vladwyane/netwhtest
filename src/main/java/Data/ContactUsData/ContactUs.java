package Data.ContactUsData;

public enum ContactUs {
    VALID("leonsted", "stanislav.leontjev@bigdropinc.com", "1111111111", "Leon trst messgae"),
    INVALID("leonsted", "stanislav123", "1111111111", "Leon trst messgae");

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMessage() {
        return message;
    }

    private String name;
    private String email;
    private String phone;
    private String message;

    ContactUs(String name, String email, String phone, String message) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }
}
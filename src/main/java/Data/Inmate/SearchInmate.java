package Data.Inmate;

public enum SearchInmate {

    SEARCH_INMATE("Auto", "test", "Inmate12345");

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInmateID() {
        return inmateID;
    }

    private String firstName;
    private String lastName;
    private String inmateID;

    SearchInmate(String firstName, String lastName, String inmateID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.inmateID = inmateID;
    }
}
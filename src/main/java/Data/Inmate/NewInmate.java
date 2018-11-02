package Data.Inmate;

public enum NewInmate {
    NEW_INMATE("FirstName" + Math.random() * 5, "LastName+" + Math.random() * 5, "NewInmateId" + Math.random() * 5, "Housing unit " + Math.random() * 5);

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInmateID() {
        return inmateID;
    }

    public String getHousingUnit() {
        return housingUnit;
    }

    private String firstName;
    private String lastName;
    private String inmateID;
    private String housingUnit;

    NewInmate(String firstName, String lastName, String inmateID, String housingUnit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.inmateID = inmateID;
        this.housingUnit = housingUnit;
    }
}
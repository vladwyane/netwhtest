package Data.User;

public enum SignInUsersData {
    VALID("stanislav.leontjev@bigdropinc.com", "987654321"),
    INVALID("stanislav123.leontjevasv@bigdropinc.com","98765432qwe1"),
    UNREGISTERED("stanislav.leontjevasv+3015@bigdropinc.com","98765432");

    public String getLoginEmail() {
        return loginEmail;
    }

    public String getLoginPassword() {
        return password;
    }

    private String  loginEmail;
    private String  password;

    SignInUsersData(String loginEmail, String password){
         this.loginEmail = loginEmail;
         this.password = password;
    }
}
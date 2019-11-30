package hw4;

public class UserInfo {

    private String username;

    private String password;

    private String usernameLabel;

    public UserInfo(String username, String password, String usernameLabel) {
        this.username = username;
        this.password = password;
        this.usernameLabel = usernameLabel;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsernameLabel() {
        return usernameLabel;
    }
}

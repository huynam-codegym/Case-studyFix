package model;

public class User {
    private String username;
    private String passwork;

    public User() {
    }

    public User(String userName, String passwork) {
        this.username = userName;
        this.passwork = passwork;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswork() {
        return this.passwork;
    }

    public void setPasswork(String passwork) {
        this.passwork = passwork;
    }

    public String shoe() {
        return this.username + "," + this.passwork;
    }

    public String toString() {
        return "model.User{userName='" + this.username + "', passwork='" + this.passwork + "'}";
    }
}

package model;

public class Account {

    private String username;
    private String password;

    //Constructor rong
    public Account() {
    }

    //Constructor chua tham so
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //getter and setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Dinh dang chuoi de in ra
    @Override
    public String toString() {
        // Dùng StringBuilder 
        return new StringBuilder("Account{username='").append(username).append("'}").toString();
    }
}

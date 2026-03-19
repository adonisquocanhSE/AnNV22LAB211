package dto;

public class LoginRequestDTO {

    private String username;
    private String password;
    private String captchaInput;
    private String languageCode;

    //contructor khong tham so
    public LoginRequestDTO() {
    }

    // contructor co tham so 
    public LoginRequestDTO(String username, String password, String captchaInput, String languageCode) {
        this.username = username;
        this.password = password;
        this.captchaInput = captchaInput;
        this.languageCode = languageCode;
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

    public String getCaptchaInput() {
        return captchaInput;
    }

    public void setCaptchaInput(String captchaInput) {
        this.captchaInput = captchaInput;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

}

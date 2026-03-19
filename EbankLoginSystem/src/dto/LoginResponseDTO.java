package dto;

public class LoginResponseDTO {

    private boolean success;
    private String message;
    //contructor khong tham so

    public LoginResponseDTO() {
    }
    //contructor chua tham so

    public LoginResponseDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    //kiem tra chinh xac

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    //getter and setter

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

package view;

public class EbankView {

    private String loginResultMessage;

    //Hien thi ket qua dang nhap
    public void displayLoginResult() {
        System.out.println(loginResultMessage);
    }

    //Setter8
    public void setLoginResultMessage(String loginResultMessage) {
        this.loginResultMessage = loginResultMessage;
    }

}

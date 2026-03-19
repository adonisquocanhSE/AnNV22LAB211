package controller;

import dto.LoginRequestDTO;
import dto.LoginResponseDTO;
import service.EbankService;
import view.EbankView;

public class EbankController {

    private EbankService serviceEbank;
    private EbankView viewEbank;
    private LoginRequestDTO loginRequestDTO;

    //contructor khoi tao Service va View
    public EbankController() {
        serviceEbank = new EbankService();
        viewEbank = new EbankView();
    }

    //dat du lieu vao request de xu ly
    public void setLoginRequestDTO(LoginRequestDTO loginRequestDTO) {
        this.loginRequestDTO = loginRequestDTO;
    }

    //Ham kiem tra qua trinh dang nhap
    public void processLogin(String successMessage, String failMessage) {

        // Khai báo biến tập trung đầu block 
        LoginResponseDTO responseDTO = serviceEbank.authenticate(loginRequestDTO);
        String resultMessage;

        // Chọn thông báo phù hợp theo kết quả trong response
        if (responseDTO.isSuccess()) {
            resultMessage = successMessage;
        } else {
            resultMessage = failMessage;
        }

        // Truyền kết quả sang view và hiển thị
        viewEbank.setLoginResultMessage(resultMessage);
        viewEbank.displayLoginResult();
    }
}

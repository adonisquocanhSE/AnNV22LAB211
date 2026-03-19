package service;

import dto.LoginRequestDTO;
import dto.LoginResponseDTO;
import model.Account;
import repository.AccountRepository;

public class EbankService {

    //Thao tac du lieu voi Repository
    private AccountRepository accountRepository;

    //contructor khoi tao repository
    public EbankService() {
        accountRepository = new AccountRepository();
    }

    // Xac thuc thong tin
    public LoginResponseDTO authenticate(LoginRequestDTO requestDTO) {

        // Khai báo biến tập trung đầu block
        Account result = accountRepository.findByUsernameAndPassword(
                requestDTO.getUsername(), requestDTO.getPassword());
        boolean isSuccess = (result != null);
        return new LoginResponseDTO(isSuccess, "");
    }

}

package repository;

import java.util.ArrayList;
import java.util.List;
import model.Account;

public class AccountRepository {

    //Tao danh sach cac account
    private List<Account> accountList;

    //contructor 
    public AccountRepository() {
        accountList = new ArrayList<>();
        loadMockData();
    }

    //nap tai khoan 
    private void loadMockData() {
        accountList.add(new Account("0123456789", "abc123456"));
        accountList.add(new Account("0123234344", "abc123456"));
        accountList.add(new Account("0133234345", "abc123456"));
        accountList.add(new Account("0123334567", "abc123456"));
        accountList.add(new Account("0123456785", "abc123456"));
    }

    // tìm kiếm username và password
    public Account findByUsernameAndPassword(String username, String password) {
        for (Account account : accountList) {
            if ((account.getUsername().equals(username)) && (account.getPassword().equals(password))) {
                return account;
            }
        }
        return null;
    }
}

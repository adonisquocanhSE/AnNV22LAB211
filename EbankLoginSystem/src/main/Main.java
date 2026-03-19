package main;

import controller.EbankController;
import utils.Validation;
import constants.Message;
import dto.LoginRequestDTO;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import utils.BundleUtils;
import utils.CaptchaUtils;

public class Main {

    public static void main(String[] args) {

        // Khai bao cac bien su dung trong chuong trinh
        Scanner scanner = new Scanner(System.in);
        EbankController controller = new EbankController();
        String languageCode;
        String username;
        String password;
        String captchaInput;
        String captchaGenerate;
        int option;
        LoginRequestDTO requestDTO;

        // Vong lap chinh cua chuong trinh
        while (true) {

            // Hien thi menu chon ngon ngu
            System.out.print(Message.MENU);

            try {

                // Nguoi dung nhap lua chon menu
                System.out.print(Message.MENU_CHOICE);
                option = Validation.getMenuOption(scanner.nextLine(), Message.ERR_INVALID_OPTION);

                // Neu chon 3 thi thoat chuong trinh
                if (option == 3) {
                    System.exit(0);
                }

                // Xac dinh ma ngon ngu dua theo lua chon
                languageCode = (option == 1)
                        ? Message.LANG_VIETNAMESE
                        : Message.LANG_ENGLISH;

                BundleUtils.setLanguage(languageCode);
                ResourceBundle bundle = BundleUtils.getBundle();

                // ===== Nhap va kiem tra username =====
                username = null;
                while (username == null) {
                    try {

                        // Hien thi thong bao nhap username
                        System.out.print(bundle.getString(Message.KEY_USERNAME));

                        // Goi ham validation de kiem tra username
                        username = Validation.getUsername(scanner.nextLine(),
                                bundle.getString(Message.KEY_USERNAME_ERROR));

                    } catch (Exception e) {

                        // Neu sai thi in loi va nhap lai
                        System.out.println(e.getMessage());
                    }
                }

                // ===== Nhap va kiem tra password =====
                password = null;
                while (password == null) {
                    try {

                        // Hien thi thong bao nhap password
                        System.out.print(bundle.getString(Message.KEY_PASSWORD));

                        // Goi ham validation de kiem tra password
                        password = Validation.getPassword(scanner.nextLine(),
                                bundle.getString(Message.KEY_PASSWORD_ERROR));

                    } catch (Exception e) {

                        // Neu sai thi in loi va nhap lai
                        System.out.println(e.getMessage());
                    }
                }

                // ===== Xu ly captcha =====
                captchaInput = null;
                while (captchaInput == null) {

                    // Tao captcha ngau nhien
                    captchaGenerate = CaptchaUtils.generateCaptcha();

                    // Hien thi captcha cho nguoi dung
                    System.out.println(new StringBuilder()
                            .append(bundle.getString(Message.KEY_CAPTCHA))
                            .append(captchaGenerate)
                            .toString());

                    try {

                        // Nguoi dung nhap captcha
                        System.out.print(bundle.getString(Message.KEY_CAPTCHA_INPUT));

                        // Kiem tra dinh dang captcha
                        captchaInput = Validation.getCaptcha(scanner.nextLine(),
                                bundle.getString(Message.KEY_CAPTCHA_ERROR));

                        // Kiem tra captcha co trung voi captcha tao ra khong
                        if (!captchaGenerate.trim().equals(captchaInput)) {
                            System.out.println(bundle.getString(Message.KEY_CAPTCHA_ERROR));
                            captchaInput = null;
                        }

                    } catch (Exception e) {

                        // Neu sai dinh dang thi thong bao loi
                        System.out.println(e.getMessage());
                    }
                }

                // Tao doi tuong DTO chua du lieu login
                requestDTO = new LoginRequestDTO(username, password, captchaInput, languageCode);

                // Truyen requestDTO sang controller
                controller.setLoginRequestDTO(requestDTO);

                // Goi controller xu ly dang nhap
                controller.processLogin(
                        bundle.getString(Message.KEY_LOGIN_SUCCESS),
                        bundle.getString(Message.KEY_LOGIN_FAIL));

            } catch (Exception e) {

                // Bat loi khi nguoi dung nhap sai menu
                System.out.println(e.getMessage());
            }
        }
    }
}

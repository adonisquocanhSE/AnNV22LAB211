package constants;

public final class Message {

    //private constructor
    private Message() {
    }
    //Message hien thi MENU
    public static final String MENU
            = "\n======== Login Program ========\n"
            + "1. Vietnamese\n"
            + "2. English\n"
            + "3. Exit\n";
    //Message yeu cau chon option
    public static final String MENU_CHOICE = "Please choose one option: ";

    //Message hien thi loi
    public static final String ERR_INVALID_OPTION = "Invalid option! Please enter 1, 2 or 3.";
    //  Thông báo lỗi khi nhập rỗng.
    public static final String ERR_EMPTY_INPUT = "Input cannot be empty!";
    //  Thông báo lỗi khi format captcha sai (không phải chữ/số, không đủ 6 ký tự)
    public static final String ERR_CAPTCHA_FORMAT
            = "Captcha must contain only alphanumeric characters and be 6 characters long!";
    //Thông báo lỗi số tài khoản không đúng định dạng
    public static final String ERR_INVALID_USERNAME = "Account number must be exactly 10 digits!";
    //Thông báo lỗi mật khẩu không đúng định dạng.
    public static final String ERR_INVALID_PASSWORD = "Password must be 8-31 characters and contain both letters and numbers!";

    //Message language codes
    // Mã ngôn ngữ tiếng Việt.
    public static final String LANG_VIETNAMESE = "vi";
    // Mã ngôn ngữ tiếng Anh.
    public static final String LANG_ENGLISH = "en";

    //Message Resource Bundle
    // Tên base của resource bundle.
    public static final String BUNDLE_BASE_NAME = "language/message";
    //Message bundle keys
    // Key lấy prompt nhập tài khoản.
    public static final String KEY_USERNAME = "messageUsername";
    // Key lấy thông báo lỗi tài khoản.
    public static final String KEY_USERNAME_ERROR = "messageUsernameError";
    // Key lấy prompt nhập mật khẩu.
    public static final String KEY_PASSWORD = "messagePassword";
    // Key lấy thông báo lỗi mật khẩu.
    public static final String KEY_PASSWORD_ERROR = "messagePasswordError";
    // Key lấy nhãn hiển thị captcha.
    public static final String KEY_CAPTCHA = "messageCaptcha";
    // Key lấy prompt nhập captcha.
    public static final String KEY_CAPTCHA_INPUT = "messageCaptchaInput";
    // Key lấy thông báo lỗi captcha sai.
    public static final String KEY_CAPTCHA_ERROR = "messageCaptchaError";
    // Key lấy thông báo đăng nhập thành công.
    public static final String KEY_LOGIN_SUCCESS = "messageLoginSuccess";
    // Key lấy thông báo đăng nhập thất bại.
    public static final String KEY_LOGIN_FAIL = "messageLoginFail";
}

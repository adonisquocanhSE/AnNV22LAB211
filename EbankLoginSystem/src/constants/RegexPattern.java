package constants;

public final class RegexPattern {

    //private constructor
    private RegexPattern() {
    }
    // Số tài khoản: chỉ gồm chữ số, đúng 10 ký tự.
    public static final String USERNAME = "\\d{10}";
    //  Mật khẩu: 8-31 ký tự, phải có cả chữ lẫn số.
    public static final String PASSWORD = "(?=.*\\d.*)(?=.*[a-zA-Z].*).{8,31}";
    // Captcha: chỉ gồm chữ và số, đúng 6 ký tự.
    public static final String CAPTCHA = "[a-zA-Z0-9]{6}";
}

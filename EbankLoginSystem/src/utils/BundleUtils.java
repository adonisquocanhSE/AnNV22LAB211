package utils;

import constants.Message;
import java.util.Locale;
import java.util.ResourceBundle;

public final class BundleUtils {

    // ngan tao doi tuong
    private BundleUtils() {
    }

    // bien luu resource bundle hien tai
    private static ResourceBundle bundle;

    // thiet lap ngon ngu cho bundle
    public static void setLanguage(String languageCode) {
        bundle = ResourceBundle.getBundle(
                Message.BUNDLE_BASE_NAME,
                new Locale(languageCode)
        );
    }

    // lay bundle de su dung
    public static ResourceBundle getBundle() {
        return bundle;
    }
}

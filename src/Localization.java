import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Korybut on 29.08.2017.
 */
public class Localization {

    static Locale localePL = new Locale("pl","PL");
    static Locale localeEN = new Locale("en","EN");
    static Locale defLocal = localePL;
    static ResourceBundle bundle = ResourceBundle.getBundle("Bundle",localeEN);

    public Localization() {
    }

    public static ResourceBundle getBundle(){
        return bundle;
    }
}

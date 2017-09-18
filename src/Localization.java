import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Korybut on 29.08.2017.
 */
public class Localization {

    static Locale localePL = new Locale("pl","PL");
    static Locale localeEN = new Locale("en","EN");
    static Locale defLocal = localePL;
    static ResourceBundle bundle = ResourceBundle.getBundle("Bundle",localePL);

    public Localization() {
    }

    public static ResourceBundle getBundle(){
        return bundle;
    }

    public static void swapLocale(){
        if(bundle.getLocale()==localePL){
        }
        else{
            Locale.setDefault(localePL);
            ResourceBundle.clearCache();
        }
    }
}

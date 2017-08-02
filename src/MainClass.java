import java.awt.*;
import java.io.FileNotFoundException;

/**
 * Created by Korybut on 03.07.2017.
 */
public class MainClass {
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            try {
                new Frame();
           } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}


import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Korybut on 21.07.2017.
 */
public class SaveFile {

    private JFileChooser fileChooser = new JFileChooser();

    public SaveFile(TextFieldsArray textFldArr) {
        int retrival = fileChooser.showSaveDialog(null);
        if(retrival == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile()+".txt");
            try{
                FileWriter writer = new FileWriter(file);
                System.out.println("Test save file");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

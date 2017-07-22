import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Korybut on 21.07.2017.
 */
public class EditFile {

    private JFileChooser fileChooser = new JFileChooser();

    public EditFile(){
        fileChooser.setFileFilter(
                new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        if(f.isDirectory()) return true;
                        else {
                            String fileName = f.getName().toLowerCase();
                            return fileName.endsWith(".hex");
                        }
                    }

                    @Override
                    public String getDescription() {
                        return "HEX file (*.hex)";
                    }
                }
        );
    }

    public void save(TextFieldsArray textFldArr) {
        int retrival = fileChooser.showSaveDialog(null);
        if(retrival == JFileChooser.APPROVE_OPTION){
            File file = new File(fileChooser.getSelectedFile()+".hex");
            try{
                FileWriter writer = new FileWriter(file);
                System.out.println("Test save file");
                for(int a=0; a<8; a++){
                    for(int b=0; b<4; b++){
                        writer.write(textFldArr.getValue(a,b) + "\r\n");
                    }
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public TextFieldsArray open(TextFieldsArray textFldArr){
        int retrival = fileChooser.showOpenDialog(null);
        if(retrival == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                Scanner scanner = new Scanner(file);
                for(int a=0; a<8; a++){
                    for(int b=0; b<4; b++){
                        if(!scanner.hasNextLine()) break;
                        textFldArr.setValue(scanner.nextLine(), a, b);
                        System.out.println("wczytalem " + a + ", " + b);
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return textFldArr;
    }
}

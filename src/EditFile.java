import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Created by Korybut on 21.07.2017.
 */
class EditFile {

    ResourceBundle bundle = Localization.bundle;
    private JFileChooser fileChooser = new JFileChooser();

    EditFile() {
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

    void save(TextFieldsArray textFldArr, StatusBar statbr) {
        if(statbr.getFileNameStatus().equals(bundle.getString("stat_notsave"))){
            //if current file is not save, default save is set on desktop directory and untitled name file.
            File file = new File(System.getProperty("user.home")+"\\Desktop\\untitled");
            fileChooser.setSelectedFile(file);
        }
        else {
            File fileName = new File(System.getProperty(
                    "user.home")+"\\Desktop\\"+statbr.getFileNameStatus().substring(0,statbr.getFileNameStatus().length()-5));
            fileChooser.setSelectedFile(fileName);
        }
        int retrival = fileChooser.showSaveDialog(null);
        if(retrival == JFileChooser.APPROVE_OPTION){
            File file;
            if(!fileChooser.getSelectedFile().toString().contains(".hex")){
                file = new File(fileChooser.getSelectedFile()+".hex");
            }
            else{
                file = new File(fileChooser.getSelectedFile()+"");
            }
            try{
                FileWriter writer = new FileWriter(file);
                for(int a=0; a<8; a++){
                    for(int b=0; b<4; b++){
                        writer.write(textFldArr.getValue(a,b) + "\r\n");
                    }
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //set saved file name to StatusBar label
            //string must be cutting, because getSelectedFile give all directory, example C:\\Users\Desktop\file.hex...
            String string = fileChooser.getSelectedFile()+"";
            string = string.substring(fileChooser.getCurrentDirectory().toString().length()+1);
            if(string.contains(".hex")){
               string = string.substring(0,string.length()-4);
            }
            statbr.setFileNameStatus(string+".hex ");
        }
    }

    TextFieldsArray open(TextFieldsArray textFldArr, StatusBar statbr){
        int retrival = fileChooser.showOpenDialog(null);
        if(retrival == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            try {
                Scanner scanner = new Scanner(file);
                for(int a=0; a<8; a++){
                    for(int b=0; b<4; b++){
                        if(!scanner.hasNextLine()) break;
                        textFldArr.setValue(scanner.nextLine(), a, b);
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String string = fileChooser.getSelectedFile()+"";
            string = string.substring(fileChooser.getCurrentDirectory().toString().length()+1);
            if(string.contains(".hex")){
                string = string.substring(0,string.length()-4);
            }
            statbr.setFileNameStatus(string+".hex ");
        }
        return textFldArr;
    }
}

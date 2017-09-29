import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Korybut on 11.07.2017.
 */
public class TextFieldsArray extends JComponent implements MouseListener{

    private String[] labelsTitles = {"MM0", "MM1", "paddw", "paddsw", "paddusw", "psubw", "psubsw", "psubusw"};
    private JTextField[][] textFields = new JTextField[8][4];
    private JLabel[] labels = new JLabel[8];
    private DocumentFilter sizeFilter = new SizeAndUpperFilter(4);

    TextFieldsArray(){
        int height = 0;
        int width = 65;
        for(int a=0; a<8; a++){
            labels[a] = new JLabel(labelsTitles[a], SwingConstants.RIGHT);
            labels[a].setBounds(0, height, 55, 20);
            add(labels[a]);
            for(int b=0; b<4; b++){
                textFields[a][b] = new JTextField();
                textFields[a][b].setBounds(width, height, 50, 20);
                textFields[a][b].setHorizontalAlignment(SwingConstants.CENTER);
                textFields[a][b].getPreferredSize();
                if(a<2) textFields[a][b].setText("0000");
                if(a>1) textFields[a][b].setEditable(false);
                textFields[a][b].addMouseListener(this);
                add(textFields[a][b]);
                // checking if that char is uppercase - if is not, change to uppercase
                ((AbstractDocument) textFields[a][b].getDocument()).setDocumentFilter(sizeFilter);
                //((AbstractDocument) textFields[a][b].getDocument()).setDocumentFilter(filter);
                width+=65;
            }
            height += 25;
            width = 65;
        }
    }

    void setValue(String value, int row, int col){ textFields[row][col].setText(value); }
    String getValue(int row, int col){ return textFields[row][col].getText(); }
    JTextField getField(int row, int col){
        return textFields[row][col];
    }

    void setOnlyNegative(){
        for(int a=0; a<2; a++){
            for(int b=0; b<4; b++){
                textFields[a][b].setText(new RandomizeHex(1).getRandomHex());
            }
        }
    }

    void setOnlyPositive(){
        for(int a=0; a<2; a++){
            for(int b=0; b<4; b++){
                textFields[a][b].setText(new RandomizeHex(0).getRandomHex());
            }
        }
    }

    void setNewParameters(){
        for(int b=0; b<4; b++){
            textFields[0][b].setText(textFields[2][b].getText());
            textFields[1][b].setText(textFields[5][b].getText());
        }
        for(int a=2; a<8; a++){
            for(int b=0; b<4; b++){
                if(a>1) textFields[a][b].setText("");
                else textFields[a][b].setText("0000");
            }
        }
    }

    private boolean checkInsertValue(int i){
        int errorThis = -1;
        boolean ok = true;
        try {
            errorThis = Integer.parseInt(textFields[0][i].getText(), 16);
            errorThis = Integer.parseInt(textFields[1][i].getText(), 16);
        } catch (NumberFormatException n) {
            n.printStackTrace();
            ok = false;
            //JOptionPane.showMessageDialog(null, bundle.getString("number_format_msg"), bundle.getString("valid_val"), JOptionPane.ERROR_MESSAGE);
            if (errorThis == -1) {
                getField(0, i);
            }
        }
        return ok;
    }

    void calculateAll(){
        calculateOnlyAdd();
        calculateOnlySub();
    }

    void calculateOnlyAdd(){
        RegistryOperation ro = new RegistryOperation();
        for(int i=0; i<4; i++){
            if(checkInsertValue(i)){
                textFields[2][i].setText(ro.hexAddw(textFields[0][i].getText(),textFields[1][i].getText()));
                textFields[3][i].setText(ro.hexAddsw(textFields[0][i].getText(),textFields[1][i].getText()));
                textFields[4][i].setText(ro.hexAddusw(textFields[0][i].getText(),textFields[1][i].getText()));
            }
        }
    }

    void calculateOnlySub(){
        RegistryOperation ro = new RegistryOperation();
        for(int i=0; i<4; i++){
            if(checkInsertValue(i)){
                textFields[5][i].setText(ro.hexSubw(textFields[0][i].getText(),textFields[1][i].getText()));
                textFields[6][i].setText(ro.hexSubsw(textFields[0][i].getText(),textFields[1][i].getText()));
                textFields[7][i].setText(ro.hexSubusw(textFields[0][i].getText(),textFields[1][i].getText()));
            }
        }
    }

    void comboBoxCalculate(int num){
        for(int i=0; i<4; i++) {
            if (checkInsertValue(i)) {
                RegistryOperation ro = new RegistryOperation();
                switch(num){
                    case 0:
                        textFields[2][i].setText(ro.hexAddw(textFields[0][i].getText(),textFields[1][i].getText()));
                        break;
                    case 1:
                        textFields[3][i].setText(ro.hexAddsw(textFields[0][i].getText(),textFields[1][i].getText()));
                        break;
                    case 2:
                        textFields[4][i].setText(ro.hexAddusw(textFields[0][i].getText(),textFields[1][i].getText()));
                        break;
                    case 3:
                        textFields[5][i].setText(ro.hexSubw(textFields[0][i].getText(),textFields[1][i].getText()));
                        break;
                    case 4:
                        textFields[6][i].setText(ro.hexSubsw(textFields[0][i].getText(),textFields[1][i].getText()));
                        break;
                    case 5:
                        textFields[7][i].setText(ro.hexSubusw(textFields[0][i].getText(),textFields[1][i].getText()));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    void setRandom(){
        for(int a=0; a<2; a++){
            for(int b=0; b<4; b++){
                textFields[a][b].setText(new RandomizeHex().getRandomHex());
            }
        }
    }

    void exchange(){
        for(int b=0; b<4; b++){
            String temp = textFields[0][b].getText();
            textFields[0][b].setText(textFields[1][b].getText());
            textFields[1][b].setText(temp);
        }
    }

    void clear(){
        for(int a=0; a<8; a++){
            for(int b=0; b<4; b++){
                if(a>1) textFields[a][b].setText("");
                else textFields[a][b].setText("0000");
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int a=0; a<8; a++) {
            for (int b = 0; b < 4; b++) {
                if(e.getSource()==textFields[a][b]){
                    textFields[a][b].selectAll();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Korybut on 11.07.2017.
 */
public class TextFieldsArray extends JComponent implements MouseListener {

    String[] labelsTitles = {"MM0", "MM1", "paddw", "paddsw", "paddusw", "psubw", "psubsw", "psubusw"};
    JTextField[][] textFields = new JTextField[8][4];
    JLabel[] labels = new JLabel[8];
    DocumentFilter sizeFilter = new SizeAndUpperFilter(4);

    public TextFieldsArray(){
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

    public void setValue(String value, int row, int col){ textFields[row][col].setText(value); }

    public String getValue(int row, int col){ return textFields[row][col].getText(); }

    public JTextField getField(int row, int col){
        return textFields[row][col];
    }

    public JTextField[][] getTextFields() {
        return textFields;
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

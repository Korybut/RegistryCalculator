import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by Korybut on 15.07.2017.
 */
class RightPanel extends JComponent {

    JLabel titleMode = new JLabel("tryb: Kalkulator", SwingConstants.CENTER);

    JButton butRand = new JButton("Losowe");
    JButton butClear = new JButton("Wyczyść");
    JButton butCalAll = new JButton("Oblicz wszystko");
    JButton butComboBox = new JButton("przelicz");

    /* JComboBox */
    BoxListCalculate boxListCalculate = new BoxListCalculate();

    RightPanel(){
        setLayout(null);
        setSize(200,195);
        setBorder(new EtchedBorder());

        add(titleMode);
        Font corbelFont = new Font("Corbel", Font.BOLD, 20);
        titleMode.setBounds(10,10,180,20);
        titleMode.setFont(corbelFont);

        add(butRand);
        butRand.setBounds(10,40,85,30);
        butRand.setFocusPainted(false);

        add(butClear);
        butClear.setBounds(105,40,85,30);
        butClear.setFocusPainted(false);

        add(butCalAll);
        butCalAll.setBounds(10,75,180,30);
        butCalAll.setFocusPainted(false);

        add(boxListCalculate);
        boxListCalculate.setLocation(10,110);

        add(butComboBox);
        butComboBox.setBounds(105,110,85,20);
        butComboBox.setFocusPainted(false);
    }

    void setRandom(TextFieldsArray t){
        butRand.addActionListener(e -> {
            t.setRandom();
        });
    }

    void clear(TextFieldsArray t){
        butClear.addActionListener(e -> {
            t.clear();
        });
    }

    void calculateAll(TextFieldsArray t){
        butCalAll.addActionListener(e -> {
            t.calculateAll();
        });
    }

    void calculateFromComboBox(TextFieldsArray t) {
        butComboBox.addActionListener(e -> {
            t.comboBoxCalculate(getBoxListCalculate().getSelectedIndex());
        });
    }

    private BoxListCalculate getBoxListCalculate() {
        return boxListCalculate;
    }

    /*public JLabel getTitleMode() {
        return titleMode;
    }*/
}

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Korybut on 15.07.2017.
 */
class RightPanel extends JComponent {

    ResourceBundle bundle = Localization.bundle;

    JLabel titleMode = new JLabel(bundle.getString("mode"), SwingConstants.CENTER);

    JButton butRand = new JButton(bundle.getString("rand"));
    JButton butClear = new JButton(bundle.getString("clear2"));
    JButton butCalAll = new JButton(bundle.getString("calculateAll"));
    JButton butComboBox = new JButton(bundle.getString("calculate"));

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

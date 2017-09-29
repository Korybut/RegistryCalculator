import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * Created by Korybut on 15.07.2017.
 */
public class RightPanel extends JComponent {

    private JLabel titleMode = new JLabel("title", SwingConstants.CENTER);
    private JButton butRand = new JButton();
    private JButton butClear = new JButton();
    private JButton butCalAll = new JButton();
    private JButton butComboBox = new JButton();

    /* JComboBox */
    private BoxListCalculate boxListCalculate = new BoxListCalculate();

    RightPanel(){
        setLayout(null);
        setSize(200,195);
        setBorder(new EtchedBorder());

        add(titleMode);
        titleMode.setBounds(10,10,180,20);
        titleMode.setFont(new Font("Corbel", Font.BOLD, 20));
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

    public void updateDisplay(ResourceBundle res){
        titleMode.setText(res.getString("mode"));
        butRand.setText(res.getString("rand"));
        butClear.setText(res.getString("clear2"));
        butCalAll.setText(res.getString("calculateAll"));
        butComboBox.setText(res.getString("calculate"));
        validate();
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

}

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by Korybut on 15.07.2017.
 */
public class RightPanel extends JComponent {

    JLabel titleMode = new JLabel("tryb: Kalkulator", SwingConstants.CENTER);

    JButton butRand = new JButton("Losowe");
    JButton butClear = new JButton("Wyczyść");
    JButton butCalAll = new JButton("Oblicz wszystko");
    JButton butComboBox = new JButton("przelicz");

    /* JComboBox */
    BoxListCalculate boxListCalculate = new BoxListCalculate();

    public RightPanel(){
        setLayout(null);
        setSize(200,195);
        setBorder(new EtchedBorder());

        add(titleMode);
        Font corbelFont = new Font("Corbel", Font.BOLD, 20);
        titleMode.setBounds(10,10,180,20);
        titleMode.setFont(corbelFont);

        add(butRand);
        butRand.setBounds(10,40,85,30);

        add(butClear);
        butClear.setBounds(105,40,85,30);

        add(butCalAll);
        butCalAll.setBounds(10,75,180,30);

        add(boxListCalculate);
        boxListCalculate.setLocation(10,110);

        add(butComboBox);
        butComboBox.setBounds(105,110,85,20);
    }

    public JButton getButRand(){
        return butRand;
    }

    public JButton getButClear(){
        return butClear;
    }

    public JButton getButCalAll(){
        return butCalAll;
    }

    public JButton getButComboBox() { return butComboBox; }

    public BoxListCalculate getBoxListCalculate() {
        return boxListCalculate;
    }

    public JLabel getTitleMode() {
        return titleMode;
    }
}
